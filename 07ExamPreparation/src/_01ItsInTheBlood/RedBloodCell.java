package _01ItsInTheBlood;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 19:30 ч.
 */
public class RedBloodCell extends BloodCell {

    private int velocity;

    public RedBloodCell() {
        super();
    }

    public RedBloodCell(String id, int health,
                        int positionRow, int positionCol,
                        int velocity) {
        super(id, health, positionRow, positionCol);
        setVelocity(velocity);
    }

    private int getVelocity() {
        return velocity;
    }

    private void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getEnergy() {
        return super.getHealth() + this.getVelocity();
    }

    @Override
    public String getAdditionalPropertyToString() {
        return String.format("Velocity: %d", getVelocity());
    }
}