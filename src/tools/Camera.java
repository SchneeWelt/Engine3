package tools;

import java.awt.Graphics2D;

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
	private int offsetX, offsetY;
	private double zoom = 1;

	public Camera()
	{
	}

	public final void camera(Graphics2D graphics)
	{
		graphics.scale(zoom, zoom);
		graphics.translate(offsetX, offsetY);
	}

	public final int getOffsetX()
	{
		return offsetX;
	}

	public final int getOffsetY()
	{
		return offsetY;
	}

	public final void setOffsetX(int offsetX)
	{
		this.offsetX = offsetX;
	}

	public final void setOffsetY(int offsetY)
	{
		this.offsetY = offsetY;
	}

	public final double getZoom()
	{
		return zoom;
	}

	public final void setZoom(double zoom)
	{
		this.zoom = zoom;
	}
}
