package _01Vehicles;

import java.text.DecimalFormat;

import static _01Vehicles.Constants.VEHICLE_NEEDS_REFUELING_MESSAGE;
import static _01Vehicles.Constants.VEHICLE_TRAVELLED_KM_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 10:32 ч.
 */
public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumptionLperKM;

    public Vehicle() {
    }

    public Vehicle(double fuelQuantity,
                   double fuelConsumptionLperKM) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionLperKM(fuelConsumptionLperKM);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionLperKM() {
        return fuelConsumptionLperKM;
    }

    private void setFuelConsumptionLperKM(double fuelConsumptionLperKM) {
        this.fuelConsumptionLperKM = fuelConsumptionLperKM;
    }

    public String drive(double distance) {
        return drive(distance, summerFuelNeeded(distance));
    }

    protected abstract double summerFuelNeeded(double distance);

    private String drive(double distance, double fuelNeeded) {

        if (fuelNeeded > getFuelQuantity()) {
            return String.format(VEHICLE_NEEDS_REFUELING_MESSAGE,
                    this.getClass().getSimpleName());
        }

        setFuelQuantity(getFuelQuantity() - fuelNeeded);

        return String.format(VEHICLE_TRAVELLED_KM_MESSAGE,
                this.getClass().getSimpleName(),
                new DecimalFormat("#.##")
                        .format(distance));
    }

    public void refuel(double quantity) {
        this.setFuelQuantity(this.getFuelQuantity() + quantity);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}