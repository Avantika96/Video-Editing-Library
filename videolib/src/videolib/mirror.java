/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class mirror {
    public static BufferedImage mirrorX(BufferedImage i){
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-i.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        BufferedImage mirrory= op.filter(i,null);

        return mirrory;
    }
    

    public static BufferedImage mirrorY(BufferedImage i){
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -i.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

        BufferedImage mirrorx= op.filter(i,null);

           return mirrorx;
    }

}