package be.howest.ti.hplusplus.types;

import be.howest.ti.hplusplus.code.HppMethodDefinition;
import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.exceptions.HppAppException;
import be.howest.ti.hplusplus.exceptions.compile.DuplicateNameException;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.scopes.HppScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HppClass extends HppType implements HppScope<HppType>
{

    private HppProgram prog = null;

    private List<HppVar> fields;
    private List<HppMethodDefinition> methods;


    public HppClass(String name){
        super(name);
        fields = new ArrayList<>();
        methods = new ArrayList<>();
    }

    public void setProgram(HppProgram prog){
        if (this.prog != null)
            throw new HppAppException("The program of a class should not be set twice !");
        this.prog = prog;
    }

    @Override
    public HppClass getSelf() { return this; }

    @Override
    public HppType getIt() {
        throw new HppAppException("Should not be called...");
    }

    @Override
    public HppType get(String name) {
        return fields.stream().filter(f->f.getName().equals(name)).findFirst().map(HppVar::getType).get();
    }

    @Override
    public HppType set(String name, HppType val) {
        throw new HppAppException("Should not be called...");
    }

    @Override
    public void add(String name, HppType val) {

    }

    public void add(HppVar field){
        if ( hasMember(field.getName()) ){
            throw new DuplicateNameException("class "+ getName() , "field", field.getName());
        }
        fields.add(field);
    }

    public void add(HppMethodDefinition method) {
        if (hasMember(method.getName())) {
            throw new DuplicateNameException("class " + getName(), "method", method.getName());
        }
        methods.add(method);
    }

    private boolean hasMember(String name){
        return fields.stream().filter(f->f.getName().equals(name)).findFirst().isPresent() |
                methods.stream().filter(m->m.getName().equals(name)).findFirst().isPresent();
    }

    public HppProgram getProg() {
        return prog;
    }

    public List<HppMethodDefinition> getMethods() {
        return Collections.unmodifiableList(methods);
    }

    public List<HppVar> getFields() {
        return Collections.unmodifiableList(fields);
    }
}
