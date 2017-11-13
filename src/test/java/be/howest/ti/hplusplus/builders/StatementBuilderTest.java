package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.stmt.*;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.types.HppClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatementBuilderTest implements IStatementTest {


    @Test @Override
    public void testExprStmt(){
        build(EXPR,ExprStmt.class);
    }

    @Test @Override
    public void testIf(){
        build(IF,IfStmt.class);
    }

    @Test @Override
    public void testIfElse(){
        build(IFELSE,IfStmt.class);
    }

    @Test @Override
    public void testFor(){
        build(FOR,ForStmt.class);
    }


    @Test @Override
    public void testReturn(){
        build(RET,ReturnStmt.class);
    }

    @Test @Override
    public void testBlock(){
        build(BLOCK,BlockStmt.class);
    }

    @Test @Override
    public void testAssign(){
        build(ASSIGN,AssignStmt.class);
    }

    @Test @Override
    public void testMemberAssign(){
        build(MEM_ASSIGN,MemberAssignStmt.class);
    }

    @Test @Override
    public void testVarDef(){
        build(VAR_DEF,VarDefStmt.class);
    }

    @Test @Override
    public void testObserveStmt() {
        build(OBSERVE,ObserveStmt.class);
    }


    private Statement build(String stmtStr, Class<?> clazz){
        Statement stmt = HppParser.parseStmt(stmtStr).accept(new StatementBuilder(new HppProgram(),new HppClass("X")));
        assertNotNull(stmtStr + " is not supposed to result in a null-stmt", stmt);
        String msg = String.format("Expected the statement (%s) to be %s, found %s.", stmtStr, clazz.getSimpleName(),
                stmt.getClass()
                .getSimpleName());
        assertTrue(msg, clazz.isInstance(stmt));
        return stmt;
    }

}