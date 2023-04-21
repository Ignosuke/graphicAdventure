package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class DrawingSurface extends Canvas {

    private BufferStrategy buffer;
    private Graphics g;

    public DrawingSurface(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void draw() {

        buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(2);
            return;
        }

        g = buffer.getDrawGraphics();

        //We draw here

        g.dispose();

        buffer.show();
    }

}
