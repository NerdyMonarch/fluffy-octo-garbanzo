package com.teamW.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static BufferedImage[] floors = {
        ImageLoader.loadImage("/textures/tiles/floors/floor_0.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_1.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_2.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_3.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_4.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_5.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_6.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_7.png")
    };
    
    private static BufferedImage[] walls;

    private static BufferedImage[] players = {
        ImageLoader.loadImage("/textures/creatures/player_1.png")
    };

    public static BufferedImage getFloor(int num) {
        return floors[num];
    }

    public static BufferedImage getWall(int num) {
        return walls[num];
    }

    public static BufferedImage getPlayer(int num) {
        return players[num];
    }

}