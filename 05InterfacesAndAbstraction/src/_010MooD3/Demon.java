package _010MooD3;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.6.2018 г.
 * Time: 15:02 ч.
 */
public class Demon extends BasicGameObject {

    private final int DEMON_HASHED_PASS_CONSTANT = 217;

    private double energy;

    public Demon() {
        super();
    }

    public Demon(String username, int level, double energy) {
        super(username, level);
        setEnergy(energy);
    }

    @Override
    protected String calcHashedPassword(String hashedPassword) {
        return String.valueOf((getUsername().length()
                * DEMON_HASHED_PASS_CONSTANT));
    }

    @Override
    public double getSpecialPoints() {
        return getLevel() * getEnergy();
    }

    private double getEnergy() {
        return energy;
    }

    private void setEnergy(double energy) {
        this.energy = energy;
    }
}