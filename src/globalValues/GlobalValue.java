package globalValues;

import java.awt.Dimension;
import java.awt.Point;

import handler.KeyEventHandler;
import handler.MouseEventHandler;

public class GlobalValue
{
	/* global mouse and keyboard event handler */
	private static KeyEventHandler keyEventHandler = new KeyEventHandler();
	private static MouseEventHandler mouseEventHandler = new MouseEventHandler();

	/* global mouse data */
	private static boolean mousePressed = false;
	private static Point mouseLocation = new Point();

	/* global system data */
	private static final double tickRate = 1000 / 30;
	private static final Dimension SCREEN_DIMENSION = new Dimension(900, 600);

	public static final boolean isMousePressed()
	{
		return mousePressed;
	}
	
	public static final KeyEventHandler getKeyEventHandler()
	{
		return keyEventHandler;
	}

	public static final MouseEventHandler getMouseEventHandler()
	{
		return mouseEventHandler;
	}

	public static final Point getMouseLocation()
	{
		return mouseLocation;
	}

	public static final double getTickrate()
	{
		return tickRate;
	}

	public static final Dimension getScreenDimension()
	{
		return SCREEN_DIMENSION;
	}

	public static final void setMousePressed(boolean mousePressed)
	{
		GlobalValue.mousePressed = mousePressed;
	}

	public static final void setMouseLocation(Point mouseLocation)
	{
		GlobalValue.mouseLocation = mouseLocation;
	}
}
