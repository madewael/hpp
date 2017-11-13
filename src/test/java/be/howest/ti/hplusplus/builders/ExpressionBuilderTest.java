package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.expr.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionBuilderTest implements IExpressionTest {




    @Test
    public void testNumber(){
        Literal i = (Literal) build(NUM,Literal.class);
        assertEquals(Integer.parseInt(NUM), i.getLiteral().getIntValue());
    }

    @Test
    public void testAssocNumber(){
        Literal i = (Literal) build(ASSOC,Literal.class);
        assertEquals(Integer.parseInt(NUM), i.getLiteral().getIntValue());
    }

    @Test
    public void testString(){
        Literal i = (Literal) build(STR, Literal.class);
        assertEquals(STR.substring(1,STR.length()-1), i.getLiteral().getStringValue());
    }

    @Test
    public void testBinOp(){
        build(BINOP, BinOperation.class);
    }

    @Test
    public void testBoolY(){
        Literal b = (Literal) build(BOOL_Y, Literal.class);
        assertTrue(b.getLiteral().getBooleanValue());
    }
    @Test
    public void testBoolN(){
        Literal b = (Literal) build(BOOL_N, Literal.class);
        assertFalse(b.getLiteral().getBooleanValue());
    }


    @Test
    public void testSimpleInvocation(){
        build(SIMPLE_INV,Invocation.class);
    }

    @Test
    public void testInvocation(){
        build(INV,Invocation.class);
    }



    @Test
    public void testVar(){
        build(VAR,VariableLookup.class);
    }


    @Test
    public void testMemberSelection(){
        build(MEM, MemberSelection.class);
    }


    @Test
    public void testSelfMemberSelection(){
        build(SELF_MEM,OwnMemberSelection.class);
    }


    @Test
    public void testSelf(){
        build(SELF, Self.class);
    }

    @Test
    public void parseIt(){
        HppParser.parseExpr(IT);
    }

    @Test
    public void testIt(){
        build(IT,It.class);
    }


    @Test
    public void testUniOp(){
        build(UNA,UnaOperation.class);
    }

    @Test
    public void testInstantiation(){
        build(INSTANTIATION,Instantiation.class);
    }


    private Expression build(String exprStr, Class<?> clazz){
        Expression expr = HppParser.parseExpr(exprStr).accept(new ExpressionBuilder());
        assertNotNull(exprStr + " is not supposed to result in a null-expression", expr);
        String msg = String.format("Expected the expression (%s) to be %s, found %s.", exprStr, clazz.getSimpleName(), expr.getClass()
                .getSimpleName());
        assertTrue(msg, clazz.isInstance(expr));
        return expr;
    }

}