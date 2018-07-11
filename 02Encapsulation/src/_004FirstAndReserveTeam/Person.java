package _004FirstAndReserveTeam;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.6.2018 г.
 * Time: 09:09 ч.
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String firstName, String lastName,
                  int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        } else {
            this.firstName = firstName;
        }
    }

    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        } else {
            this.lastName = lastName;
        }
    }

    private void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        } else {
            this.age = age;
        }
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        } else {
            this.salary = salary;
        }
    }

    public int getAge() {
        return age;
    }

    public void increaseSalary(Double bonus) {

        if (this.age < 30) {
            bonus /= 2.0;
        }

        this.salary *= 1 + bonus / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",
                this.firstName,
                this.lastName,
                this.salary);
    }
}