package hw7.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/** A pizza created through {@link PizzaBuilder}. */
public final class Pizza {
    private final String chain;
    private final Size size;
    private final List<Topping> toppings;

    Pizza(PizzaBuilder builder) {
        this.chain = builder.getChain();
        this.size = builder.getSize();
        this.toppings = Collections.unmodifiableList(
                new ArrayList<Topping>(builder.getToppings()));
    }

    public String getChain() {
        return chain;
    }

    public Size getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    /** Prints the pizza chain, required size, and every selected topping. */
    public void eat() {
        String toppingList = toppings.stream()
                .map(Topping::getDisplayName)
                .collect(Collectors.joining(", "));

        System.out.printf("%s | %s pizza | Toppings: %s%n",
                chain, size.getDisplayName(), toppingList);
    }

    public enum Size {
        SMALL("Small"),
        MEDIUM("Medium"),
        LARGE("Large");

        private final String displayName;

        Size(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum Topping {
        PEPPERONI("Pepperoni"),
        SAUSAGE("Sausage"),
        MUSHROOMS("Mushrooms"),
        BACON("Bacon"),
        ONIONS("Onions"),
        EXTRA_CHEESE("Extra Cheese"),
        PEPPERS("Peppers"),
        CHICKEN("Chicken"),
        OLIVES("Olives"),
        SPINACH("Spinach"),
        TOMATO_AND_BASIL("Tomato and Basil"),
        BEEF("Beef"),
        HAM("Ham"),
        PESTO("Pesto"),
        SPICY_PORK("Spicy Pork"),
        HAM_AND_PINEAPPLE("Ham and Pineapple");

        private final String displayName;

        Topping(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
