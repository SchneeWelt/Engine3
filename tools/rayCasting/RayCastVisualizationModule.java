package tools.rayCasting;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import in.Draw;
import tools.Shapes;
import tools.rect.Rect;

/**
 * Stellt einen Ray[] grafisch dar, wenn dieser auf die übergebenen boundary
 * objecte trifft. Sollte der Ray des Ray[] oder das Boundary object des
 * Boundary[] seine position ändern, so muss die repaint() methode aufgerufen
 * werden, um die grafik dartstellung zu aktualisieren. Um überhaupt etwas sehen
 * zu können, muss die draw() methode, dieser Klasse - wie üblich - aufgerufen
 * werden.
 */

public class RayCastVisualizationModule implements Draw
{
	private ArrayList<Ray> rays;
	private Boundary boundary;
	private Rect[][] lastResults;

	public RayCastVisualizationModule(ArrayList<Ray> rays, Boundary boundary)
	{
		this.rays = rays;
		this.boundary = boundary;

		lastResults = new Rect[rays.size()][0];

		repaint();
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		/* visualize ray */
		visualizeRay(graphics);

		/* visualize boundary */
		boundary.draw(graphics);
	}

	public final void repaint()
	{
		int i = 0;

		for (Ray ray : rays)
		{
			lastResults[i] = ray.cast(boundary);
			i++;
		}
	}

	private final void visualizeRay(Graphics2D graphics)
	{
		int i = 0;
		for (Ray ray : rays)
		{
			visualizeMatchingRay(i, graphics, ray);
			i++;
		}
	}

	/**
	 * Stellt ein Ray grafisch dar, forausgesetzt, dass dieser auf ein Boundary
	 * object trifft.
	 * 
	 * @param graphics
	 */

	private final void visualizeMatchingRay(int i, Graphics2D graphics, Ray ray)
	{
		boolean useT1 = true;
		boolean useT2 = true;

		Rect t = new Rect();

		if (lastResults[i][0] == null)
			useT1 = false;
		if (lastResults[i][1] == null)
			useT2 = false;

		if (useT1 && useT2)
		{
			float distT1, distT2;
			distT1 = dist(lastResults[i][0], ray.getLocation());
			distT2 = dist(lastResults[i][1], ray.getLocation());

			if (distT1 < distT2)
				t = lastResults[i][0];
			else
				t = lastResults[i][1];
		}

		if (!useT1 && useT2)
			t = lastResults[i][1];

		if (useT1 && !useT2)
			t = lastResults[i][0];

		if (!useT1 && !useT2)
			return;

		/* visualize ray */
		graphics.setColor(Color.white);
		graphics.drawLine(t.getRoundX(), t.getRoundY(), ray.getLocation().getRoundX(), ray.getLocation().getRoundY());

		/* visualize collision point */
		graphics.setColor(Color.red);
		Shapes.fillCirlce(t.getRoundX(), t.getRoundY(), 1, graphics);
	}

	private final float dist(Rect r1, Rect r2)
	{
		float i1 = r2.getX() - r1.getX();
		float i2 = r2.getY() - r1.getY();

		return ((float) Math.sqrt(i1 * i1 + i2 * i2));
	}
}
