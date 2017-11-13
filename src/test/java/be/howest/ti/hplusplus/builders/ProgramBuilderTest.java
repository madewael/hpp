package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.exceptions.compile.DuplicateNameException;
import be.howest.ti.hplusplus.exceptions.compile.SyntaxException;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ProgramBuilderTest {

    private final File EMPTY_PROGRAM = new File("src/test/resources/empty.hpp");

    @Test
    public void parseEmptyProgram(){
        try {
            HppParser.parse(EMPTY_PROGRAM);
            fail("It should not be possible to parse an empty program.");
        } catch (SyntaxException ex) {
            // expected
        }
    }


    private final File STMT_PROGRAM = new File("src/test/resources/stmt.hpp");

    @Test
    public void parseStmtProgram(){
        HppParser.parse(STMT_PROGRAM);
    }

    @Test
    public void buildStmtProgram(){
        HppProgram p = HppParser.parse(STMT_PROGRAM).accept(new ProgramBuilder());
    }

    private final File CLASS_PROGRAM = new File("src/test/resources/classes.hpp");
    private final File DUPLICATE_CLASS_PROGRAM = new File("src/test/resources/duplicatedClasses.hpp");

    @Test
    public void parseClassProgram(){
        HppParser.parse(CLASS_PROGRAM);
    }

    @Test
    public void buildClassProgram(){
        HppProgram p = HppParser.parse(CLASS_PROGRAM).accept(new ProgramBuilder());
    }

    @Test
    public void buildDuplicateClassProgram(){
        try {
            HppProgram p = HppParser.parse(DUPLICATE_CLASS_PROGRAM).accept(new ProgramBuilder());
            fail("It should not be possible to have two classes with the same name.");
        } catch (DuplicateNameException ex){
            // expected
        }
    }

}