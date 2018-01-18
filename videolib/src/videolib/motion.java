/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class motion {
    public static BufferedImage resize(BufferedImage i,double newHeight, double newWidth){
       int w=i.getWidth();
       int h=i.getHeight();
       BufferedImage resized= new BufferedImage(w,h,i.getType());
       AffineTransform at = new AffineTransform();
       at.scale(newHeight, newWidth);
       AffineTransformOp scaleOp =  new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
       resized = scaleOp.filter(i,resized);
       return resized;
    }
    
    public static BufferedImage rotate(BufferedImage i,double angle){
     
            double rads = Math.toRadians(angle);
            double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
            int w = i.getWidth();
            int h = i.getHeight();
            int newWidth = (int) Math.floor(w * cos + h * sin);
            int newHeight = (int) Math.floor(h * cos + w * sin);

            BufferedImage rotated = new BufferedImage(newWidth, newHeight,i.getType());
            Graphics2D g2d = rotated.createGraphics();
            AffineTransform at = new AffineTransform();
            at.translate((newWidth - w) / 2, (newHeight - h) / 2);

            int x = w / 2;
            int y = h / 2;

            at.rotate(rads, x, y);
            g2d.setTransform(at);
            g2d.drawImage(i, 0, 0, null);
            
            g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
            g2d.dispose();

            return rotated;
    }
    
    public static BufferedImage crop(BufferedImage i,int x,int y,int w,int h){
         i=i.getSubimage(x,y,w,h);
        
        return i;    
    }
    
}
