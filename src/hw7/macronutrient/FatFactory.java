package hw7.macronutrient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/** Singleton factory that randomly creates a diet-compatible fat. */
public final class FatFactory implements MacronutrientCategoryFactory<Fat> {
    private FatFactory() {
    }

    private static final class Holder {
        private static final FatFactory INSTANCE = new FatFactory();
    }

    public static FatFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public Fat create(DietPlan dietPlan) {
        if (dietPlan == null) {
            throw new IllegalArgumentException("Diet plan is required.");
        }

        List<Fat> allowed = new ArrayList<Fat>();
        for (Fat fat : Fat.values()) {
            if (dietPlan.allows(fat)) {
                allowed.add(fat);
            }
        }
        return allowed.get(ThreadLocalRandom.current().nextInt(allowed.size()));
    }
}
