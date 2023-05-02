package tools;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ImgsConverter {

    public static BufferedImage scalate(BufferedImage originalIMG, double x, double y) {
        int width = originalIMG.getWidth(), height = originalIMG.getHeight();

        BufferedImage scalatedIMG = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        AffineTransform transformer = new AffineTransform();
        transformer.scale(x, y);

        AffineTransformOp operation = new AffineTransformOp(transformer, AffineTransformOp.TYPE_BILINEAR);

        scalatedIMG = operation.filter(originalIMG, scalatedIMG);

        return scalatedIMG;
    }

    public static BufferedImage scalate(BufferedImage originalIMG, double x) {
        int width = originalIMG.getWidth(), height = originalIMG.getHeight();

        BufferedImage scalatedIMG = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        AffineTransform transformer = new AffineTransform();
        transformer.scale(x, x);

        AffineTransformOp operation = new AffineTransformOp(transformer, AffineTransformOp.TYPE_BILINEAR);

        scalatedIMG = operation.filter(originalIMG, scalatedIMG);

        return scalatedIMG;
    }
}
