package be.howest.ti.hplusplus.exceptions;

import java.io.IOException;

public class HppAppException extends HppException {


    public HppAppException(){
        super();
    }

    public HppAppException(String message){
        super(message);
    }

    public HppAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
