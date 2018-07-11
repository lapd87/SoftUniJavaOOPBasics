package _08MilitaryElite;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:07 ч.
 */
public class LeutenantGeneral extends Private {

    private Set<Private> privates;

    public LeutenantGeneral() {
        super();
        this.privates = new LinkedHashSet<>();
    }

    public LeutenantGeneral(int id, String firstName,
                            String lastName, double salary,
                            Set<Private> privates) {
        super(id, firstName, lastName, salary);
        setPrivates(privates);
    }

    private void setPrivates(Set<Private> privates) {
        this.privates = privates;
    }

    private Set<Private> getPrivates() {
        return privates;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:");

        getPrivates().stream()
                .sorted((p1, p2) -> Integer
                        .compare(p2.getId(), p1.getId()))
                .forEach(p -> stringBuilder
                        .append(System.lineSeparator())
                        .append("  ")
                        .append(p));

        return stringBuilder.toString();
    }
}