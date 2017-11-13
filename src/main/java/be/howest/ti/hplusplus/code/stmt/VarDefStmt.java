package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class VarDefStmt extends Statement {

    final HppVar var;
    public VarDefStmt(HppVar var){this.var=var;}
    public VarDefStmt(String name, HppType type){
        this(new HppVar(name,type));
    }

    @Override
    public void eval(HppScope<HppValue> scope) {
        scope.add(var.getName(), var.getType().getDefaultValue());
    }
}
