package _01ItsInTheBlood;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 19:30 ч.
 */
public abstract class Microbe extends Cell {

    private int virulence;

    public Microbe() {
        super();
    }

    public Microbe(String id, int health,
                   int positionRow, int positionCol,
                   int virulence) {
        super(id, health, positionRow, positionCol);
        setVirulence(virulence);
    }

    protected int getVirulence() {
        return virulence;
    }

    private void setVirulence(int virulence) {
        this.virulence = virulence;
    }

    @Override
    public String getAdditionalPropertyToString() {
        return String.format("Virulence: %d", getVirulence());
    }
}