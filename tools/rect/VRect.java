package tools.rect;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import in.Draw;

/**
 * The VRect also VisibleRect can display itself on a canvas. It can still hold
 * the four values x, y, width and height. Those will now be used to render the
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
 * 
 * New Stroke Width. VisibleRects now have a strokeWidth parameter. Changing
 * this value will increase the strokeWidth when using the outline mode. The
 * default Value is 1.
 */

public class VRect extends Rect implements Draw
{
	private boolean displayRect = true;

	private int strokeWidth = 1;
	private int displayState = 0;
	public static final int DISPLAY_STATE_FILL = 0;
	public static final int DISPLAY_STATE_OUTLINE = 1;

	private Color color = Color.orange;

	/* clone constructor */
	public VRect(VRect vRect)
	{
		super(vRect);
		setColor(vRect.getColor());
		setDisplayRect(vRect.isDisplayRect());
		setStrokeWidth(vRect.getStrokeWidth());
		setDisplayState(vRect.getDisplayState());
	}

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

	public VRect(int x, int y, int w, int h, int DISPLAY_STATE, int strokeWidth)
	{
		super(x, y, w, h);
		setStrokeWidth(strokeWidth);
		setDisplayState(DISPLAY_STATE);
	}

	public VRect(int x, int y, int w, int h, int DISPLAY_STATE, int strokeWidth, Color color)
	{
		super(x, y, w, h);
		setColor(color);
		setStrokeWidth(strokeWidth);
		setDisplayState(DISPLAY_STATE);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		if (isDisplayRect())
			displayVisibleRect(graphics);
	}

	private void displayVisibleRect(Graphics2D graphics)
	{
		graphics.setColor(color);

//		switch (getDisplayState())
//		{
//			case DISPLAY_STATE_FILL ->
//			{
//				graphics.fillRect(x, y, w, h);
//			}
//			case DISPLAY_STATE_OUTLINE ->
//			{
//				graphics.setStroke(new BasicStroke(strokeWidth));
//				graphics.drawRect(x, y, w, h);
//			}
//		}

		if (displayState == DISPLAY_STATE_FILL)
			graphics.fillRect(x, y, w, h);
		else if (displayState == DISPLAY_STATE_OUTLINE)
		{
			graphics.setStroke(new BasicStroke(strokeWidth));
			graphics.drawRect(x, y, w, h);
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

	public final int getStrokeWidth()
	{
		return strokeWidth;
	}

	public final void setDisplayRect(boolean displayRect)
	{
		this.displayRect = displayRect;
	}

	public final boolean isDisplayRect()
	{
		return displayRect;
	}

	private final void setStrokeWidth(int strokeWidth)
	{
		this.strokeWidth = strokeWidth;
	}

	private final void setDisplayState(int displayState)
	{
		this.displayState = displayState;
	}
}
