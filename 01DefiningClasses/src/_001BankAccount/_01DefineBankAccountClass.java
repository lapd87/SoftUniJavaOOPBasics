package _001BankAccount;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 10:04 ч.
 */
public class _01DefineBankAccountClass {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.id = 1;
        account.balance = 15;

        System.out.printf("Account ID%d, balance %.2f",
                account.id,
                account.balance);
    }
}