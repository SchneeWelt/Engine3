package tools.rect;

import java.awt.Rectangle;

/**
 * The CRect or CollisionRect describes a blueprint for rect which is collision
 * sensitev.
 */

public class CRect extends Rect
{
	public CRect(CRect rect)
	{
		super(rect);
	}

	public CRect(float x, float y)
	{
		super(x, y);
	}

	public CRect(float x, float y, float w, float h)
	{
		super(x, y, w, h);
	}

	public final boolean isCollision(CRect other)
	{
		int x = Math.round(this.x);
		int y = Math.round(this.y);
		int w = Math.round(this.w);
		int h = Math.round(this.h);

		int xo = Math.round(other.getX());
		int yo = Math.round(other.getY());
		int wo = Math.round(other.getW());
		int ho = Math.round(other.getH());

		Rectangle r1 = new Rectangle(xo, yo, wo, ho);
		Rectangle r2 = new Rectangle(x, y, w, h);

		return r1.intersects(r2);
	}
}
