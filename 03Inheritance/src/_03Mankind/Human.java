package _03Mankind;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 12:30 ч.
 */
public class Human {

    private String firstName;
    private String lastName;

    public Human() {
    }

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    private void setFirstName(String firstName) {

        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }

        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {

        if (!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }

        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }

        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("First Name: ")
                .append(this.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ")
                .append(this.getLastName())
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}