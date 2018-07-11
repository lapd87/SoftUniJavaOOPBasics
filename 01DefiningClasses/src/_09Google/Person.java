package _09Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.6.2018 г.
 * Time: 09:55 ч.
 */
public class Person {

    private String name;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Relative> parents;
    private List<Relative> children;
    private Car car;


    public Person() {
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, Company company,
                  List<Pokemon> pokemon, List<Relative> parents,
                  List<Relative> children, Car car) {
        this.name = name;
        this.company = company;
        this.pokemon = pokemon;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Relative> getParents() {
        return parents;
    }

    public List<Relative> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name)
                .append(System.lineSeparator())
                .append("Company:")
                .append(System.lineSeparator())
                .append(company != null ? company : "")
                .append("Car:")
                .append(System.lineSeparator())
                .append(car != null ? car : "")
                .append("Pokemon:")
                .append(System.lineSeparator());

        pokemon.forEach(stringBuilder::append);

        stringBuilder.append("Parents:")
                .append(System.lineSeparator());

        parents.forEach(stringBuilder::append);

        stringBuilder.append("Children:")
                .append(System.lineSeparator());

        children.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}