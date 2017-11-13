package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.exceptions.HppAppException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppValue;

public abstract class Expression {

    public abstract HppValue eval(HppScope<HppValue> scope);

    protected HppType type = null;

    public HppType getType(){
        if (type==null) throw new HppAppException("Cant get type. Do type check first");
        return type;
    }

    public HppType checkType(HppScope<HppType> typeScope){
        if (this.type==null) this.type = determineType(typeScope);
        return type;
    }

    protected abstract HppType determineType(HppScope<HppType> typeScope);

}
