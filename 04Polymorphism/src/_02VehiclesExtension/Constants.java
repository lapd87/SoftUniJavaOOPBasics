package _02VehiclesExtension;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 10:40 ч.
 */
public final class Constants {

    public static final double CAR_CLIMA_FUEL_CONSUMPTION = 0.9;
    public static final double TRUCK_CLIMA_FUEL_CONSUMPTION = 1.6;
    public static final double TRUCK_FUEL_ADJUST_TANK_HOLE_LEAKAGE = 0.95;
    public static final double BUS_CLIMA_FUEL_CONSUMPTION = 1.4;

    public static final String VEHICLE_NEEDS_REFUELING_MESSAGE = "%s needs refueling";
    public static final String VEHICLE_TRAVELLED_KM_MESSAGE = "%s travelled %s km";

    public static final String NEGATIVE_FUEL_QUANTITY_MESSAGE = "Fuel must be a positive number";
    public static final String TOO_MUCH_FUEL_QUANTITY_MESSAGE = "Cannot fit fuel in tank";
}