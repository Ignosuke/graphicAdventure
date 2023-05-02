package state;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.CollisionZone;
import graphics.DrawingSurface;
import tools.ImgsConverter;
import tools.ResourcesLoader;

public class GameState {
    private CollisionZone collisionZone;
    private BufferedImage image;
    private final DrawingSurface ds;

    public GameState(final DrawingSurface ds) {
        this.ds = ds;

        image = ResourcesLoader.loadImage("images/Background.jpg");

        image = ImgsConverter.scalate(image, 0.8);

        collisionZone = new CollisionZone(ds.getWidth(), ds.getHeight());
    }
    
    public void update() {
        collisionZone.update(ds.getMouse().getMouseDetectionArea());
        checkCursorPosition();
    }

    public void draw(final Graphics g) {
        // g.drawImage(image, 0, 0, null);
    }

    private void checkCursorPosition() {
        if (collisionZone.isLeftCollision()) {
            final String leftDirection = "left_direction.png";
            
            if (ds.getMouse().getCurrentCursor().equals(leftDirection)) return;

            ds.getMouse().setCursor(ds, leftDirection);
            return;
        } else if (collisionZone.isRightCollision()) {
            final String rightDirection = "right_direction.png";
            
            if (ds.getMouse().getCurrentCursor().equals(rightDirection)) return;

            ds.getMouse().setCursor(ds, rightDirection);
            return;
        } else {
            final String defaultDirection = "default_cursor.png";
            
            if (ds.getMouse().getCurrentCursor().equals(defaultDirection)) return;

            ds.getMouse().setCursor(ds, defaultDirection);
        }
        
    }
}
