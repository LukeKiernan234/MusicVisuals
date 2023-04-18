package ie.tudublin;

import c21737525.*;

import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.*;
import java.util.ArrayList;

import C21325063.*;

public class GroupVisual extends Visual {

    private float[] lerpedBuffer;
    private float[] lerpedBuffer2;
    private float halfHeight = height / 2;

    int visual = 0; // 0 = VilimsVisual, 1 = VilimsSphere, 2 = RotatingAudioBands, 3 = MyVisual

    // create the visuals here
    VilimsVisual vv = new VilimsVisual(this);
    VilimsSphere vs = new VilimsSphere(this);

    HaoCube hc = new HaoCube(this);
    HaoWave hw = new HaoWave(this);

    public void settings() {
        size(1024, 768, P3D);
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
        if(key == '5')
        {
            visual = 4;
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
        hc.createbox(300,hc.cubes2,-6000,-1000,1000); 
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

        switch (visual) {
            case 0:
                vv.render();
                break;
            case 1:
                vs.render();
                break;
            case 2:
                hc.render(hc.cubes1);
                break;
            case 3:
                hc.render(hc.cubes2);
                break;
            case 4:
                hw.render();
                break;
            default:
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


}
