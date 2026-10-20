package hw7.macronutrient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/** Singleton factory that randomly creates a diet-compatible carb. */
public final class CarbFactory implements MacronutrientCategoryFactory<Carb> {
    private CarbFactory() {
    }

    private static final class Holder {
        private static final CarbFactory INSTANCE = new CarbFactory();
    }

    public static CarbFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public Carb create(DietPlan dietPlan) {
        if (dietPlan == null) {
            throw new IllegalArgumentException("Diet plan is required.");
        }

        List<Carb> allowed = new ArrayList<Carb>();
        for (Carb carb : Carb.values()) {
            if (dietPlan.allows(carb)) {
                allowed.add(carb);
            }
        }
        return allowed.get(ThreadLocalRandom.current().nextInt(allowed.size()));
    }
}
