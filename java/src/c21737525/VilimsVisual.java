package c21737525;

import processing.core.*;

public class VilimsVisual
{
    GroupVisual gv;

    public VilimsVisual(GroupVisual gv)
    {
        this.gv = gv;
    }


    public void render()
    {
        gv.translate(gv.width / 2, gv.height / 2); // move the origin to the center of the screen
        gv.getFFT().forward(gv.getAudioBuffer()); // get the FFT data for the current frame
        gv.pushMatrix(); // push the current transformation matrix onto the stack
        gv.setBands(gv.getFFT().getSpectrumReal()); // get the average amplitude for each band




        int radius = 300; //the size of the circle (radius)
        int stick = 300; //length of the line
        
        for (int i = 0; i < gv.getAudioPlayer().mix.size(); i += 8){
            float cirRadius = gv.map(i, 0, gv.getAudioPlayer().mix.size(), 0, 2 * gv.PI); // where each line of the circle is drawn
            float stickLong = gv.abs(gv.getAudioPlayer().mix.get(i)) * stick; // lenght of the line based on the amplitude of the sound
            float c = gv.map(i, 0, gv.getAudioPlayer().mix.size(), 0, 255); // full range of the color based on the amplitude of the sound
            
            gv.stroke(c, 255, 255);
            gv.strokeWeight(3);
            gv.line(gv.sin(cirRadius) * radius, gv.cos(cirRadius) * radius, gv.sin(cirRadius) * (stickLong + radius), gv.cos(cirRadius) * (stickLong + radius));
            // on each end of line, add a curvy line
            gv.noFill();
            gv.arc(gv.sin(cirRadius) * (stickLong + radius), gv.cos(cirRadius) * (stickLong + radius), 15, 15, 0, gv.PI);
        }

        
        int radius2 = 100; //the size of the circle (radius)
        int stick2 = 100; //length of the line
        
        for (int i = 0; i < gv.getAudioPlayer().mix.size(); i += 8){
            float cirRadius = gv.map(i, 0, gv.getAudioPlayer().mix.size(), 0, 2 * gv.PI); //the place of each line of the circle
            float stickLong = gv.abs(gv.getAudioPlayer().mix.get(i)) * stick2; //length of the line
            // full range of the color based on the amplitude of the sound
            float c = gv.map(i, 0, gv.getAudioPlayer().mix.size(), 0, 255);
           gv.stroke(c, 255, 255);
           gv.strokeWeight(3);
           gv.line(gv.sin(cirRadius) * radius2, gv.cos(cirRadius) * radius2, gv.sin(cirRadius) * (stickLong + radius2), gv.cos(cirRadius) * (stickLong + radius2));
       }



        // pop the transformation matrix off the stack
        gv.popMatrix(); 
    }
}
