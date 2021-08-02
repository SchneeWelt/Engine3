package tools;

import java.awt.Graphics2D;

import tools.rect.Rect;

/**
 * The Camera class simulates a simple camera to use. In the moment it is
 * possible to move the camera up, down, left and right as well as zoom out and
 * zoom in.
 * 
 * To use the camera when creating the next frame the method camera() has to be
 * called.
 * 
 * To move the camera sideways change the offsetX to move the camera up / down
 * change the offsetY value. Getters and setters are available for both.
 * 
 * To zoom in or out change the zoom value. The default value is one. Zoom
 * values have to be positive values therfore there is a value range from 0 to
 * positive infinity. Even slight changes can make big differeces. The Value is
 * from data type double. I recomend usind new zoom values like 1.6 or 3.2 not
 * bigger.
 */

public class Camera
{
	private double zoom = 1;

	private Rect offset;

	/**
	 * initialisiert die Kamera und lässt sie auf punkt 0, 0
	 * schauen.
	 */
	
	public Camera()
	{
		offset = new Rect(0, 0);
	}

	/**
	 * Initilisiert die Kamera und lässt sie auf einen vordefinierten 
	 * Punkt schauen. 
	 * 
	 * @param xOffset
	 * @param yOffset
	 * @param zoom: Default = 1
	 */
	
	public Camera(int xOffset, int yOffset, double zoom)
	{
		this.zoom = zoom;
		
		offset = new Rect(xOffset, yOffset);
	}
	
	public final void camera(Graphics2D graphics)
	{
		graphics.scale(zoom, zoom);
		graphics.translate(offset.getRoundX(), offset.getRoundY());
	}

	/**
	 * Bewegt die Kamera auf eine neue Position, in dem die input parameter auf die
	 * vorhandene Position addiert werden.
	 * 
	 * @param incrementX
	 * @param incrementY
	 */

	public final void move(float incrementX, float incrementY)
	{
		offset.incrementX(incrementX);
		offset.incrementY(incrementY);
	}
	
	public final void zoom(double incrementZ)
	{
		zoom += incrementZ;
	}

	/**
	 * Fokusiert die Camera auf Punkt 0, 0
	 */

	public final void reset()
	{
		offset.collapse();
	}

	public final void setZoom(double zoom)
	{
		this.zoom = zoom;
	}

	public final void setOffset(Rect offset)
	{
		this.offset = offset;
	}

	public final Rect getOffset()
	{
		return offset;
	}

	public final double getZoom()
	{
		return zoom;
	}
}
