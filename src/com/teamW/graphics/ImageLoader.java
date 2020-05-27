package com.teamW.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
        // Obtains Image from Path and Turns it into a BufferedImage
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        // Checks IO Operation Failures 
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // Never Reached
        return null;
    }
}