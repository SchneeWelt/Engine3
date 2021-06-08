package objects.hud.hudElement.textDisplay;

import java.awt.Graphics2D;

import main.Draw;
import tools.rect.Rect;

public class CharacterHighlighter implements Draw
{
	private Cursor cursor;
	private TextDisplay textDisplay;
	private Rect lastPosition = new Rect(0, 0);

	public CharacterHighlighter(TextDisplay textDisplay, Cursor cursor)
	{
		this.cursor = cursor;
		this.textDisplay = textDisplay;
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		undoLastHighlight();
		defineLastPosition();
		highleightNewCharacter();
	}
	
	private final void highleightNewCharacter()
	{
		textDisplay.highlightCharacter(cursor.getLine(), cursor.getLetter());
	}
	
	private final void defineLastPosition()
	{
		lastPosition.setY(cursor.getLine());
		lastPosition.setX(cursor.getLetter());
	}
	
	private final void undoLastHighlight()
	{
		int line = lastPosition.getY();
		int letter = lastPosition.getX();
		textDisplay.undoCharacterHighlight(line, letter);
	}
}
