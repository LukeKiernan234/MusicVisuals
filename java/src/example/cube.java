package example;

import processing.core.PApplet;
import java.util.Random;

public class cube {
    private float size;
    private float x;
    private float y;
    private float z;
    private float rot;
    private float speed;
    private float rotang;
    private float color;

    //setter
    public void setZ(float z) {
        this.z = z;
    }

    public void setColor(float color) {
        this.color = color;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setRotang(float rotang) {
        this.rotang = rotang;
    }

    //constructor
    public cube(float size, float x,float y, float z, float rot, float color) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rot = rot;
        this.speed = 10;
        this.rotang = 0;
        this.color = color;
    }


    public void render(MyVisual mv)
    {

        mv.pushMatrix();
        mv.translate(x, y, z);
        mv.rotateY(rot);
        mv.rotateX(rot);
        mv.stroke(color,255,255);
        mv.box(size);
        mv.popMatrix();

        this.rot += rotang;
        this.z+=this.speed;
        this.color %= 255;
        if(this.z > 1024)
        {
            this.z = -9000;
        }
    }
}
