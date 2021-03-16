package tools.rect;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Draw;

/**
 * The VRect also VisibleRect can display itself on a canvas. It can still hold the four
 * values x, y, width and height. Those will now be used to render the
 * VisibleRect on screen. Every time the lates version of the VisibleRect has to
 * be painted simply call the draw() method.
 * 
 * The visibleRect can differentiate between fill and outline. Fill means that
 * the whole rect is drawn on screen. Therefore, the result will look like a
 * black or red etc rect. However, outline will only draw the outline of the
 * rect on screen. A VisibleRect only can obtain the state show or outline at
 * the same time both are not valid. There is a constuctor which can set the
 * displayState. If it is not set within the constructor the default value 0
 * will be used. At the time I am developing this the value 0 means
 * DISPLAY_STATE_FILL please make sure that this has not changed in later
 * versions.
 * 
 * VisibleRects have a color atribute inside. The default one has the color
 * orange. The color atribute defines the color of the rect no matter wether it
 * is the whole rect or just its outline. You can set or get the visibleRects
 * color with its getters and setters. In addition I also implemented several
 * contructors with color parameters.
 */

public class VRect extends Rect implements Draw
{
	private int displayState = 0;
	public static final int DISPLAY_STATE_FILL = 0;
	public static final int DISPLAY_STATE_OUTLINE = 1;

	private Color color = Color.orange;

	public VRect(int x, int y)
	{
		super(x, y);
	}

	public VRect(int x, int y, int w, int h)
	{
		super(x, y, w, h);
	}

	public VRect(int x, int y, int w, int h, Color color)
	{
		super(x, y, w, h);
		setColor(color);
	}

	public VRect(int x, int y, int w, int h, int DISPLAY_STATE)
	{
		super(x, y, w, h);
		setDisplayState(DISPLAY_STATE);
	}

	public VRect(int x, int y, int w, int h, int DISPLAY_STATE, Color color)
	{
		super(x, y, w, h);
		setColor(color);
		setDisplayState(DISPLAY_STATE);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		displayVisibleRect(graphics);
	}

	private void displayVisibleRect(Graphics2D graphics)
	{
		graphics.setColor(color);

		switch (getDisplayState())
		{
			case DISPLAY_STATE_FILL -> graphics.fillRect(getX(), getY(), getW(), getH());
			case DISPLAY_STATE_OUTLINE -> graphics.drawRect(getX(), getY(), getW(), getH());
		}
	}

	public final Color getColor()
	{
		return color;
	}

	public final void setColor(Color color)
	{
		this.color = color;
	}

	public final int getDisplayState()
	{
		return displayState;
	}

	private final void setDisplayState(int displayState)
	{
		this.displayState = displayState;
	}
}
