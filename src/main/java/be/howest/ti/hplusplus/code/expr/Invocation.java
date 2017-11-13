package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.exceptions.compile.HppTypeCheckException;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.FunctionType;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppFunction;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

import java.util.List;
import java.util.stream.Collectors;

public class Invocation extends Expression {
    final Expression function;
    final List<Expression> args;


    public String toString(){
        return String.format("%s: %s with %s", this.getClass().getSimpleName(),
                function,
                args.stream().map(Expression::toString).collect(Collectors.joining(",")));
    }

    public Invocation(Expression function, List<Expression> args){this.function = function; this.args=args;}


    public HppValue eval(HppScope<HppValue> scope){
        HppFunction func = (HppFunction) this.function.eval(scope);
        if (func==null) throw new HppExecutionException("No function found:"+ function);

        List<HppValue> args = this.args.stream()
                .map(arg->{
                    return arg.eval(scope);
                })
                .collect(Collectors.toList());
        return func.apply(args);
    }
    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        try {
            FunctionType funType = (FunctionType) function.checkType(typeScope);
            List<HppType> args = this.args.stream()
                    .map(arg->{
                        return arg.checkType(typeScope);
                    })
                    .collect(Collectors.toList());

            List<HppType> params = funType.getParamTypes();

            if (params.size() != args.size()){
                throw new HppTypeCheckException(String.format("%s: expected %d args, found %d",
                        this, params.size(), args.size()));
            }

            for(int i=0; i<params.size() ; i++){
                if ( args.get(i) != params.get(i) ){
                    throw new HppTypeCheckException(String.format("%s: expected arg %d to be %s, found %s",
                            this, i, params.get(i), args.get(i)));
                }


            }
            return funType.getReturnType();
        } catch (ClassCastException ex){
            throw new HppTypeCheckException(function,"function");
        }
    }

}
