package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class AssignStmt extends Statement {
    final String tar;
    final Expression val;
    public AssignStmt(String tar, Expression val){
        this.tar=tar;
        this.val=val;
    }
    @Override
    public void eval(HppScope<HppValue> scope) {
        scope.set(tar, val.eval(scope));
    }
}
