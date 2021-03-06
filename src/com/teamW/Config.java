package com.teamW;

import java.awt.Color;

public final class Config {
    // Holds Dimensions of the Game Window
    public static final int WIDTH = 720;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int NUMBER_OF_BUFFERS = 3;
    
    // Default Game Object Dimension
    public static final int DEFAULT_OBJECT_WIDTH = 32;
    public static final int DEFAULT_OBJECT_HEIGHT = 32;

    public static final int TILE_WIDTH = 16;
    public static final int TILE_HEIGHT = 16;
    
    public static final int TILE_SCALE = 2;

    // Holds Dimensions of the Room
    public static final int ROOM_WIDTH = 15;
    public static final int ROOM_HEIGHT = 15;

    // Creature Defaults
    public static final double DEFAULT_SPEED = 1;
    public static final int DEFAULT_HEALTH = 10;

    // Background
    public static final Color background = new Color(37, 19, 26);
	public static final int ATTACK_SIZE = 5;
}