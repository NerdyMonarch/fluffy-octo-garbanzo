package com.teamW.inputs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import sun.awt.AWTAccessor.KeyEventAccessor; //class in openJDK

public class KeyInput extends KeyAdapter {

    private boolean[] keys;
    public boolean up, down, left, right;
    public boolean attackUp, attackDown, attackLeft, attackRight;
    public KeyInput() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        attackUp = keys[KeyEvent.VK_I];
        attackDown = keys[KeyEvent.VK_K];
        attackLeft = keys[KeyEvent.VK_J];
        attackRight = keys[KeyEvent.VK_L];
    }
    
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}