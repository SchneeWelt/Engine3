package tools.rect;

import java.awt.Rectangle;

/**
 * The CRect or CollisionRect describes a blueprint for rect which can test
 * collision between each other.
 */

public class CRect extends Rect
{
	public CRect(CRect rect)
	{
		super(rect);
	}

	public CRect(int x, int y)
	{
		super(x, y);
	}

	public CRect(int x, int y, int w, int h)
	{
		super(x, y, w, h);
	}

	public final boolean isCollision(CRect other)
	{
		Rectangle r = new Rectangle(x, y, w, h).intersection(new Rectangle(other.getX(), other.getY(), other.getW(), other.getH()));
		return (r != null);
	}
}
