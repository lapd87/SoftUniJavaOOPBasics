package _002CarShopExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 09:50 ч.
 */
public class Seat implements Sellable {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Double price;

    public Seat() {
    }

    public Seat(String model, String color,
                Integer horsePower, String countryProduced,
                Double price) {
        setModel(model);
        setColor(color);
        setHorsePower(horsePower);
        setCountryProduced(countryProduced);
        setPrice(price);
    }

    private void setPrice(Double price) {
        this.price = price;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    private void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    private String getCountryProduced() {
        return countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                getModel(),
                getCountryProduced(),
                TIRES);
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}