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
		int x = other.getX();
		int y = other.getY();
		int w = other.getW();
		int h = other.getH();
		Rectangle r1 = new Rectangle(x, y, w, h);
		Rectangle r2 = new Rectangle(this.x, this.y, this.w, this.h);
		
		return r1.intersects(r2);
	}
}
