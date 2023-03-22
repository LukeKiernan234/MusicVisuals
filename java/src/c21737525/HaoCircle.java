package c21737525;

import ie.tudublin.GroupVisual;

public class HaoCircle {
    GroupVisual mv;
    float cy;
    float cx;
    float lerprad;
    float lerpc;

    public HaoCircle(GroupVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cx = this.mv.width / 2;
    }

    public void render()
    {
        int size = mv.getAudioBuffer().size();
        mv.colorMode(GroupVisual.HSB);
        mv.stroke(255);
        mv.noFill();

        float circlewidth = GroupVisual.map(mv.getSmoothedAmplitude(),0,0.3f,100,300);
        float c = GroupVisual.map(mv.getSmoothedAmplitude(),0,0.3f,0,255);
        lerpc = GroupVisual.lerp(lerpc,c,0.01f);
        for(int i = 0; i<size;i++)
        {
            // mv.stroke(GroupVisual.map(i,0,bands.length,0,255),255,255);
            mv.stroke(255);

            float theta = GroupVisual.map(i,0,size,0,GroupVisual.TWO_PI);

            float rad = GroupVisual.map(mv.getAudioBuffer().get(i),0,0.5f,0,300);
            lerprad = GroupVisual.lerp(lerprad,rad,0.01f);
            lerprad = GroupVisual.abs(lerprad);
            float x1 = cx + GroupVisual.cos(theta)*circlewidth;
            float y1 = cy + GroupVisual.sin(theta)*circlewidth;
            float x2 = cx + (GroupVisual.cos(theta)*(circlewidth+lerprad));
            float y2 = cy + (GroupVisual.sin(theta)*(circlewidth+lerprad));
            mv.stroke(lerpc,255,255);
            mv.line(x1,y1,x2,y2);

        }
    }
}
