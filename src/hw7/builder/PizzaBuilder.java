package hw7.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Builder for pizzas whose chain and size are required at creation time. */
public final class PizzaBuilder {
    private final String chain;
    private final Pizza.Size size;
    private final Set<Pizza.Topping> toppings = new LinkedHashSet<Pizza.Topping>();

    public PizzaBuilder(String chain, Pizza.Size size) {
        if (chain == null || chain.trim().isEmpty()) {
            throw new IllegalArgumentException("Pizza chain is required.");
        }
        if (size == null) {
            throw new IllegalArgumentException("Pizza size is required.");
        }
        this.chain = chain.trim();
        this.size = size;
    }

    public PizzaBuilder addTopping(Pizza.Topping topping) {
        if (topping == null) {
            throw new IllegalArgumentException("Topping cannot be null.");
        }
        toppings.add(topping);
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }

    String getChain() {
        return chain;
    }

    Pizza.Size getSize() {
        return size;
    }

    List<Pizza.Topping> getToppings() {
        return Collections.unmodifiableList(
                new ArrayList<Pizza.Topping>(toppings));
    }
}
