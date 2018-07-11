package _01ItsInTheBlood;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 19:10 ч.
 */
public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Cluster() {
    }

    public Cluster(String id, int rows, int cols) {
        this();
        setId(id);
        setRows(rows);
        setCols(cols);
        cells = new Cell[rows][cols];
    }

    protected int getRows() {
        return rows;
    }

    protected int getCols() {
        return cols;
    }

    protected String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    private void setCols(int cols) {
        this.cols = cols;
    }

    public Cell[][] getCells() {
        return cells;
    }

    protected List<Cell> getCellsList() {
        List<Cell> cellList = new ArrayList<>();

        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                if (cell != null) {
                    cellList.add(cell);
                }
            }
        }
        return cellList;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("----Cluster %s",
                getId()));

        getCellsList().stream()
                .sorted(Comparator.comparingInt(Cell::getPositionRow)
                        .thenComparing(Cell::getPositionCol))
                .forEach(cell ->
                        stringBuilder
                                .append(System.lineSeparator())
                                .append(cell));

        return stringBuilder.toString();
    }
}