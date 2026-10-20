package hw7.macronutrient;

/** Factory contract shared by each macronutrient category. */
public interface MacronutrientCategoryFactory<T> {
    T create(DietPlan dietPlan);
}
