package _002SalaryIncrease;

import java.text.DecimalFormat;

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
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(Double bonus) {

        if (this.age > 30) {
            this.salary += this.salary * bonus / 100;
        } else {
            this.salary += this.salary * bonus / 200;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",
                this.firstName,
                this.lastName,
                new DecimalFormat("#.0############################################################")
                        .format(this.salary));
    }
}