package tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourcesLoader {  
    public BufferedImage loadImage(String imgName) {
        BufferedImage tempIMG = null;
        
        try {
            // tempIMG = ImageIO.read(ClassLoader.class.getResourceAsStream("assets/Background.jpg"));
            tempIMG = ImageIO.read(new File("assets/" + imgName));  // idfk why does this work and the code commented above doesn't
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return tempIMG;
    }
}
