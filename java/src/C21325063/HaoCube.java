package C21325063;

import java.util.ArrayList;
import java.util.Random;

// import ddf.minim.analysis.FFT;
import processing.core.*;
import ie.tudublin.*;

public class HaoCube {
    GroupVisual gv;
    float lerpc;
    public ArrayList<cube> cubes1 = new ArrayList<cube>();
    public ArrayList<cube> cubes2 = new ArrayList<cube>();

    public HaoCube(GroupVisual gv)
    {
        this.gv = gv;
    }
    float rotate = 1f;
    float z = 100;
    public void render(ArrayList<cube> cubes)
    {
        gv.noFill();
        gv.lights();
        drawbox(cubes);
       
    }

    public void createbox(int num, ArrayList<cube> cubes,float low,float high,float size)
    {
        Random r = new Random();
        //initalize of cubes, randomize thier position and color
        //add cubes into arraylist
        for(int i = 0; i < num; i++)
        {
            float x = r.nextFloat(gv.width);
            float y = r.nextFloat(gv.height);
            float z = r.nextFloat(low, high);
            float rot = r.nextFloat(0,2);
            float color = 0;
            cube c;
            if(cubes == cubes1)
            {
                c = new cube(size,x,y, z, rot,color);
            }
            else
            {
                c = new cube(size,x,y, z, 0,color);
            }
            cubes.add(c);
        }

    }
    public void drawbox(ArrayList<cube> cubes)
    {
        gv.camera();
        float rotang = PApplet.map(gv.getAmplitude(),0.04f,0.2f,0,0.2f);
        float speed = PApplet.map(gv.getAmplitude(),0,0.3f,0,50);

        float color = PApplet.map(gv.getSmoothedAmplitude(),0.06f,0.23f,100,255);
        lerpc = PApplet.lerp(lerpc,color,0.05f);

        for(int i = 0;i<cubes.size();i++)
        {
            cube c = cubes.get(i);
            c.setSpeed(speed);
            c.setColor(lerpc);
            c.setRotang(rotang);
            if(cubes == cubes2)
            {
                c.render2(gv);
            }
            else if(cubes == cubes1)
            {
                c.render(gv);
            }
        }
    }
}
