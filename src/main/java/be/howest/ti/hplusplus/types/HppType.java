package be.howest.ti.hplusplus.types;

import be.howest.ti.hplusplus.exceptions.execution.KeyNotPresent;
import be.howest.ti.hplusplus.values.HppMap;
import be.howest.ti.hplusplus.values.HppSequence;
import be.howest.ti.hplusplus.values.HppValue;

public abstract class HppType {



    public static final HppType INT = new HppType("INT"){ };
    public static final HppType STR = new HppType("STR"){};
    public static final HppType BOOL = new HppType("BOOL"){};
    public static final HppType makeSequenceType(HppType base){
        return  new HppType("SEQ of " + base.getName()){

            public HppValue getDefaultValue() {
                return new HppSequence(base);
            }

        };
    }

    public static final HppType makeMapType(HppType key, HppType value) {
        return new HppType("MAP of " + key.getName() + " to " + value.getName()) {
            public HppValue getDefaultValue() { return new HppMap(key, value); }
        };
    }

    public static HppType getTypeByName(String name){
        switch(name){
            case "int": return INT;
            case "string": return STR;
            case "bool": return BOOL;
            default: throw new KeyNotPresent(name + " is a unknown base-type");
        }
    }


    private final String name;

    protected HppType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HppType hppType = (HppType) o;

        return name.equals(hppType.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String toString(){
        return name;
    }

    public HppValue getDefaultValue() {
        return HppValue.getUndefined(this);
    }
}

