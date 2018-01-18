/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class screenshot {
    public void screenshotEffect(int time,String vid, String path) throws FrameGrabber.Exception, FrameRecorder.Exception, IOException{
            FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(vid);
            frameGrabber.start();
        
            Java2DFrameConverter paintConverter = new Java2DFrameConverter();
            double fps= frameGrabber.getFrameRate();
            int f=(int)fps*time;
            for(int j=0;j<frameGrabber.getLengthInFrames();j++)
            {
             Frame frame = frameGrabber.grabImage();
             BufferedImage img =paintConverter.convert(frame);
             if(j==f){
            ImageIO.write(img,"png", new File(path));
             }
            }
            frameGrabber.stop();
    }
    
}
