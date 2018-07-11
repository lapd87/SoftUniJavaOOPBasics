package _01ItsInTheBlood;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 20:24 ч.
 */
public class Virus extends Microbe {

    public Virus() {
        super();
    }

    public Virus(String id, int health,
                 int positionRow, int positionCol,
                 int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    public int getEnergy() {
        return super.getHealth() + getVirulence();
    }
}