package objects.abstracts;

public class Vector
{
	private float[] values;

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
	 * @param decrement
	 * @param index
	 */

	public final void decrement(float decrement, int index)
	{
		values[index] -= decrement;
	}

	/**
	 * @param increment
	 * @param index
	 */

	public final void increment(float increment, int index)
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

	public final void set(float[] values)
	{
		for (int i = 0; i < this.values.length; i++)
			this.values[i] = values[i];
	}

	public final void set(float value, int index)
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
