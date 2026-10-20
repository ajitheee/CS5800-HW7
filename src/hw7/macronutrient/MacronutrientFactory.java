package hw7.macronutrient;

/**
 * Singleton Abstract Factory that coordinates the three singleton category
 * factories and creates a complete meal for a customer.
 */
public abstract class MacronutrientFactory {
    protected MacronutrientFactory() {
    }

    private static final class Holder {
        private static final MacronutrientFactory INSTANCE =
                new BalancedMealFactory();
    }

    public static MacronutrientFactory getInstance() {
        return Holder.INSTANCE;
    }

    public abstract CarbFactory getCarbFactory();

    public abstract ProteinFactory getProteinFactory();

    public abstract FatFactory getFatFactory();

    public abstract Meal createMeal(Customer customer);

    private static final class BalancedMealFactory extends MacronutrientFactory {
        private final CarbFactory carbFactory = CarbFactory.getInstance();
        private final ProteinFactory proteinFactory = ProteinFactory.getInstance();
        private final FatFactory fatFactory = FatFactory.getInstance();

        @Override
        public CarbFactory getCarbFactory() {
            return carbFactory;
        }

        @Override
        public ProteinFactory getProteinFactory() {
            return proteinFactory;
        }

        @Override
        public FatFactory getFatFactory() {
            return fatFactory;
        }

        @Override
        public Meal createMeal(Customer customer) {
            if (customer == null) {
                throw new IllegalArgumentException("Customer is required.");
            }
            DietPlan dietPlan = customer.getDietPlan();
            return new Meal(
                    carbFactory.create(dietPlan),
                    proteinFactory.create(dietPlan),
                    fatFactory.create(dietPlan));
        }
    }
}
