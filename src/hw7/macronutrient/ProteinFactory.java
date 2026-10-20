package hw7.macronutrient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/** Singleton factory that randomly creates a diet-compatible protein. */
public final class ProteinFactory implements MacronutrientCategoryFactory<Protein> {
    private ProteinFactory() {
    }

    private static final class Holder {
        private static final ProteinFactory INSTANCE = new ProteinFactory();
    }

    public static ProteinFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public Protein create(DietPlan dietPlan) {
        if (dietPlan == null) {
            throw new IllegalArgumentException("Diet plan is required.");
        }

        List<Protein> allowed = new ArrayList<Protein>();
        for (Protein protein : Protein.values()) {
            if (dietPlan.allows(protein)) {
                allowed.add(protein);
            }
        }
        return allowed.get(ThreadLocalRandom.current().nextInt(allowed.size()));
    }
}
