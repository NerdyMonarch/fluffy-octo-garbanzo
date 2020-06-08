package com.teamW.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.teamW.Config;

public abstract class GameObject {
    // Coordinates
    protected double x;
    protected double y;

    // Dimension of Object
    protected int width;
    protected int height;

    // Collisions
    protected Rectangle bounds;

    public GameObject() {
        this.x = 0;
        this.y = 0;
        this.width = Config.DEFAULT_OBJECT_WIDTH;
        this.height = Config.DEFAULT_OBJECT_HEIGHT;

        this.bounds = new Rectangle(0, 0, width, height);
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Method to Update Game State
    public abstract void tick();

    // Method to Render Game Object
    public abstract void render(Graphics g);

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }
}