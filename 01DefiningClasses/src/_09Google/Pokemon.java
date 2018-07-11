package _09Google;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.6.2018 г.
 * Time: 09:58 ч.
 */
public class Pokemon {

    private String name;
    private String type;

    public Pokemon() {
    }

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name)
                .append(" ")
                .append(type)
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}