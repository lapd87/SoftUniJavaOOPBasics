package _001OverloadMethod;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.6.2018 г.
 * Time: 09:26 ч.
 */
public class MathOperation {

    protected int add(int a, int b) {
        return a + b;
    }

    protected int add(int a, int b, int c) {
        return a + b + c;
    }

    protected int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}