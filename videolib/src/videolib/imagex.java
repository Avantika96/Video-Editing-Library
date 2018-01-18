/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class imagex {
    public static BufferedImage textWatermark(BufferedImage i,String text){
        Graphics2D g2d = (Graphics2D) i.getGraphics();
 
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
        g2d.setComposite(alphaChannel);
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Arial", Font.BOLD, 72));
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);
 
        int centerX = (i.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = i.getHeight() / 2;

        g2d.drawString(text, centerX, centerY);
        return i;
    }
    
    public static BufferedImage imgWatermark(BufferedImage i,BufferedImage w){

        Graphics2D g2d = (Graphics2D) i.getGraphics(); 
        AlphaComposite alphaChannel = AlphaComposite.getInstance( AlphaComposite.SRC_OVER, 0.3f); 
        g2d.setComposite(alphaChannel); 

        int topLeftX = (i.getWidth() - w.getWidth()) / 2; 
        int topLeftY = (i.getHeight() - w .getHeight()) / 2; 
        g2d.drawImage(w, topLeftX, topLeftY, null);
    
        return i;
    }
    
}
