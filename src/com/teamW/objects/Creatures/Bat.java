package com.teamW.objects.Creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.graphics.Animation;
import com.teamW.graphics.Assets;

public class Bat extends Creature {

    private Animation batAnimation;
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    private boolean oppoDirection;
    private long directTimer;
    public static int batsKilled = 0;

    public Bat(int x, int y) {
        super(x, y, Config.DEFAULT_OBJECT_WIDTH, Config.DEFAULT_OBJECT_HEIGHT);
        this.bounds = new Rectangle(0, 0, height * Config.TILE_SCALE, width * Config.TILE_SCALE);
        batAnimation = new Animation(150, Assets.getBatAnimation());
        this.health = 2;
    }

    public void tick() {
        batAnimation.tick();
        setBehavior();
        move();
    }

    public void render(Graphics g) {
        g.drawImage(batAnimation.getCurrentFrame(), (int) x, (int) y, width, height, null);
    }
    
    public void die() {
        System.out.println("It's Dead!!!!");
        Player player = Handler.getGame().getGameState().getHandler().getPlayer();
        player.setHealth(player.getHealth() + 3);
        batsKilled++;
    }

    public void setBehavior() {
        double playerX = Handler.getGame().getGameState().getHandler().getPlayer().getX();
        double playerY = Handler.getGame().getGameState().getHandler().getPlayer().getY();

        Rectangle temp = new Rectangle((int) x,(int) y, bounds.width / 2, bounds.height / 2);
        if(temp.intersects(new Rectangle((int) playerX, (int) playerY, width / 2, height / 2))) {
            Handler.getGame().getGameState().getHandler().getPlayer().hurt(1);
            System.out.println("Hurting");
            xMove = -4;
            yMove = -4;
            return;
        }
        
        if((System.currentTimeMillis() - directTimer) > 2000) {
            oppoDirection = !oppoDirection;
            directTimer = System.currentTimeMillis();
        }
        if(!oppoDirection) {
            xMove = 1;
            yMove = 1;
        }
        else {
            xMove = -1;
            yMove = -1;
        }


    }
}