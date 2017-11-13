package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class Self extends Expression {
    public HppValue eval(HppScope<HppValue> scope){
        return scope.getSelf();
    }

    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        return typeScope.getSelf();
    }

    public String toString(){
        return String.format("%s", this.getClass().getSimpleName());
    }
}
