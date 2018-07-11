package _01Vehicles;

import static _01Vehicles.Constants.TRUCK_CLIMA_FUEL_CONSUMPTION;
import static _01Vehicles.Constants.TRUCK_FUEL_ADJUST_TANK_HOLE_LEAKAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 12:46 ч.
 */
public class Truck extends Vehicle {

    public Truck(double truckFuel, double truckFuelConsumptionLperKM) {
        super(truckFuel, truckFuelConsumptionLperKM);
    }

    @Override
    public void refuel(double quantity) {
        super.refuel(quantity * TRUCK_FUEL_ADJUST_TANK_HOLE_LEAKAGE);
    }

    @Override
    protected double summerFuelNeeded(double distance) {
        return distance * (getFuelConsumptionLperKM()
                + TRUCK_CLIMA_FUEL_CONSUMPTION);
    }
}