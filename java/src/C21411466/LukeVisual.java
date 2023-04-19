package C21411466;

import ie.tudublin.*;

public class LukeVisual extends Visual {

    GroupVisual gv;
    float rot = 0;
    float radius = 125;
    int startTime; 
    float camZ = 1700; 
 

    public LukeVisual(GroupVisual gv) {
        this.gv = gv;
        startTime = millis();  // initialize the start time
    }

    public void render() {
        gv.strokeWeight(3);
        gv.stroke(255);
        gv.lights();
        gv.stroke(GroupVisual.map(gv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        
        float t = (float) (millis() - startTime) / (float) (gv.getAudioLength() * 1000);
        float newCamZ = GroupVisual.lerp(camZ, 1000, t);
        gv.camera(0, 15, newCamZ, 0, 0, 0, 0, 1, 0); // set new camera position
    
        float[] bands = gv.getSmoothedBands();
        int numCubes = bands.length;
        for (int i = 0; i < numCubes; i++) {
            float h = (bands[i] * 3); 
            float w = (bands[i] * 0.2f);
    
            gv.pushMatrix();
  
            rot += 0.004f;
            gv.rotateY(rot);
            gv.translate(gv.width / numCubes * (i + 0.5f) - gv.width / 2, gv.height / 5, 0);
            gv.fill(map(i, 0, numCubes, 0, 255), 255, 255); 
            gv.box(w, h, w);
            gv.popMatrix();
        }
    
        
    }
}
