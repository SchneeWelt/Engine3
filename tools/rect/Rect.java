package tools.rect;

/**
 * The Rect class is a blue print for a data holder. It can hold x,y, width and
 * height values. All of those are from the data type int. The default for x and
 * y is 0 the default for w and h however, is 1.
 *
 */

public class Rect
{
	protected int x, y, w = 1, h = 1;

	/* clone constructor */
	public Rect(Rect rect)
	{
		setX(rect.getX());
		setY(rect.getY());
		setW(rect.getW());
		setH(rect.getH());
	}
	
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
	
	@Override
	public String toString()
	{
		String output = "X:" + x;
		output += " ";
		output += "Y:" + y;
		output += " ";
		output += "W:" + w;
		output += " ";
		output += "H:" + h;
		output += "\n";
		output += "Default:" + super.toString();

		return output;
	}

	/**
	 * The IncrementX method will add the incrementX value to the current x value of
	 * this rect.
	 * 
	 * @param incrementX
	 */

	public final void incrementX(int incrementX)
	{
		setX(getX() + incrementX);
	}
	
	/**
	 * The IncrementY method will add the incrementY value to the current y value of
	 * this rect.
	 * 
	 * @param incrementY
	 */

	public final void incrementY(int incrementY)
	{
		setY(getY() + incrementY);
	}
	
	/**
	 * The IncrementW method will add the incrementW value to the current w value of
	 * this rect.
	 * 
	 * @param incrementW
	 */

	public final void incrementW(int incrementW)
	{
		setW(getW() + incrementW);
	}
	
	/**
	 * The IncrementH method will add the incrementH value to the current h value of
	 * this rect.
	 * 
	 * @param incrementH
	 */

	public final void incrementH(int incrementH)
	{
		setH(getH() + incrementH);
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getW()
	{
		return w;
	}

	public int getH()
	{
		return h;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setW(int w)
	{
		this.w = w;
	}

	public void setH(int h)
	{
		this.h = h;
	}
}
