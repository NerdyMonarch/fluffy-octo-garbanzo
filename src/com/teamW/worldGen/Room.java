package com.teamW.worldGen;

import java.awt.Graphics;
import java.util.Scanner;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.tiles.TileHandler;

public class Room {
    
    private Handler handler;
    private int width, height;
    private int[][] tiles;
    private Scanner input;

    public Room(Handler handler, String path) {
        this.handler = handler;
        this.input = new Scanner(path);
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
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
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