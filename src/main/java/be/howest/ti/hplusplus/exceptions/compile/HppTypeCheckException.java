package be.howest.ti.hplusplus.exceptions.compile;

import be.howest.ti.hplusplus.code.expr.Expression;

public class HppTypeCheckException extends HppCompileException {

    public HppTypeCheckException(Expression expr, String expected){
        super(String.format("Expected '%s' to be of type '%s' but found '%s'",expr,expected,expr.getType()));
    }

    public HppTypeCheckException(String msg){
        super(msg);
    }
}
