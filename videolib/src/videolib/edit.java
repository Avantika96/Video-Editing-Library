/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

/**
 *
 * @author AVANTIKA GUPTA
 */
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core;
import static org.bytedeco.javacpp.opencv_core.CV_8UC3;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;


public class edit {
    
    public FFmpegFrameGrabber frameGrabber;
    public FFmpegFrameGrabber frameGrabberAud;
    public FFmpegFrameRecorder recorder;
    Java2DFrameConverter paintConverter=new Java2DFrameConverter();
    
    public void slideInVerEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=this.frameGrabber.getLengthInFrames()-102;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+0.5;
                   img=slide.slideInVer(img, per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void slideOutVerEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=this.frameGrabber.getLengthInFrames()-102;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+0.5;
                   img=slide.slideOutVer(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void slideDownEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=this.frameGrabber.getLengthInFrames()-102;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+1;
                   img=slide.slideDown(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void slideUpEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=this.frameGrabber.getLengthInFrames()-102;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+1;
                   img=slide.slideUp(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void slideLeftEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=this.frameGrabber.getLengthInFrames()-102;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+1;
                   img=slide.slideLeft(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void slideRightEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=this.frameGrabber.getLengthInFrames()-102;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+1;
                   img=slide.slideRight(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void slideInHorEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=this.frameGrabber.getLengthInFrames()-102;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+0.5;
                   img=slide.slideInHor(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void slideOutHorEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=this.frameGrabber.getLengthInFrames()-102;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+0.5;
                   img=slide.slideOutHor(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
        
    public void fadeInEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=100;
        double per=101;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j<time && frame!=null){
                   per=per-1;
                   img=fade.fade(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void fadeOutEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=frameGrabber.getLengthInFrames()-100;
        double per=0;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per+1;
                   img=fade.fade(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void fadeXEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        int time=frameGrabber.getLengthInFrames()-100;
        double per=101;
        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j>=time && frame!=null){
                   per=per-1;
                   img=fade.fadeX(img,per);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void waveXEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                   img=special.waveX(img); 
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void waveYEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=special.waveY(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void parabolizeEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=special.parabolize(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void parabolizeInvEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=special.parabolizeInv(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void posterizationEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=special.posterization(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void mirrorXEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=mirror.mirrorX(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void mirrorYEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=mirror.mirrorY(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void darkerEffect(float factor) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.darker(img,factor);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void inverseEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.inverse(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void blackWhiteEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.blackWhite(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void contrastEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.contrast(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void edgeDetectEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.edgeDetect(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void gammaEffect(double red,double green,double blue) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.gamma(img,red,green,blue);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void hueEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.hue(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void sepiaEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.sepia(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void sunsetEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.sunset(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void temperatureEffect(int temp) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.temperature(img,temp);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void solarizeEffect(float threshold,boolean m, boolean k, boolean l) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.solar(img,threshold,m,k,l);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void greyEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.grey(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void brightnessEffect(float factor) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=color.brightness(img, factor);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void blinkEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(j%20==0 && frame!=null)
                {
                img=special.blink(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void blurEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=special.blur(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void swirlEffect() throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=special.swirl(img);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void glassEffect(float factor) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=special.glass(img, factor);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    
    public void freezeEffect(int freeze_sec,int freeze_for) throws FrameGrabber.Exception, FrameRecorder.Exception{
        Frame frameAud;
        for(int ii=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;ii++)
            {
                Frame frame = frameGrabber.grabImage();
                BufferedImage i = paintConverter.convert(frame);
                if(ii==((int)(frameGrabber.getFrameRate())*freeze_sec))
                {
               for(int t=0;t<(freeze_for*(int)(frameGrabber.getFrameRate()));t++)
                    {

                     frame = paintConverter.getFrame(i);
                     recorder.record(frame);
                    }
                }
                else
                {
                    frame = paintConverter.getFrame(i);
                    recorder.record(frame);
                    this.recorder.record(frameAud);
                }
            }
        close();
    }
    
    public void resizeEffect(double height,double width) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=motion.resize(img,height,width);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void rotateEffect(double angle) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=motion.rotate(img, angle);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void clipEffect(double start,double endd) throws FrameGrabber.Exception, FrameRecorder.Exception{
        int fps=(int)frameGrabber.getFrameRate();
        int st=(int)start*fps;
        int end=(int)endd*fps;
        int j=0;
        Frame frameAud;
        for(;(frameAud=frameGrabberAud.grabFrame(true,false,false,false))!=null;){
           frameGrabber.setFrameNumber(j+1);
           if(j>st && j<end)
           {
               Frame frame = frameGrabber.grabImage();
                BufferedImage i = paintConverter.convert(frame);
                //i=sunset(i);
                frame = paintConverter.getFrame(i);
                if(frame!=null)
                {recorder.record(frame);
           
                recorder.record(frameAud);}
           }
           j++;
                
       }
        
        close();
    }
    
    public void cropEffect(int x, int y, int height, int width) throws FrameGrabber.Exception, FrameRecorder.Exception{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=motion.crop(img,x,y,width,height);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    
    public void imageWatermarkEffect(String path) throws FrameGrabber.Exception, FrameRecorder.Exception, IOException{

        Frame frameAud;
        BufferedImage imgage = ImageIO.read(new File(path));
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=imagex.imgWatermark(img, imgage);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    public void textWatermarkEffect(String text) throws FrameGrabber.Exception, FrameRecorder.Exception, IOException{

        Frame frameAud;
        for(int j=0;(frameAud=this.frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null)
                {
                    img=imagex.textWatermark(img,text);
                }
                frame = paintConverter.getFrame(img);
                this.recorder.record(frame);
                this.recorder.record(frameAud);
            }
        
        close();
        
    }
    
    
    public void reverseEffect() throws FrameRecorder.Exception, FrameGrabber.Exception{
        Stack<opencv_core.Mat> frameStack=new Stack<>();
        int length = frameGrabber.getLengthInFrames();
        BufferedImage j=null;
        for(int x=0;x<length;x++)
            {
                Frame frame = frameGrabber.grabImage();
                if(x==0)
                {
                j = paintConverter.convert(frame);
                BufferedImage imageCopy =new BufferedImage(j.getWidth(), j.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                imageCopy.getGraphics().drawImage(j, 0, 0, null);
                byte[] data = ((DataBufferByte) imageCopy.getRaster().getDataBuffer()).getData();  
                opencv_core.Mat img = new opencv_core.Mat(j.getHeight(),j.getWidth(),CV_8UC3);
                img.data().put(data);

                frameStack.push(img);
                }
                else
                {
                    BufferedImage i=paintConverter.convert(frame);
                    BufferedImage imageCopy =new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                    imageCopy.getGraphics().drawImage(i, 0, 0, null);
                    byte[] data = ((DataBufferByte) imageCopy.getRaster().getDataBuffer()).getData();  
                    opencv_core.Mat img = new opencv_core.Mat(i.getHeight(),i.getWidth(),CV_8UC3);
                    img.data().put(data);       
                    frameStack.push(img);
                
                }
            }
             while(!frameStack.isEmpty())
                {

                    opencv_core.Mat mat_frame=frameStack.pop();
                    int width = mat_frame.cols(), height = mat_frame.rows(), channels = mat_frame.channels() ;  
                    byte[] sourcePixels = new byte[width * height * channels];  
                    mat_frame.data().get(sourcePixels);    
                    BufferedImage image = new BufferedImage(width, height,j.getType());  
                    final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();  
                    System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);  
                    Frame frame = paintConverter.getFrame(image);
                    recorder.record(frame);

                }
             recorder.stop();
             frameGrabber.stop();
    }
    
    
    public void timeMirrorEffect() throws FrameRecorder.Exception, FrameGrabber.Exception{
        Stack<opencv_core.Mat> frameStack=new Stack<>();
        int length = frameGrabber.getLengthInFrames();
        BufferedImage j=null;
        for(int x=0;x<length;x++)
            {
                Frame frame = frameGrabber.grabImage();
                if(x==0)
                {
                j = paintConverter.convert(frame);
                recorder.record(frame);
                BufferedImage imageCopy =new BufferedImage(j.getWidth(), j.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                imageCopy.getGraphics().drawImage(j, 0, 0, null);
                byte[] data = ((DataBufferByte) imageCopy.getRaster().getDataBuffer()).getData();  
                opencv_core.Mat img = new opencv_core.Mat(j.getHeight(),j.getWidth(),CV_8UC3);
                img.data().put(data);

                frameStack.push(img);
                }
                else
                {
                    recorder.record(frame);
                    BufferedImage i=paintConverter.convert(frame);
                    BufferedImage imageCopy =new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                    imageCopy.getGraphics().drawImage(i, 0, 0, null);
                    byte[] data = ((DataBufferByte) imageCopy.getRaster().getDataBuffer()).getData();  
                    opencv_core.Mat img = new opencv_core.Mat(i.getHeight(),i.getWidth(),CV_8UC3);
                    img.data().put(data);       
                    frameStack.push(img);
                
                }
            }
            while(!frameStack.isEmpty())
            {

                opencv_core.Mat mat_frame=frameStack.pop();
                int width = mat_frame.cols(), height = mat_frame.rows(), channels = mat_frame.channels() ;  
                byte[] sourcePixels = new byte[width * height * channels];  
                mat_frame.data().get(sourcePixels);    
                BufferedImage image = new BufferedImage(width, height,j.getType());  
                final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();  
                System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);  
                Frame frame = paintConverter.getFrame(image);
                recorder.record(frame);

            }
            recorder.stop();
            frameGrabber.stop();
        
    }
    
    public void changeAudioEffect(String path) throws FrameGrabber.Exception, FrameRecorder.Exception{
        FFmpegFrameGrabber frameGrabAud=new FFmpegFrameGrabber(path);
        frameGrabAud.start();
        Frame frameAud;
        for(int j=0;(frameAud=frameGrabAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = this.frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                if(frame!=null){
                  frame = paintConverter.getFrame(img);
                    recorder.record(frame);
                    recorder.record(frameAud);
                }
            }
        
        close();
        
    }
    
    public edit(String src, String dst) throws FrameGrabber.Exception, FrameRecorder.Exception{
        this.frameGrabber = new FFmpegFrameGrabber(src);
        this.frameGrabber.start();
        this.frameGrabberAud = new FFmpegFrameGrabber(src);
        this.frameGrabberAud.start();
        this.recorder = new FFmpegFrameRecorder(dst, frameGrabber.getImageWidth(), frameGrabber.getImageHeight(), frameGrabber.getAudioChannels());
        this.recorder.setVideoCodec(frameGrabber.getVideoCodec());
        this.recorder.setVideoBitrate(frameGrabber.getVideoBitrate());
        this.recorder.setFrameRate(frameGrabber.getFrameRate());
        this.recorder.setFormat(frameGrabber.getFormat());
        this.recorder.setAspectRatio(frameGrabber.getAspectRatio());
        this.recorder.setAudioBitrate(frameGrabber.getAudioBitrate());
        this.recorder.setSampleRate(frameGrabber.getSampleRate());
        this.recorder.setAudioChannels(frameGrabber.getAudioChannels());
        this.recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
        this.recorder.start();
    }
    
    public void close() throws FrameGrabber.Exception, FrameRecorder.Exception
    {
        this.frameGrabber.stop();
        this.frameGrabberAud.stop();
        this.recorder.stop();
    }
    
}
