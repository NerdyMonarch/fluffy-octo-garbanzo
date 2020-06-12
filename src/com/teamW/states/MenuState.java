package com.teamW.states;

import java.awt.Graphics;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.graphics.Assets;

public class MenuState extends State {

    public void tick() {
        if(Handler.getMouseInput().isLeftPressed()) {
            State.setState(Handler.getGame().getGameState());
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.getMenuAsset(0), 0, 0, Config.WIDTH, Config.HEIGHT, null);
        g.drawImage(Assets.getMenuAsset(1), 0, 32, Config.WIDTH, 80, null);
    }
}