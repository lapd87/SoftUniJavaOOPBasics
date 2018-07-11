package _05PizzaCalories;

import static _05PizzaCalories.PizzaConstants.*;
import static _05PizzaCalories.PizzaConstants.BASE_CALORIES_PER_GRAM;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.6.2018 г.
 * Time: 10:14 ч.
 */
public class Topping {

    private String type;
    private double weightInGrams;

    public Topping() {
    }

    public Topping(String type, double weightInGrams) {
        setType(type);
        setWeightInGrams(weightInGrams);
    }

    private void setType(String type) {
        if (!DEFAULT_TOPPING_TYPES.containsKey(type)) {
            throw new IllegalArgumentException(String
                    .format(INVALID_TOPPING_TYPE_MESSAGE, type));
        } else {
            this.type = type;
        }
    }

    private void setWeightInGrams(double weightInGrams) {
        if (weightInGrams < 1 || weightInGrams > 50) {
            throw new IllegalArgumentException(String
                    .format(INVALID_TOPPING_WEIGHT_MESSAGE, getType()));
        } else {
            this.weightInGrams = weightInGrams;
        }
    }

    private String getType() {
        return type;
    }

    public double getCalories() {
        double toppingModifier = DEFAULT_TOPPING_TYPES
                .get(type);

        return BASE_CALORIES_PER_GRAM * weightInGrams
                * toppingModifier;
    }
}