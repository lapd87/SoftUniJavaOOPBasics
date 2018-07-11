package _02VehiclesExtension;

import static _02VehiclesExtension.Constants.BUS_CLIMA_FUEL_CONSUMPTION;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 14:11 ч.
 */
public class Bus extends Vehicle {

    public Bus() {
    }

    public Bus(double fuelQuantity,
               double fuelConsumptionLperKM,
               double tankCapacity) {
        super(fuelQuantity, fuelConsumptionLperKM, tankCapacity);
    }

    @Override
    protected double climaFuelNeeded(double distance) {
        return distance * (getFuelConsumptionLperKM()
                + BUS_CLIMA_FUEL_CONSUMPTION);
    }
}