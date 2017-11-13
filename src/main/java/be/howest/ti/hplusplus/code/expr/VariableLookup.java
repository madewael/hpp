package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.exceptions.compile.HppTypeCheckException;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.exceptions.execution.KeyNotPresent;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class VariableLookup extends Expression {
    final String name;
    public VariableLookup(String name){this.name=name;}

    public HppValue eval(HppScope<HppValue> scope){
        HppValue res=  scope.get(name);
        if (res == null){
            throw new HppExecutionException(name + "not found");
        }
        return res;
    }

    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        try {
            return typeScope.get(name);
        } catch (KeyNotPresent ex){
            throw new HppTypeCheckException(name + " not found in type scope.");
        }
    }

    public String toString(){
        return String.format("%s: %s", this.getClass().getSimpleName(),name);
    }

}
