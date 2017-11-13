package be.howest.ti.hplusplus.exceptions;

public abstract class HppException  extends RuntimeException {

    public HppException(){
        super();
    }

    public HppException(String message){
        super(message);
    }

    public HppException(String message, Throwable cause) {
        super(message,cause);
    }
}
