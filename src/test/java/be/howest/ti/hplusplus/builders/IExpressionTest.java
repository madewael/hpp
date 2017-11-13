package be.howest.ti.hplusplus.builders;

public interface IExpressionTest {

    String NUM = "123";
    String ASSOC = "("+NUM+")";
    String STR = "\"azerty\"";
    String BINOP = "(3-5)";
    String BOOL_Y = "yes";
    String BOOL_N = "no";
    String SIMPLE_INV = "do retString";
    String INV = "do sum with 1,2,3";
    String VAR = "x";
    String MEM = "name of pers";
    String SELF_MEM = "my name";
    String SELF = "me";
    String IT = "it";
    String UNA = "-5";
    String INSTANTIATION = "new A";

    void testNumber();
    void testAssocNumber();
    void testString();
    void testBinOp();
    void testBoolY();
    void testBoolN();
    void testSimpleInvocation();
    void testInvocation();
    void testVar();
    void testMemberSelection();
    void testSelfMemberSelection();
    void testSelf();
    void testIt();
    void testUniOp();
    void testInstantiation();


}