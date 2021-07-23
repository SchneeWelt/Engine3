package tools;

import java.util.Random;

public class Randoms
{
	private Random r = new Random();

	/**
	 * @param rightBound
	 * @return
	 */
	
	public final float randomFloat(float rightBound)
	{
		return r.nextFloat() * rightBound;
	}
	
	/**
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	
	public final float randomFloat(float leftBound, float rightBound)
	{
		return leftBound + (r.nextFloat() * (rightBound - leftBound));
	}
	
	/**
	 * returns a random double between 0 and rightBorder (inclusive)
	 * 
	 * @param rightBound
	 * @return
	 */

	public final double randomDouble(double rightBound)
	{
		return r.nextDouble() * rightBound;
	}

	/**
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */

	public final double randomDouble(double leftBound, double rightBound)
	{
		return leftBound + (r.nextDouble() * (rightBound - leftBound));
	}

	/**
	 * @param rightBorder
	 * @return
	 */

	public final int randomInt(int rightBorder)
	{
		return r.nextInt(rightBorder);
	}

	/**
	 * @param leftBorder 
	 * @param rightBorder
	 * @return
	 */

	public final int randomInt(int leftBorder, int rightBorder)
	{
		int d = rightBorder - leftBorder;
		return r.nextInt(d) + leftBorder;
	}

	/**
	 * @return
	 */

	public boolean randomBoolean()
	{
		return r.nextBoolean();
	}
}
