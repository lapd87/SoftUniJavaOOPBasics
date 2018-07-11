package _05PizzaCalories;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.6.2018 г.
 * Time: 12:05 ч.
 */
public final class PizzaConstants {

    public static final double BASE_CALORIES_PER_GRAM = 2;

    public static final String INVALID_DOUGH_FLOUR_TYPE_OR_BAKING_TEHNIQUE_MESSAGE = "Invalid type of dough.%n";
    public static final String INVALID_DOUGH_WEIGHT_MESSAGE = "Dough weight should be in the range [1..200].%n";
    public static final String INVALID_TOPPING_TYPE_MESSAGE = "Cannot place %s on top of your pizza.%n";
    public static final String INVALID_TOPPING_WEIGHT_MESSAGE = "%s weight should be in the range [1..50].%n";
    public static final String INVALID_TOPPING_COUNT_MESSAGE = "Number of toppings should be in range [0..10].%n";
    public static final String INVALID_PIZZA_NAME_MESSAGE = "Pizza name should be between 1 and 15 symbols.%n";

    public static final Map<String, Double> DEFAULT_DOUGH_FLOUR_TYPES = new HashMap<String, Double>() {{
        put("White", 1.5);
        put("Wholegrain", 1.0);
    }};
    public static final Map<String, Double> DEFAULT_DOUGH_BAKING_TECHNIQUES = new HashMap<String, Double>() {{
        put("Crispy",0.9);
        put("Chewy",1.1);
        put("Homemade",1.0);
    }};
    public static final Map<String, Double> DEFAULT_TOPPING_TYPES = new HashMap<String, Double>() {{
        put("Meat",1.2);
        put("Veggies",0.8);
        put("Cheese",1.1);
        put("Sauce",0.9);
    }};
}