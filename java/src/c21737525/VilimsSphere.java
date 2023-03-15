package c21737525;

import ie.tudublin.*;
import processing.core.*;


public class VilimsSphere extends Visual {

    GroupVisual gv;

    public VilimsSphere(GroupVisual gv) {
        this.gv = gv;
    }

    // This 3D visual is going to be a big sphere that is going to be rotating and the audio bands are going to be rotating around the sphere, like few moons around the planet.
    // The sphere is going to be rotating around the center of the screen, and will be changing color based on bass.
    // "Moons" are going to be rotating around the sphere, and the size of the "moon" is going to be based on the amplitude of the sound. They will be split into 6 groups, each group will be a different color.
    // lerpedBuffer is going to be used to change the size of the "moon" based on the amplitude of the sound.

    /* IDEA: MAKE MOONS JUMP UP AND DOWN BASED ON THE AMPLITUDE, IT SHOULD BE LERPED. */

    
    float lerpedAvg = 0;
    float rotation = 0;
    float rot = 0;
    float radius = 125;

    public void render()
    {

    
        gv.translate(gv.width / 2, gv.height / 2); // move the origin to the center of the screen
        //gv.getFFT().forward(gv.getAudioBuffer()); // get the FFT data for the current frame
        gv.setBands(gv.getFFT().getSpectrumReal()); // get the average amplitude for each band

        gv.stroke(255);
        gv.lights();
        gv.stroke(gv.map(gv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        gv.camera(0, 15, 300, 0, 0, 0, 0, 1, 0);
        //gv.translate(0, 0, -250);

        rot += gv.getAmplitude() / 8.0f;

        gv.rotateY(rot);
        float[] bands = gv.getSmoothedBands();
        for(int i = 0 ; i < bands.length ; i ++)
        {
            gv.sphereDetail(50);
            float theta = gv.map(i, 0, bands.length, 0, TWO_PI);

            gv.stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            float x = gv.sin(theta) * radius;
            float z = gv.cos(theta) * radius;
            float h = bands[i] - 100;
            gv.pushMatrix();
            gv.translate(x, - h / 2 , z);
            gv.rotateY(theta);
            gv.sphere(15);
            gv.popMatrix();

        }

        // middle sphere, rotates based on the amplitude of the sound, reverse direction
        gv.pushMatrix();
        gv.sphereDetail(8, 16);
        gv.rotateY(gv.getAmplitude() * 2);
        gv.sphere(100);
        gv.popMatrix();



    
    }

}
