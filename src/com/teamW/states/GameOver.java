package com.teamW.states;

import java.awt.Graphics;
import java.io.FileNotFoundException;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.graphics.Assets;

public class GameOver extends State {

    @Override
    public void tick() {
        if(Handler.getMouseInput().isLeftPressed()) {
            try {
                Handler.getGame().resetGame();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            State.setState(Handler.getGame().getGameState());
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.getMenuAsset(2), 0, 0, Config.WIDTH, Config.HEIGHT, null);
    }
    
}