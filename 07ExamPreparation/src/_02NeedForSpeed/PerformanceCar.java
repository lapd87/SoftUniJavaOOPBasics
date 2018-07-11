package _02NeedForSpeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 10:03 ч.
 */
public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(int id, String brand, String model,
                          int yearOfProduction, int horsepower,
                          int acceleration, int suspension, int durability) {
        super(id, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public int setHorsepower(int horsepower) {
        return horsepower + (horsepower * 50) / 100;
    }

    @Override
    public int setSuspension(int suspension) {
        return suspension - (suspension * 25) / 100;
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        tuneHorsepower(tuneIndex);
        tuneSuspension(tuneIndex);
        addOns.add(addOn);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Add-ons: %s",
                        addOns.size() == 0 ? "None" : String.join(", ", addOns)));

        return stringBuilder.toString();
    }
}