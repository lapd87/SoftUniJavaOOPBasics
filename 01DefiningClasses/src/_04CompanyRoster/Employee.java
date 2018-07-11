package _04CompanyRoster;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 19:11 ч.
 */
public class Employee {

    private static final String DEFAULT_EMAIL = "n/a";
    private static final int DEFAULT_AGE = -1;

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee() {
    }

    public Employee(String name, double salary,
                    String position, String department) {
        this(name, salary, position, department,
                DEFAULT_EMAIL, DEFAULT_AGE);
    }

    public Employee(String name, double salary,
                    String position, String department,
                    String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d%n",
                name, salary, email, age);
    }
}