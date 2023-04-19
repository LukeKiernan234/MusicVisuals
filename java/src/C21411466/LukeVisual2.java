package C21411466;

import ie.tudublin.*;
import processing.core.PApplet;
import processing.core.PConstants;

public class LukeVisual2 extends Visual {
    
    GroupVisual gv;
    float radius = 300;
    float angle = 0;
    int numLines = 32;
    float lineLength = 100;
    float lineThickness = 10;
    float[] lineAngles;
    float[] lineSpeeds;
    float[] lineOffsets;

    public LukeVisual2(GroupVisual gv) {
        this.gv = gv;
        lineAngles = new float[numLines];
        lineSpeeds = new float[numLines];
        lineOffsets = new float[numLines];
        float angleIncrement = PConstants.TWO_PI / (float) numLines;
        float speedIncrement = 0.05f / (float) numLines;
        float offsetIncrement = PConstants.TWO_PI / (float) numLines;
        for (int i = 0; i < numLines; i++) {
            lineAngles[i] = i * angleIncrement;
            lineSpeeds[i] = (i + 1) * speedIncrement;
            lineOffsets[i] = i * offsetIncrement;
        }
    }
    public void renderBackground() {
    
        // Draw particles
        gv.camera();
        for (int i = 0; i < 100; i++) {
            float x = gv.random(-gv.width/2, gv.width/2);
            float y = gv.random(-gv.height/2, gv.height/2);
            float z = gv.random(-radius, radius);
            float size = gv.random(1, 5);
            float r = gv.random(255);
            float g = gv.random(255);
            float b = gv.random(255);
            gv.fill(r, g, b);
            gv.noStroke();
            gv.pushMatrix();
            gv.translate(gv.width/2 + x, gv.height/2 + y, z);
            gv.sphere(size);
            gv.popMatrix();
        }
    }
    

    public void render() {

        gv.pushMatrix();

        float amplitude = gv.getSmoothedAmplitude();
        float size1 = PApplet.map(amplitude, 0, 1, 0.5f, 20.0f);
        radius = 300 * size1;
        lineLength = 100 * size1;
    
        renderBackground();
    
        gv.lights();
        gv.noFill();
    
        // Update angles of lines
        float angleIncrement = PApplet.map(amplitude, 0, 1, 0, 0.05f);
        for (int i = 0; i < numLines; i++) {
            lineAngles[i] += lineSpeeds[i] + angleIncrement;
        }
    
        // Draw lines
        for (int i = 0; i < numLines; i++) {
            float x = PApplet.sin(lineAngles[i] + lineOffsets[i]) * radius;
            float y = PApplet.cos(lineAngles[i] + lineOffsets[i]) * radius;
            float z = PApplet.map(amplitude, 0, 1, -radius, radius);
            float thickness = PApplet.map(gv.getSmoothedFrequency(i), 0, 1, 8, lineThickness);
    
            // Increase thickness and length gradually with amplitude
            thickness *= amplitude * 10;
            lineLength *= amplitude * 2;
    
            // Set stroke color and weight
            gv.strokeWeight(thickness);
            gv.stroke(PApplet.map(i, 0, numLines, 0, 255), 255, 255);
    
            // Draw line
            gv.line(gv.width/2, gv.height/2, z, x+gv.width/2, y+gv.height/2, z);

            
        }
        gv.popMatrix();
    }
    
}

    
    
    

