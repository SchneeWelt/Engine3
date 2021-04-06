package tools;

import java.awt.Color;
import java.awt.Graphics2D;

import globalValues.GlobalValue;
import main.Draw;
import tools.rect.VRect;

/**
 * In a nutshel the Background class is colored Rect wich is as big as the
 * screen. Therefore, it is possible to overpaint old frames so that animations
 * like character movements can be made posible.
 */

public class Background implements Draw
{
	private VRect body = null;

	public Background()
	{
		createBody(Color.black);
	}

	public Background(Color color)
	{
		createBody(color);
	}

	public Background(int x, int y, int w, int h, Color color)
	{
		createBody(color);
		body.setX(x);
		body.setY(y);
		body.setW(w);
		body.setH(h);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		body.draw(graphics);
	}

	private void createBody(Color color)
	{
		int x = 0;
		int y = 0;
		int w = GlobalValue.getScreenDimension().width;
		int h = GlobalValue.getScreenDimension().height;

		body = new VRect(x, y, w, h, color);
	}
}
