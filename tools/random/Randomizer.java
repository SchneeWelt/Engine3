package tools.random;

import java.util.Random;

/**
 * The Randomizer class creates random values. Different methods are given.
 * 
 */

public class Randomizer
{
	/**
	 * returns a random int between 0 and rightBorder(inclusive)
	 * 
	 * @param rightBorder
	 * @return
	 */

	public final int random(int rightBorder)
	{
		return new Random().nextInt(rightBorder + 1);
	}

	/**
	 * returns a random value between the right and the left border.
	 * 
	 * @param leftBorder  inclusive
	 * @param rightBorder inclusive
	 * @return
	 */

	public final int random(int leftBorder, int rightBorder)
	{
		int dist = rightBorder + 1 - leftBorder;
		return new Random().nextInt(dist) + leftBorder;
	}

	/**
	 * returns a true or false value with every new method call
	 * 
	 * @return
	 */

	public boolean random()
	{
		return new Random().nextBoolean();
	}
}
