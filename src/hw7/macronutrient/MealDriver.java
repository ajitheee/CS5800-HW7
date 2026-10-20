package hw7.macronutrient;

/** Generates valid random meals for six customers covering every diet plan. */
public final class MealDriver {
    private MealDriver() {
    }

    public static void main(String[] args) {
        Customer[] customers = {
                new Customer("Alex", DietPlan.NO_RESTRICTION),
                new Customer("Bianca", DietPlan.PALEO),
                new Customer("Carlos", DietPlan.VEGAN),
                new Customer("Diana", DietPlan.NUT_ALLERGY),
                new Customer("Evan", DietPlan.NO_RESTRICTION),
                new Customer("Fatima", DietPlan.PALEO)
        };

        MacronutrientFactory mealFactory = MacronutrientFactory.getInstance();
        System.out.println("=== Random Macronutrient Meals ===");

        for (Customer customer : customers) {
            Meal meal = mealFactory.createMeal(customer);
            verifyDietRules(customer, meal);
            System.out.printf("%s (%s) -> %s%n",
                    customer.getName(),
                    customer.getDietPlan().getDisplayName(),
                    meal);
        }
    }

    private static void verifyDietRules(Customer customer, Meal meal) {
        DietPlan dietPlan = customer.getDietPlan();
        if (!dietPlan.allows(meal.getCarb())
                || !dietPlan.allows(meal.getProtein())
                || !dietPlan.allows(meal.getFat())) {
            throw new IllegalStateException(
                    "Generated meal violates " + dietPlan.getDisplayName());
        }
    }
}
