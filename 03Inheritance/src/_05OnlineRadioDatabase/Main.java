package _05OnlineRadioDatabase;


import _05OnlineRadioDatabase.exceptions.InvalidSongException;
import _05OnlineRadioDatabase.exceptions.InvalidSongLengthException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 15:36 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException, InvalidSongLengthException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        Radio radio = new Radio();

        for (int i = 0; i < n; i++) {

            String[] input = bufferedReader.readLine()
                    .trim()
                    .split(";");
            try {
                if (input.length != 3) {
                    throw new InvalidSongLengthException("Invalid song length.");
                }

                String artistName = input[0];
                String songName = input[1];
                String[] time = input[2].split(":");

                int songMinutes = 0;
                int songSeconds = 0;
                try {
                    songMinutes = Integer.parseInt(time[0]);
                    songSeconds = Integer.parseInt(time[1]);
                } catch (Exception e) {
                    throw new InvalidSongLengthException("Invalid song length.");
                }

                Song song = new Song(artistName, songName, songMinutes, songSeconds);

                radio.addSong(song);

                System.out.println("Song added.");
            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.println(radio);
    }
}