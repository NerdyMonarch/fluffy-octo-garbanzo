package com.teamW;

import java.io.FileNotFoundException;

public class Launcher {
    public static void main(String[] args) throws FileNotFoundException {
        Game game = new Game("Wessica and Wikhil");
        game.start();
    }
}