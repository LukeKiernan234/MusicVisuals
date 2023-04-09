package ie.tudublin;

import c21737525.VilimsVisual;
import C21411466.LukeVisual;
import C21411466.LukeVisual2;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new GroupVisual());		
	}
	public void RotatingAudioBands()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();
		// main.RotatingAudioBands();		
	}
}