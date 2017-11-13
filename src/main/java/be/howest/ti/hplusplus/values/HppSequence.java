package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.code.HppMethodDefinition;
import be.howest.ti.hplusplus.exceptions.execution.KeyNotPresent;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HppSequence extends HppObject {

    private final List<HppValue> values = new ArrayList<>();

    public List<HppValue> getSequence(){
        return Collections.unmodifiableList(values);
    }

    private final HppType baseType;

    public HppSequence(HppType baseType){
        super(new HppClass("HppSequence"));
        this.baseType = baseType;
    }

    @Override
    public HppFunction getMember(String name) {
        switch(name){
            case "size": return new HppFunction(null, this){
                public HppValue apply(List<HppValue> args){
                    return new HppInt(values.size());
                }
            };
            case "add": return new HppFunction(null, this){
                public HppValue apply(List<HppValue> args){
                    for(HppValue val : args){
                        values.add(val);
                    }
                    return new HppInt(args.size()); // return number of elements added.
                }
            };
            case "get": return new HppFunction(null, this){
                public HppValue apply(List<HppValue> args){
                    return values.get( args.get(0).getIntValue() );
                }
            };
            default: throw new KeyNotPresent(name + " in sequence");
        }
    }

    public void add(HppValue val){
        values.add(val);
    }

    @Override
    public HppType getType() {
        return HppType.makeSequenceType(baseType);
    }

    public String toString() {
        return "["+getSequence().stream().map(HppValue::toString).collect(Collectors.joining(", "))+"]";
    }

}
