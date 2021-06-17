package tools;

import java.awt.Graphics2D;

public class Shapes
{
	public static final void fillCirlce(int x, int y, int r, Graphics2D graphics)
	{
		graphics.fillOval(x - r, y - r, r * 2, r * 2);
	}
	
	public static final void drawCirlce(int x, int y, int r, Graphics2D graphics)
	{
		graphics.drawOval(x - r, y - r, r * 2, r * 2);
	}
}
