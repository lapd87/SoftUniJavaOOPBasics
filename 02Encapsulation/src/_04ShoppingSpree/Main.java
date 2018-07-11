package _04ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.6.2018 г.
 * Time: 15:57 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        List<Person> clients = new ArrayList<>();

        String[] peopleArgs = bufferedReader.readLine()
                .split(";");

        for (String personData : peopleArgs) {
            String[] personArgs = personData.split("=");
            String name = personArgs[0];
            double money = Double.parseDouble(personArgs[1]);

            try {
                Person person = new Person(name, money);
                clients.add(person);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        List<Product> products = new ArrayList<>();


        String[] productsArgs = bufferedReader.readLine()
                .split(";");

        for (String productData : productsArgs) {
            String[] productArgs = productData.split("=");
            String name = productArgs[0];
            double cost = Double.parseDouble(productArgs[1]);

            try {
                Product product = new Product(name, cost);
                products.add(product);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        String command;
        while (!"END".equals(command = bufferedReader.readLine())) {

            String[] commandArgs = command.split("\\s+");
            String clientName = commandArgs[0];
            String productName = commandArgs[1];


            clients.stream()
                    .filter(c -> clientName
                            .equals(c.getName()))
                    .forEach(c -> products.stream()
                            .filter(p -> productName
                                    .equals(p.getName()))
                            .forEach(p -> System.out
                                    .println(c.buyProduct(p)))
                    );
        }

        for (Person client : clients) {
            System.out.println(client);
        }
    }
}