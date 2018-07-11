package _01ItsInTheBlood;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 19:30 ч.
 */
public class WhiteBloodCell extends BloodCell {

    private int size;

    public WhiteBloodCell() {
        super();
    }

    public WhiteBloodCell(String id, int health,
                          int positionRow, int positionCol,
                          int size) {
        super(id, health, positionRow, positionCol);
        setSize(size);
    }

    private int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public int getEnergy() {
        return (super.getHealth() + this.getSize()) * 2;
    }

    @Override
    public String getAdditionalPropertyToString() {
        return String.format("Size: %d",getSize());
    }
}