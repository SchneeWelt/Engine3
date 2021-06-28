package objects.abstracts;

import tools.rect.Rect;

public class Matrix
{
	private Float[][] matrix;

	public Matrix(int zeilen, int spalten)
	{
		matrix = new Float[zeilen][spalten];
		
		collapse();
	}
	
	@Override
	public String toString()
	{
		String r = "";
		
		for (int i = 0; i < matrix.length; i ++)
		{
			r += i + ": ";
			
			for (float f : matrix[i])
			{
				r += f + ", ";
			}
			
			r += "\n";
		}
		
		r += super.toString();
		
		return r;
	}

	public final void collapse()
	{
		for (Float[] floats : matrix)
			for (int i = 0; i < floats.length; i++)
				floats[i] = 0f;
	}

	public final void set(int zeile, int spalte, Float value)
	{
		matrix[zeile][spalte] = value;
	}

	public final Float get(int zeile, int spalte)
	{
		return matrix[zeile][spalte];
	}

	/**
	 * @return Die größe dieser Matrix auf w -> Zeilen und h -> spalten
	 */

	public final Rect size()
	{
		Rect r = new Rect();
		r.setW(matrix.length);
		r.setH(matrix[0].length);
		return r;
	}
}
