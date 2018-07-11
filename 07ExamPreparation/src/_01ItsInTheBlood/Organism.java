package _01ItsInTheBlood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 19:06 ч.
 */
public class Organism {

    private String name;
    private List<Cluster> clusters;

    public Organism() {
        this.clusters = new ArrayList<>();
    }

    public Organism(String name) {
        this();
        setName(name);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    protected List<Cluster> getClusters() {
        return clusters;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Organism - %s",
                getName()))
                .append(System.lineSeparator())
                .append(String.format("--Clusters: %d",
                        getClusters().size()))
                .append(System.lineSeparator())
                .append(String.format("--Cells: %d",
                        getClusters()
                                .stream()
                                .mapToInt(c -> c.getCellsList()
                                        .size())
                                .sum()));

        getClusters()
                .forEach(cluster ->
                        stringBuilder
                                .append(System.lineSeparator())
                                .append(cluster));

        return stringBuilder.toString();
    }
}