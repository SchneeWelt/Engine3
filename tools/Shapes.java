package tools;

import java.awt.Graphics2D;

public class Shapes
{
	public static final void fillCirlce(float x, float y, float r, Graphics2D graphics)
	{
		int xp = Math.round(x);
		int yp = Math.round(y);
		int rp = Math.round(r);

		graphics.fillOval(xp - rp, yp - rp, rp * 2, rp * 2);
	}

	public static final void drawCirlce(float x, float y, float r, Graphics2D graphics)
	{
		int xp = Math.round(x);
		int yp = Math.round(y);
		int rp = Math.round(r);

		graphics.drawOval(xp - rp, yp - rp, rp * 2, rp * 2);
	}
}
