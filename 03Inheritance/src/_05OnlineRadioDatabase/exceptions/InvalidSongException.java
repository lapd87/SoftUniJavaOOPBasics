package _05OnlineRadioDatabase.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 14:33 ч.
 */
public class InvalidSongException extends Exception {
    public InvalidSongException(String message) {
        super(message);
    }
}