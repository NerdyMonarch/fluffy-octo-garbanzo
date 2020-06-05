package com.teamW.worldGen;

import java.awt.Graphics;
import java.util.Scanner;

import com.teamW.Config;

public class Room {
    
    private int width, height;
    private int[][] tiles;
    private Scanner input;

    public Room(String path) {
        this.input = new Scanner(path);
        this.tiles = new int[Config.ROOM_WIDTH][Config.ROOM_HEIGHT];
        loadRoom(path);
    }

    public void render(Graphics g) {
        for(int  y= 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
            }
        }
    }

    public void tick() {

    }

    /* public Tile getTile(int num) {
        // PlaceHolder
        return new Tile();
    } */

    public void loadRoom(String path) {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                tiles[x][y] = input.nextInt();
            }
        }
    }


}