package be.howest.ti.hplusplus.code;

import be.howest.ti.hplusplus.types.HppType;

public class HppVar {

    private final String name;
    private HppType type;

    public HppVar(String name, HppType type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public HppType getType(){
        return type;
    }
}
