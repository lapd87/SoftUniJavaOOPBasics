package _05PizzaCalories;

import static _05PizzaCalories.PizzaConstants.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.6.2018 г.
 * Time: 10:14 ч.
 */
public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weightInGrams;

    public Dough() {
    }

    public Dough(String flourType, String bakingTechnique, double weightInGrams) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeightInGrams(weightInGrams);
    }

    private void setFlourType(String flourType) {
        if (!DEFAULT_DOUGH_FLOUR_TYPES.containsKey(flourType)) {
            throw new IllegalArgumentException(INVALID_DOUGH_FLOUR_TYPE_OR_BAKING_TEHNIQUE_MESSAGE);
        } else {
            this.flourType = flourType;
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!DEFAULT_DOUGH_BAKING_TECHNIQUES.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException(INVALID_DOUGH_FLOUR_TYPE_OR_BAKING_TEHNIQUE_MESSAGE);
        } else {
            this.bakingTechnique = bakingTechnique;
        }
    }

    private void setWeightInGrams(double weightInGrams) {
        if (weightInGrams < 1 || weightInGrams > 200) {
            throw new IllegalArgumentException(INVALID_DOUGH_WEIGHT_MESSAGE);
        } else {
            this.weightInGrams = weightInGrams;
        }
    }

    public double getCalories() {
        double flourCaloriesModifier = DEFAULT_DOUGH_FLOUR_TYPES
                .get(flourType);
        double bakingCaloriesModifier = DEFAULT_DOUGH_BAKING_TECHNIQUES
                .get(bakingTechnique);

        return BASE_CALORIES_PER_GRAM * weightInGrams
                * flourCaloriesModifier * bakingCaloriesModifier;
    }
}