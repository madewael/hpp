package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.scopes.BaseScope;
import be.howest.ti.hplusplus.scopes.HppLocalScope;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ExpressionEvalTest implements IExpressionTest {

    private BaseScope scope;

    @Before
    public void init(){
        scope = new BaseScope(new HppProgram());
    }

    @Test
    public void testNumber(){
        HppValue res = eval(NUM, scope);
        assertEquals(Integer.parseInt(NUM), res.getIntValue());
    }

    @Test
    public void testString(){
        HppValue res = eval(STR, scope);
        assertEquals(STR.substring(1,STR.length()-1), res.getStringValue());
    }

    public void testAssocNumber(){ /* not test */ }

    @Test
    public void testBinOp(){
        HppValue res = eval(BINOP, scope);
        assertEquals(3-5, res.getIntValue());
    }

    @Override
    public void testBoolY() {
        HppValue res = eval(BOOL_Y, scope);
        assertTrue(res.getBooleanValue());
    }

    @Override
    public void testBoolN() {
        HppValue res = eval(BOOL_N, scope);
        assertFalse(res.getBooleanValue());
    }

    @Test
    public void testInvocation(){
        HppValue sum = new HppFunction(null, null){

            public HppValue apply(List<HppValue> args){
                System.out.println("calling sum");
                return new HppInt(args.stream().mapToInt(arg->arg.getIntValue()).sum());
            }

        };
        BaseScope scope = this.scope;
        scope.add("sum", sum);
        HppValue res = eval(INV, scope);
        assertEquals(1+2+3, res.getIntValue());
    }

    @Test
    public void testSimpleInvocation(){
        final HppString ret = new HppString("evalSimpleInvocation");
        HppValue retString = new HppFunction(null,null){

            public HppValue apply(List<HppValue> args){
                return ret;
            }

        };
        scope.add("retString", retString);
        HppValue res = eval("do retString", scope);
        assertEquals(ret, res);
    }

    @Test
    public void testVar(){
        HppValue val = new HppInt(123);
        scope.add(VAR, val);
        HppValue res = eval(VAR, scope);
        assertEquals(val, res);
    }
    @Test
    public void testMemberSelection(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("name", HppType.STR));

        HppProgram prog = new HppProgram();
        prog.add(c);


        HppValue name = new HppString("Alice");
        HppObject pers = new HppObject(c);
        pers.set("name", name);

        scope.add("pers", pers);
        HppValue res = eval(MEM, scope);

        assertEquals("Alice", res.getStringValue());
    }


    @Test
    public void testSelfMemberSelection(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("name",HppType.STR));


        HppProgram prog = new HppProgram();
        prog.add(c);


        HppValue name = new HppString("Alice");
        HppObject pers = new HppObject(c);
        pers.set("name", name);

        HppValue res = eval(SELF_MEM, pers);

        assertEquals("Alice", res.getStringValue());
    }

    @Test
    public void testSelf(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("name",HppType.STR));


        HppProgram prog = new HppProgram();
        prog.add(c);


        HppValue name = new HppString("Alice");
        HppObject pers = new HppObject(c);
        pers.set("name", name);

        HppValue res = eval(SELF, pers);
        assertEquals(pers,res);
    }


    @Test
    public void testIt(){
        HppValue it = new HppInt(123);
        HppLocalScope scope = new HppLocalScope(this.scope,it);
        assertEquals(it, scope.getIt());
        HppValue res = eval(IT, scope);
        assertEquals(it, res);
    }


    @Test
    public void testUniOp(){
        HppValue res = eval(UNA, scope);
    }

    @Test
    public void testInstantiation(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("name",HppType.STR));

        HppProgram prog = new HppProgram();
        prog.add(c);

        HppValue res = eval(INSTANTIATION,new BaseScope(prog));

    }

    private HppValue eval(String exprStr, HppScope scope){
        Expression expr = HppParser.parseExpr(exprStr).accept(new ExpressionBuilder());
        assertNotNull(exprStr + " is not supposed to result in a null-expression", expr);
        return expr.eval(scope);
    }

}