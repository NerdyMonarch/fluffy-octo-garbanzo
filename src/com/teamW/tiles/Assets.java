package com.teamW.tiles;

import java.awt.image.BufferedImage;

import com.teamW.graphics.ImageLoader;

public class Assets {
    public static BufferedImage floor0, floor1, floor2, floor3, floor4, floor5, floor6, floor7,player1;
    

    public static void init(){
        floor0 = (ImageLoader.loadImage("/textures/tiles/floors/floor_0.png"));
        floor1 = (ImageLoader.loadImage("/textures/tiles/floors/floor_1.png"));
        floor2 = (ImageLoader.loadImage("/textures/tiles/floors/floor_2.png"));
        floor3 = (ImageLoader.loadImage("/textures/tiles/floors/floor_3.png"));
        floor4 = (ImageLoader.loadImage("/textures/tiles/floors/floor_4.png"));
        floor5 = (ImageLoader.loadImage("/textures/tiles/floors/floor_5.png"));
        floor6 = (ImageLoader.loadImage("/textures/tiles/floors/floor_6.png"));
        floor7 = (ImageLoader.loadImage("/textures/tiles/floors/floor_7.png"));
        player1 = (ImageLoader.loadImage("/textures/creatures/player_1.png"));
    }
}