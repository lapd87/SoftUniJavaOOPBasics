package _08MilitaryElite;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:15 ч.
 */
public class Engineer extends SpecialisedSoldier {

    private Set<Repair> repairs;

    public Engineer() {
        super();
        this.repairs = new LinkedHashSet<>();
    }

    public Engineer(int id, String firstName, String lastName,
                    double salary, Corp corp,
                    Set<Repair> repairs) {
        super(id, firstName, lastName, salary, corp);
        setRepairs(repairs);
    }

    private void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    private Set<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append("Repairs:");

        getRepairs()
                .forEach(r -> stringBuilder
                        .append(System.lineSeparator())
                        .append("  ")
                        .append(r));

        return stringBuilder.toString();
    }
}