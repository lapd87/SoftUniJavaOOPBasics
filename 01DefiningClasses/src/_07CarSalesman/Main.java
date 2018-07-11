package _07CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 20:54 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String, Engine> engines = new LinkedHashMap<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            String model = input[0];
            String power = input[1];

            Engine engine = new Engine(model, power);

            switch (input.length) {
                case 3:
                    String displacementOrEfficiency = input[2];

                    if (displacementOrEfficiency.matches("\\d+")) {
                        String displacement = displacementOrEfficiency;
                        engine.setDisplacement(displacement);
                    } else {
                        String efficiency = displacementOrEfficiency;
                        engine.setEfficiency(efficiency);
                    }
                    break;
                case 4:
                    String displacement = input[2];
                    String efficiency = input[3];
                    engine.setDisplacement(displacement);
                    engine.setEfficiency(efficiency);
                    break;
            }

            engines.put(model, engine);
        }

        List<Car> cars = new ArrayList<>();

        int m = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < m; i++) {

            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            String model = input[0];
            Engine engine = engines.get(input[1]);

            if (engine == null) {
                continue;
            }

            Car car = new Car(model, engine);

            switch (input.length) {
                case 3:
                    String weightOrColor = input[2];

                    if (weightOrColor.matches("\\d+")) {
                        String weight = weightOrColor;
                        car.setWeight(weight);
                    } else {
                        String color = weightOrColor;
                        car.setColor(color);
                    }
                    break;
                case 4:
                    String weight = input[2];
                    String color = input[3];
                    car.setWeight(weight);
                    car.setColor(color);
                    break;
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}