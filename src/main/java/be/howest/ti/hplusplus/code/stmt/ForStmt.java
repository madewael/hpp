package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.scopes.HppLocalScope;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class ForStmt extends Statement {
    final Expression sequence;
    final Statement body;
    public ForStmt(Expression expr, Statement body){this.sequence=expr;this.body=body;}

    @Override
    public void eval(HppScope<HppValue> scope) {
        for(HppValue it : sequence.eval(scope).getSequence()){
            HppScope<HppValue> local = new HppLocalScope<>(scope,it);
            body.eval(local);
        }
    }
}
