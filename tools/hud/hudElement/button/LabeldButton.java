package objects.hud.hudElement.button;

import java.awt.Graphics2D;

import objects.hud.HUD;
import objects.hud.hudElement.textDisplay.TextDisplay;
import tools.rect.Rect;

public class LabeldButton extends Button
{
	private TextDisplay textDisplay;

	public LabeldButton(String buttonId, String label, OnButtonClick onButtonClick, Rect location, HUD hud)
	{
		super(buttonId, onButtonClick, location, hud);

		textDisplay = new TextDisplay(true, true, location, hud);
		textDisplay.writeLines(label);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);
		textDisplay.draw(graphics);
	}
}
