package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class Literal extends Expression {
    final HppValue val;

    public Literal(HppValue val){this.val=val;}

    public HppValue getLiteral(){
        return val;
    }

    @Override public HppValue eval(HppScope<HppValue> scope){
        return val;
    }

    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        return val.getType();
    }


}
