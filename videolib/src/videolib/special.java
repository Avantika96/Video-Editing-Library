/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class special {
    public static BufferedImage waveX(BufferedImage i){
        int x_out,y_out,dx,dy;
        
        double n1 =(2*PI)/128;  //y       
        BufferedImage w= new BufferedImage(i.getWidth(),i.getHeight(),i.getType());        
        for(int x=0;x<i.getWidth()-50;x++){        
            for(int y=0 ; y<i.getHeight()-1;y++){
                y_out=y;
                x_out=(int) (x+20*sin(n1*y));//x+dx                
                int rgb=i.getRGB(x, y);                
                if(x_out<0)
                    x_out=0;                
                if(x>=i.getWidth())
                    x=i.getWidth()-1;                
                if(y_out<0)
                    y=0;                
                if(y_out>=i.getHeight())
                    y=i.getHeight()-1; 
                
                w.setRGB(x_out, y_out, rgb);             
            }
        }    
        return w;
        
    } 
    
    public static BufferedImage waveY(BufferedImage i){
        int x_out,y_out,dx,dy;        
        double n1 =(2*PI)/128;      
        BufferedImage w= new BufferedImage(i.getWidth(),i.getHeight(),i.getType());        
    
        for(int x=0;x<i.getWidth();x++){        
            for(int y=0 ; y<i.getHeight();y++){
                x_out=x;
                y_out=(int)(y+20*sin(n1*x));                
                int rgb=i.getRGB(x, y);                
                if(x_out<=0)
                    x_out=0;                
                if(x_out>=i.getWidth())
                    x_out=i.getWidth()-1;                
                if(y_out<=0)
                    y_out=0;                
                if(y_out>=i.getHeight())
                    y_out=i.getHeight()-1;
                
                w.setRGB(x_out, y_out, rgb);   
                
                                       
            }
        }    
        return w;
    }  
    
    public static BufferedImage parabolize(BufferedImage i){
        BufferedImage out= new BufferedImage(i.getWidth(),i.getHeight(),i.getType());
        for(int x=0;x<i.getWidth();x++){
            for(int y=0;y<i.getHeight();y++){
                int rgb = i.getRGB(x, y);
                Color c=new Color(rgb);
                int r=c.getRed();
                int g=c.getGreen();
                int b=c.getBlue();
                r=(int) (255*pow(1-(r/128),2));
                g=(int) (255*pow(1-(g/128),2));
                b=(int) (255*pow(1-(b/128),2));
                c= new Color(r,g,b);
                out.setRGB(x, y, c.getRGB());
            }
        
        }
        
        return out;
    }
    
    public static BufferedImage parabolizeInv(BufferedImage i){
        BufferedImage out= new BufferedImage(i.getWidth(),i.getHeight(),i.getType());
        for(int x=0;x<i.getWidth();x++){
            for(int y=0;y<i.getHeight();y++){
                int rgb = i.getRGB(x, y);
                Color c=new Color(rgb);
                int r=c.getRed();
                int g=c.getGreen();
                int b=c.getBlue();
                r=(int) (255-(255*pow(1-(r/128),2)));
                g=(int) (255-(255*pow(1-(g/128),2)));
                b=(int) (255-(255*pow(1-(b/128),2)));
                c= new Color(r,g,b);
                out.setRGB(x, y, c.getRGB());
            }
        
        }
        
        return out;
    }
    
    public static BufferedImage posterization(BufferedImage i){
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
                int grayAmount;
                grayAmount = (int)Math.round((red * 0.299) + (green * 0.587) + (blue * 0.114)) ;

               if ( grayAmount < 64 )
                {
                  red = 0;
                  green = 0;
                  blue = 255;
                }
                else if ( grayAmount < 128 )
                {
                  red = 255;
                  green = 0;
                  blue = 255;
                }
                else if ( grayAmount < 192 )
                {
                  red = 0;
                  green = 255;
                  blue = 0;
                }
                else 
                {
                  red = 255;
                  green = 255;
                  blue = 0;
                }

               c = new Color(red,green,blue);                
                i.setRGB(xPos,yPos,c.getRGB());
              }
            }
         
        return i;    
    }
    
     public static BufferedImage blink(BufferedImage i){
     
        int r,g,b,y,x;       
        for(x=0;x<i.getWidth();x++){        
            for( y=0 ; y<i.getHeight();y++)
            {
                int rgb = i.getRGB(x,y);
                Color c = new Color(rgb,true);
                r=0;
                g=0;
                b=0;
                c = new Color(r,g,b);                
                i.setRGB(x,y,c.getRGB());
            }
        }
        return i;
    }
     
     public static BufferedImage blur(BufferedImage i){
        int radius = 11;
        int size = radius * 2 + 1;
        float weight = 1.0f / (size * size);
        float[] data = new float[size * size];
    
        for (int j = 0; j < data.length; j++) 
        {
            data[j] = weight;
        }
        Kernel kernel = new Kernel(size, size, data);
        BufferedImageOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_ZERO_FILL, null);
        BufferedImage blur= op.filter(i,null);
        
        return blur;
    }
     
    public static BufferedImage swirl(BufferedImage i){
        int width  = i.getWidth();
        int height = i.getHeight();
        double x0 = 0.5 * (width  - 1);
        double y0 = 0.5 * (height - 1);

        BufferedImage sw=new BufferedImage(width,height,i.getType());

        for (int sx = 0; sx < width; sx++) {
            for (int sy = 0; sy < height; sy++) {
                double dx = sx - x0;
                double dy = sy - y0;
                double r = Math.sqrt(dx*dx + dy*dy);
                double angle = Math.PI / 256 * r;
                int tx = (int) (+dx * Math.cos(angle) - dy * Math.sin(angle) + x0);
                int ty = (int) (+dx * Math.sin(angle) + dy * Math.cos(angle) + y0);

                if (tx >= 0 && tx < width && ty >= 0 && ty < height)
                    sw.setRGB(sx, sy, new Color(i.getRGB(tx, ty)).getRGB());
            }
        }

       return sw;
    }
    
    public static BufferedImage glass(BufferedImage i,float parameter){
        int x2,y2;   
              
        BufferedImage w= new BufferedImage(i.getWidth(),i.getHeight(),i.getType());        
        for(int x=0;x<i.getWidth();x++){        
            for(int y=0 ; y<i.getHeight();y++){                 
                double rand1=Math.random();
                double rand2=Math.random();
                y2=(int)(y + (rand1 - 0.5) * parameter);
                x2=(int)(x + (rand1 - 0.5) * parameter);
                if(x2<0)
                    x2=0;
                if(x2>=i.getWidth())
                    x2=i.getWidth()-1;
                if(y2<0)
                    y2=0;
                if(y2>=i.getHeight())
                    y2=i.getHeight()-1;
                
                int rgb=i.getRGB(x2, y2);
                w.setRGB(x, y, rgb);                              
                
            }
        }             
        return w;
    }
    
}
