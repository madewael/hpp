package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class IfStmt extends Statement {

    final Expression cond;
    final Statement body, bodyElse;



    public IfStmt(Expression expr, Statement body){
        this(expr,body,null);
    }
    public IfStmt(Expression expr, Statement body, Statement bodyElse){this.cond=expr;this.body=body;this
            .bodyElse=bodyElse;}


    @Override
    public void eval(HppScope<HppValue> scope) {
        HppValue cond = this.cond.eval(scope);

        if ( cond.getBooleanValue() ){
            body.eval(scope);
        } else if (bodyElse != null) {
            bodyElse.eval(scope);
        }
    }
}
