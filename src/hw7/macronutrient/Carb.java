package hw7.macronutrient;

public enum Carb {
    CHEESE("Cheese"),
    BREAD("Bread"),
    LENTILS("Lentils"),
    PISTACHIO("Pistachio");

    private final String displayName;

    Carb(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
