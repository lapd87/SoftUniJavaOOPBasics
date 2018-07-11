package _05OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 14:38 ч.
 */
public class Radio {

    private List<Song> songs;

    public Radio() {
        this.songs = new ArrayList<>();
    }

    private List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        getSongs().add(song);
    }

    private String playlistLength() {

        long totalLengthSeconds = getSongs().stream()
                .mapToInt(Song::songLengthInSeconds)
                .sum();

        long hours = totalLengthSeconds / 3600;
        long minutes = totalLengthSeconds % 3600 / 60;
        long seconds = totalLengthSeconds % 3600 % 60;

        return String.format("Playlist length: %dh %dm %ss",
                hours, minutes, seconds);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String
                .format("Songs added: %d",
                        getSongs().size()))
                .append(System.lineSeparator())
                .append(playlistLength());

        return stringBuilder.toString();
    }
}