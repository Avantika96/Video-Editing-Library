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
public class slide {
     public static BufferedImage slideDown(BufferedImage i, double per){
         int xPos, yPos;
         int red,green,blue;
         int hgt_per_end=Integer.MAX_VALUE;

         int wid = i.getWidth();
         int hgt = i.getHeight();
         if(per>0)
         {
             hgt_per_end=(int)(hgt-((per/100)*hgt)); 
         }
         
        for (  xPos = 0 ; xPos < wid ; ++xPos )
        {
            for ( yPos = 0 ; yPos < hgt ; ++yPos )
            {
                int rgb = i.getRGB(xPos,yPos);
                Color c = new Color(rgb,true);
                red=c.getRed();
                green=c.getGreen();
                blue=c.getBlue();
                if(yPos>=hgt_per_end)
                {
                    red=0;
                    green=0;
                    blue=0;
                }

              c = new Color(red,green,blue);                
              i.setRGB(xPos,yPos,c.getRGB());
            }
        
        }
         
        return i;    
     }
     
     
      public static BufferedImage slideInVer(BufferedImage i, double per){
         int xPos, yPos;
         int red,green,blue;

         int wid = i.getWidth();
         int hgt = i.getHeight();
         int hgt_per_start=(int)((per/100)*hgt);
         int hgt_per_end=(int)(hgt-((per/100)*hgt));

            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(yPos<=hgt_per_start || yPos>=hgt_per_end)
                  {
                      red=0;
                      green=0;
                      blue=0;
                  }

                  c = new Color(red,green,blue);                
                  i.setRGB(xPos,yPos,c.getRGB());
              }
            }
         
         return i;    
      }
      
      
       public static BufferedImage slideLeft(BufferedImage i, double per){
         int xPos, yPos;
         int red,green,blue;
         int wid_per_end=Integer.MAX_VALUE;

         int wid = i.getWidth();
         int hgt = i.getHeight();
         if(per>0)
         {
             wid_per_end=(int)(wid-((per/100)*wid)); 
         }
         

            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(xPos>=wid_per_end)
                  {
                      red=0;
                      green=0;
                      blue=0;
                  }

                c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }

            }
         
        return i;    
      }
       
       
      public static BufferedImage slideOutVer(BufferedImage i, double per){
        int xPos, yPos;
         int red,green,blue;
         int hgt_per_start,hgt_per_end;

         int wid = i.getWidth();
         int hgt = i.getHeight();
         if(per>0)
         {
            hgt_per_start=(int)((hgt/2)-((per/100)*hgt));
            hgt_per_end=(int)((hgt/2)+((per/100)*hgt)); 
         }
         else
         {
             hgt_per_start=Integer.MAX_VALUE;
             hgt_per_end=Integer.MIN_VALUE;
         }
         
     
            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(yPos>=hgt_per_start && yPos<=hgt_per_end)
                  {
                      red=0;
                      green=0;
                      blue=0;
                  }

                c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }

            }
         
        return i;    
      }
      
      public static BufferedImage slideRight(BufferedImage i, double per){
        int xPos, yPos;
         int red,green,blue;
         int wid_per_start=0;

         int wid = i.getWidth();
         int hgt = i.getHeight();
         if(per>0)
         {
           wid_per_start=(int)((per/100)*wid);
         }

         
  
            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(xPos<=wid_per_start)
                  {
                      red=0;
                      green=0;
                      blue=0;
                  }

                c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }

            }
         
        return i;    
      }
      
      
      public static BufferedImage slideUp(BufferedImage i, double per){
        int xPos, yPos;
         int red,green,blue;
         int hgt_per_start=0;

         int wid = i.getWidth();
         int hgt = i.getHeight();
         if(per>0)
         {
           hgt_per_start=(int)((per/100)*hgt);
         }

         
    
            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(yPos<=hgt_per_start)
                  {
                      red=0;
                      green=0;
                      blue=0;
                  }

               c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }

            }
         
        return i;    
      }
      
      
      public static BufferedImage slideInHor(BufferedImage i, double per){
         int xPos, yPos;
         int red,green,blue;

         int wid = i.getWidth();
         int hgt = i.getHeight();
         int wid_per_start=(int)((per/100)*wid);
         int wid_per_end=(int)(wid-((per/100)*wid));
     
            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(xPos<=wid_per_start || xPos>=wid_per_end)
                  {
                      red=0;
                      green=0;
                      blue=0;
                  }

               c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }
            }
         
        return i;    
      }
      
      
      public static BufferedImage slideOutHor(BufferedImage i, double per){
        int xPos, yPos;
         int red,green,blue;
         int wid_per_start,wid_per_end;

         int wid = i.getWidth();
         int hgt = i.getHeight();
         if(per>0)
         {
            wid_per_start=(int)((wid/2)-((per/100)*wid));
            wid_per_end=(int)((wid/2)+((per/100)*wid)); 
         }
         else
         {
             wid_per_start=Integer.MAX_VALUE;
             wid_per_end=Integer.MIN_VALUE;
         }
         
 
            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  if(xPos>=wid_per_start && xPos<=wid_per_end)
                  {
                      red=0;
                      green=0;
                      blue=0;
                  }

               c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }

            }
         
        return i;    
      }
      
}
