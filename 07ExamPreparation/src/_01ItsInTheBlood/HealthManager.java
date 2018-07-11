package _01ItsInTheBlood;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 20:39 ч.
 */
public class HealthManager {

    private Map<String, Organism> healthManager;

    public HealthManager() {
        this.healthManager = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        if (healthManager.containsKey(organismName)) {
            return healthManager.get(organismName).toString();
        }

        return null;
    }

    public String createOrganism(String name) {
        if (healthManager.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        }

        Organism organism = new Organism(name);

        healthManager.put(name, organism);

        return String.format("Created organism %s", name);
    }

    public String addCluster(String organismName, String id,
                             int rows, int cols) {

        Organism organism = this.healthManager.get(organismName);

        if (organism != null) {
            if (organism.getClusters().stream().noneMatch(c -> id.equals(c.getId()))) {
                if (rows > 0 && cols > 0) {
                    Cluster cluster = new Cluster(id, rows, cols);

                    organism.getClusters().add(cluster);

                    return String.format("Organism %s: Created cluster %s",
                            organismName, id);
                }
            }
        }

        return null;
    }

    public String addCell(String organismName, String clusterId,
                          String cellType, String cellId, int health,
                          int positionRow, int positionCol,
                          int additionalProperty) {

        Organism organism = this.healthManager.get(organismName);

        if (organism != null) {
            Cluster cluster = organism.getClusters().stream()
                    .filter(c -> clusterId.equals(c.getId()))
                    .findFirst()
                    .orElse(null);

            if (cluster != null) {
                Cell[][] cells = cluster.getCells();

                if (positionRow >= 0 && positionRow < cells.length
                        && positionCol >= 0 && positionCol < cells[0].length) {

                    Cell cell = cells[positionRow][positionCol];
                    if (cell == null) {
                        switch (cellType) {
                            case "RedBloodCell":
                                cells[positionRow][positionCol] = new RedBloodCell(cellId,
                                        health, positionRow, positionCol, additionalProperty);
                                break;
                            case "WhiteBloodCell":
                                cells[positionRow][positionCol] = new WhiteBloodCell(cellId,
                                        health, positionRow, positionCol, additionalProperty);
                                break;
                            case "Virus":
                                cells[positionRow][positionCol] = new Virus(cellId,
                                        health, positionRow, positionCol, additionalProperty);
                                break;
                            case "Fungi":
                                cells[positionRow][positionCol] = new Fungi(cellId,
                                        health, positionRow, positionCol, additionalProperty);
                                break;
                            case "Bacteria":
                                cells[positionRow][positionCol] = new Bacteria(cellId,
                                        health, positionRow, positionCol, additionalProperty);
                                break;
                        }

                        return String.format("Organism %s: Created cell %s in cluster %s",
                                organismName, cellId, clusterId);
                    }
                }
            }
        }

        return null;
    }

    public String activateCluster(String organismName) {

        Organism organism = this.healthManager.get(organismName);

        if (organism != null) {

            Cluster cluster = organism.getClusters().get(0);
            organism.getClusters().remove(0);

            List<Cell> cellList = cluster.getCellsList();

            if (cellList.size() > 1) {
                while (cellList.size() > 1) {

                    Cell firstCell = cellList.get(0);
                    cellList.remove(0);

                    switch (firstCell.getClass().getSimpleName()) {
                        case "RedBloodCell":
                        case "WhiteBloodCell":
                            firstCell.setHealth(firstCell.getHealth() + cellList.stream()
                                    .mapToInt(Cell::getHealth)
                                    .sum());
                            firstCell.setPositionCol(cellList.get(cellList.size() - 1).getPositionCol());
                            firstCell.setPositionRow(cellList.get(cellList.size() - 1).getPositionRow());
                            cellList.clear();
                            cellList.add(firstCell);
                            break;
                        case "Virus":
                        case "Fungi":
                        case "Bacteria":
                            Cell secondCell = cellList.get(0);
                            cellList.remove(0);

                            while (true) {
                                secondCell.setHealth(secondCell.getHealth() - firstCell.getEnergy());
                                if (secondCell.getHealth() <= 0) {
                                    firstCell.setPositionCol(secondCell.getPositionCol());
                                    firstCell.setPositionRow(secondCell.getPositionRow());
                                    cellList.add(0, firstCell);
                                    break;
                                }

                                firstCell.setHealth(firstCell.getHealth() - secondCell.getEnergy());
                                if (firstCell.getHealth() <= 0) {
                                    cellList.add(0, secondCell);
                                    break;
                                }
                            }
                    }
                }

                Cluster resultCluster = new Cluster(cluster.getId(), cluster.getRows(), cluster.getCols());

                Cell cell = cellList.get(0);

                resultCluster.getCells()[cell.getPositionRow()][cell.getPositionCol()] = cell;

                organism.getClusters().add(resultCluster);
            } else {
                organism.getClusters().add(cluster);
            }


            return String.format("Organism %s: Activated cluster %s. Cells left: %d",
                    organismName, cluster.getId(), cellList.size());
        }

        return null;
    }

}