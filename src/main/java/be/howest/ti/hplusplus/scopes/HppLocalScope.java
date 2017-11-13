package be.howest.ti.hplusplus.scopes;

import java.util.Optional;

public class HppLocalScope<T> extends BaseScope<T> {

    private final Optional<T> it;
    public HppLocalScope(HppScope<T> parent, T it){
        super(parent);
        this.it = Optional.ofNullable(it);
    }

    @Override
    public T getIt() {
        return it.orElseGet(()->super.getIt());
    }
}
