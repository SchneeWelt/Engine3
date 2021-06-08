package tools.hud;

import java.awt.Graphics2D;

import in.Draw;
import tools.background.Background;
import tools.hud.hudElement.textDisplay.TextDisplayCoordinator;

public class HUD implements Draw
{
	private Background background;
	private TextDisplayCoordinator textDisplayCoordinator;

	public HUD()
	{
		background = new Background();
		textDisplayCoordinator = new TextDisplayCoordinator();
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		/* background layer */
		background.draw(graphics);

		/* foreground layer */
	}

	public TextDisplayCoordinator getTextDisplayCoordinator()
	{
		return textDisplayCoordinator;
	}
}
