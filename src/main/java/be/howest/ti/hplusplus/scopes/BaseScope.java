package be.howest.ti.hplusplus.scopes;

import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.exceptions.execution.KeyAlreadyPresent;
import be.howest.ti.hplusplus.exceptions.execution.KeyNotPresent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BaseScope<T> implements HppScope<T> {

    public T getLocal(String name) {
        if ( values.containsKey(name) ){
            return values.get(name);
        } else {
            throw new KeyNotPresent("No '"+name+"' not found locally.");
        }
    }

    private final Map<String,T> values = new HashMap<>();
    private final Optional<HppScope<T>> parent;
    private final HppProgram prog;

    public BaseScope(HppProgram prog){
        this.prog = prog;
        this.parent = Optional.ofNullable(null);
    }

    public BaseScope(HppScope parent){
        this.prog = parent.getProg();
        this.parent = Optional.of(parent);
    }

    public void add(String name, T val) {
        if ( values.containsKey(name) ){
            throw new KeyAlreadyPresent(name);
        } else {
            values.put(name,val);
        }
    }

    @Override
    public HppProgram getProg() {
        return prog;
    }

    @Override
    public T getSelf() {
        return parent
                .map(HppScope<T>::getSelf)
                .orElseThrow(()->new KeyNotPresent("No parent and 'self' not found."));
    }

    @Override
    public T getIt() {
        return parent
                .map(HppScope<T>::getIt)
                .orElseThrow(()->new KeyNotPresent("No parent and 'it' not found."));
    }

    public T get(String name){
        if ( values.containsKey(name) ){
            return values.get(name);
        } else {
            return parent.map(p->p.get(name))
                    .orElseThrow(()->new KeyNotPresent("No parent and '"+name+"' not found."));
        }
    }

    public T set(String name, T val){
        if ( values.containsKey(name) ){
            return values.put(name,val);
        } else {
            return parent.map(p->p.set(name,val))
                    .orElseThrow(()->new KeyNotPresent("No parent and '"+name+"' not found."));
        }
    }

}
