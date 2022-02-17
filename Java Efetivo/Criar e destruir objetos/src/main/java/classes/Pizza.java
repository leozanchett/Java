package classes;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addToping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract T self();

        abstract Pizza build();
        // As subclasses devem sobreescrever esse método para retornar "essa classe protegida abstrata T; self()
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
