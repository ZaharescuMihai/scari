package Viewport;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Events.EventHandler;


public class Viewport 
{
	static int EVNT_CAMERA_CHANGED = 1;
	
	BufferedImage image_canvas;
	Graphics2D drawing_canvas;
	
	EventHandler event_handler;
	
	Transform2D camera;
	
	/**
	 * Constructs a viewport window having the given dimensions
	 * @param w width in pixels of the displaying region
	 * @param h height in pixels of the displaying region
	 */
	public Viewport(int w, int h)
	{
		initCanvas(w, h);
	}
	
	/**
	 * Updates the internal objects to reflect the new size, only if the size os different.
	 * @param w the new width of the drawing region
	 * @param h the new height of the drawing region
	 */
	private void initCanvas(int w, int h)
	{
		if(w == image_canvas.getWidth() && h == image_canvas.getHeight())
			return;
		
		image_canvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		drawing_canvas = (Graphics2D)image_canvas.getGraphics();
	}
	
	public void paint(ViewportObject object)
	{
		object.repaint(camera, drawing_canvas);
	}
}
