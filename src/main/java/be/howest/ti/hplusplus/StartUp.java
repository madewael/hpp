package be.howest.ti.hplusplus;

import be.howest.ti.hplusplus.builders.HppParser;
import be.howest.ti.hplusplus.builders.ProgramBuilder;
import be.howest.ti.hplusplus.grammar.HplusplusParser;
import be.howest.ti.hplusplus.code.HppProgram;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class StartUp {

    private static Logger LOG = Logger.getLogger(StartUp.class.getSimpleName());

    public static void main(String[] args) throws IOException {

        HplusplusParser.ProgContext syntaxTree = HppParser.parse(new File
                ("src/main/resources/example-programs/p3.hpp"));

        HppProgram p = syntaxTree.accept(new ProgramBuilder());

        System.out.println( "End of program:" + p.eval() );


    }

}
