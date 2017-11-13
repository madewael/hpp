package be.howest.ti.hplusplus.builders;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ExpressionBuilderTest.class,
        StatementBuilderTest.class,
        ExpressionEvalTest.class,
        StatementEvalTest.class
})

public class Tests { }