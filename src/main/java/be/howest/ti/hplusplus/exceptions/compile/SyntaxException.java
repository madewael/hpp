package be.howest.ti.hplusplus.exceptions.compile;

public class SyntaxException extends HppCompileException {

    public SyntaxException(String msg){
        super(String.format("Syntax: %s",msg));
    }

}
