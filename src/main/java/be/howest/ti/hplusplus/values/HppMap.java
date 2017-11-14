package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.exceptions.execution.KeyNotPresent;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;
import java.util.*;

public class HppMap extends HppObject {

    private final Map<HppValue, HppValue> mappings = new HashMap<>();

    public Map<HppValue, HppValue> getMap() {
        return Collections.unmodifiableMap(mappings);
    }

    private final HppType keyType;
    private final HppType valueType;

    public HppMap(HppType keyType, HppType valueType){
        super(new HppClass("HppMap"));
        this.keyType = keyType;
        this.valueType = valueType;
    }

    @Override
    public HppFunction getMember(String name) {
        switch(name){
            case "put": return new HppFunction(null, this){
                public HppValue apply(List<HppValue> args) {
                    mappings.put(args.get(0), args.get(1));
                    return new HppInt(mappings.size());
                }
            };
            case "get": return new HppFunction(null, this){
                public HppValue apply(List<HppValue> args) {
                    return mappings.get(args.get(0));
                }
            };
            default: throw new KeyNotPresent(name + " in sequence");
        }
    }

    public void add(HppValue key, HppValue value){
        mappings.put(key, value);
    }

    @Override
    public HppType getType() {
        return HppType.makeMapType(keyType, valueType);
    }

    @Override
    public String toString() {
        return "";
    }
}
