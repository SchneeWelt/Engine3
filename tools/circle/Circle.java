package tools.circle;

/**
 * The Circle class is a data holder holdable values are x, y and radius. All
 * thre values can be get and set with their getters and setter.
 * 
 * The default values for x and y are 0. However the default value for r is 10.
 */

public class Circle
{
	protected int x, y, r = 10;
	
	/* clone constructor */
	public Circle(Circle circle)
	{
		setX(circle.getX());
		setY(circle.getY());
		setR(circle.getR());
	}

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

	/**
	 * The IncrementX method will add the incrementX value to the current x value of
	 * this circle.
	 * 
	 * @param incrementX
	 */

	public final void incrementX(int incrementX)
	{
		setX(getX() + incrementX);
	}

	/**
	 * The IncrementY method will add the incrementY value to the current y value of
	 * this circle.
	 * 
	 * @param incrementY
	 */

	public final void incrementY(int incrementY)
	{
		setY(getY() + incrementY);
	}

	/**
	 * The IncrementR method will add the incrementR value to the current r value of
	 * this circle.
	 * 
	 * @param incrementR
	 */

	public final void incrementR(int incrementR)
	{
		setR(getR() + incrementR);
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
