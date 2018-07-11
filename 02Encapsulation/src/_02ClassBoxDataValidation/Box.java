package _02ClassBoxDataValidation;

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
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
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