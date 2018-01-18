/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.image.BufferedImage;
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
public class mashup {
    public void concatenate(String video1, String video2, String output) throws FrameGrabber.Exception, FrameRecorder.Exception{
        Java2DFrameConverter paintConverter=new Java2DFrameConverter();
        FFmpegFrameGrabber frameGrabber1 = new FFmpegFrameGrabber(video1);
        FFmpegFrameGrabber frameGrabber2 = new FFmpegFrameGrabber(video2);
        FFmpegFrameGrabber frameGrabber1Aud = new FFmpegFrameGrabber(video1);
        FFmpegFrameGrabber frameGrabber2Aud = new FFmpegFrameGrabber(video2);
        frameGrabber1.start();
        frameGrabber1Aud.start();
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(output, frameGrabber1.getImageWidth(), frameGrabber1.getImageHeight(), frameGrabber1.getAudioChannels());
        recorder.setVideoCodec(frameGrabber1.getVideoCodec());
        recorder.setVideoBitrate(frameGrabber1.getVideoBitrate());
        recorder.setFrameRate(frameGrabber1.getFrameRate());
        recorder.setFormat(frameGrabber1.getFormat());
        recorder.setAspectRatio(frameGrabber1.getAspectRatio());
        recorder.setAudioBitrate(frameGrabber1.getAudioBitrate());
        recorder.setSampleRate(frameGrabber1.getSampleRate());
        recorder.setAudioChannels(frameGrabber1.getAudioChannels());
        recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
        
        
        recorder.start();

        
        //frameGrabber1.start();
        //frameGrabber1Aud.start();
        Frame frame1Aud;
        Frame frame2Aud;
        int j=0;
        for(int x=0;(frame1Aud=frameGrabber1Aud.grabFrame(true, false, false, false))!=null;x++)
            {
                Frame frame = frameGrabber1.grabImage();
                BufferedImage i = paintConverter.convert(frame);
                if(frame!=null){
                    frame = paintConverter.getFrame(i);
                    recorder.record(frame);
                    recorder.record(frame1Aud);
                }
                j++;
            }
              
        frameGrabber1.stop();
        frameGrabber1Aud.stop();
        frameGrabber2.start();
        frameGrabber2Aud.start();
        for(int x=0;(frame2Aud=frameGrabber2Aud.grabFrame(true, false, false, false))!=null;x++)
            {
                Frame frame2 = frameGrabber2.grabImage();
                BufferedImage i = paintConverter.convert(frame2);
                if(frame2!=null){
                    frame2 = paintConverter.getFrame(i);
                    recorder.record(frame2);
                    recorder.record(frame2Aud);
                }
                j++;
            }
        frameGrabber2.stop();
        frameGrabber2Aud.stop();
        recorder.stop();
        
    }
    
}
