package objects.hud.hudElement.textDisplay.page.letter;

import java.awt.Graphics2D;

import objects.database.ABC;
import objects.hud.HUD;
import tools.random.Randomizer;
import tools.rect.Rect;

public class RandomLetter extends Letter
{
	private ABC abc = new ABC();
	private Randomizer random = new Randomizer();

	public RandomLetter(Character c, HUD hud, Rect location)
	{
		super(c, hud, location);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);
		hackerBackground();
	}
	
	private final void hackerBackground()
	{
		int i = random.random(0, new ABC().getABC().size());
		
		i %= abc.getABC().size();
		
		super.character = abc.getABC().get(i);
	}
}
