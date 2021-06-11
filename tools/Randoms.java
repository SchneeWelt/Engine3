package tools.random;

import java.util.Random;

public class Randoms
{
	private Random r = new Random();

	/**
	 * Returns a random float value between 0 and rightBound (inklusieve)
	 * 
	 * @param rightBound
	 * @return
	 */
	
	public final float randomFloat(float rightBound)
	{
		rightBound++;
		float leftBound = 0;
		float random = r.nextFloat();
		return leftBound + (random * (rightBound - leftBound));
	}
	
	/**
	 * Returns a random float value between the leftBound (inklusive) and the rightBound
	 * (inklusive) 
	 * 
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	
	public final float randomFloat(float leftBound, float rightBound)
	{
		rightBound++;
		float random = r.nextFloat();
		return leftBound + (random * (rightBound - leftBound));
	}
	
	/**
	 * returns a random double between 0 and rightBorder (inclusive)
	 * 
	 * @param rightBound
	 * @return
	 */

	public final double randomDouble(double rightBound)
	{
		rightBound++;
		double leftBound = 0;
		double random = r.nextDouble();
		return leftBound + (random * (rightBound - leftBound));
	}

	/**
	 * Returns a random double between the leftBound (inklusive) and the rightBound
	 * (inklusive)
	 * 
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */

	public final double randomDouble(double leftBound, double rightBound)
	{
		rightBound++;
		double random = r.nextDouble();
		return leftBound + (random * (rightBound - leftBound));
	}

	/**
	 * returns a random int between 0 and rightBorder (inclusive)
	 * 
	 * @param rightBorder
	 * @return
	 */

	public final int randomInt(int rightBorder)
	{
		return r.nextInt(rightBorder + 1);
	}

	/**
	 * returns a random value between the right and the left border.
	 * 
	 * @param leftBorder  inclusive
	 * @param rightBorder inclusive
	 * @return
	 */

	public final int randomInt(int leftBorder, int rightBorder)
	{
		int d = rightBorder + 1 - leftBorder;
		return r.nextInt(d) + leftBorder;
	}

	/**
	 * returns a true or false value with every new method call
	 * 
	 * @return
	 */

	public boolean randomBoolean()
	{
		return r.nextBoolean();
	}
}
