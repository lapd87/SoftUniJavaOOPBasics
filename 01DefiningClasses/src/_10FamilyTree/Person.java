package _10FamilyTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.6.2018 г.
 * Time: 10:57 ч.
 */
public class Person {

    private static final String DEFAULT_NAME = "";
    private static final String DEFAULT_BIRTHDAY = "";

    private String name;
    private String birthday;
    private List<Person> parents;
    private List<Person> children;

    public Person() {
        this(DEFAULT_NAME, DEFAULT_BIRTHDAY);
    }

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name)
                .append(" ")
                .append(birthday)
                .append(System.lineSeparator())
                .append("Parents:")
                .append(System.lineSeparator());

        parents.forEach(p -> stringBuilder.append(p.getName())
                .append(" ")
                .append(p.getBirthday())
                .append(System.lineSeparator()));

        stringBuilder.append("Children:")
                .append(System.lineSeparator());

        children.forEach(c -> stringBuilder.append(c.getName())
                .append(" ")
                .append(c.getBirthday())
                .append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}