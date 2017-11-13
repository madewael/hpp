package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.expr.*;
import be.howest.ti.hplusplus.exceptions.compile.HppCompileException;
import be.howest.ti.hplusplus.grammar.HplusplusBaseVisitor;
import be.howest.ti.hplusplus.grammar.HplusplusParser;
import be.howest.ti.hplusplus.values.HppBool;
import be.howest.ti.hplusplus.values.HppInt;
import be.howest.ti.hplusplus.values.HppString;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class ExpressionBuilder extends HplusplusBaseVisitor<Expression> {

    public Expression visitNumberLiteral(HplusplusParser.NumberLiteralContext ctx){
        return new Literal(new HppInt( Integer.parseInt(ctx.NUMBER().getText())));
    }

    public Expression visitBooleanLiteral(HplusplusParser.BooleanLiteralContext ctx){
        switch(ctx.BOOL().getText()){
            case "yes": return new Literal(HppBool.YES);
            case "no": return new Literal(HppBool.NO);
            default: throw new HppCompileException("Found unexpected boolean:"+ctx.BOOL().getText());
        }
    }

    public Expression visitStringLiteral(HplusplusParser.StringLiteralContext ctx){
        String strWithQuotes = ctx.STRING().getText();
        return new Literal(new HppString( strWithQuotes.substring(1,strWithQuotes.length()-1) ));
    }

    public Expression visitInvocation(HplusplusParser.InvocationContext ctx){
        Expression tar = ctx.expr().accept(this);
        List<Expression> args = new ArrayList<>();
        if(ctx.args() != null) {
            for (ParseTree pt : ctx.args().children) {
                Expression arg = pt.accept(this);
                if (arg != null) {
                    args.add(arg);
                } else {
                    //System.out.println("Null arg:"+ pt.getText());
                }
            }
        }


        return new Invocation(tar,args);
    }

    public Expression visitName(HplusplusParser.NameContext ctx){
        return new VariableLookup(ctx.getText());
    }

    public Expression visitMemberSelection(HplusplusParser.MemberSelectionContext ctx){
        String name = ctx.name().ID().getSymbol().getText();

        if (ctx.self()!=null) {
            return new OwnMemberSelection(name);
        } else {
            Expression obj = ctx.expr().accept(this);
            return new MemberSelection(name, obj);
        }



    }

    public Expression visitAssocExpr(HplusplusParser.AssocExprContext ctx){
        return ctx.expr().accept(this);
    }

    public Expression visitSelf(HplusplusParser.SelfContext ctx){
        return new Self();
    }

    public Expression visitIt(HplusplusParser.ItContext ctx){
        return new It();
    }

    public Expression visitUniOp(HplusplusParser.UniOpContext ctx){
        Expression a = ctx.expr().accept(this);
        String op = ctx.OP().getText();
        return new UnaOperation(op,a);
    }



    public Expression visitBinOp(HplusplusParser.BinOpContext ctx){
        Expression a = ctx.expr(0).accept(this);
        String op = ctx.OP().getText();
        Expression b = ctx.expr(1).accept(this);
        return new BinOperation(a, op, b);
    }




    @Override
    public Expression visitInstantiation(HplusplusParser.InstantiationContext ctx) {
        return new Instantiation(ctx.name().getText());
    }

}
