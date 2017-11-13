package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.HppMethodDefinition;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.grammar.HplusplusBaseVisitor;
import be.howest.ti.hplusplus.grammar.HplusplusParser;

public class ClassBuilder extends HplusplusBaseVisitor<HppClass> {

    private final HppProgram prog;

    public ClassBuilder(HppProgram prog){
        this.prog = prog;
    }


    public HppClass visitClassDef(HplusplusParser.ClassDefContext ctx){
        String className = ctx.name().ID().getText();
        HppClass c = (HppClass)prog.getType(className);

        ctx.memberDefs().accept(new HplusplusBaseVisitor<Void>(){
            public Void visitMethodDef(HplusplusParser.MethodDefContext ctx){
                String name = ctx.name().ID().getText();

                HppMethodDefinition method = ctx.accept(new MethodBuilder(prog, c));

                c.add(method);
                return null;
            }

            public Void visitFieldDef(HplusplusParser.FieldDefContext ctx){
                String fieldName = ctx.varDef().name().ID().getText();
                String fieldType = ctx.varDef().type().getText();
                c.add(new HppVar(fieldName,prog.getType(fieldType)));
                return null;
            }
        });

        return c;
    }










}
