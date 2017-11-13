package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.grammar.HplusplusBaseVisitor;
import be.howest.ti.hplusplus.grammar.HplusplusParser;

public class ProgramBuilder extends HplusplusBaseVisitor<HppProgram> {

    public HppProgram visitProg(HplusplusParser.ProgContext ctx){
        HppProgram prog = new HppProgram();

        for(HplusplusParser.ClassDefContext classCtx : ctx.classDef()){
            String className = classCtx.name().ID().getText();
            prog.add(new HppClass(className));
        }


        final ClassBuilder classBuilder = new ClassBuilder(prog);

        for(HplusplusParser.ClassDefContext classCtx : ctx.classDef()){
            classCtx.accept( classBuilder );
        }

        prog.setCode( ctx.expr().accept(new ExpressionBuilder() ));

        return prog;
    }


}
