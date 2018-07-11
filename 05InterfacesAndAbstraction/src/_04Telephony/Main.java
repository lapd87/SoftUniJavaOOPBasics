package _04Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 12:04 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] phoneNumbers = bufferedReader.readLine()
                .split("\\s+");
        String[] urls = bufferedReader.readLine()
                .split("\\s+");

        Smartphone smartphone = new Smartphone();

        for (String phoneNumber : phoneNumbers) {
            try {
                smartphone.setPhoneNumber(phoneNumber);
                System.out.println(smartphone.call());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (String url : urls) {
            try {
                smartphone.setUrl(url);
                System.out.println(smartphone.browse());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}