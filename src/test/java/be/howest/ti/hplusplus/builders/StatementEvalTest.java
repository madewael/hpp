package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.exceptions.execution.KeyNotPresent;
import be.howest.ti.hplusplus.scopes.BaseScope;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.scopes.HppLocalScope;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.code.stmt.Statement;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class StatementEvalTest implements IStatementTest {

    private HppLocalScope<HppValue> scopeWithFooAndBar;

    private AtomicInteger fooInvocationCount;

    private AtomicInteger barInvocationCount;

    private HppValue foo =new HppFunction(null,null){

        public HppValue apply(List<HppValue> args){
            return new HppInt(fooInvocationCount.incrementAndGet());
        }

    };

    private final HppValue bar = new HppFunction(null, null){

        public HppValue apply(List<HppValue> args){
            return new HppInt(barInvocationCount.incrementAndGet());
        }

    };

    @Before
    public void init(){
        fooInvocationCount = new AtomicInteger(0);
        barInvocationCount = new AtomicInteger(0);

        scopeWithFooAndBar = new HppLocalScope(new BaseScope(new HppProgram()),null);
        scopeWithFooAndBar.add("foo",foo);
        scopeWithFooAndBar.add("bar",bar);
    }




    @Test @Override
    public void testExprStmt(){
        eval(EXPR,scopeWithFooAndBar);
        int after = fooInvocationCount.get();
        assertEquals(1,fooInvocationCount.get());
    }

    @Test @Override
    public void testIf(){
        HppLocalScope scope = scopeWithFooAndBar;
        scope.add("x", HppBool.YES);
        eval(IF,scope);

        assertEquals(1,fooInvocationCount.get());

        scope.set("x", HppBool.NO);
        eval(IF,scope);
        assertEquals(1,fooInvocationCount.get());

    }

    @Test @Override
    public void testIfElse(){

        HppLocalScope scope = scopeWithFooAndBar;
        scope.add("x", HppBool.YES);
        eval(IFELSE,scope);

        assertEquals(1,fooInvocationCount.get());
        assertEquals(0,barInvocationCount.get());

        scope.set("x", HppBool.NO);
        eval(IFELSE,scope);
        assertEquals(1,fooInvocationCount.get());
        assertEquals(1,barInvocationCount.get());
    }

    @Test @Override
    public void testWhile() {
        HppLocalScope scope = scopeWithFooAndBar;
        scope.add("x", new HppInt(5));
        eval(WHILE,scope);

        assertEquals(5,fooInvocationCount.get());
    }

    @Test @Override
    public void testFor(){
        HppLocalScope scope = scopeWithFooAndBar;
        HppSequence seq = new HppSequence(HppType.INT);

        seq.add(new HppInt(0));
        seq.add(new HppInt(1));
        seq.add(new HppInt(2));

        scope.add("x",seq);
        eval(FOR,scopeWithFooAndBar);

        assertEquals(3,fooInvocationCount.get());
    }


    @Test @Override
    public void testReturn(){
        try {
            eval(RET,scopeWithFooAndBar);
            fail("Should have returned");
        } catch ( HppValue returnValue) {
            assertEquals( 1  , returnValue.getIntValue());
        }
    }

    @Override
    public void testVarDef() {
        try{
            scopeWithFooAndBar.get("x");
            fail("x should not yet exist");
        } catch (KeyNotPresent ex) {

        }
        eval(VAR_DEF,scopeWithFooAndBar);
        scopeWithFooAndBar.get("x");
    }

    @Override
    public void testObserveStmt() {
        eval(OBSERVE,scopeWithFooAndBar);
    }

    @Test @Override
    public void testBlock(){
        eval(BLOCK,scopeWithFooAndBar);
        assertEquals(2,fooInvocationCount.get());
        assertEquals(1,barInvocationCount.get());
    }

    @Test @Override
    public void testAssign(){
        scopeWithFooAndBar.add("x",null);
        eval(ASSIGN,scopeWithFooAndBar);
        assertEquals(30,scopeWithFooAndBar.get("x").getIntValue());
    }

    @Test @Override
    public void testMemberAssign(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("age",HppType.INT));

        HppProgram prog = new HppProgram();
        prog.add(c);

        HppObject pers = new HppObject(c);
        pers.set("age", new HppInt(29));


        eval(MEM_ASSIGN,pers);
        assertEquals(30,pers.get("age").getIntValue());
    }

    private void eval(String stmtStr, HppScope scope){
        Statement stmt = HppParser.parseStmt(stmtStr).accept(new StatementBuilder(new HppProgram(),new HppClass("X")));
        assertNotNull(stmtStr + " is not supposed to result in a null-stmt", stmtStr);
        stmt.eval(scope);
    }

}