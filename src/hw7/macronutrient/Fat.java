package hw7.macronutrient;

public enum Fat {
    AVOCADO("Avocado"),
    SOUR_CREAM("Sour cream"),
    TUNA("Tuna"),
    PEANUTS("Peanuts");

    private final String displayName;

    Fat(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
