package _01Vehicles;

import static _01Vehicles.Constants.CAR_CLIMA_FUEL_CONSUMPTION;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 10:43 ч.
 */
public class Car extends Vehicle {


    public Car(double carFuel, double carFuelConsumptionLperKM) {
        super(carFuel,carFuelConsumptionLperKM);
    }

    @Override
    protected double summerFuelNeeded(double distance) {
        return distance * (getFuelConsumptionLperKM()
                + CAR_CLIMA_FUEL_CONSUMPTION);
    }
}