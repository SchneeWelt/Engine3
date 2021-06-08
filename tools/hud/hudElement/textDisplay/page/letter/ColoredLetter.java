package objects.hud.hudElement.textDisplay.page.letter;

import java.awt.Color;
import java.awt.Graphics2D;

import objects.hud.HUD;
import tools.Background;
import tools.rect.Rect;

/**
 * Ein Letter Objekt mit einem farblichen hintergrund. Die HintergrundFarbe
 * ist über den Konstruktor, sowie einem Setter verstellbar.
 */

public class ColoredLetter extends Letter
{
	private Background background;

	public ColoredLetter(Color backgroundColor, Character c, HUD hud, Rect location)
	{
		super(c, hud, location);
		background = new Background(location, backgroundColor);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);
		background.draw(graphics);
	}
	
	public final void setBackgroundColor(Color backgroundColor)
	{
		background.setBackgroundColor(backgroundColor);
	}
}
