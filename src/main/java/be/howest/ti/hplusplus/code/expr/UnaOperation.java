package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.exceptions.compile.HppTypeCheckException;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppInt;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class UnaOperation extends Expression {
    final String op;
    final Expression expr;

    public UnaOperation(String op, Expression expr){
        this.op = op;
        this.expr = expr;
    }

    public HppValue eval(HppScope<HppValue> scope){
        HppValue val = expr.eval(scope);
        switch(op){
            case "-": return new HppInt( -val.getIntValue() );
            default: throw new HppExecutionException("Unsupported Operation");
        }


    }

    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        HppType expected = null,ret = null;
        switch(op){
            case "-": expected = HppType.INT; ret= HppType.INT; break;
            default: throw new HppExecutionException("Unsupported Operation");
        }

        if (expected == expr.checkType(typeScope)){
            return ret;
        } else {
            throw new HppTypeCheckException("Expected an operant of type "+ expected + " with operator "+op+". Foudn " +
                    ""+expr.getType()+".");
        }

    }

    public String toString(){
        return String.format("%s: %s %s", this.getClass().getSimpleName(),op,expr);
    }

}
