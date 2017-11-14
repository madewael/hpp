package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.types.HppType;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && getIntValue() == ((HppInt) obj).getIntValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}