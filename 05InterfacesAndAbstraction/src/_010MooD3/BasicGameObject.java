package _010MooD3;

import java.text.DecimalFormat;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.6.2018 г.
 * Time: 14:53 ч.
 */
public abstract class BasicGameObject implements GameObject {

    private String username;
    private String hashedPassword;
    private int level;

    public BasicGameObject() {
    }

    public BasicGameObject(String username, int level) {
        setUsername(username);
        setHashedPassword(hashedPassword);
        setLevel(level);
    }

    private void setUsername(String username) {
        this.username = username;
    }

    protected abstract String calcHashedPassword(String hashedPassword);

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = calcHashedPassword(hashedPassword);
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public abstract double getSpecialPoints();

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public String getCharacterType() {
        return getClass().getSimpleName();
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(String
                        .format("\"%s\" | \"%s\" -> %s",
                                getUsername(),
                                getHashedPassword(),
                                getCharacterType()))
                .append(System.lineSeparator());

        String format = "";
        if (getCharacterType().equals("Demon")) {
            format = "#.0";
        } else {
            format = "#.##";
        }

        DecimalFormat decimalFormat = new DecimalFormat(format);

        stringBuilder.append(String.format("%s",
                decimalFormat.format(getSpecialPoints())));

        return stringBuilder.toString();
    }
}
