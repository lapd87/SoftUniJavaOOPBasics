package _05PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.6.2018 г.
 * Time: 13:03 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            String[] pizzaArgs = bufferedReader.readLine()
                    .split("\\s+");

            String pizzaName = pizzaArgs[1];
            int pizzaToppingsCount = Integer.parseInt(pizzaArgs[2]);

            Pizza pizza = new Pizza(pizzaName, pizzaToppingsCount);

            String[] doughArgs = bufferedReader.readLine()
                    .split("\\s+");

            String doughFlourType = doughArgs[1];
            String doughBakingTechnique = doughArgs[2];
            double doughWeight = Double.parseDouble(doughArgs[3]);

            Dough dough = new Dough(doughFlourType,
                    doughBakingTechnique, doughWeight);

            pizza.setDough(dough);

            for (int i = 0; i < pizzaToppingsCount; i++) {

                String[] toppingArgs = bufferedReader.readLine()
                        .split("\\s+");

                String toppingType = toppingArgs[1];
                double toppingWeight = Double.parseDouble(toppingArgs[2]);

                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);
            }

            System.out.println(pizza);

        } catch (IllegalArgumentException iae) {
            System.out.printf(iae.getMessage());
        }
    }
}
