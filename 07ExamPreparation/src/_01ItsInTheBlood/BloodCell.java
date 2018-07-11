package _01ItsInTheBlood;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 19:29 ч.
 */
public abstract class BloodCell extends Cell {

    public BloodCell() {
        super();
    }

    public BloodCell(String id, int health,
                     int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }
}