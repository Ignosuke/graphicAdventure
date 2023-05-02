package collisions;

import java.awt.Rectangle;

public class CollisionZone {
    
    private boolean leftCollision, rightCollision;

    private final Rectangle leftArea, rightArea;
    
    public CollisionZone(final int wWidth, final int wHeight) {
        leftCollision = false;
        rightCollision = false;

        final int tenthProportionWidht = wWidth/10;

        leftArea = new Rectangle(0, 0, tenthProportionWidht, wHeight);
        rightArea = new Rectangle(wWidth - tenthProportionWidht, 0, tenthProportionWidht, wHeight);
    }

    public void update(final Rectangle mouseArea) {
        leftCollision = (mouseArea.intersects(leftArea)) ? true : false;
        rightCollision = (mouseArea.intersects(rightArea)) ? true : false;
    }

    public boolean isLeftCollision() {
        return leftCollision;
    }

    public boolean isRightCollision() {
        return rightCollision;
    }

    public Rectangle getLeftArea() {
        return leftArea;
    }

    public Rectangle getRightArea() {
        return rightArea;
    }
}
