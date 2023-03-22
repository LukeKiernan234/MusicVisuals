package example;

import java.util.ArrayList;
import java.util.Random;

import ddf.minim.analysis.FFT;
import processing.core.*;

public class scene2 {
    MyVisual mv;
    float cy;
    float cx;
    float lerpc;
    ArrayList<cube> cubes = new ArrayList<cube>();

    public scene2(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cx = this.mv.width / 2;
    }
    float rotate = 1f;
    float z = 100;
    public void render()
    {

        mv.colorMode(PApplet.HSB);
        mv.noFill();
        mv.lights();
        drawbox();
        // z+= 3;
        // z = z % 1024;
    }

    public void createbox(int num)
    {
        Random r = new Random();
        for(int i = 0; i < num; i++)
        {
            float x = r.nextFloat(1000);
            float y = r.nextFloat(800);
            float z = r.nextFloat(-9000, -1000);
            float color = r.nextFloat(255);
            cube c = new cube(20.0f,x,y, z, 0.5f,color);
            cubes.add(c);
        }

    }
    public void drawbox()
    {
        float rotang = PApplet.map(mv.getAmplitude(),0,0.5f,0,0.5f);
        float speed = PApplet.map(mv.getAmplitude(),0,0.3f,0,50);

        int highestIndex = 0;
        FFT fft = mv.getFFT();
        for(int i = 0; i < fft.specSize();i++)
        {
            if(fft.getBand(i) > fft.getBand(highestIndex))
            {
                highestIndex = i;
            }
        }

        float color = PApplet.map(fft.indexToFreq(highestIndex),0,2000.0f,0,255);
        lerpc = PApplet.lerp(lerpc,color,0.05f);

        for(int i = 0;i<cubes.size();i++)
        {
            cube c = cubes.get(i);
            c.setSpeed(speed);
            c.setColor(lerpc);
            c.setRotang(rotang);
            c.render(mv);
        }
        System.out.println(fft.indexToFreq(highestIndex));
    }
}
