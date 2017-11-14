package be.howest.ti.hplusplus.code;

import be.howest.ti.hplusplus.code.stmt.Statement;
import be.howest.ti.hplusplus.exceptions.execution.KeyNotPresent;
import be.howest.ti.hplusplus.scopes.BaseScope;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.code.expr.Expression;
import be.howest.ti.hplusplus.exceptions.HppAppException;
import be.howest.ti.hplusplus.exceptions.compile.DuplicateNameException;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppFunction;
import be.howest.ti.hplusplus.values.HppValue;

import java.util.HashMap;
import java.util.Map;

public class HppProgram {

    private final Map<String, HppClass> classes;
    private Expression code;

    public HppProgram(){
        classes = new HashMap<>();
    }

    public void add(HppClass c){
        if (classes.containsKey(c.getName())){
            throw new DuplicateNameException("the program","class", c.getName());
        } else {
            c.setProgram(this);
            classes.put(c.getName(), c);
        }
    }


    public void setCode(Expression code){
        this.code = code;
    }


    public HppType getType(String name) {
        try {
            return HppType.getTypeByName(name);
        } catch( KeyNotPresent ex) {
            if (classes.containsKey(name)) {
                return classes.get(name);
            } else if (name.endsWith("s")) {
                String baseName = name.substring(0, name.length() - 1);
                return HppType.makeSequenceType(getType(baseName));
            } else if (name.split(" to ").length == 2) {
                String[] names = name.split(" to ");
                return HppType.makeMapType(getType(names[0]), getType(names[1]));
            } else {
                throw new KeyNotPresent(name + " is not a known type");
            }
        }
    }

    public HppValue eval() {
        return this.code.eval(new BaseScope<HppValue>(this));
    }


}
