package _02VehiclesExtension;

import java.text.DecimalFormat;

import static _02VehiclesExtension.Constants.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 10:32 ч.
 */
public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumptionLperKM;
    private double tankCapacity;

    public Vehicle() {
    }

    public Vehicle(double fuelQuantity,
                   double fuelConsumptionLperKM,
                   double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionLperKM(fuelConsumptionLperKM);
        setTankCapacity(tankCapacity);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException(NEGATIVE_FUEL_QUANTITY_MESSAGE);
        }

        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionLperKM() {
        return fuelConsumptionLperKM;
    }

    private void setFuelConsumptionLperKM(double fuelConsumptionLperKM) {
        this.fuelConsumptionLperKM = fuelConsumptionLperKM;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected abstract double climaFuelNeeded(double distance);

    protected double defaultFuelNeeded(double distance) {
        return distance * getFuelConsumptionLperKM();
    }

    protected String drive(double distance, double fuelNeeded) {

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

        if (quantity <= 0) {
            throw new IllegalArgumentException(NEGATIVE_FUEL_QUANTITY_MESSAGE);
        }

        if (quantity + getFuelQuantity() > getTankCapacity()) {
            throw new IllegalArgumentException(TOO_MUCH_FUEL_QUANTITY_MESSAGE);
        }

        this.setFuelQuantity(this.getFuelQuantity() + quantity);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}