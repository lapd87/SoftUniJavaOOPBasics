package _11CatLady;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.6.2018 г.
 * Time: 14:41 ч.
 */
public class Cymric extends Cat {

    private double furLength;

    public Cymric(double furLength) {
        this.furLength = furLength;
    }

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f",
                super.getName(), this.furLength);
    }
}