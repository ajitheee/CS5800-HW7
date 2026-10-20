package hw7.macronutrient;

/** A balanced meal containing exactly one carb, one protein, and one fat. */
public final class Meal {
    private final Carb carb;
    private final Protein protein;
    private final Fat fat;

    public Meal(Carb carb, Protein protein, Fat fat) {
        if (carb == null || protein == null || fat == null) {
            throw new IllegalArgumentException(
                    "A meal requires one carb, one protein, and one fat.");
        }
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
    }

    public Carb getCarb() {
        return carb;
    }

    public Protein getProtein() {
        return protein;
    }

    public Fat getFat() {
        return fat;
    }

    @Override
    public String toString() {
        return String.format("Carb: %s | Protein: %s | Fat: %s",
                carb.getDisplayName(), protein.getDisplayName(), fat.getDisplayName());
    }
}
