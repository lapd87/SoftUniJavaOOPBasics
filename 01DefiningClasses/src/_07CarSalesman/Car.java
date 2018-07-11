package _07CarSalesman;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 20:48 ч.
 */
public class Car {

    private static final String DEFAULT_WEIGHT = "n/a";
    private static final String DEFAULT_COLOR = "n/a";


    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car() {
    }

    public Car(String model, Engine engine) {
        this(model, engine, DEFAULT_WEIGHT, DEFAULT_COLOR);
    }

    public Car(String model, Engine engine,
               String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(model).append(":")
                .append(System.lineSeparator())
                .append(engine)
                .append(System.lineSeparator())
                .append("Weight: ").append(weight)
                .append(System.lineSeparator())
                .append("Color: ").append(color);

        return stringBuilder.toString();
    }
}