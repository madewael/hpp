package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppValue;

/**
 * Created by tomdo on 14/11/2017.
 */
public class WhileStmt extends Statement {
    final Expression cond;
    final Statement body;

    public WhileStmt(Expression expr, Statement body) {
        this.cond = expr;
        this.body = body;
    }

    @Override
    public void eval(HppScope<HppValue> scope) {
        while ( this.cond.eval(scope).getBooleanValue() ) {
            body.eval(scope);
        }
    }
}
