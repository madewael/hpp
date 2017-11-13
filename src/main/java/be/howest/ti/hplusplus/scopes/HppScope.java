package be.howest.ti.hplusplus.scopes;

import be.howest.ti.hplusplus.code.HppProgram;

public interface HppScope<T> {

    T getSelf();
    T getIt();
    T get(String name);
    T set(String name, T val);
    void add(String name, T val);

    HppProgram getProg();
}
