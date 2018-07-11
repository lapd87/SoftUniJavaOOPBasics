package _002MethodOverriding;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 09:28 ч.
 */
public class Square extends Rectangle {

    private Double side;

    public Square(Double side) {
        super(side);
        setSide(side);
    }

    public void setSide(Double side) {
        this.side = side;
    }

    @Override
    public Double area() {
        return side * side;
    }
}