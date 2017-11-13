package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class ExprStmt extends Statement {
    final Expression expr;
    public ExprStmt(Expression expr){this.expr=expr;}

    @Override
    public void eval(HppScope<HppValue> scope) {
        expr.eval(scope);
    }
}
