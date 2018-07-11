package _002Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
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
                    CreateAccount(bankAccounts);
                    break;
                case "Deposit":
                    DepositToAccount(bankAccounts, inputArgs);
                    break;
                case "SetInterest":
                    SetAccountInterest(inputArgs);
                    break;
                case "GetInterest":
                    GetAccountInterest(bankAccounts, inputArgs);
                    break;
            }
        }
    }

    private static void GetAccountInterest(Map<Integer, BankAccount> bankAccounts, String[] inputArgs) {
        BankAccount currentAccount;

        int id = Integer.parseInt(inputArgs[1]);

        if (bankAccounts.containsKey(id)) {
            currentAccount = bankAccounts.get(id);

            int years = Integer.parseInt(inputArgs[2]);

            if (years >= 0) {
                double interest = currentAccount.getInterest(years);

                System.out.printf("%.2f%n", interest);
            } else {
                System.out.println("Invalid interest period");
            }
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void SetAccountInterest(String[] inputArgs) {
        double interestRate = Double.parseDouble(inputArgs[1]);

        BankAccount.setInterestRate(interestRate);
    }

    private static void DepositToAccount(Map<Integer, BankAccount> bankAccounts, String[] inputArgs) {
        BankAccount currentAccount;

        int id = Integer.parseInt(inputArgs[1]);

        if (bankAccounts.containsKey(id)) {
            currentAccount = bankAccounts.get(id);

            double amount = Double.parseDouble(inputArgs[2]);

            if (amount >= 0) {
                currentAccount.deposit(amount);

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String resultAmount = decimalFormat.format(amount);

                System.out.printf("Deposited %s to %s%n",
                        resultAmount, currentAccount);
            } else {
                System.out.println("Negative amount");
            }
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void CreateAccount(Map<Integer, BankAccount> bankAccounts) {
        BankAccount currentAccount = new BankAccount();

        int id = currentAccount.getId();

        bankAccounts.put(id, currentAccount);

        System.out.printf("Account %s created%n",
                currentAccount);
    }
}