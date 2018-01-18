/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class fade {
     public static BufferedImage fade(BufferedImage i, double per){
         int xPos, yPos;
         int red,green,blue;
         long k=0;
         int wid = i.getWidth();
         int hgt = i.getHeight();
            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  k=k+1;
                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(per!=0)
                  {
                      red=(int)(red-(0.01*per*red));
                      green=(int)(green-(0.01*per*green));
                      blue=(int)(blue-(0.01*per*blue));
                  }

               c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }
            }
         
        return i;    
      }
     
     
    public static BufferedImage fadeX(BufferedImage i, double per){
         int xPos, yPos;
         int red,green,blue;
         long k=0;
         int wid = i.getWidth();
         int hgt = i.getHeight();
            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {
              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {
                  k=k+1;
                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(per!=0)
                  {
                      if(k%per==0){
                        red=0;
                        green=0;
                        blue=0;
                      }
                  }

               c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }
            }
         
        return i;    
      }
    
}
