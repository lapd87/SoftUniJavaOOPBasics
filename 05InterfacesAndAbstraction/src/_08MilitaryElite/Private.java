package _08MilitaryElite;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 14:47 ч.
 */
public class Private extends BaseSoldier {

    private double salary;

    public Private() {
        super();
    }

    public Private(int id, String firstName, String lastName,
                   double salary) {
        super(id, firstName, lastName);
        setSalary(salary);
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    private double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f",
                super.toString(),
                getSalary());
    }
}