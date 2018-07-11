package _003Shapes;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 10:16 ч.
 */
public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);

        calculateArea();
        calculatePerimeter();
    }

    private double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        this.width = width;
    }


    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * (getHeight() + getWidth()));
    }

    @Override
    public void calculateArea() {
        setArea(getHeight() * getWidth());
    }
}