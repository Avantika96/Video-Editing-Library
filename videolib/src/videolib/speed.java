/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class speed {
    
    public void accelerateEffect(String src, String dst,float rate) throws FrameGrabber.Exception, FrameRecorder.Exception{
        FFmpegFrameGrabber frameGrabber;
        FFmpegFrameGrabber frameGrabberAud;
        FFmpegFrameRecorder recorder;
        Java2DFrameConverter paintConverter=new Java2DFrameConverter();
        frameGrabber = new FFmpegFrameGrabber(src);
        frameGrabber.start();
        frameGrabberAud = new FFmpegFrameGrabber(src);
        frameGrabberAud.start();
        recorder = new FFmpegFrameRecorder(dst, frameGrabber.getImageWidth(), frameGrabber.getImageHeight(), frameGrabber.getAudioChannels());
        recorder.setVideoCodec(frameGrabber.getVideoCodec());
        recorder.setVideoBitrate(frameGrabber.getVideoBitrate());
        recorder.setFrameRate(rate*frameGrabber.getFrameRate());
        recorder.setFormat(frameGrabber.getFormat());
        recorder.setAspectRatio(frameGrabber.getAspectRatio());
        recorder.setAudioBitrate(frameGrabber.getAudioBitrate());
        recorder.setSampleRate(frameGrabber.getSampleRate());
        recorder.setAudioChannels(frameGrabber.getAudioChannels());
        recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
        recorder.start();
        Frame frameAud;
        for(int j=0;(frameAud=frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                frame = paintConverter.getFrame(img);
                if(frame!=null){
                    recorder.record(frame);
                    recorder.record(frameAud);
                }
            }
        frameGrabber.stop();
        frameGrabberAud.stop();
        recorder.stop();
        
    }
    
    public void deaccelerateEffect(String src, String dst,float rate) throws FrameGrabber.Exception, FrameRecorder.Exception{
        FFmpegFrameGrabber frameGrabber;
        FFmpegFrameGrabber frameGrabberAud;
        FFmpegFrameRecorder recorder;
        Java2DFrameConverter paintConverter=new Java2DFrameConverter();
        frameGrabber = new FFmpegFrameGrabber(src);
        frameGrabber.start();
        frameGrabberAud = new FFmpegFrameGrabber(src);
        frameGrabberAud.start();
        recorder = new FFmpegFrameRecorder(dst, frameGrabber.getImageWidth(), frameGrabber.getImageHeight(), frameGrabber.getAudioChannels());
        recorder.setVideoCodec(frameGrabber.getVideoCodec());
        recorder.setVideoBitrate(frameGrabber.getVideoBitrate());
        recorder.setFrameRate(rate*frameGrabber.getFrameRate());
        recorder.setFormat(frameGrabber.getFormat());
        recorder.setAspectRatio(frameGrabber.getAspectRatio());
        recorder.setAudioBitrate(frameGrabber.getAudioBitrate());
        recorder.setSampleRate(frameGrabber.getSampleRate());
        recorder.setAudioChannels(frameGrabber.getAudioChannels());
        recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
        recorder.start();
        Frame frameAud;
        for(int j=0;(frameAud=frameGrabberAud.grabFrame(true, false, false, false))!=null;j++)
            {
                Frame frame = frameGrabber.grabImage();
                BufferedImage img = paintConverter.convert(frame);
                frame = paintConverter.getFrame(img);
                if(frame!=null){
                    recorder.record(frame);
                    recorder.record(frameAud);
                }

            }
        frameGrabber.stop();
        frameGrabberAud.stop();
        recorder.stop();
        
    }
    
    public void loopEffect(String input, String output,int times) throws FrameGrabber.Exception, FrameRecorder.Exception, IOException{
        Java2DFrameConverter paintConverter=new Java2DFrameConverter();
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(output,640,360,2);
        recorder.start();
        for(int t=0;t<times;t++)
        {
            FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(input);
            FFmpegFrameGrabber frameGrabberAud = new FFmpegFrameGrabber(input);
                frameGrabber.start();
                frameGrabberAud.start();
        if(t==0){
        recorder.setVideoCodec(frameGrabber.getVideoCodec());
        recorder.setVideoBitrate(frameGrabber.getVideoBitrate());
        recorder.setFrameRate(frameGrabber.getFrameRate());
        recorder.setFormat(frameGrabber.getFormat());
        recorder.setAspectRatio(frameGrabber.getAspectRatio());
        recorder.setAudioBitrate(frameGrabber.getAudioBitrate());
        recorder.setSampleRate(frameGrabber.getSampleRate());
        recorder.setAudioChannels(frameGrabber.getAudioChannels());
        recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
        recorder.setPixelFormat(frameGrabber.getPixelFormat());
        recorder.setVideoQuality(0);
        } 
       
            int length = frameGrabber.getLengthInFrames();
            Frame frameAud;
            for(int ii=0;(frameAud=frameGrabberAud.grabFrame(true, false, false, false))!=null;ii++)
                {
                    Frame frame = frameGrabber.grabImage();
                    BufferedImage i = paintConverter.convert(frame);
                    frame = paintConverter.getFrame(i);
                    if(frame!=null){
                         recorder.record(frame);
                         recorder.record(frameAud);
                    }

                }
                  frameGrabber.stop();
                  frameGrabberAud.stop();
        }
              
        recorder.stop();
    }
    
}
