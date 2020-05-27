package com.teamW.objects;

import java.awt.Graphics;

public abstract class GameObject {
    // Coordinates
    protected int x;
    protected int y;

    public GameObject() {
        this.x = 0;
        this.y = 0;
    }

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Method to Update Game State
    public abstract void tick();

    // Method to Render Game Object
    public abstract void render(Graphics g);

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}