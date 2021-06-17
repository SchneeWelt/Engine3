package tools.rect;

/**
 * The Rect class is a blueprint for a data holder. It can hold x,y, width and
 * height values. All of those are of the data type int. The default for x and y
 * is 0 the default for w and h however, is 1.
 */

public class Rect
{
	protected float x, y, w = 1, h = 1;

	/* clone constructor */
	public Rect(Rect rect)
	{
		setX(rect.getX());
		setY(rect.getY());
		setW(rect.getW());
		setH(rect.getH());
	}

	public Rect()
	{
		x = 0;
		y = 0;
	}

	public Rect(float x, float y)
	{
		setX(x);
		setY(y);
	}

	public Rect(float x, float y, float w, float h)
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
		output += "Default: " + super.toString();

		return output;
	}

	/**
	 * Gibt true zurück, wenn alle Werte dieses Rect objektes mit allen Werten des
	 * anderen Rect objectes other übereinstimmen.
	 * 
	 * @param other
	 * @return
	 */

	public final boolean equal(Rect other)
	{
		return (this.x == other.getX() && this.y == other.getY() && this.w == other.getW() && this.h == other.getH());
	}

	/**
	 * The IncrementX method will add the incrementX value to the current x value of
	 * this rect.
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

	/**
	*	Gillt für x, y, w und h
	*/

	public final void collapseAll()
	{
		collapse();
		collapseW();
		collapseH();
	}

	public final void collapseW()
	{
		setW(0);
	}

	public final void collapseH()
	{ 
		setH(0);
	}
	
	public final void collapseY()
	{
		setY(0);
	}

	public final void collapseX()
	{
		setX(0);
	}

	public final void decrementX(float decrementX)
	{
		setX(getX() - decrementX);
	}

	public final void decrementY(float decrementY)
	{
		setY(getY() - decrementY);
	}

	/**
	 * The IncrementY method will add the incrementY value to the current y value of
	 * this rect.
	 * 
	 * @param incrementY
	 */

	public final void incrementY(float incrementY)
	{
		setY(getY() + incrementY);
	}

	/**
	 * The IncrementW method will add the incrementW value to the current w value of
	 * this rect.
	 * 
	 * @param incrementW
	 */

	public final void incrementW(float incrementW)
	{
		setW(getW() + incrementW);
	}

	public final void decrementW(float decrementW)
	{
		setW(getW() - decrementW);
	}

	/**
	 * The IncrementH method will add the incrementH value to the current h value of
	 * this rect.
	 * 
	 * @param incrementH
	 */

	public final void incrementH(float incrementH)
	{
		setH(getH() + incrementH);
	}

	public final void decrementH(float decrementH)
	{
		setH(getH() - decrementH);
	}

	/**
	 * Gibt ein neuen Vektor des Types Rect zurück, welcher die Länge eins
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

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

	public float getW()
	{
		return w;
	}

	public float getH()
	{
		return h;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public int getRoundX()
	{
		return Math.round(x);
	}

	public int getRoundY()
	{
		return Math.round(y);
	}

	public int getRoundW()
	{
		return Math.round(w);
	}

	public int getRoundH()
	{
		return Math.round(h);
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public void setW(float w)
	{
		this.w = w;
	}

	public void setH(float h)
	{
		this.h = h;
	}
}
