package C21325063;

import java.util.ArrayList;
import java.util.Random;

// import ddf.minim.analysis.FFT;
import processing.core.*;
import ie.tudublin.*;

public class HaoCube {
    GroupVisual gv;
    float lerpc;
    ArrayList<cube> cubes = new ArrayList<cube>();

    public HaoCube(GroupVisual gv)
    {
        this.gv = gv;
    }
    float rotate = 1f;
    float z = 100;
    public void render()
    {
        gv.noFill();
        gv.lights();
        drawbox();
    }

    public void createbox(int num)
    {
        Random r = new Random();
        for(int i = 0; i < num; i++)
        {
            float x = r.nextFloat(gv.width);
            float y = r.nextFloat(gv.height);
            float z = r.nextFloat(-9000, -1000);
            float color = r.nextFloat(255);
            cube c = new cube(20.0f,x,y, z, 0.5f,color);
            cubes.add(c);
        }

    }
    public void drawbox()
    {
        float rotang = PApplet.map(gv.getAmplitude(),0,0.5f,0,0.5f);
        float speed = PApplet.map(gv.getAmplitude(),0,0.3f,0,50);


        float color = PApplet.map(gv.getSmoothedAmplitude(),0,0.2f,0,255);
        lerpc = PApplet.lerp(lerpc,color,0.05f);

        for(int i = 0;i<cubes.size();i++)
        {
            cube c = cubes.get(i);
            c.setSpeed(speed);
            c.setColor(lerpc);
            c.setRotang(rotang);
            c.render(gv);
        }
    }
}
