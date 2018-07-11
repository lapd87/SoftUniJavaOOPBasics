package _02VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 12:58 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] carData = bufferedReader.readLine()
                .split("\\s+");
        String[] truckData = bufferedReader.readLine()
                .split("\\s+");
        String[] busData = bufferedReader.readLine()
                .split("\\s+");

        double carFuel = Double.parseDouble(carData[1]);
        double carFuelConsumptionLperKM = Double.parseDouble(carData[2]);
        double carTankCapacity = Double.parseDouble(carData[3]);
        Car car = new Car(carFuel,
                carFuelConsumptionLperKM,carTankCapacity);

        double truckFuel = Double.parseDouble(truckData[1]);
        double truckFuelConsumptionLperKM = Double.parseDouble(truckData[2]);
        double truckTankCapacity = Double.parseDouble(truckData[3]);
        Truck truck = new Truck(truckFuel,
                truckFuelConsumptionLperKM,truckTankCapacity);

        double busFuel = Double.parseDouble(busData[1]);
        double busFuelConsumptionLperKM = Double.parseDouble(busData[2]);
        double busTankCapacity = Double.parseDouble(busData[3]);
        Bus bus = new Bus(busFuel,
                busFuelConsumptionLperKM, busTankCapacity);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);
        vehicles.add(bus);

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            String[] commandArgs = bufferedReader.readLine()
                    .split("\\s+");

            String command = commandArgs[0];
            String vehicleType = commandArgs[1];
            double fuelOrDistance = Double.parseDouble(commandArgs[2]);

            try {
                switch (command) {
                    case "Drive":
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle.getClass().getSimpleName().equals(vehicleType)) {
                                System.out.println(vehicle.drive(fuelOrDistance,
                                        vehicle.climaFuelNeeded(fuelOrDistance)));
                                break;
                            }
                        }
                        break;
                    case "Refuel":
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle.getClass().getSimpleName().equals(vehicleType)) {
                                vehicle.refuel(fuelOrDistance);
                                break;
                            }
                        }
                        break;
                    case "DriveEmpty":
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle.getClass().getSimpleName().equals(vehicleType)) {
                                System.out.println(vehicle.drive(fuelOrDistance,
                                        vehicle.defaultFuelNeeded(fuelOrDistance)));
                                break;
                            }
                        }
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}