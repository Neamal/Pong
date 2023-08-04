package pong;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileInputStream;

public class Images {
	
	BufferedImage background; {
        try {
            File file = new File("C:/Users/naema/eclipse-workspace/Pong/src/pong/r.png");
            FileInputStream fis = new FileInputStream(file);
            background = ImageIO.read(fis);
        } catch (IOException e) {
            System.err.println(e);
        }
        }
}
