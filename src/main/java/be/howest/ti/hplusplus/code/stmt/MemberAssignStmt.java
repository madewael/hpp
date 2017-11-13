package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class MemberAssignStmt extends Statement {
    final String memberName;
    final Expression val;

    public MemberAssignStmt(String memberName, Expression val){
        this.memberName = memberName;
        this.val=val;
    }

    @Override
    public void eval(HppScope<HppValue> scope) {
        try {
            scope.getSelf().getObject().set(memberName,val.eval(scope));
        } catch (ClassCastException ex){
            throw new HppExecutionException("Get self in scope returned a non-object:"+scope.getSelf());
        }
    }
}
