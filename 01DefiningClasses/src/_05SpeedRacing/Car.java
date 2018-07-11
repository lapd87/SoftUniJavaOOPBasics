package _05SpeedRacing;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 19:52 ч.
 */
public class Car {

    private static final int DEFAULT_DISTANCE_TRAVELED = 0;

    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car() {
    }

    public Car(String model, double fuelAmount,
               double fuelCostPerKm) {
        this(model, fuelAmount, fuelCostPerKm, DEFAULT_DISTANCE_TRAVELED);
    }

    public Car(String model, double fuelAmount,
               double fuelCostPerKm, int distanceTraveled) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = distanceTraveled;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void Drive(int distance) {

        double fuelNeeded = this.fuelCostPerKm * distance;

        if (fuelNeeded > this.fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            fuelAmount -= fuelNeeded;
            distanceTraveled += distance;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",
                model, fuelAmount, distanceTraveled);
    }
}