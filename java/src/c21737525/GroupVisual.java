package c21737525;

import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.*;
import java.util.ArrayList;
import ie.tudublin.*;

public class GroupVisual extends Visual {

    float[] lerpedBuffer;
    float[] lerpedBuffer2;

    int visual = 0; // 0 = Vilims, 1 = Cube, 2 = RotatingAudioBands, 3 = MyVisual


    // create the visuals here
    VilimsVisual vv = new VilimsVisual(this);

    public void settings() {
        size(1024, 768, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

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
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    
}
