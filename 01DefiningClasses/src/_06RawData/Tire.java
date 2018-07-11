package _06RawData;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 20:20 ч.
 */
public class Tire {

    private double pressure;
    private int age;

    public Tire() {
    }

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }
}