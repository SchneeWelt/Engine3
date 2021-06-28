package objects.abstracts;

import tools.printer.ErrorPrinter;

/**
 * Matrix based math
 */

public class MMath
{
	/**
	 * @param matrix
	 * @param vector
	 * @return
	 */

	public final static Vector matMull(Matrix matrix, Vector vector)
	{
		if (matrix.size().getRoundH() != vector.size())
		{
			ErrorPrinter print = new ErrorPrinter();
			print.print("unvalid sizes");
			return null;
		}

		Vector result = new Vector(matrix.size().getRoundW());

		for (int i = 0; i < matrix.size().getRoundW(); i++)
		{
			float tempR = 0f;

			for (int j = 0; j < vector.size(); j++)
				tempR += matrix.get(i, j) * vector.get(j);
			
			result.set(Math.round(tempR), i);
		}

		return result;
	}
}
