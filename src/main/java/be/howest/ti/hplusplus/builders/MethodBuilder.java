package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.HppMethodDefinition;
import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.code.stmt.Statement;
import be.howest.ti.hplusplus.grammar.HplusplusBaseVisitor;
import be.howest.ti.hplusplus.grammar.HplusplusParser;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.types.HppClass;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class MethodBuilder extends HplusplusBaseVisitor<HppMethodDefinition> {

    private final HplusplusBaseVisitor<HppVar> varBuilder = new HplusplusBaseVisitor<HppVar>(){
        @Override
        public HppVar visitParam(HplusplusParser.ParamContext ctx) {
            String varName = ctx.varDef().name().getText();
            String varType = ctx.varDef().type().getText();
            return new HppVar(varName,prog.getType(varType));
        }
    };

    private final HppProgram prog;
    private final HppClass c;
    public MethodBuilder(HppProgram prog, HppClass c) {
        super();
        this.prog = prog;
        this.c = c;

    }


    @Override
    public HppMethodDefinition visitMethodDef(HplusplusParser.MethodDefContext ctx) {
        String name = ctx.name().getText();

        List<HppVar> params = new ArrayList<>();
        if(ctx.params() != null) {
            for (ParseTree pt : ctx.params().children) {
                HppVar p = pt.accept(varBuilder);
                if (p != null) {
                    params.add(p);
                } else {
                    //System.out.println("Null param:"+ pt.getText());
                }
            }
        }

        String returnType = ctx.type().getText();

        Statement body = ctx.block().accept(new StatementBuilder(prog, c));


        return new HppMethodDefinition(name,params, prog.getType(returnType), body);
    }
}
