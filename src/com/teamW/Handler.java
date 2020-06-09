package com.teamW;

import java.util.LinkedList;
import java.awt.Graphics;

import com.teamW.inputs.KeyInput;
import com.teamW.objects.GameObject;
import com.teamW.worldGen.Room;

public class Handler {
    private Game game;
    private Room room;

    public Handler(Game game) {
        this.game = game; 
    }

	public KeyInput getKeyInput(){
        return game.getKeyInput();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }
    
    public Game getGame(){
        return game;
    }

    public void setGame(Game game){
        this.game = game;
    }

    public Room getRoom(){
        return room;
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