package _04ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.6.2018 г.
 * Time: 15:51 ч.
 */
public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person() {
        this.products = new ArrayList<>();
    }

    public Person(String name, double money) {
        this();
        setName(name);
        setMoney(money);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public String getName() {
        return name;
    }

    private List<Product> getProducts() {
        return products;
    }

    public String buyProduct(Product product) {
        if (product.getCost() > money) {
            return String.format("%s can't afford %s",
                    this.name, product.getName());
        } else {
            money -= product.getCost();
            products.add(product);
            return String.format("%s bought %s",
                    this.name, product.getName());
        }
    }

    @Override
    public String toString() {
        if (products.size() > 0) {
            return String.format("%s - %s",
                    this.name,
                    String.join(", ",
                            products.stream()
                                    .map(Product::getName)
                                    .collect(Collectors.toList())));
        } else {
            return String.format("%s - Nothing bought",
                    this.name);
        }
    }
}