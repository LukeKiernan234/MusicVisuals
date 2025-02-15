package ie.tudublin;

import ddf.minim.*;
import c21737525.*;
import C21325063.*;
import C21411466.*;

public class GroupVisual extends Visual {

    private float[] lerpedBuffer;
    private float[] lerpedBuffer2;
    private float halfHeight = height / 2;

    int visual = 0; // 0 = VilimsVisual, 1 = VilimsSphere, 2 = RotatingAudioBands, 3 = MyVisual 4 = lukeVisual
    int m = 0;
    int mode[] = {31, 58, 76, 99, 167, 205, 300};
    // create the visuals here, these are objects of the classes
    VilimsVisual vv = new VilimsVisual(this);
    VilimsSphere vs = new VilimsSphere(this);

    HaoCube hc = new HaoCube(this);
    LukeVisual lv = new LukeVisual(this); 
    LukeVisual2 lv2 = new LukeVisual2(this);
    HaoWave hw = new HaoWave(this);     

    public void settings() {
        //size(2560, 1430, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D);
    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

        }
        if (key == '1') {
            visual = 0;
        }
        if (key == '2') {
            visual = 1;
        }
        if (key == '3') {
            visual = 2;
        }
        if (key == '4') {
            visual = 3;
        }
        if (key == '5') {
            visual = 4;
        }
        if (key == '6') {
            visual = 5;
        }
        if (key == '7') {
            visual = 6;
        }


    }

    public void setup() {
        colorMode(HSB);
        //noCursor();
        frameRate(60);
        startMinim();
        loadAudio("born_slippy.mp3");
        getAudioPlayer().play();
        smooth();
        lerpedBuffer = new float[width];
        lerpedBuffer2 = new float[width]; 
        hc.createbox(250,hc.cubes1,-8000,-1000,30); 
        hc.createbox(100,hc.cubes2,-6000,-1000,1000); 

    }
    
    
    
    public void draw() {
        background(0);
        calculateFrequencyBands();
        calculateAverageAmplitude();
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        m = millis() /1000;
        //value store in mode array stands for the end time of each visual
        //end times stored in mode array are sorted in ascending order
        //compare current time to the end time of each visual until find a end time that is greater than current time
        //then loop stops and the current index stands for the visual that should be displayed 
        for (int i = 0; i < mode.length; i++) {
            if (m < mode[i]) {
                visual = i;
                break;
            }
        }
        switch (visual) {
            case 0:
                hw.render();
                break;
            case 1:
                vv.render();
                break;
            case 2:
                lv.render();
                break;
            case 3:
                hc.render(hc.cubes1);
                break;
            case 4:
                lv2.render();
                break;
            case 5:
                hc.render(hc.cubes2);
                break;
            case 6:
                vs.render();
                break;
        }
    }

    


    
    
    

    public float[] getLerpedBuffer() {
        return lerpedBuffer;
    }

    public void setLerpedBuffer(float[] lerpedBuffer) {
        this.lerpedBuffer = lerpedBuffer;
    }

    public float[] getLerpedBuffer2() {
        return lerpedBuffer2;
    }

    public void setLerpedBuffer2(float[] lerpedBuffer2) {
        this.lerpedBuffer2 = lerpedBuffer2;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

    public void setHalfHeight(float halfHeight) {
        this.halfHeight = halfHeight;
    }

    public int getAudioLength() {
        AudioPlayer ap = getAudioPlayer();
        return (int) Math.ceil(ap.length() / 1000.0);
    }

    public float getSmoothedFrequency(int i) {
        return 0;
    }
    

}
