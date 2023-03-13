package c21737525;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class VilimsVisual extends Visual {

    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
 
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("born_slippy.mp3");
        getAudioPlayer().play();
        //startListening(); 
        
    }
    
    float angle1 = 0;
    float angle2 = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }

        // Set background color
        background(0);
        
        
        // Add some lights
        ambientLight(50, 50, 50);
        pointLight(255, 255, 255, width/2, height/2, -100);
        
        // Move the origin to the center of the window
        translate(width/2, height/2);
        
        // Rotate the cube around Y axis
        rotateY(angle1);
        
        // Draw a cube
        fill(200,150,150);
        box(100);
        
        // Move the origin along X axis by half of the cube size plus some offset
        translate(100 + sin(angle2) *50 ,0 ,0 );
        
        // Rotate the sphere around Z axis
        rotateZ(angle2);

        // Draw a red sphere with radius 20
        fill(255,255,255);
        sphere(20);

        // Update rotation angles
        angle1 += radians(1);
        angle2 += radians(5); 





    }
}
