package _03WildFarm;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:17 ч.
 */
public abstract class Food {

    private int quantity;

    public Food() {
    }

    public Food(int quantity) {
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}