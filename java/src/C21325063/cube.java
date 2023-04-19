package C21325063;

import ie.tudublin.GroupVisual;

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

    public void render(GroupVisual gv)
    {

        gv.camera();

        //gv.translate(gv.width / 2, gv.height / 2, z ); // move the origin to the center of the screen
        gv.pushMatrix();
        gv.translate(x, y, z);
        gv.rotateY(rot);
        gv.rotateX(rot);
        gv.stroke(color,255,255);
        gv.box(size);
        gv.popMatrix();

        this.rot += rotang;
        this.z+=this.speed;
        this.color %= 255;
        if(this.z > 1000)
        {
            this.z = -6000;
        }
    }

    public void render2(GroupVisual gv)
    {
        gv.camera();

        gv.translate(gv.width / 2, gv.height / 2, z ); // move the origin to the center of the screen
        gv.pushMatrix();
        gv.strokeWeight(3);
        gv.rotateY(rot);
        gv.rotateX(rot);
        gv.stroke(color,255,255);
        gv.box(size);
        gv.popMatrix();

        this.rot += rotang;
        this.z+=this.speed;
        if(this.z > 1024)
        {
            this.z = -10000;
        }
    }
    
}
