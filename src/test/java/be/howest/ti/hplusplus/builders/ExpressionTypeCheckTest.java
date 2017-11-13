package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.exceptions.compile.HppTypeCheckException;
import be.howest.ti.hplusplus.scopes.BaseScope;
import be.howest.ti.hplusplus.scopes.HppLocalScope;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.FunctionType;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExpressionTypeCheckTest implements IExpressionTest {

    private BaseScope<HppType> scope;

    @Before
    public void init(){
        scope = new BaseScope<>(new HppProgram());
    }

    @Test
    public void testNumber(){
        HppType res = checkType(NUM, scope);
        assertEquals(HppType.INT, res);
    }

    @Test
    public void testString(){
        HppType res = checkType(STR, scope);
        assertEquals(HppType.STR, res);
    }

    public void testAssocNumber(){ /* not test */ }

    @Test
    public void testBinOp(){
        HppType res = checkType(BINOP, scope);
        assertEquals(HppType.INT, res);
    }

    @Test
    public void testBinOpWrongArgs(){
        String expr = "(1-\"a\")";
        try{
            HppType res = checkType(expr, scope);
            fail(expr + " should be able to type check.");
        } catch (HppTypeCheckException ex){

        }
    }

    @Override
    public void testBoolY() {
        HppType res = checkType(BOOL_Y, scope);
        assertEquals(HppType.BOOL, res);
    }

    @Override
    public void testBoolN() {
        HppType res = checkType(BOOL_N, scope);
        assertEquals(HppType.BOOL, res);
    }

    @Test
    public void testInvocation(){
        scope.add("sum", FunctionType.getFunctionType(Arrays.asList(HppType.INT,HppType.INT,HppType.INT),HppType.INT));
        HppType res = checkType(INV, scope);
        assertEquals(HppType.INT, res);
    }

    @Test
    public void testInvocationMoreArgs(){
        try {
            scope.add("sum", FunctionType.getFunctionType(Arrays.asList(HppType.INT, HppType.INT), HppType.INT));
            checkType(INV, scope);
            fail("Expected type error because more arguments where used in the invocation than the type of the " +
                    "function says.");
        } catch (HppTypeCheckException ex){

        }
    }

    @Test
    public void testInvocationLessArgs(){
        try {
            scope.add("sum", FunctionType.getFunctionType(Arrays.asList(HppType.INT, HppType.INT,HppType.INT, HppType.INT), HppType.INT));
            checkType(INV, scope);
            fail("Expected type error because less arguments where used in the invocation than the type of the " +
                    "function says.");
        } catch (HppTypeCheckException ex){

        }
    }

    @Test
    public void testSimpleInvocation(){
        scope.add("retString", FunctionType.getFunctionType(Arrays.asList(),HppType.INT));
        HppType res = checkType(SIMPLE_INV, scope);
        assertEquals(HppType.INT, res);

    }

    @Test
    public void testVar(){
        scope.add(VAR, HppType.INT);
        HppType res = checkType(VAR, scope);
        assertEquals(HppType.INT, res);
    }
    @Test
    public void testMemberSelection(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("name", HppType.STR));

        HppProgram prog = new HppProgram();
        prog.add(c);


        scope.add("pers", c);
        HppType res = checkType(MEM, scope);

        assertEquals(HppType.STR, res);
    }


    @Test
    public void testSelfMemberSelection(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("name",HppType.STR));


        HppProgram prog = new HppProgram();
        prog.add(c);

        HppType res = checkType(SELF_MEM, c);

        assertEquals(HppType.STR, res);
    }

    @Test
    public void testSelf(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("name",HppType.STR));


        HppProgram prog = new HppProgram();
        prog.add(c);

        HppType res = checkType(SELF, c);
        assertEquals(c,res);
    }


    @Test
    public void testIt(){
        HppLocalScope<HppType> scope = new HppLocalScope(this.scope,HppType.INT);

        HppType res = checkType(IT, scope);
        assertEquals(HppType.INT, res);
    }


    @Test
    public void testUniOp(){
        HppType res = checkType(UNA, scope);
        assertEquals(HppType.INT, res);
    }

    @Test
    public void testInstantiation(){
        HppClass c = new HppClass("A");
        c.add(new HppVar("name",HppType.STR));


        HppProgram prog = new HppProgram();
        prog.add(c);

        HppType res = checkType(INSTANTIATION, c);
        assertEquals(c,res);
    }


    private HppType checkType(String exprStr, HppScope<HppType> scope){
        Expression expr = HppParser.parseExpr(exprStr).accept(new ExpressionBuilder());
        assertNotNull(exprStr + " is not supposed to result in a null-expression", expr);
        return expr.checkType(scope);
    }

}