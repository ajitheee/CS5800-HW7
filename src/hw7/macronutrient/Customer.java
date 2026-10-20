package hw7.macronutrient;

public final class Customer {
    private final String name;
    private final DietPlan dietPlan;

    public Customer(String name, DietPlan dietPlan) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name is required.");
        }
        if (dietPlan == null) {
            throw new IllegalArgumentException("Customer diet plan is required.");
        }
        this.name = name.trim();
        this.dietPlan = dietPlan;
    }

    public String getName() {
        return name;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }
}
