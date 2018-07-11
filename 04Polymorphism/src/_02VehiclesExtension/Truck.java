package _02VehiclesExtension;


import static _02VehiclesExtension.Constants.TRUCK_CLIMA_FUEL_CONSUMPTION;
import static _02VehiclesExtension.Constants.TRUCK_FUEL_ADJUST_TANK_HOLE_LEAKAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 12:46 ч.
 */
public class Truck extends Vehicle {

    public Truck() {
    }

    public Truck(double fuelQuantity,
                 double fuelConsumptionLperKM,
                 double tankCapacity) {
        super(fuelQuantity, fuelConsumptionLperKM, tankCapacity);
    }

    @Override
    public void refuel(double quantity) {
        super.refuel(quantity * TRUCK_FUEL_ADJUST_TANK_HOLE_LEAKAGE);
    }

    @Override
    protected double climaFuelNeeded(double distance) {
        return distance * (getFuelConsumptionLperKM()
                + TRUCK_CLIMA_FUEL_CONSUMPTION);
    }
}