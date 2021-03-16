package tools.rect;

/**
 * The Rect class is a blue print for a data holder. It can hold x,y, width and
 * height values. All of those are from the data type int. The default for x and
 * y is 0 the default for w and h however, is 10.
 *
 */

public class Rect
{
	private int x, y, w = 10, h = 10;

	public Rect(int x, int y)
	{
		setX(x);
		setY(y);
	}

	public Rect(int x, int y, int w, int h)
	{
		setX(x);
		setY(y);
		setW(w);
		setH(h);
	}

	public final int getX()
	{
		return x;
	}

	public final int getY()
	{
		return y;
	}

	public final int getW()
	{
		return w;
	}

	public final int getH()
	{
		return h;
	}

	public final void setX(int x)
	{
		this.x = x;
	}

	public final void setY(int y)
	{
		this.y = y;
	}

	public final void setW(int w)
	{
		this.w = w;
	}

	public final void setH(int h)
	{
		this.h = h;
	}
}
