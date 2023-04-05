package ie.tudublin;

import c21737525.*;

import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.*;
import java.util.ArrayList;

import C21325063.HaoCube;
import C21411466.*;
import ie.tudublin.*;

public class GroupVisual extends Visual {

    private float[] lerpedBuffer;
    private float[] lerpedBuffer2;
    private float halfHeight = height / 2;

    int visual = 0; // 0 = VilimsVisual, 1 = VilimsSphere, 2 = RotatingAudioBands, 3 = MyVisual 4 = lukeVisual

    // create the visuals here
    VilimsVisual vv = new VilimsVisual(this);
    VilimsSphere vs = new VilimsSphere(this);
    HaoCube hc = new HaoCube(this);
    LukeVisual lv = new LukeVisual(this);

    public void settings() {
        //size(1024, 768, P3D);Fg
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
        hc.createbox(500); 
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
                hc.render();
                break;
            case 3:
                lv.render();
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

}
