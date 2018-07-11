package _003Shapes;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 10:18 ч.
 */
public class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        setRadius(radius);

        calculateArea();
        calculatePerimeter();
    }

    private final double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * getRadius());
    }

    @Override
    public void calculateArea() {
        setArea(Math.PI * getRadius() * getRadius());
    }
}