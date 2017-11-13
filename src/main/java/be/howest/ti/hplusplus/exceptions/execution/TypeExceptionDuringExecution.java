package be.howest.ti.hplusplus.exceptions.execution;

public class TypeExceptionDuringExecution extends HppExecutionException {


    public TypeExceptionDuringExecution(String expected, String received, Object obj){
        super(String.format("Expected a value of type '%s' but found '%s' (%s)",expected, received,obj));
    }

}
