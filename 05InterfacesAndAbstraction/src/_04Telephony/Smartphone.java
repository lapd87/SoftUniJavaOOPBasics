package _04Telephony;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 12:03 ч.
 */
public class Smartphone implements Callable, Browsable {

    private final String INVALID_PHONE_NUMBER_MESSAGE = "Invalid number!";
    private final String INVALID_URL_MESSAGE = "Invalid URL!";

    private String phoneNumber;
    private String url;

    public Smartphone() {
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_PHONE_NUMBER_MESSAGE);
        }

        this.phoneNumber = phoneNumber;
    }

    public void setUrl(String url) {
        if (url.matches(".*\\d+.*")) {
            throw new IllegalArgumentException(INVALID_URL_MESSAGE);
        }

        this.url = url;
    }

    private String getUrl() {
        return url;
    }

    private String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String call() {
        return String.format("Calling... %s",
                getPhoneNumber());
    }

    @Override
    public String browse() {
        return String.format("Browsing: %s!",
                getUrl());
    }
}