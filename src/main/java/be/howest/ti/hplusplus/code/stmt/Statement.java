package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.exceptions.HppAppException;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppLocalScope;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

import java.util.List;

public abstract class Statement {

    public abstract void eval(HppScope<HppValue> scope);

}