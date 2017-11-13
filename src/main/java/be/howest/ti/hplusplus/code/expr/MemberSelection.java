package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.exceptions.compile.HppTypeCheckException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class MemberSelection extends Expression {
    final String memberName;
    final Expression object;


    public MemberSelection(String memberName, Expression object){ this.memberName=memberName;this.object=object;}

    public HppValue eval(HppScope<HppValue> scope){
        HppObject base = object.eval(scope).getObject();
        return base.getMember(memberName);
    }

    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        try {
            HppClass objectsClass = (HppClass) object.checkType(typeScope);
            return objectsClass.get(memberName);
        } catch (ClassCastException ex){
            throw new HppTypeCheckException("The type of "+object+" is not a class !");
        }
    }

    public String toString(){
        return String.format("%s: %s of %s", this.getClass().getSimpleName(),memberName, object);
    }
}
