package be.howest.ti.hplusplus.exceptions.compile;

public class DuplicateNameException extends HppCompileException {

    public DuplicateNameException(String ctx, String type, String name){
        super(String.format("Cannot create second %s in %s with same name: %s",type, ctx, name));
    }

}
