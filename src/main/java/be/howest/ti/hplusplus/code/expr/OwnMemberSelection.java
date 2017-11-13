package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.exceptions.HppAppException;
import be.howest.ti.hplusplus.exceptions.compile.HppTypeCheckException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class OwnMemberSelection extends Expression {
    final String memberName;

    public OwnMemberSelection(String memberName){ this.memberName=memberName;}

    public HppValue eval(HppScope<HppValue> scope){
        try {
            return scope.getSelf().getObject().get(memberName);
        } catch (ClassCastException ex){
            throw new HppAppException("self was not an object");
        }
    }

    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        try{
            HppClass myClass = (HppClass)typeScope.getSelf();
            return myClass.get(memberName);
        } catch (ClassCastException ex){
            throw new HppTypeCheckException("The type of "+typeScope.getSelf()+" is not a class !");
        }
    }

    public String toString(){
        return String.format("%s: %s", this.getClass().getSimpleName(),memberName);
    }

}
