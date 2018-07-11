package _02NeedForSpeed;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 10:08 ч.
 */
public class ShowCar extends Car {

    private int stars;

    public ShowCar(int id, String brand, String model,
                   int yearOfProduction, int horsepower,
                   int acceleration, int suspension, int durability) {
        super(id, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        tuneHorsepower(tuneIndex);
        tuneSuspension(tuneIndex);
        stars += tuneIndex;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("%s *", stars));

        return stringBuilder.toString();
    }
}