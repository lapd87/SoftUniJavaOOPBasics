package _05PizzaCalories;

import java.util.ArrayList;
import java.util.List;

import static _05PizzaCalories.PizzaConstants.INVALID_PIZZA_NAME_MESSAGE;
import static _05PizzaCalories.PizzaConstants.INVALID_TOPPING_COUNT_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.6.2018 г.
 * Time: 10:13 ч.
 */
public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    public Pizza(String name, int toppingsCount) {
        setName(name);
        setToppings(toppingsCount);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException(INVALID_PIZZA_NAME_MESSAGE);
        } else {
            this.name = name;
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int toppingsCount) {
        if (toppingsCount < 0 || toppingsCount > 10) {
            throw new IllegalArgumentException(INVALID_TOPPING_COUNT_MESSAGE);
        } else {
            this.toppings = new ArrayList<>();
        }
    }

    private List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        getToppings().add(topping);
    }

    private double getTotalCalories() {

        double toppingCalories = toppings.stream()
                .mapToDouble(Topping::getCalories)
                .sum();

        return dough.getCalories() + toppingCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",
                name, getTotalCalories());
    }
}