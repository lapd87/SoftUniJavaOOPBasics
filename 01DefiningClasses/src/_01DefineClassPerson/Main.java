package _01DefineClassPerson;

import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 14:47 ч.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}