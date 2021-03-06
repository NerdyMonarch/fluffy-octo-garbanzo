package com.teamW.states;

import java.awt.Graphics;
import java.io.FileNotFoundException;

public abstract class State {
    
    private static State currentState = null;

    public State() {
    }
    
    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }
    
    public abstract void tick();

    public abstract void render(Graphics g);
}