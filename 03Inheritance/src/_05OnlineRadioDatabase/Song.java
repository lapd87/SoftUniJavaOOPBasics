package _05OnlineRadioDatabase;

import _05OnlineRadioDatabase.exceptions.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 15:29 ч.
 */
public class Song {

    private String artistName;
    private String songName;
    private int minutesLength;
    private int secondsLength;

    public Song() {
    }

    public Song(String artistName, String songName,
                int minutesLength, int secondsLength) throws InvalidSongException {
        setArtistName(artistName);
        setSongName(songName);
        setMinutesLength(minutesLength);
        setSecondsLength(secondsLength);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {

        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {

        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }

        this.songName = songName;
    }

    private void setMinutesLength(int minutesLength) throws InvalidSongMinutesException {

        if (minutesLength < 0 || minutesLength > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }

        this.minutesLength = minutesLength;
    }

    private void setSecondsLength(int secondsLength) throws InvalidSongSecondsException {

        if (secondsLength < 0 || secondsLength > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }

        this.secondsLength = secondsLength;
    }

    private int getMinutesLength() {
        return minutesLength;
    }

    private int getSecondsLength() {
        return secondsLength;
    }

    public int songLengthInSeconds() {
        return getMinutesLength() * 60 + getSecondsLength();
    }
}