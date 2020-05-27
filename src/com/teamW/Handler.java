package com.teamW;

import java.util.LinkedList;
import java.awt.Graphics;

import com.teamW.objects.GameObject;

public class Handler {
    // List of GameObjects to Update
    private LinkedList<GameObject> objects;

    public Handler() {
        objects = new LinkedList<GameObject>();
    }

    // Updates all Objects in List
    public void tick() {
        for(int i = 0; i < objects.size(); i++) {
            GameObject obj = objects.get(i);
            obj.tick();
        }
    }

    // Renders all Objects in List
    public void render(Graphics g) {
        for(int i = 0; i < objects.size(); i++) {
            GameObject obj = objects.get(i);
            obj.render(g);
        }
    }

    // Adds Object into Linked List
    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    // Removes Object from Linked List
    public void removeObject(GameObject obj) {
        objects.remove(obj);
    }
}