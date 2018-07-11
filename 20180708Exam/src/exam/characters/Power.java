package exam.characters;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:58 ч.
 */
public class Power implements SuperPower {

    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        setName(name);
        setPowerPoints(powerPoints);
    }

    private void setName(String name) {
        if (name.matches("\\@[a-zA-Z_]{3,}\\@")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }
    }

    private void setPowerPoints(double powerPoints) {
        if (powerPoints >= 0) {
            this.powerPoints = powerPoints;
        } else {
            throw new IllegalArgumentException("Power points should be a possitive number!");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerPoints() {
        return powerPoints + getName().length() / 2;
    }
}