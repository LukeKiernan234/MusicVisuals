package example;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    scene1 s1;
    scene2 s2;
    RotatingAudioBands rt;

    public void settings()
    {
        size(1024, 1024,P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("heroplanet.mp3");

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        s1 = new scene1(this);
        s2 = new scene2(this);
        s2.createbox(100);
    }


    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        // wf.render();
        // abv.render();
        s1.render();
        //s2.render();
    }
}
