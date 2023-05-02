package control;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

import graphics.DrawingSurface;
import tools.ResourcesLoader;

public class Mouse extends MouseAdapter{

    private Point position = new Point();
    final Point clickPoint = new Point(16, 16);
    final Toolkit config = Toolkit.getDefaultToolkit();
    private String currentCursorIcon;
    private Cursor cursor;
    private Rectangle mouseDetectionArea;

    public Mouse(final DrawingSurface ds) {

        setCursor(ds, "default_cursor.png");

        updatePosition(ds);

        mouseDetectionArea = new Rectangle((int) position.getX(), (int) position.getY(), 2, 2);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public void update(final DrawingSurface ds) {
        updatePosition(ds);
        updateMouseDetectionArea();
    }

    public void drawCoordinates(final Graphics g) {
        g.drawRect(0, 0, 55, 30);
        g.fillRect(0, 0, 55, 30);
        g.setColor(Color.WHITE);
        g.drawString("X " + getPosition().getX(), 5, 15);
        g.drawString("Y " + getPosition().getY(), 5, 25);
    }

    private void updatePosition(final DrawingSurface ds) {
        final Point initPosition = MouseInfo.getPointerInfo().getLocation();

        SwingUtilities.convertPointFromScreen(initPosition, ds);

        position.setLocation(initPosition.getX(), initPosition.getY());
    }

    private void updateMouseDetectionArea() {
        mouseDetectionArea.setLocation((int) position.getX(), (int) position.getY());
    }

    public Rectangle getMouseDetectionArea() {
        return mouseDetectionArea;
    }
    
    public void setCursor(final DrawingSurface ds, final String cursorName) {
        currentCursorIcon = cursorName;

        final BufferedImage cursorState = ResourcesLoader.loadImage("cursors/" + currentCursorIcon);

        cursor = config.createCustomCursor(cursorState, clickPoint, "CURSOR_ICON");

        ds.setCursor(cursor);
    }

    public String getCurrentCursor() {
        return currentCursorIcon;
    }
}
