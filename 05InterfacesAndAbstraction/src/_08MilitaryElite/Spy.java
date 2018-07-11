package _08MilitaryElite;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:25 ч.
 */
public class Spy extends BaseSoldier {

    private String codeNumber;

    public Spy() {
        super();
    }

    public Spy(int id, String firstName, String lastName,
               String codeNumber) {
        super(id, firstName, lastName);
        setCodeNumber(codeNumber);
    }

    private void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    private String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append("Code Number: ")
                .append(getCodeNumber());

        return stringBuilder.toString();
    }
}