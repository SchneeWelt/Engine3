package tools.background;

import java.awt.Color;
import java.awt.Graphics2D;

import globalValues.Globals;
import in.Draw;
import tools.rect.VRect;

/**
 * In a nutshel the Background class is a black Rect which is as big as the
 * screen. Therefore, it is possible to overpaint old frames so that animations
 * like character movements can be made posible.
 */

public class Background implements Draw
{
	private VRect rect = buildBackground();

	@Override
	public void draw(Graphics2D graphics)
	{
		rect.draw(graphics);
	}

	private VRect buildBackground()
	{
		int x = 0;
		int y = 0;
		int w = Globals.SCREEN_DIMENSION.getRoundW();
		int h = Globals.SCREEN_DIMENSION.getRoundH();

		return new VRect(x, y, w, h, Color.black);
	}
}
