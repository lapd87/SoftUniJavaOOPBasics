package _08MilitaryElite;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:12 ч.
 */
public class Corp {

    private String type;

    public Corp() {
    }

    public Corp(String type) {
        setType(type);
    }

    private void setType(String type) {
        if ("Airforces".equals(type)
                || "Marines".equals(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String getType() {
        return type;
    }

    @Override
    public String toString() {
        return getType();
    }
}