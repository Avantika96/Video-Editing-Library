/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class color {
    public static BufferedImage darker(BufferedImage i,float factor){     
         if(factor!=0){
             factor=1/factor;
             for(int x=0;x<i.getWidth();x++){
                 for(int y=0 ; y<i.getHeight();y++){
                     int rgb = i.getRGB(x,y);
                     Color c=new Color(rgb);
                     int r = (int) Math.max(factor*c.getRed(),0);
                     int g=(int) Math.max(factor*c.getGreen(),0);
                     int b=(int) Math.max(factor*c.getBlue(),0);
                     c=new Color(r,g,b);                                        
                     i.setRGB(x,y,c.getRGB());
                 }
             }
             
        } 
         else {
             for(int x=0;x<i.getWidth();x++){
                 for(int y=0 ; y<i.getHeight();y++){
                     int rgb = i.getRGB(x,y);
                     Color c=new Color(rgb);
                     c=c.darker();
                     int r = c.getRed();
                     int g=c.getGreen();
                     int b=c.getBlue();
                     c=new Color(r,g,b);
                     i.setRGB(x,y,c.getRGB());
                 }
             }
         }
           
     return i;   
  
    }
    
    public static BufferedImage inverse(BufferedImage i){
         int r,g,b,y,x;       
        for(x=0;x<i.getWidth();x++){        
            for( y=0 ; y<i.getHeight();y++){
                int rgb = i.getRGB(x,y);
                Color c = new Color(rgb,true);
                r=255-c.getRed();
                g=255-c.getGreen();
                b=255-c.getBlue();
                c = new Color(r,g,b);                
                i.setRGB(x,y,c.getRGB());
            }
        }
        return i;    
    }
    
    public static BufferedImage blackWhite(BufferedImage i){
        
       
        int w=new Color(255,255,255).getRGB();//-1
         
        int bl=new Color(0,0,0).getRGB();//-16777216
       
        
        for(int x=0;x<i.getWidth();x++){        
            for(int y=0 ; y<i.getHeight();y++){
                int rgb = i.getRGB(x,y);
                if(rgb>(bl/2))
                    rgb=w;
                                
                else
                    rgb=bl;
                
                i.setRGB(x,y,rgb);
            }
        }
     return i;   
    }
    
    public static BufferedImage contrast(BufferedImage i){
        float scaleFactor=2.6f;
         RescaleOp rescale = new RescaleOp(scaleFactor,20.0f, null);
         i=rescale.filter(i,null);
         
        return i;    
    }
    
    public static BufferedImage edgeDetect(BufferedImage i){
         int xPos, yPos,red,green,blue;
                int wid = i.getWidth();
                int hgt = i.getHeight();
                int type=i.getType();
                BufferedImage result=new BufferedImage(wid-1,hgt-1,type);

                for (  xPos = 0 ; xPos < wid-1 ; ++xPos )
                {
                  for ( yPos = 0 ; yPos < hgt-1 ; ++yPos )
                  {
                    int rgb = i.getRGB(xPos,yPos);
                    Color c = new Color(rgb,true);
                    int rgb1 = i.getRGB(xPos+1,yPos);
                    Color c1 = new Color(rgb,true);
                    int rgb2 = i.getRGB(xPos,yPos+1);
                    Color c2 = new Color(rgb,true);


                    int rgb4 = result.getRGB(xPos,yPos);
                    Color c4;

                    if ( Math.abs(rgb-rgb1)<30 && Math.abs(rgb-rgb2)<30 )
                    {
                      c4 = Color.WHITE;
                    }
                    else
                    {
                      c4 = Color.BLACK;
                    }

                    result.setRGB(xPos,yPos,c4.getRGB());
                  }
                }
         
        return result;    
    }
    
    public static BufferedImage gamma(BufferedImage img,double red, double green, double blue){
            int width = img.getWidth();
            int height = img.getHeight();
            int A, R, G, B;
            int pixel;
            final int    MAX_SIZE = 256;
            final double MAX_VALUE_DBL = 255.0;
            final int    MAX_VALUE_INT = 255;
            final double REVERSE = 1.0;
            int[] gammaR = new int[MAX_SIZE];
            int[] gammaG = new int[MAX_SIZE];
            int[] gammaB = new int[MAX_SIZE];

            // setting values for every gamma channels
            for(int i = 0; i < MAX_SIZE; ++i) {
                gammaR[i] = (int)Math.min(MAX_VALUE_INT,
                        (int)((MAX_VALUE_DBL * Math.pow(i / MAX_VALUE_DBL, REVERSE / red)) + 0.5));
                gammaG[i] = (int)Math.min(MAX_VALUE_INT,
                        (int)((MAX_VALUE_DBL * Math.pow(i / MAX_VALUE_DBL, REVERSE / green)) + 0.5));
                gammaB[i] = (int)Math.min(MAX_VALUE_INT,
                        (int)((MAX_VALUE_DBL * Math.pow(i / MAX_VALUE_DBL, REVERSE / blue)) + 0.5));
            }

            for(int x = 0; x < width; ++x) {
                for(int y = 0; y < height; ++y) {
                    int rgb = img.getRGB(x, y);
                    Color c = new Color(rgb,true);
                    R = gammaR[c.getRed()];
                    G = gammaG[c.getGreen()];
                    B = gammaB[c.getBlue()];
                    c = new Color(R,G,B);                
                    img.setRGB(x,y,c.getRGB());
                }
            }
 
        return img;    
    }
    
    public static BufferedImage hue(BufferedImage i){
         int xPos, yPos,red,green,blue;

         int wid = i.getWidth();
         int hgt = i.getHeight();
   

            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                   float[] hsbVals = new float[3];
                    Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsbVals);

                    c = new Color(Color.HSBtoRGB(0.5f, hsbVals[1], hsbVals[2]));

                i.setRGB(xPos,yPos,c.getRGB());
              }
            }

                return i;    
    }
    
    public static BufferedImage sepia(BufferedImage i){
         int r,g,b,y,x;       
        for(x=0;x<i.getWidth();x++){        
            for( y=0 ; y<i.getHeight();y++){
                int rgb = i.getRGB(x,y);
                Color c = new Color(rgb,true);
                r=c.getRed();
                g=c.getGreen();
                b=c.getBlue();
                double red,green,blue;
                red=r*0.393+g*0.769+b*0.189;
                red=Math.ceil(red);
                int re=(int)red;
                if(re>255)
                {re=255;}
                green=r*0.349+g*0.686+b*0.168;
                green=Math.ceil(green);
                int gr=(int)green;
                if(gr>255)
                {gr=255;}
                blue=r*0.272+g*0.534+b*0.131;
                blue=Math.ceil(blue);
                int bl=(int)blue;
                if(bl>255)
                {bl=255;}
                c = new Color(re,gr,bl);                
                i.setRGB(x,y,c.getRGB());
            }
        }
        return i;    
    }
    
    public static BufferedImage sunset(BufferedImage i){
         int xPos, yPos,red,green,blue;

         int wid = i.getWidth();
         int hgt = i.getHeight();
   
 
            for (  xPos = 0 ; xPos < wid ; ++xPos )
            {

              for ( yPos = 0 ; yPos < hgt ; ++yPos )
              {

                  int rgb = i.getRGB(xPos,yPos);
                  Color c = new Color(rgb,true);
                  red=c.getRed();
                  green=c.getGreen();
                  blue=c.getBlue();
                  green=green/2;
                  blue=blue/2;

                c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }
            }

                return i;    
    }
    
     public static BufferedImage temperature(BufferedImage i, int temp){
         int r,g,b,y,x,j,m;
         double red1,green1,blue1;
         int[][] kelvin_temp= new int[][]{
             {1000,255,56,0},
             {2000,255,137,18},
             {3000,255,180,107},
             {4000,255,209,163},
             {5000,255,228,206},
             {6000,255,243,239},
             {7000,245,243,255},
             {8000,227,233,255},
             {9000,214,225,255},
             {10000,204,219,255},
             {11000,196,215,255},
             {12000,191,211,255},
             {13000,186,208,255},
             {14000,182,206,255},
             {15000,179,204,255},
             {16000,176,202,255},
             {17000,174,200,255},
             {18000,172,199,255},
             {19000,170,198,255},
             {20000,168,197,255},
             {21000,167,196,255},
             {22000,166,195,255},
             {23000,164,194,255},
             {24000,163,194,255},
             {25000,163,193,255},
             {26000,162,192,255},
             {27000,161,192,255},
             {28000,160,191,255},
             {29000,160,191,255},
             {30000,159,191,255}   
         };
        for (j=0;j<30;j++){
            if(kelvin_temp[j][0]==temp)
                break;
        }
        red1=(kelvin_temp[j][1]/255);
        green1=(kelvin_temp[j][2]/255);
        blue1=(kelvin_temp[j][3]/255);
        for(x=0;x<i.getWidth();x++){        
            for( y=0 ; y<i.getHeight();y++){
                int rgb = i.getRGB(x,y);
                Color c = new Color(rgb,true);
                r=c.getRed();
                g=c.getGreen();
                b=c.getBlue();
                double red,green,blue;
                red=r*red1+g*0+b*0;
                red=Math.ceil(red);
                int re=(int)red;
                if(re>255)
                {re=255;}
                green=r*0+g*green1+b*0;
                green=Math.ceil(green);
                int gr=(int)green;
                if(gr>255)
                {gr=255;}
                blue=r*0+g*0+b*blue1;
                blue=Math.ceil(blue);
                int bl=(int)blue;
                if(bl>255)
                {bl=255;}
                c = new Color(re,gr,bl);                
                i.setRGB(x,y,c.getRGB());
            }
        }
        return i;    
    }
     
    public static BufferedImage solar(BufferedImage i,float threshhold,boolean j,boolean k,boolean l){
       for(int x=0;x<i.getWidth();x++){        
            for(int y=0 ; y<i.getHeight();y++){
                int rgb=i.getRGB(x, y);
                Color c= new Color(rgb);
                int r=c.getRed();
                int g=c.getGreen();
                int b=c.getBlue();
                if(j)
                    r=(r<=threshhold)? r: 255-r;
                if(k)
                    g=(g<=threshhold)? g: 255-g;
                if(l)
                    b=(b<=threshhold)? b: 255-b;
                i.setRGB(x, y, new Color(r,g,b).getRGB());
                
            }
       }
   return i;
   
   }
    
    public static BufferedImage grey(BufferedImage i){
        BufferedImage gray = new BufferedImage(i.getWidth(),i.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
       
        Graphics2D g = gray.createGraphics();
        g.drawImage(i, null, 0, 0);
        
        return gray;
    }
    
    public static BufferedImage brightness(BufferedImage i,float brightenFactor){
        RescaleOp op = new RescaleOp(brightenFactor, 0, null);
        i = op.filter(i, i);   
        return i; 
   
    }
    
}
