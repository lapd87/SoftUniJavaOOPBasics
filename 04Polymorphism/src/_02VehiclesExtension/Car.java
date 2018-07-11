package _02VehiclesExtension;


import static _02VehiclesExtension.Constants.CAR_CLIMA_FUEL_CONSUMPTION;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 10:43 ч.
 */
public class Car extends Vehicle {

    public Car() {
    }

    public Car(double fuelQuantity,
               double fuelConsumptionLperKM,
               double tankCapacity) {
        super(fuelQuantity, fuelConsumptionLperKM, tankCapacity);
    }

    @Override
    protected double climaFuelNeeded(double distance) {
        return distance * (getFuelConsumptionLperKM()
                + CAR_CLIMA_FUEL_CONSUMPTION);
    }
}