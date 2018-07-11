package _06RawData;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 20:18 ч.
 */
public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tyres;

    public Car() {
    }


    public Car(String model, int engineSpeed, int enginePower,
               int cargoWeight, String cargoType,
               double tire1Pressure, int tire1Age,
               double tire2Pressure, int tire2Age,
               double tire3Pressure, int tire3Age,
               double tire4Pressure, int tire4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tyres = new Tire[]{
                new Tire(tire1Pressure, tire1Age),
                new Tire(tire2Pressure, tire2Age),
                new Tire(tire3Pressure, tire3Age),
                new Tire(tire4Pressure, tire4Age),
        };
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTyres() {
        return tyres;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return model;
    }
}