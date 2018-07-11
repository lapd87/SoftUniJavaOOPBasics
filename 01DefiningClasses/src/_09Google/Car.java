package _09Google;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.6.2018 г.
 * Time: 09:56 ч.
 */
public class Car {

    private String model;
    private String speed;

    public Car() {
    }

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(model)
                .append(" ")
                .append(speed)
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}