package com.teamW.states;

import java.awt.Graphics;

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
        g.drawImage(Assets.getMenuAsset(0), 0, 0, null);
    }
}