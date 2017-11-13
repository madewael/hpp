package be.howest.ti.hplusplus.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FunctionType extends HppType {

    private static final Map<String,FunctionType> CACHE = new HashMap<>();

    private final List<HppType> args;
    private final HppType ret;

    private FunctionType(List<HppType> args, HppType ret){
        super(buildName(args, ret));
        this.args = args;
        this.ret = ret;
        CACHE.put(this.getName(),this);
    }

    public static FunctionType getFunctionType(List<HppType> args, HppType ret){
        String name = buildName(args, ret);
        return Optional
                .ofNullable(CACHE.get(name))
                .orElseGet(()->new FunctionType(args,ret));
    }

    private static String buildName(List<HppType> args, HppType ret) {
        return String.format("[f(%s)->%s]",
                args.stream().map(HppType::toString).collect(Collectors.joining(",")),
                ret.toString());
    }

    public HppType getReturnType() {
        return ret;
    }

    public List<HppType> getParamTypes() {
        return args;
    }
}
