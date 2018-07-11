package _09CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.6.2018 г.
 * Time: 14:06 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine()
                .split("\\s+");

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        StringBuilder addCollectionAdd = new StringBuilder();
        StringBuilder addRemoveCollectionAdd = new StringBuilder();
        StringBuilder myListAdd = new StringBuilder();
        for (String s : input) {
            addCollectionAdd
                    .append(addCollection.add(s))
                    .append(" ");

            addRemoveCollectionAdd
                    .append(addRemoveCollection.add(s))
                    .append(" ");

            myListAdd
                    .append(myList.add(s))
                    .append(" ");
        }
        System.out.println(addCollectionAdd.toString().trim());
        System.out.println(addRemoveCollectionAdd.toString().trim());
        System.out.println(myListAdd.toString().trim());

        int removeCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder addRemoveCollectionRemove = new StringBuilder();
        StringBuilder myListRemove = new StringBuilder();

        for (int i = 0; i < removeCount; i++) {
            addRemoveCollectionRemove
                    .append(addRemoveCollection.remove())
                    .append(" ");

            myListRemove
                    .append(myList.remove())
                    .append(" ");
        }

        System.out.println(addRemoveCollectionRemove.toString().trim());
        System.out.println(myListRemove.toString().trim());
    }
}