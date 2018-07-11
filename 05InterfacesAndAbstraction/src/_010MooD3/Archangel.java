package _010MooD3;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 13:06 ч.
 */
public class Archangel extends BasicGameObject {


    private final int ARCHANGEL_HASHED_PASS_CONSTANT = 21;

    private int mana;

    public Archangel() {
        super();
    }

    public Archangel(String username, int level, int mana) {
        super(username, level);
        setMana(mana);
    }

    private int getMana() {
        return mana;
    }

    private void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    protected String calcHashedPassword(String hashedPassword) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getUsername());
        stringBuilder.reverse();
        stringBuilder.append(getUsername().length()
                * ARCHANGEL_HASHED_PASS_CONSTANT);

        return stringBuilder.toString();
    }

    @Override
    public double getSpecialPoints() {
        return getLevel() * getMana();
    }
}