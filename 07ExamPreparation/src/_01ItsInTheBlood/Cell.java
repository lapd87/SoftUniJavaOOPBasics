package _01ItsInTheBlood;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 19:13 ч.
 */
public abstract class Cell {

    public static final int CELL_DEFAULT_ENERGY = 0;

    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell() {
    }

    public Cell(String id, int health,
                int positionRow, int positionCol) {
        setId(id);
        setHealth(health);
        setPositionRow(positionRow);
        setPositionCol(positionCol);
    }

    private String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    protected int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected int getPositionRow() {
        return positionRow;
    }

    protected void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    protected int getPositionCol() {
        return positionCol;
    }

    protected void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public abstract int getEnergy();

    public abstract String getAdditionalPropertyToString();

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("------Cell %s [%d,%d]",
                        getId(),
                        getPositionRow(),
                        getPositionCol()))
                .append(System.lineSeparator())
                .append(String.format("--------Health: %d | %s | Energy: %d",
                        getHealth(),
                        getAdditionalPropertyToString(),
                        getEnergy()));

        return stringBuilder.toString();
    }
}