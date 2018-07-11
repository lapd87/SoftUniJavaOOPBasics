package _03Ferrari;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 11:55 ч.
 */
public class Ferrari implements Car {

    private final String MODEL = "488-Spider";
    private String driver;

    public Ferrari(String driver) {
        setDriver(driver);
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    private String getMODEL() {
        return MODEL;
    }

    private String getDriver() {
        return driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                getMODEL(),
                useBrakes(),
                pushGasPedal(),
                getDriver());
    }
}