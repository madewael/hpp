package be.howest.ti.hplusplus.builders;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public interface IStatementTest {

    String EXPR = "do foo.";
    String IF = "if (x) do foo.";
    String IFELSE = "if (x) do foo. else do bar.";
    String WHILE = "while ( (x > 0) ) (: x << (x - 1). do foo. :)";
    String FOR = "for (x) do foo with it.";
    String BLOCK ="(: do foo. do bar. do foo.:)";
    String MEM_ASSIGN = "my age << 30.";
    String ASSIGN = "x << 30.";
    String RET = ">> 1.";
    String VAR_DEF = "x:int.";
    String OBSERVE = "onChange ~> age of p.";

    void testExprStmt();
    void testIf();
    void testIfElse();
    void testWhile();
    void testFor();
    void testBlock();
    void testMemberAssign();
    void testAssign();
    void testReturn();
    void testVarDef();

    void testObserveStmt();

}