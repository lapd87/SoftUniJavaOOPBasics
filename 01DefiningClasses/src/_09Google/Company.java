package _09Google;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.6.2018 г.
 * Time: 09:57 ч.
 */
public class Company {

    private String name;
    private String department;
    private double salary;

    public Company() {
    }

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name)
                .append(" ")
                .append(department)
                .append(" ")
                .append(String.format("%.2f", salary))
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}