package _002CarShopExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 09:58 ч.
 */
public interface Rentable extends Car {

    Integer getMinRentDay();
    Double getPricePerDay();
}
