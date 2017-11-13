package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

import java.util.List;
import java.util.stream.Collectors;

public class PrintStmt extends Statement {
    final List<Expression> vals;
    public PrintStmt(List<Expression> vals){
        this.vals=vals;
    }

    @Override
    public void eval(HppScope<HppValue> scope) {
        String res = vals
                .stream()
                .map(val->val.eval(scope))
                .map(HppValue::toString)
                .collect(Collectors.joining(" "));
        System.out.println(">>"+res);
    }
}
