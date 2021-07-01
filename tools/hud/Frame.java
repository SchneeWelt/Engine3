package tools.hud;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import in.Draw;
import tools.rect.Rect;

/**
 * This is not a frame to display stuff on but a frame to suround a element.
 * Frame color as well as the strokeSize of the frame can be changed.
 */

public class Frame implements Draw
{
	private int strokeSize = 4;

	private Rect location;
	private Color frameColor;

	public Frame(Rect location)
	{
		this.location = location;

		frameColor = Color.gray;
	}

	public Frame(Rect location, Color frameColor)
	{
		this.location = location;
		this.frameColor = frameColor;
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		/* display bounds */
		graphics.setColor(frameColor);
		graphics.setStroke(new BasicStroke(strokeSize));

		float x1 = location.getX();
		float y1 = location.getY();
		float x2 = location.getX() + location.getW();
		float y2 = location.getY() + location.getH();

		line(x1, y1, x2, y1, graphics);
		line(x1, y2, x2, y2, graphics);

		line(x1, y1, x1, y2, graphics);
		line(x2, y1, x2, y2, graphics);
	}

	private final void line(float x1, float y1, float x2, float y2, Graphics2D graphics)
	{
		graphics.drawLine(Math.round(x1), Math.round(y1), Math.round(x2), Math.round(y2));
	}

	public int getStrokeSize()
	{
		return strokeSize;
	}

	public void setStrokeSize(int strokeSize)
	{
		this.strokeSize = strokeSize;
	}

	public Color getFrameColor()
	{
		return frameColor;
	}

	public void setFrameColor(Color frameColor)
	{
		this.frameColor = frameColor;
	}

	public final Rect getLocation()
	{
		return location;
	}

	public final void setLocation(Rect location)
	{
		this.location = location;
	}
}
