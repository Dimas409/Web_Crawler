package ru.kuznetsov.springfirststeps;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;


public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    private List<Music> genre;


    public MusicPlayer(List<Music> genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public String  playMusic(){
        Random r = new Random();
        int i = r.nextInt(genre.size());
        return "Playing: " + genre.get(i).getSong();
    }

}
