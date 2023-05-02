package graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import control.Mouse;
import state.GameState;

public class DrawingSurface extends Canvas {

    private int width, height;

    private BufferStrategy buffer;
    private Graphics g;

    private Mouse mouse;

    public DrawingSurface(int width, int height) {
        this.width = width;
        this.height = height;

        mouse = new Mouse(this);

        setCursor(mouse.getCursor());

        setPreferredSize(new Dimension(width, height));
    }

    public void update(final GameState gs) {
        gs.update();

        mouse.update(this);
    }

    public void draw(final GameState gs) {
        buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(2);
            return;
        }

        g = buffer.getDrawGraphics();

        gs.draw(g);

        mouse.drawCoordinates(g);

        g.dispose();

        buffer.show();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Mouse getMouse() {
        return mouse;
    }
}
