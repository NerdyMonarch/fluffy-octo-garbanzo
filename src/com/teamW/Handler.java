package com.teamW;

import com.teamW.inputs.KeyInput;
import com.teamW.inputs.MouseInput;
import com.teamW.worldGen.Room;

public class Handler {
    private static Game game;
    private static Room room;

    public static KeyInput getKeyInput(){
        return game.getKeyInput();
    }

    public static MouseInput getMouseInput() {
        return game.getMouseInput();
    }

    public static Game getGame(){
        return Handler.game;
    }

    public static void setGame(Game game){
        Handler.game = game;
    }

    public static void setRoom(Room room) {
        Handler.room = room;
    }
    
    public static Room getRoom(){
        return Handler.room;
    }
}