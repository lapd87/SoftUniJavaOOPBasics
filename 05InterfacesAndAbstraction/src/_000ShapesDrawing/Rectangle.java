package _000ShapesDrawing;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 09:43 ч.
 */
public class Rectangle implements Drawable {

    private Integer width;
    private Integer height;

    public Rectangle() {
    }

    public Rectangle(Integer width, Integer height) {
        setWidth(width);
        setHeight(height);
    }

    private Integer getWidth() {
        return width;
    }

    private void setWidth(Integer width) {
        this.width = width;
    }

    private Integer getHeight() {
        return height;
    }

    private void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < this.getHeight(); i++) {
            System.out.print("*");
            for (int j = 1; j < this.getWidth() - 1; j++) {
                System.out.print(" ");
                if (i == 0 || i == (this.getHeight() - 1)){
                    System.out.print("*");
                } else { System.out.print(" "); }}
            System.out.print(" ");
            System.out.print("*");
            System.out.println();
        }
    }
}