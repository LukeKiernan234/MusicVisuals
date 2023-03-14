package c21737525;

public class VilimsSphere {

    GroupVisual gv;

    public VilimsSphere(GroupVisual gv) {
        this.gv = gv;
    }

    // This 3D visual is going to be a big sphere that is going to be rotating and the audio bands are going to be rotating around the sphere, like few moons around the planet.
    // The sphere is going to be rotating around the center of the screen, and will be changing color based on bass.
    // "Moons" are going to be rotating around the sphere, and the size of the "moon" is going to be based on the amplitude of the sound. They will be split into 6 groups, each group will be a different color.
    // lerpedBuffer is going to be used to change the size of the "moon" based on the amplitude of the sound.

    /* IDEA: MAKE MOONS JUMP UP AND DOWN BASED ON THE AMPLITUDE, IT SHOULD BE LERPED. */

    public void render()
    {

    
        gv.translate(gv.width / 2, gv.height / 2); // move the origin to the center of the screen
        gv.getFFT().forward(gv.getAudioBuffer()); // get the FFT data for the current frame
        gv.pushMatrix(); // push the current transformation matrix onto the stack
        gv.setBands(gv.getFFT().getSpectrumReal()); // get the average amplitude for each band






        // pop the transformation matrix off the stack
        gv.popMatrix();
    
    }

}
