package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.code.expr.MemberSelection;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppFunction;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class ObserveStmt extends Statement {

    private final Expression observer;
    private final Expression subject;
    private final String memberName;

    public ObserveStmt(Expression observer, Expression subject, String memberName) {
        this.observer = observer;
        this.subject = subject;
        this.memberName = memberName;
    }

    @Override
    public void eval(HppScope<HppValue> scope) {
        try {
            HppFunction observer = (HppFunction) this.observer.eval(scope);
            HppObject subject = this.subject.eval(scope).getObject();
            subject.addObserver(memberName, observer);
        } catch (ClassCastException ex){
            throw new HppExecutionException("Observer should be a function.");
        }
    }
}
