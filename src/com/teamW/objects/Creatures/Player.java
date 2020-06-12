package com.teamW.objects.Creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.graphics.Animation;
import com.teamW.graphics.Assets;
import com.teamW.states.State;

import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Animation idleAnimation;
    private Animation walkAnimation;
    private Animation attackAnimation;
    private Boolean lookingLeft;
    private Boolean attacking;

    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    
    public Player(int x, int y) {
        super(x, y, Config.DEFAULT_OBJECT_WIDTH, Config.DEFAULT_OBJECT_HEIGHT);
        this.bounds = new Rectangle(0, 0, height * Config.TILE_SCALE, width * Config.TILE_SCALE);
        idleAnimation = new Animation(250, Assets.getPlayerAnimation(0));
        walkAnimation = new Animation(150, Assets.getPlayerAnimation(1));
        attackAnimation = new Animation(100, Assets.getPlayerAnimation(1));
        lookingLeft = false;
        attacking = false;
    }

    public void tick() {
        animTick();
        getInput();
        if(xMove < 0 && !lookingLeft) {
            lookingLeft = true;
            x += width * Config.TILE_SCALE;
        }
        else if(xMove > 0 && lookingLeft) {
            lookingLeft = false;
            x -= width * Config.TILE_SCALE;
        }
        move();
        checkAttacks();
    }

    private void checkAttacks() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer > attackCooldown - 300) {
            attacking = false;
        }
        if(attackTimer < attackCooldown) {
            return;
        }
        Rectangle temp = new Rectangle();
        int tempSize = Config.ATTACK_SIZE;
        temp.width = tempSize;
        temp.height = tempSize;

        if(Handler.getKeyInput().attackUp) {
            temp.x = (int) x + bounds.width / 2 - tempSize / 2;
            temp.y = (int) y - tempSize;
        }
        else if(Handler.getKeyInput().attackDown) {
            temp.x = (int) x + bounds.width / 2 - tempSize / 2;
            temp.y = (int) y + bounds.height;
        }
        else if(Handler.getKeyInput().attackLeft) {
            temp.x = (int) x - tempSize;
            temp.y = (int) y + bounds.height / 2 - tempSize / 2;
        }
        else if(Handler.getKeyInput().attackRight) {
            temp.x = (int) x + bounds.width;
            temp.y = (int) y + bounds.height / 2 - tempSize / 2;
        }
        else {
            return;
        }
        attacking = true;
        attackTimer = 0;
        
        for(Creature c: Handler.getGame().getGameState().getHandler().getObjects()) {
            if(c.equals(this)) {
                continue;
            }
            if(c.getCollisionBounds(0, 0).intersects(temp)) {
                c.hurt(1);
                System.out.println("Hurting");
                return;
            }
        }
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if(Handler.getKeyInput().up) {
            yMove = -speed;
        }
        if(Handler.getKeyInput().down) {
            yMove = speed;
        }
        if(Handler.getKeyInput().left) {
            xMove = -speed;
        }
        if(Handler.getKeyInput().right) {
            xMove = speed;
        }
    }

    public void die() {
        System.out.println("You Lose");
        State.setState(Handler.getGame().getGameOver());
    }

    public BufferedImage getFrame() {
        if(attacking) {
            return attackAnimation.getCurrentFrame();
        }
        if(Math.abs(xMove) > 0 || Math.abs(yMove) > 0) {
            return walkAnimation.getCurrentFrame();
        }
        return idleAnimation.getCurrentFrame();
    }

    public void animTick() {
        idleAnimation.tick();
        walkAnimation.tick();
        attackAnimation.tick();
    }

    public void render(Graphics g) {
        int tempWidth = width;
        if(lookingLeft) {
            tempWidth *= -1;
        }
        g.drawImage(getFrame(), (int) x, (int) y, tempWidth * Config.TILE_SCALE, height * Config.TILE_SCALE, null);
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Health: " + health, 15, 30);
    }
}