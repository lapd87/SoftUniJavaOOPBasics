package _02NeedForSpeed;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 10:02 ч.
 */
public abstract class Car {

    private int id;
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(int id, String brand, String model,
               int yearOfProduction, int horsepower,
               int acceleration, int suspension, int durability) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.suspension = setSuspension(suspension);
        this.durability = durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int setHorsepower(int horsepower) {
        return horsepower;
    }

    public int setSuspension(int suspension) {
        return suspension;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    public int getId() {
        return id;
    }

    public abstract void tune(int tuneIndex, String addOn);

    public void tuneHorsepower(int tuneIndex) {
        horsepower += tuneIndex;
    }

    public void tuneSuspension(int tuneIndex) {
        suspension += tuneIndex / 2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s %s %d",
                brand, model, yearOfProduction))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s",
                        horsepower, acceleration))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability",
                        suspension, durability));

        return stringBuilder.toString();
    }
}