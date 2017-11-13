package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class Instantiation extends Expression {

    private final String className;

    public Instantiation(String name){
        this.className = name;
    }

    @Override
    public HppValue eval(HppScope<HppValue> scope){
        try {
            HppClass c = (HppClass)scope.getProg().getType(className);
            return new HppObject(c);
        } catch (ClassCastException ex){
            throw new HppExecutionException("Cannot instanciate an object of class " + className +", because it is " +
                    "not a class: "+ scope.getProg().getType(className));
        }

    }

    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        return typeScope.getProg().getType(className);
    }

    public String toString(){
        return String.format("%s of class %s", this.getClass().getSimpleName(),
                className);
    }
}
