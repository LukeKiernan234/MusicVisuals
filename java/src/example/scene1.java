package example;

import processing.core.*;

public class scene1{
    MyVisual mv;
    float cy;
    float cx;
    float lerprad;
    float lerpc;

    public scene1(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cx = this.mv.width / 2;
    }

    public void render()
    {
        int size = mv.getAudioBuffer().size();
        mv.colorMode(PApplet.HSB);
        mv.stroke(255);
        mv.noFill();

        float circlewidth = PApplet.map(mv.getSmoothedAmplitude(),0,0.3f,100,300);
        float c = PApplet.map(mv.getSmoothedAmplitude(),0,0.3f,0,255);
        lerpc = PApplet.lerp(lerpc,c,0.01f);
        for(int i = 0; i<size;i++)
        {
            // mv.stroke(PApplet.map(i,0,bands.length,0,255),255,255);
            mv.stroke(255);

            float theta = PApplet.map(i,0,size,0,PApplet.TWO_PI);

            float rad = PApplet.map(mv.getAudioBuffer().get(i),0,0.5f,0,300);
            lerprad = PApplet.lerp(lerprad,rad,0.01f);
            lerprad = PApplet.abs(lerprad);
            float x1 = cx + PApplet.cos(theta)*circlewidth;
            float y1 = cy + PApplet.sin(theta)*circlewidth;
            float x2 = cx + (PApplet.cos(theta)*(circlewidth+lerprad));
            float y2 = cy + (PApplet.sin(theta)*(circlewidth+lerprad));
            mv.stroke(lerpc,255,255);
            mv.line(x1,y1,x2,y2);

        }
    }

}
