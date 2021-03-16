package tools.circle;

/**
 * The Circle class is a data holder holdable values are x, y and radius. All
 * thre values can be get and set with their getters and setter.
 * 
 * The default values for x and y are 0. However the default value for r is 10.
 */

public class Circle
{
	private int x, y, r = 10;

	public Circle(int x, int y)
	{
		setX(x);
		setY(y);
	}

	public Circle(int x, int y, int r)
	{
		setX(x);
		setY(y);
		setR(r);
	}

	public final int getX()
	{
		return x;
	}

	public final int getY()
	{
		return y;
	}

	public final int getR()
	{
		return r;
	}

	public final void setX(int x)
	{
		this.x = x;
	}

	public final void setY(int y)
	{
		this.y = y;
	}

	public final void setR(int r)
	{
		this.r = r;
	}

}
