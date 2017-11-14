package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.types.HppType;

import java.util.Objects;

public class HppString extends HppValue {

    private final String str;

    public HppString(String str){
        this.str = str;
    }

    public String getStringValue(){
        return str;
    }

    @Override
    public HppType getType() {
        return HppType.STR;
    }

    public String toString(){ return str; }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && getStringValue().equals(((HppString) obj).getStringValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}