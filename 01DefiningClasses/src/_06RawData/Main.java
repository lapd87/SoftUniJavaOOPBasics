package _06RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 20:29 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tyre1pressure = Double.parseDouble(input[5]);
            int tyre1age = Integer.parseInt(input[6]);
            double tyre2pressure = Double.parseDouble(input[7]);
            int tyre2age = Integer.parseInt(input[8]);
            double tyre3pressure = Double.parseDouble(input[9]);
            int tyre3age = Integer.parseInt(input[10]);
            double tyre4pressure = Double.parseDouble(input[11]);
            int tyre4age = Integer.parseInt(input[12]);

            Car car = new Car(model, engineSpeed, enginePower,
                    cargoWeight, cargoType,
                    tyre1pressure, tyre1age,
                    tyre2pressure, tyre2age,
                    tyre3pressure, tyre3age,
                    tyre4pressure, tyre4age);

            cars.add(car);
        }

        String command = bufferedReader.readLine();

        printFilteredCars(command, cars);
    }

    private static void printFilteredCars(String command, List<Car> cars) {

        cars.stream()
                .filter(c -> {
                    boolean filterCargo = c.getCargo().getCargoType().equals(command);

                    boolean extraFilter = false;
                    switch (command) {
                        case "fragile":
                            extraFilter = Arrays.stream(c.getTyres())
                                    .anyMatch(t -> t.getPressure() < 1);
                            break;
                        case "flamable":
                            extraFilter = c.getEngine().getEnginePower() > 250;
                            break;
                    }

                    return filterCargo && extraFilter;
                })
                .forEach(System.out::println);
    }
}