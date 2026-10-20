package hw7.builder;

import static hw7.builder.Pizza.Size.LARGE;
import static hw7.builder.Pizza.Size.MEDIUM;
import static hw7.builder.Pizza.Size.SMALL;
import static hw7.builder.Pizza.Topping.BACON;
import static hw7.builder.Pizza.Topping.BEEF;
import static hw7.builder.Pizza.Topping.CHICKEN;
import static hw7.builder.Pizza.Topping.EXTRA_CHEESE;
import static hw7.builder.Pizza.Topping.HAM;
import static hw7.builder.Pizza.Topping.HAM_AND_PINEAPPLE;
import static hw7.builder.Pizza.Topping.MUSHROOMS;
import static hw7.builder.Pizza.Topping.OLIVES;
import static hw7.builder.Pizza.Topping.ONIONS;
import static hw7.builder.Pizza.Topping.PEPPERONI;
import static hw7.builder.Pizza.Topping.PEPPERS;
import static hw7.builder.Pizza.Topping.PESTO;
import static hw7.builder.Pizza.Topping.SAUSAGE;
import static hw7.builder.Pizza.Topping.SPICY_PORK;
import static hw7.builder.Pizza.Topping.SPINACH;
import static hw7.builder.Pizza.Topping.TOMATO_AND_BASIL;

/** Demonstrates every pizza and topping-count combination required by HW7. */
public final class PizzaDriver {
    private PizzaDriver() {
    }

    public static void main(String[] args) {
        System.out.println("=== Original Pizza Hut pizzas ===");
        createPizza("Pizza Hut", SMALL,
                PEPPERONI, MUSHROOMS, EXTRA_CHEESE).eat();
        createPizza("Pizza Hut", MEDIUM,
                SAUSAGE, BACON, ONIONS, PEPPERS, CHICKEN, OLIVES).eat();
        createPizza("Pizza Hut", LARGE,
                PEPPERONI, SAUSAGE, MUSHROOMS, BACON, ONIONS,
                EXTRA_CHEESE, PEPPERS, OLIVES, SPINACH).eat();

        System.out.println();
        System.out.println("=== Expanded pizza chains ===");
        createPizza("Pizza Hut", LARGE,
                CHICKEN, TOMATO_AND_BASIL, PESTO).eat();
        createPizza("Pizza Hut", SMALL,
                HAM, HAM_AND_PINEAPPLE).eat();

        createPizza("Little Caesars", MEDIUM,
                PEPPERONI, SAUSAGE, MUSHROOMS, BACON,
                ONIONS, EXTRA_CHEESE, PEPPERS, OLIVES).eat();
        createPizza("Little Caesars", SMALL,
                BEEF, CHICKEN, ONIONS, PEPPERS, PESTO, SPICY_PORK).eat();

        createPizza("Dominos", SMALL,
                EXTRA_CHEESE).eat();
        createPizza("Dominos", LARGE,
                PEPPERONI, BACON, MUSHROOMS).eat();
    }

    private static Pizza createPizza(String chain, Pizza.Size size,
                                     Pizza.Topping... toppings) {
        PizzaBuilder builder = new PizzaBuilder(chain, size);
        for (Pizza.Topping topping : toppings) {
            builder.addTopping(topping);
        }
        return builder.build();
    }
}
