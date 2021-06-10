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
	public static final int TICKS = 30;
	public static final double TICK_RATE = 1000 / TICKS;
	public static final Rect SCREEN_DIMENSION = new Rect(0, 0, 900, 600);

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

	public static final void setMousePressed(boolean mousePressed)
	{
		Globals.mousePressed = mousePressed;
	}

	public static final void setMouseLocation(Rect mouseLocation)
	{
		Globals.mouseLocation = mouseLocation;
	}
}
