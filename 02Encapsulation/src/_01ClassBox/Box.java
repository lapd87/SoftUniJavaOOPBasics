package _01ClassBox;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.6.2018 г.
 * Time: 12:16 ч.
 */
public class Box {

    private double length;
    private double width;
    private double height;

    public Box() {
    }

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getSurfaceArea() {
        return 2 * (length * width + length * height
                + width * height);
    }

    public double getLateralSurfaceArea() {
        return 2 * (length * height + width * height);
    }

    public double getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                        "Lateral Surface Area - %.2f%n" +
                        "Volume - %.2f",
                getSurfaceArea(),
                getLateralSurfaceArea(),
                getVolume());
    }
}