package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.types.HppType;

public class HppInt extends HppValue {

    private final int n;

    public HppInt(int n){ this.n = n; }

    public int getIntValue(){
        return n;
    }

    @Override
    public HppType getType() {
        return HppType.INT;
    }

    public String toString(){
        return String.format("HppInt(%d)",n);
    }



}