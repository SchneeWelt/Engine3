package objects.hud.hudElement.textDisplay.page.letter;

import java.awt.Graphics2D;

import objects.hud.HUD;
import objects.hud.hudElement.button.Button;
import objects.hud.hudElement.button.ButtonEvent;
import objects.hud.hudElement.button.OnButtonClick;
import objects.hud.hudElement.textDisplay.Cursor;
import tools.rect.Rect;

public class ExtendetLetter extends Letter implements OnButtonClick
{
	private int thisLine = 0;
	private int thisLetter = 0;

	private Cursor cursor;
	private Button button;

	/**
	 * Erstellt ein ExtendetLetter objekt, bei dem der Character vordefiniert werden
	 * kann.
	 * 
	 * @param thisLine
	 * @param thisLetter
	 * @param cursor
	 * @param c
	 * @param hud
	 * @param location
	 */

	public ExtendetLetter(int thisLine, int thisLetter, Cursor cursor, Character c, HUD hud, Rect location)
	{
		super(c, hud, location);
		setup(thisLine, thisLetter, cursor);
	}

	/**
	 * Erstellt ein ExtendetLetter objekt, bei dem der Character nicht vordefiniert
	 * werden kann. Die thisLine und thisLetter werte sollen angeben, wo sich dieses
	 * Letter objekt auf dem TextDisplay befindet. Dieses wissen is beispielsweise
	 * für den Cursor wichtig.
	 * 
	 * @param thisLine
	 * @param thisLetter
	 * @param cursor
	 * @param hud
	 * @param location
	 */

	public ExtendetLetter(int thisLine, int thisLetter, Cursor cursor, HUD hud, Rect location)
	{
		super(hud, location);
		setup(thisLine, thisLetter, cursor);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);
		button.draw(graphics);
	}

	@Override
	public void onButtonClick(ButtonEvent e)
	{
		cursor.jump(thisLine, thisLetter);
	}

	private final void setup(int thisLine, int thisLetter, Cursor cursor)
	{
		this.thisLetter = thisLetter;
		this.thisLine = thisLine;
		this.cursor = cursor;

		button = new Button("BTN:2", this, location, hud);
		button.setTransparent(true);
	}
}
