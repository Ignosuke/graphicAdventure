package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import tools.ResourcesLoader;

public class DrawingSurface extends Canvas {

    private int width, height;

    private ResourcesLoader resourcesLoader = new ResourcesLoader();

    private BufferStrategy buffer;
    private Graphics g;
    private BufferedImage image;

    public DrawingSurface(int width, int height) {
        this.width = width;
        this.height = height;

        image = resourcesLoader.loadImage("Background.jpg");

        setPreferredSize(new Dimension(width, height));
    }

    public void draw() {
        buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(2);
            return;
        }

        g = buffer.getDrawGraphics();

        g.drawImage(image, 0, 0, null);
        
        //We draw here
        // g.setColor(Color.BLACK);
        // g.fillRect(0, 0, width, height);

        g.dispose();

        buffer.show();
    }

}
