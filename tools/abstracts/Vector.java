package tools.abstracts;

import java.util.ArrayList;

public class Vector
{
	private float[] values;

	public Vector(float[] values)
	{
		this.values = values;
	}

	public Vector(int length)
	{
		values = new float[length];

		collapse();
	}

	public Vector(Vector vector)
	{
		values = vector.getAll();
	}

	@Override
	public String toString()
	{
		String output = "";

		int i = 0;
		for (float f : values)
		{
			output += i + ": " + f + "\n";
			i++;
		}

		output += "" + super.toString();

		return output;
	}

	/**
	 * Copys every value of the other vector into this vector. If the other vector
	 * is longer as this vector than those values will not be copied. If the other
	 * vector is shorter than this vector then the remaining values remain
	 * unchanged.
	 * 
	 * @param other
	 */

	public final void copyValues(Vector other)
	{
		for (int i = 0; i < values.length; i++)
			set(i, other.get(i));
	}

	/**
	 * True wenn dieser Vector in allen bereichen größer ist als der andere. Der
	 * andere Vektor sollte die selbe größe wie dieser aufweisen, sonnst können
	 * fehler auftreten.
	 * 
	 * @param other
	 * @return
	 */

	public final boolean greater(Vector other)
	{
		ArrayList<Boolean> results = new ArrayList<Boolean>();

		for (int i = 0; i < size(); i++)
			results.add(this.get(i) > other.get(i));
		
		for (Boolean b : results)
			if (!b)
				return false;
		return true;
	}
	
	public boolean smaller(Vector other)
	{
		ArrayList<Boolean> results = new ArrayList<Boolean>();

		for (int i = 0; i < size(); i++)
			results.add(this.get(i) < other.get(i));
		
		for (Boolean b : results)
			if (!b)
				return false;
		return true;
	}

	public final float[] normalize()
	{
		float betrag = 0;
		for (float f : values)
			betrag += Math.sqrt(f * f);

		float[] result = new float[values.length];

		int i = 0;
		for (float f : values)
		{
			result[i] = f / betrag;
			i++;
		}

		return result;
	}

	/**
	 * @param index
	 * @param decrement
	 */

	public final void decrement(int index, float decrement)
	{
		values[index] -= decrement;
	}

	/**
	 * @param index
	 * @param increment
	 */

	public final void increment(int index, float increment)
	{
		values[index] += increment;
	}

	public final void collapse()
	{
		for (int i = 0; i < values.length; i++)
			values[i] = 0f;
	}

	public final int size()
	{
		return values.length;
	}

	/**
	 * Enters all values from the input in this vector. The input can only be as
	 * long as this vector. If it is longer or smaler than the values out of bounds
	 * wont change.
	 * 
	 * @param values
	 */

	public final void setAll(float[] values)
	{
		for (int i = 0; i < this.values.length; i++)
			this.values[i] = values[i];
	}

	public final void set(int index, float value)
	{
		values[index] = value;
	}

	public final float[] getAll()
	{
		return values;
	}

	public final float get(int index)
	{
		return values[index];
	}
}
