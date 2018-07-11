package _05OnlineRadioDatabase.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 14:34 ч.
 */
public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(String message) {
        super(message);
    }
}