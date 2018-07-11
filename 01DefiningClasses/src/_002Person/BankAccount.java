package _002Person;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 10:03 ч.
 */
public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;

    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public double getInterest(int years) {
        return interestRate * this.balance * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "ID" + id;
    }
}