package hw7.macronutrient;

/** Diet-plan rules from the HW7 assignment. */
public enum DietPlan {
    NO_RESTRICTION("No Restriction"),
    PALEO("Paleo"),
    VEGAN("Vegan"),
    NUT_ALLERGY("Nut Allergy");

    private final String displayName;

    DietPlan(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean allows(Carb carb) {
        switch (this) {
            case PALEO:
                return carb == Carb.PISTACHIO;
            case VEGAN:
                return carb != Carb.CHEESE;
            case NUT_ALLERGY:
                return carb != Carb.PISTACHIO;
            case NO_RESTRICTION:
            default:
                return true;
        }
    }

    public boolean allows(Protein protein) {
        switch (this) {
            case PALEO:
                return protein != Protein.TOFU;
            case VEGAN:
                return protein == Protein.TOFU;
            case NO_RESTRICTION:
            case NUT_ALLERGY:
            default:
                return true;
        }
    }

    public boolean allows(Fat fat) {
        switch (this) {
            case PALEO:
                return fat != Fat.SOUR_CREAM;
            case VEGAN:
                return fat != Fat.SOUR_CREAM && fat != Fat.TUNA;
            case NUT_ALLERGY:
                return fat != Fat.PEANUTS;
            case NO_RESTRICTION:
            default:
                return true;
        }
    }
}
