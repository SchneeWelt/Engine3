package tools.rect;

import java.awt.Color;
import java.awt.Graphics2D;

import in.Draw;

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

	public VCRect(float x, float y)
	{
		super(x, y);
	}

	public VCRect(float x, float y, float w, float h)
	{
		super(x, y, w, h);
	}

	public VCRect(boolean displayOutline, VCRect rect)
	{
		super(rect);
		setDisplayOutline(displayOutline);
	}

	public VCRect(float x, float y, boolean displayOutline)
	{
		super(x, y);
		setDisplayOutline(displayOutline);
	}

	public VCRect(float x, float y, float w, float h, boolean displayOutline)
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
		
		int x = Math.round(this.x);
		int y = Math.round(this.y);
		int w = Math.round(this.w);
		int h = Math.round(this.h);
		
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
