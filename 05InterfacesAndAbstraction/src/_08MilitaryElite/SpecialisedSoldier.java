package _08MilitaryElite;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:11 ч.
 */
public class SpecialisedSoldier extends Private {

    private Corp corp;

    public SpecialisedSoldier() {
        super();
    }

    public SpecialisedSoldier(int id, String firstName,
                              String lastName, double salary,
                              Corp corp) {
        super(id, firstName, lastName, salary);
        setCorp(corp);
    }

    private void setCorp(Corp corp) {
        this.corp = corp;
    }

    private Corp getCorp() {
        return corp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(getCorp());

        return stringBuilder.toString();
    }
}