package _11CatLady;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.6.2018 г.
 * Time: 14:43 ч.
 */
public class StreetExtraordinaire extends Cat {

    private double decivelsOfMeows;

    public StreetExtraordinaire(double decivelsOfMeows) {
        this.decivelsOfMeows = decivelsOfMeows;
    }

    public StreetExtraordinaire(String name, double decivelsOfMeows) {
        super(name);
        this.decivelsOfMeows = decivelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f",
                super.getName(), this.decivelsOfMeows);
    }

}