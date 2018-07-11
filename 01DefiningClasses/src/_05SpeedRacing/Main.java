package _05SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 20:03 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            String model = input[0];

            if (cars.containsKey(model)) {
                continue;
            }

            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostPerKm = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);

            cars.put(model, car);
        }

        String command;
        while (!"End".equals(command = bufferedReader.readLine())) {

            String[] commandArgs = command.split("\\s+");

            String model = commandArgs[1];
            int distance = Integer.parseInt(commandArgs[2]);

            if (!cars.containsKey(model)) {
                continue;
            }

            cars.get(model).Drive(distance);
        }

        cars.forEach((key, value) -> System.out.println(value));
    }
}