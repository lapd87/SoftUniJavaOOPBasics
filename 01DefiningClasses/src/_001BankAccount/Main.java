package _001BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 10:32 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input;
        while (!"End".equals(input = bufferedReader.readLine())) {

            String[] inputArgs = input.split("\\s+");

            switch (inputArgs[0]) {
                case "Create":
                    CreateAccount(bankAccounts, inputArgs);
                    break;
                case "Deposit":
                    DepositToAccount(bankAccounts, inputArgs);
                    break;
                case "Withdraw":
                    WithdrawFromAccount(bankAccounts, inputArgs);
                    break;
                case "Print":
                    PrintAccount(bankAccounts, inputArgs);
                    break;
            }
        }
    }

    private static void PrintAccount(Map<Integer, BankAccount> bankAccounts, String[] inputArg) {
        BankAccount currentAccount;

        int id = Integer.parseInt(inputArg[1]);

        if (bankAccounts.containsKey(id)) {
            currentAccount = bankAccounts.get(id);

            System.out.printf("Account %s, balance %.2f%n",
                    currentAccount,
                    currentAccount.getBalance());
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void WithdrawFromAccount(Map<Integer, BankAccount> bankAccounts, String[] inputArgs) {
        BankAccount currentAccount;

        int id = Integer.parseInt(inputArgs[1]);

        if (bankAccounts.containsKey(id)) {
            currentAccount = bankAccounts.get(id);

            double amount = Double.parseDouble(inputArgs[2]);
            double balance = currentAccount.getBalance();

            if (amount <= balance) {
                currentAccount.withdraw(amount);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void DepositToAccount(Map<Integer, BankAccount> bankAccounts, String[] inputArgs) {
        BankAccount currentAccount;

        int id = Integer.parseInt(inputArgs[1]);

        if (bankAccounts.containsKey(id)) {
            currentAccount = bankAccounts.get(id);

            double amount = Double.parseDouble(inputArgs[2]);

            if (amount >= 0) {
                currentAccount.deposit(amount);
            } else {
                System.out.println("Negative amount");
            }
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void CreateAccount(Map<Integer, BankAccount> bankAccounts, String[] inputArg) {
        BankAccount currentAccount;

        int id = Integer.parseInt(inputArg[1]);

        if (!bankAccounts.containsKey(id)) {
            currentAccount = new BankAccount();
            currentAccount.setId(id);

            bankAccounts.put(id, currentAccount);
        } else {
            System.out.println("Account already exists");
        }
    }
}