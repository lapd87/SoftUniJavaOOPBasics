package _006StackOfStrings;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 11:40 ч.
 */
public class StackOfStrings {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {

        if (isEmpty()) {
            return null;
        }

        return data.remove(data.size() - 1);
    }

    public String peek() {

        if (isEmpty()) {
            return null;
        }

        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}