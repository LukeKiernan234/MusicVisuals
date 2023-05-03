package C21325063;

import ie.tudublin.GroupVisual;
import processing.core.PApplet;

public class HaoWave {
    float offset;
    float offsetspeed;
    float waveheight;
    float totallength;
    float circlesize;
    float color;
    float brightness;
    float center_size;
    float outer_size;
    GroupVisual gv;
    float cy;
    float cx;
    float lerprad;
    float lerpc;

  public HaoWave(GroupVisual gv)
  {
    offset = gv.random(0,5);
    waveheight = 500;
    totallength = 10 * PApplet.TWO_PI;
    circlesize = 10;
    outer_size = 30;
    this.gv = gv;
    cy = this.gv.height / 2;
    cx = this.gv.width / 2;
  }

  public void render()
  {
    gv.camera();
    //calculation for outer circle
    offsetspeed = PApplet.map(gv.getSmoothedAmplitude(),0.05f,0.23f,0.01f,0.03f);
    color = PApplet.map(gv.getSmoothedAmplitude(),0.05f,0.23f,0,25);
    brightness = PApplet.map(gv.getSmoothedAmplitude(),0.05f,0.23f,100,255);
    
    //center circle calculation
    int size = gv.getAudioBuffer().size();
    float circlewidth = GroupVisual.map(gv.getSmoothedAmplitude(),0.05f,0.3f,20,60);
    float c = GroupVisual.map(gv.getSmoothedAmplitude(),0,0.23f,40,0);
    lerpc = GroupVisual.lerp(lerpc,c,0.01f);
  
    
    //center circle
    for(int i = 0; i<size;i++)
    {

        float theta = GroupVisual.map(i,0,size,0,GroupVisual.TWO_PI);
        float rad = GroupVisual.map(gv.getAudioBuffer().get(i),0,0.5f,0,30);
        lerprad = GroupVisual.lerp(lerprad,rad,0.01f);
        lerprad = GroupVisual.abs(lerprad);
        float x1 = GroupVisual.cos(theta)*circlewidth;
        float y1 = GroupVisual.sin(theta)*circlewidth;
        float x2 = GroupVisual.cos(theta)*(circlewidth+lerprad);
        float y2 = GroupVisual.sin(theta)*(circlewidth+lerprad);

        gv.pushMatrix();
        gv.translate(gv.width*0.5f,gv.height*0.5f);
        gv.stroke(lerpc,255,255);
        gv.line(x1,y1,x2,y2);
        gv.popMatrix();

    }

    //outer
    for (float a=0; a< totallength; a+=0.3)
    {
      float angle = a+offset;//current angle
    
      float x = PApplet.cos(angle) * waveheight*gv.noise(a, angle, a)*gv.getSmoothedAmplitude()*outer_size;
      float y = PApplet.sin(angle) * waveheight*gv.noise(a,angle)*0.5f;
      gv.noStroke();
      gv.fill(255-255*(a/totallength),255-255*(a/totallength),255-255*(a/totallength));
      gv.pushMatrix();
      gv.translate(gv.width*0.5f,gv.height*0.5f);
      gv.ellipse(x,y,circlesize,circlesize);
      gv.popMatrix();
    }
    offset +=offsetspeed;
  }
}
