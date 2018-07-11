package _002MethodOverriding;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 09:28 ч.
 */
public class Rectangle {

    private Double sideA;
    private Double sideB;

    public Rectangle(Double sideA, Double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(Double sideA) {
        this.sideA = sideA;
    }

    public Double area() {
        return sideA * sideB;
    }
}