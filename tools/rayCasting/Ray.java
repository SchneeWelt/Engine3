package tools.rayCasting;

import tools.rect.Rect;

public class Ray
{
	private Rect location;
	private Rect direction;

	public Ray(Rect location, Rect direction)
	{
		this.location = location;
		this.direction = direction;
	}

	/**
	 * Gibt ein Rect[] zurück auf 0 ist der erste Schnittpunkt auf x und y
	 * gespeichert, auf 1 ist der zweite Schnittpunkt - ebenfalls auf x und y -
	 * gespeichert. Wurde kein Schnittpunkt gefunden, wird an besagten Stellen im
	 * Array null eingetragen.
	 * 
	 * @param b
	 * @return
	 */

	public final Rect[] cast(Boundary b)
	{
		/* restliche Wtartwerte bestimmen */
		float rad = b.getR();
		Rect M = b.getM();

		/*
		 * Ansatz: ((location.x-M.x) + r(direction.x))² + ((location.y-M.y) + r(direction.y))² = radius²
		 */

		/* rechnung */
		float s1 = location.getX() - M.getX();
		float s2 = location.getY() - M.getY();
		float s3 = s1 * s1;
		float s4 = s2 * s2;
		float s5 = s3 + s4;
		float s6 = s5 - (rad * rad);

		float i1 = (s1 * direction.getX()) * 2;
		float i2 = (s2 * direction.getY()) * 2;
		float i3 = i1 + i2;

		float q1 = direction.getX() * direction.getX();
		float q2 = direction.getY() * direction.getY();
		float q3 = q1 + q2;

		/* skalar deklarieren */
		Rect skalar = null;

		/* skalar berechnen */
		skalar = solveQuadraticEquation(q3, i3, s6);

		/* solution deklarieren */
		Rect[] solution = new Rect[] { new Rect(), new Rect() };

		/* operations aufsicht */
		boolean computeFirstSolution = true;
		boolean computeSecondSolution = true;

		/* NaN validation and infinity validation */
		Float z1 = skalar.getX();
		Float z2 = skalar.getY();

		/* negative und nicht mögliche Werte streichen */
		if (skalar.getX() < 0 | z1.isNaN() | z1.isInfinite())
			computeFirstSolution = false;
		if (skalar.getY() < 0 | z2.isNaN() | z2.isInfinite())
			computeSecondSolution = false;

		/* schnittpunkte berechnen */
		if (computeFirstSolution)
		{
			solution[0].setX(location.getX() + skalar.getX() * direction.getX());
			solution[0].setY(location.getY() + skalar.getX() * direction.getY());
		} else
			solution[0] = null;

		if (computeSecondSolution)
		{
			solution[1].setX(location.getX() + skalar.getY() * direction.getX());
			solution[1].setY(location.getY() + skalar.getY() * direction.getY());
		} else
			solution[1] = null;

		/* ergebniss zurückgeben */
		return solution;
	}

	/**
	 * Der wert direction muss mindestens ein atribut haben, dass nicht 0 ist. Also
	 * direction.x = 0 und direction.y = 0 ist verboten.
	 * 
	 * @param direction
	 */

	public final void lookAt(Rect direction)
	{
		if (direction.getX() == 0 && direction.getY() == 0)
			System.out.println("[Error] direction is a 0 vektor!");

		this.direction = direction;
	}

	/**
	 * Darstellung: x1*x² + x2 * x + x3
	 * 
	 * @param x1
	 * @param x2
	 * @param x3
	 * @return
	 */

	private final Rect solveQuadraticEquation(float x1, float x2, float x3)
	{
		Rect solution = null;

		if (x1 == 0)
		{
			System.out.println("[Error] x1 is equal to 0!");
			return solution;
		}

		if (x1 != 1)
		{
			x2 /= x1;
			x3 /= x1;
		}

		float p = x2;
		float q = x3;
		float g1 = -p / 2;
		float g2 = (float) Math.sqrt((p / 2) * (p / 2) - q);

		solution = new Rect(g1 + g2, g1 - g2);
		return solution;
	}

	public final Rect getLocation()
	{
		return location;
	}

	public final Rect getDirection()
	{
		return direction;
	}
}
