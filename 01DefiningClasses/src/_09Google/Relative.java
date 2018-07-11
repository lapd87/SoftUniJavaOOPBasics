package _09Google;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.6.2018 г.
 * Time: 10:11 ч.
 */
public class Relative {

    private String name;
    private String birthday;

    public Relative() {
    }

    public Relative(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name)
                .append(" ")
                .append(birthday)
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}