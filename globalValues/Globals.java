package globalValues;

import handler.KeyEventHandler;
import handler.MouseEventHandler;
import tools.rect.Rect;

public class Globals
{
	/* global mouse and keyboard event handler */
	private static KeyEventHandler keyEventHandler = new KeyEventHandler();
	private static MouseEventHandler mouseEventHandler = new MouseEventHandler();

	/* global mouse data */
	private static boolean mousePressed = false;
	private static Rect mouseLocation = new Rect(0, 0);

	/* global system data */
	private static final double tickRate = 1000 / 30;
	private static final Rect SCREEN_DIMENSION = new Rect(0, 0, 900, 600);

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

	public static final Rect getMouseLocation()
	{
		return mouseLocation;
	}

	public static final double getTickrate()
	{
		return tickRate;
	}

	public static final Rect getScreenDimension()
	{
		return SCREEN_DIMENSION;
	}

	public static final void setMousePressed(boolean mousePressed)
	{
		Globals.mousePressed = mousePressed;
	}

	public static final void setMouseLocation(Rect mouseLocation)
	{
		Globals.mouseLocation = mouseLocation;
	}
}
