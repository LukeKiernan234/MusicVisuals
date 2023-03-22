package c21737525;

import ie.tudublin.*;
import processing.core.PConstants;

public class VilimsVisual
{
    GroupVisual gv;

    public VilimsVisual(GroupVisual gv)
    {
        this.gv = gv;
    }


    // This visual is split in two parts, the first part is the outer circle in which sticks representing the amplitude of the sound are drawn, at the end of each stick is half-circle
    // The second part is the inner circle, that needs to be re-visited, but the initial idea was to invert the sticks so they are drawn towards the center of the circle.
    public void render()
    {

        // reset the camera
        gv.camera();
        gv.translate(gv.width / 2, gv.height / 2); // move the origin to the center of the screen
        gv.pushMatrix(); // push the current transformation matrix onto the stack

        int radius = 300; //the size of the circle (radius)
        int stick = 300; //length of the line
        
        for (int i = 0; i < gv.getAudioPlayer().mix.size(); i += 8)
        {
            float cirRadius = GroupVisual.map(i, 0, gv.getAudioPlayer().mix.size(), 0, 2 * PConstants.PI); // where each line of the circle is drawn
            float stickGrow = GroupVisual.abs(gv.getAudioPlayer().mix.get(i)) * stick; // lenght of the line based on the amplitude of the sound
            float c = GroupVisual.map(i, 0, gv.getAudioPlayer().mix.size(), 0, 255); // full range of the color based on the amplitude of the sound
            float f = gv.getLerpedBuffer()[i] * gv.getHalfHeight() * 4.0f;
            
            gv.stroke(c, 255, 255);
            gv.strokeWeight(5);
            gv.line(GroupVisual.sin(cirRadius) * radius, (GroupVisual.cos(cirRadius) * radius) + f, GroupVisual.sin(cirRadius) * (stickGrow + radius), (GroupVisual.cos(cirRadius) * (stickGrow + radius)) - f);
            // on each end of line, add a curvy line
            gv.noFill();
            gv.arc(GroupVisual.sin(cirRadius) * (stickGrow + radius), GroupVisual.cos(cirRadius) * (stickGrow + radius), 15, 15, 0, PConstants.PI); //place half circle at the end of each line 
        }

        //center sphere
        gv.lights();
        gv.rotateY(gv.getSmoothedAmplitude() * 10 ); // rotate the sphere based on the amplitude of the sound
        gv.noFill();
        gv.stroke(GroupVisual.map(gv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        gv.strokeWeight(2);
        gv.sphereDetail(32, 32);
        gv.sphere(250);

        // pop the transformation matrix off the stack
        gv.popMatrix(); 
    }
}
