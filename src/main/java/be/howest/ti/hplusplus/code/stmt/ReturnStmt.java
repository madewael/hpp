package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class ReturnStmt extends Statement {

    final Expression expr;
    public ReturnStmt(Expression expr){
        this.expr=expr;
    }

    @Override
    public void eval(HppScope<HppValue> scope) {
        HppValue res = expr.eval(scope);
        if (res==null){
            throw new HppExecutionException(expr + " evaluated to null");
        }
        throw res;
    }
}
