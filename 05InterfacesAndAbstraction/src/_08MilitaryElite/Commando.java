package _08MilitaryElite;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:19 ч.
 */
public class Commando extends SpecialisedSoldier {

    private Set<Mission> missions;

    public Commando() {
        super();
        this.missions = new LinkedHashSet<>();
    }

    public Commando(int id, String firstName, String lastName,
                    double salary, Corp corp,
                    Set<Mission> missions) {
        super(id, firstName, lastName, salary, corp);
        setMissions(missions);
    }

    private void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

    public Set<Mission> getMissions() {
        return missions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append("Missions:");

        getMissions()
                .forEach(m -> stringBuilder
                        .append(System.lineSeparator())
                        .append("  ")
                        .append(m));

        return stringBuilder.toString();
    }
}