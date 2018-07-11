package _001BankAccount;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 10:30 ч.
 */
public class _02GettersAndSetters {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.setId(1);
        account.deposit(15);
        account.withdraw(5);

        System.out.printf("Account %s, balance %.2f",
                account,
                account.getBalance());
    }
}