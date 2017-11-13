package be.howest.ti.hplusplus.code;

import be.howest.ti.hplusplus.code.stmt.Statement;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppLocalScope;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.FunctionType;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppValue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HppMethodDefinition {

    protected final String name;
    protected final List<HppVar> params;
    protected final Statement body;
    protected HppType returnType;

    public HppMethodDefinition(String name, List<HppVar> params, HppType returnType, Statement body) {
        this.params = params;
        this.name = name;
        this.body = body;
        this.returnType = returnType;
    }

    public String getName(){
        return name;
    }

    public HppValue apply(HppScope<HppValue> parentScope, List<HppValue> args){
        HppLocalScope newScope = new HppLocalScope(parentScope,null);

        if ( params.size() != args.size()){
            throw new HppExecutionException(String.format("The function %s expects %d arguments, given %s",
                    getName(), params.size(), args.size()
                    ));
        }

        for(int i=0;i<params.size(); i++){
            newScope.add(params.get(i).getName(), args.get(i));
        }

        try {
            body.eval(newScope);
        } catch (HppValue returnValue){
            return returnValue;
        }
        throw new HppExecutionException("The function "+getName()+ " did not return");
    }

    public FunctionType getType() {
        return FunctionType.getFunctionType(params.stream().map(p->p.getType()).collect(Collectors.toList()),
                returnType);
    }

    public List<HppVar> getParams() {
        return Collections.unmodifiableList(params);
    }

    public Statement getBody() {
        return body;
    }
}
