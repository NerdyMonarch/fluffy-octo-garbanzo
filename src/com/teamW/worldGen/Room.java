package com.teamW.worldGen;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.teamW.Config;
import com.teamW.tiles.TileHandler;

public class Room {

    private int width, height;
    private int[][] tiles;
    private Scanner input;
    private File file;

    public Room(String path) throws FileNotFoundException {

        this.file = new File(path);
        this.input = new Scanner(file);
        this.tiles = new int[Config.ROOM_WIDTH][Config.ROOM_HEIGHT];
        this.width = Config.ROOM_WIDTH;
        this.height = Config.ROOM_HEIGHT;
        loadRoom(path);
    }

    public void render(Graphics g) {
        for(int  y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                TileHandler.getTile(tiles[x][y]).render(g, x * Config.TILE_WIDTH * Config.TILE_SCALE, y * Config.TILE_HEIGHT * Config.TILE_SCALE);
            }
        }
    }

    public void tick() {

    }

    public void loadRoom(String path) {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(input.hasNextInt()) {
                    tiles[x][y] = input.nextInt();
                }
                else {
                    System.out.println("ERROR IN READING WORLD TXT");
                }
            }
        }
    }


}