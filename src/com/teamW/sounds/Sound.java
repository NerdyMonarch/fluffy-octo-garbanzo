package com.teamW.sounds;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    protected Clip clip;

    public Sound(String path) {
        try {
            File file = new File(path);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch (Exception e) {

        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void loop(int num) {
        clip.loop(num);
    }

    public void stop() {
        clip.stop();
    }

    public void close() {
        clip.close();
    }
}