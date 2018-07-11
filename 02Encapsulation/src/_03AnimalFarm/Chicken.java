package _03AnimalFarm;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.6.2018 г.
 * Time: 13:56 ч.
 */
public class Chicken {

    private String name;
    private int age;
    private String eggProduction;

    public Chicken() {
    }

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
        setEggProduction();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }
    }

    private void setEggProduction() {
        if (age < 6) {
            this.eggProduction = "2";
        } else if (age < 12) {
            this.eggProduction = "1";
        } else {
            this.eggProduction = "0.75";
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                name,
                age,
                eggProduction);
    }
}