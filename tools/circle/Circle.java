package tools.circle;

import tools.rect.Rect;

/**
 * The Circle class is a data holder holdable values are x, y and radius. All
 * thre values can be get and set with their getters and setter.
 * 
 * The default values for x and y are 0. However the default value for r is 10.
 */

public class Circle
{
	protected float x, y, r = 10;

	/* clone constructor */
	public Circle(Circle circle)
	{
		setX(circle.getX());
		setY(circle.getY());
		setR(circle.getR());
	}
	
	public Circle()
	{
		x = 0; 
		y = 0;
	}

	public Circle(float x, float y)
	{
		setX(x);
		setY(y);
	}

	public Circle(float x, float y, float r)
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

	public final void incrementX(float incrementX)
	{
		setX(getX() + incrementX);
	}
	
	/**
	* gillt für x und y
	*/

	public final void collapse()
	{
		collapseX();
		collapseY();
	}
	
	public final void collapseY()
	{
		setY(0);
	}
	
	public final void collapseX()
	{
		setX(0);
	}

	/**
	*	Gillt für x, y und r
	*/

	public final void collapseAll()
	{
		collapse();
		collapseR();
	}

	public final void collapseR()
	{
		setR(0);
	}
	
	/**
	 * Gibt ein neuen Vektor des Types Circle zurück, welcher die Länge eins
	 * hat.
	 * 
	 * @return
	 */

	public final Rect normalize()
	{
		float newX, newY;
		float betrag = (float) Math.sqrt(this.x * this.x + this.y * this.y);

		newX = x / betrag;
		newY = y / betrag;
		Rect result = new Rect(newX, newY);

		return result;
	}

	/**
	 * The IncrementY method will add the incrementY value to the current y value of
	 * this circle.
	 * 
	 * @param incrementY
	 */

	public final void incrementY(float incrementY)
	{
		setY(getY() + incrementY);
	}

	/**
	 * The IncrementR method will add the incrementR value to the current r value of
	 * this circle.
	 * 
	 * @param incrementR
	 */

	public final void incrementR(float incrementR)
	{
		setR(getR() + incrementR);
	}

	public final void decrementY(float decrementY)
	{
		setY(getY() - decrementY);
	}
	
	public final void decrementX(float decrementX)
	{
		setX(getX() - decrementX);
	}
	
	public final void decrementR(float decrementR)
	{
		setR(getR() - decrementR);
	}

	/**
	 * Returns true when all values of the object where the method is called from
	 * are equal with the other object
	 * 
	 * @param other
	 * @return
	 */

	public final boolean equals(Circle other)
	{
		return (this.x == other.getX() && this.y == other.getY() && this.r == other.getR());
	}

	public final int getRoundX()
	{
		return Math.round(x);
	}
	
	public final int getRoundY()
	{
		return Math.round(y);
	}
	
	public final int getRoundR()
	{
		return Math.round(r);
	}
	
	public final float getX()
	{
		return x;
	}

	public final float getY()
	{
		return y;
	}

	public final float getR()
	{
		return r;
	}

	public final void setX(float x)
	{
		this.x = x;
	}

	public final void setY(float y)
	{
		this.y = y;
	}

	public final void setR(float r)
	{
		this.r = r;
	}

}
