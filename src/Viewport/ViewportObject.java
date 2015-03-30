package Viewport;

import java.awt.Graphics2D;

public interface ViewportObject 
{
	public void repaint(Transform2D transform, Graphics2D canvas);
	
	public String getName();
}
