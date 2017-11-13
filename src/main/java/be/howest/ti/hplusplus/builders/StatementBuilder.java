package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.code.stmt.*;
import be.howest.ti.hplusplus.exceptions.compile.HppCompileException;
import be.howest.ti.hplusplus.grammar.HplusplusBaseVisitor;
import be.howest.ti.hplusplus.grammar.HplusplusParser;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.types.HppClass;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StatementBuilder extends HplusplusBaseVisitor<Statement> {

    private final HppProgram prog;
    private final HppClass c;

    public StatementBuilder(HppProgram prog){
        this(prog,null);
    }

    public StatementBuilder(HppProgram prog, HppClass c) {
        super();
        this.prog = prog;
        this.c =c;
    }

    public Statement visitExprStmt(HplusplusParser.ExprStmtContext ctx){
        return new ExprStmt( ctx.expr().accept(new ExpressionBuilder()) );
    }

    public Statement visitIfStmt(HplusplusParser.IfStmtContext ctx){
        Expression cond = ctx.expr().accept(new ExpressionBuilder());
        Statement body = ctx.stmt(0).accept(this);


        Statement bodyElse = Optional.ofNullable(ctx.stmt(1)).map(x->x.accept(this)).orElse(null);

        return new IfStmt(cond, body,bodyElse);
    }

    public Statement visitForStmt(HplusplusParser.ForStmtContext ctx){
        Expression seq = ctx.expr().accept(new ExpressionBuilder());
        Statement body = ctx.stmt().accept(this);
        return new ForStmt(seq, body);
    }

    public Statement visitReturnStmt(HplusplusParser.ReturnStmtContext ctx){
        if (c==null){
            throw new HppCompileException("Cannot have return statement in program.");
        }
        return new ReturnStmt( ctx.expr().accept(new ExpressionBuilder()) );
    }

    public Statement visitBlockStmt(HplusplusParser.BlockStmtContext ctx){
        List<Statement> stmts = ctx.stmt().stream().map(stmt -> stmt.accept(this)).collect(Collectors.toList());
        return new BlockStmt(stmts);
    }

    @Override
    public Statement visitVarDefStmt(HplusplusParser.VarDefStmtContext ctx) {
        String name = ctx.varDef().name().getText();
        String type = ctx.varDef().type().getText();
        Statement res =  new VarDefStmt(name,prog.getType(type));
        return res;
    }

    public Statement visitAssignStmt(HplusplusParser.AssignStmtContext ctx){
        String name = ctx.name().getText();
        Expression val = ctx.expr().accept(new ExpressionBuilder());
        if (ctx.self() != null){
            return new MemberAssignStmt(name, val);
        } else {
            return new AssignStmt(name,val);
        }
    }

    @Override
    public Statement visitObserveStmt(HplusplusParser.ObserveStmtContext ctx) {
        Expression observer = ctx.expr(0).accept(new ExpressionBuilder());
        Expression subject = ctx.expr(1).accept(new ExpressionBuilder());
        String memberName = ctx.name().getText();
        return new ObserveStmt(observer,subject,memberName);
    }

    @Override
    public Statement visitPrintStmt(HplusplusParser.PrintStmtContext ctx) {
        ExpressionBuilder exprBuilder = new ExpressionBuilder();
        List<Expression> vals = ctx.expr().stream().map( expr->expr.accept(exprBuilder)).collect(Collectors.toList());
        return new PrintStmt(vals);
    }
}
