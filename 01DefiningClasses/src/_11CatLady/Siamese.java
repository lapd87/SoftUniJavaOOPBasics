package _11CatLady;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.6.2018 г.
 * Time: 14:39 ч.
 */
public class Siamese extends Cat {

    private double earSize;

    public Siamese(double earSize) {
        this.earSize = earSize;
    }

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f",
                 super.getName(), this.earSize);
    }
}