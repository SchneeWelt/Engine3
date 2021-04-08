package tools.rect;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Draw;

/**
 * The VCRect or VisibleCollisionRect can visually show its location on screen.
 * Doing so requiers the call of the draw() method. The Rect is displayed on
 * screen with an orange outline. Wether the outline should be displayed or not
 * can be changed with the value displayOutline of type boolean. The default
 * value is set to true.
 */

public class VCRect extends CRect implements Draw
{
	private boolean displayOutline = true;

	public VCRect(VCRect rect)
	{
		super(rect);
		setDisplayOutline(rect.isDisplayOutline());
	}

	public VCRect(int x, int y)
	{
		super(x, y);
	}

	public VCRect(int x, int y, int w, int h)
	{
		super(x, y, w, h);
	}

	public VCRect(boolean displayOutline, VCRect rect)
	{
		super(rect);
		setDisplayOutline(displayOutline);
	}

	public VCRect(int x, int y, boolean displayOutline)
	{
		super(x, y);
		setDisplayOutline(displayOutline);
	}

	public VCRect(int x, int y, int w, int h, boolean displayOutline)
	{
		super(x, y, w, h);
		setDisplayOutline(displayOutline);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		if (isDisplayOutline())
		{
			displayOutline(graphics);
		}
	}

	protected void displayOutline(Graphics2D graphics)
	{
		graphics.setColor(Color.orange);
		graphics.drawRect(x, y, w, h);
	}
	
	public final boolean isDisplayOutline()
	{
		return displayOutline;
	}

	public final void setDisplayOutline(boolean displayOutline)
	{
		this.displayOutline = displayOutline;
	}
}
