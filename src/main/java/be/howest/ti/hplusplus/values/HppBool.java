package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.types.HppType;

public class HppBool extends HppValue {

    public static final HppBool YES = new HppBool(){

        public boolean getBooleanValue(){return true;}
        public String toString(){return "_YES_"; }

    };

    public static final HppBool NO = new HppBool(){

        public boolean getBooleanValue(){return false;}
        public String toString(){return "_NO_"; }

    };

    private HppBool(){ }

    @Override
    public HppType getType() {
        return HppType.BOOL;
    }

}
