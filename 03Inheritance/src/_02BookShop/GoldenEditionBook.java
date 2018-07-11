package _02BookShop;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 11:56 ч.
 */
public class GoldenEditionBook extends Book {

    public GoldenEditionBook() {
        super();
    }

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected void setPrice(double price) {
        super.setPrice(price + price * 0.3);
    }
}