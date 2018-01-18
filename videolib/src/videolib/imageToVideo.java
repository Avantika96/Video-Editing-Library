/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import org.bytedeco.javacpp.avcodec;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;

/**
 *
 * @author AVANTIKA GUPTA
 */
public class imageToVideo {
     public void imageToVideoConvert(String imgPath, String videoPath) throws FrameGrabber.Exception, FrameRecorder.Exception{
        Scanner s=new Scanner(System.in);
        ArrayList<String> links = new ArrayList<>();
        File f=new File(imgPath);
        File[] f2=f.listFiles();
        for(File f3:f2)
        {
                links.add(f3.getAbsolutePath());
        }
        convertJPGtoMovie(links, videoPath);
        s.close();
     }
     
     public void convertJPGtoMovie(ArrayList<String> links, String vidPath) throws FrameGrabber.Exception, FrameRecorder.Exception
	 {
		 OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();
		 FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(vidPath,640,720,2);
		 try {
			 recorder.setFrameRate(25);
             recorder.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4);
             //recorder.setVideoBitrate(9000);
             recorder.setVideoBitrate(1682 * 1024 );
             recorder.setFrameRate(25);
             recorder.setFormat("mp4");
             recorder.setVideoQuality(0); // maximum quality
             recorder.start();
              int time = 10;
              int number_images = 13;

                     for (int i = 0; i < number_images; i++) {
                        for (int j = 0; j < time; j++) {
                            recorder.record(grabberConverter.convert(cvLoadImage(links.get(i))));

            }
        }

		     recorder.stop();
		    }
		    catch (org.bytedeco.javacv.FrameRecorder.Exception e){
		    }
                 
	 }
     
     public void addAudio(String vidPath,String output, String audio) throws FrameGrabber.Exception, FrameRecorder.Exception{
         Java2DFrameConverter paintConverter=new Java2DFrameConverter();
	
	

        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(vidPath);
        FFmpegFrameGrabber frameGrabber1 = new FFmpegFrameGrabber(audio);
        frameGrabber.start();
        frameGrabber1.start();
        
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(output, frameGrabber.getImageWidth(), frameGrabber.getImageHeight(), frameGrabber1.getAudioChannels());
        recorder.setVideoCodec(frameGrabber.getVideoCodec());
        recorder.setVideoBitrate(frameGrabber.getVideoBitrate());
        recorder.setFrameRate(frameGrabber.getFrameRate());
        recorder.setFormat(frameGrabber.getFormat());
        recorder.setAspectRatio(frameGrabber.getAspectRatio());
        recorder.setAudioBitrate(frameGrabber1.getAudioBitrate());
        recorder.setSampleRate(frameGrabber1.getSampleRate());
        recorder.setAudioChannels(frameGrabber1.getAudioChannels());
        recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
        recorder.start();
        Frame frame1;
        for(;(frame1=frameGrabber1.grabFrame(true,false,false,false))!=null;){
                Frame frame = frameGrabber.grabImage();
                BufferedImage i = paintConverter.convert(frame);
                frame = paintConverter.getFrame(i);
                if(frame!=null){
                    recorder.record(frame);
                    recorder.record(frame1);
                }
                
       }
        frameGrabber.stop();
        frameGrabber1.stop();
        recorder.stop();
     }
      
}
