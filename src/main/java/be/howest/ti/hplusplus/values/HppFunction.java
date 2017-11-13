package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.code.HppMethodDefinition;
import be.howest.ti.hplusplus.types.FunctionType;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.code.stmt.Statement;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppLocalScope;
import be.howest.ti.hplusplus.scopes.HppScope;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HppFunction extends HppValue {

    private final HppMethodDefinition method;
    private final HppObject base;

    public HppFunction(HppMethodDefinition method, HppObject base){
        this.method = method;
        this.base = base;
    }

    public String getName(){ return method.getName(); }

    public HppValue apply(List<HppValue> args){
        return method.apply(base,args);
    }

    @Override
    public FunctionType getType() { return method.getType(); }

    public List<HppVar> getParams() {
        return method.getParams();
    }

    public String toString(){
        return "Function:" + getName();
    }

}
