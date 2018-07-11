package _07CarSalesman;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 20:49 ч.
 */
public class Engine {

    private static final String DEFAULT_DISPLACEMENT = "n/a";
    private static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine() {
    }

    public Engine(String model, String power) {
        this(model, power, DEFAULT_DISPLACEMENT, DEFAULT_EFFICIENCY);
    }

    public Engine(String model, String power,
                  String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(model).append(":")
                .append(System.lineSeparator())
                .append("Power: ").append(power)
                .append(System.lineSeparator())
                .append("Displacement: ").append(displacement)
                .append(System.lineSeparator())
                .append("Efficiency: ").append(efficiency);

        return stringBuilder.toString();
    }
}