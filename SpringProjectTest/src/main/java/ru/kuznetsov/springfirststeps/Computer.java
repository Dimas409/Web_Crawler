package ru.kuznetsov.springfirststeps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        List<String> strings = Collections.singletonList(musicPlayer.playMusic());
        return "Computer" +
                " " + id +
                " " + musicPlayer.playMusic();
    }
}
