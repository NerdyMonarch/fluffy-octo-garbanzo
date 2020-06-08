package com.teamW.tiles;

import java.awt.Graphics;

public abstract class Tile {

    protected final int id;
    protected boolean solid;
    protected int index;

    public Tile(int id) {
        this.id = id;
        this.solid = false;
        this.index = 0;
    }

    public abstract void tick();

    public abstract void render(Graphics g, int x, int y);

    public abstract void setIndex(int num);

    public int getIndex() {
        return index;
    }

    public void resetIndex() {
        index = 0;
    }

    public int getId() {
        return id;
    }

    public boolean isSolid() {
        return solid;
    }
}