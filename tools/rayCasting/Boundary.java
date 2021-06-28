package tools.rayCasting;

import java.awt.Color;
import java.awt.Graphics2D;

import in.Draw;
import tools.Shapes;
import tools.circle.Circle;
import tools.rect.Rect;

public class Boundary implements Draw
{
	private Circle circle;
	private Color debugColor = Color.orange;

	public Boundary(int centerX, int centerY, int radius)
	{
		circle = new Circle(centerX, centerY, radius);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		displayBoundary(graphics);
	}

	private final void displayBoundary(Graphics2D graphics)
	{
		graphics.setColor(debugColor);
		Shapes.drawCirlce(circle.getRoundX(), circle.getRoundY(), circle.getRoundR(), graphics);
	}
	
	public final float getR()
	{
		return circle.getR();
	}
	
	public final Rect getM()
	{
		return new Rect(circle.getX(), circle.getY());
	}
}
