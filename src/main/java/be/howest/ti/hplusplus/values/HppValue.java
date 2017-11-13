package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.exceptions.execution.TypeExceptionDuringExecution;

import java.util.List;

public abstract class HppValue extends RuntimeException {

    public int getIntValue(){
        throw new TypeExceptionDuringExecution("int",this.getClass().getSimpleName(),this);
    }

    public String getStringValue(){
        throw new TypeExceptionDuringExecution("string",this.getClass().getSimpleName(),this);
    }

    public boolean getBooleanValue(){
        throw new TypeExceptionDuringExecution("bool",this.getClass().getSimpleName(),this);
    }

    public List<HppValue> getSequence(){
        throw new TypeExceptionDuringExecution("sequence",this.getClass().getSimpleName(),this);
    }

    public HppObject getObject(){
        throw new TypeExceptionDuringExecution("ref",this.getClass().getSimpleName(),this);
    }


    public abstract HppType getType();

    public static HppValue getUndefined(final HppType type){
        return new HppValue(){

            public String toString(){
                return String.format("Undefined value of type %s", getType());
            }

            @Override
            public HppType getType() {
                return type;
            }
        };
    }


}
