package objects.hud.hudElement.textDisplay.page.letter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import objects.hud.HUD;
import objects.hud.hudElement.HUDElement;
import tools.rect.Rect;

/**
 * Zeigt genau einen Character auf der gegebenen location an. Die Breite und
 * Höhe ist immer gleich, der Konstruktor Vektor 'location' kann diese Werte
 * ebenfalls nicht beeinflussen.
 * 
 * Der Location Vektor beschreibt eine Box, der anzuzeigende Character ist in
 * diesem Zentriert.
 * 
 * Das Letter Objekt zeit genau einen Buchstaben oder eine Zahl an. Methoden zum
 * hervorheben von diesem sind ebenfalls vorhanden.
 */

public class Letter extends HUDElement
{
	private boolean letterSelected = false;
	private final int innerStrokeSize = 1;
	private boolean displayOutline = false;

	public static final int LETTER_SIZE_X = 12;
	public static final int LETTER_SIZE_Y = 24;

	protected Character character = ' ';
	private Color highlight = new Color(0, 0, 0, 25);
	private Font font = new Font("Consolas", Font.BOLD, 13);

	/**
	 * KopyConstructor: Erzeugt eine exakte Kopie eines anderen Letter objektes
	 * 
	 * @param character
	 * @param hud
	 * @param location
	 */

	public Letter(Letter letter)
	{
		super(letter.hud, letter.location);
		setup(letter.hud, letter.location);
		this.character = letter.character;

		letterSelected = letter.isLetterSelected();
		displayOutline = letter.isDisplayOutline();
	}

	/**
	 * Erzeugt ein Letter objet, bei dem der Character vordefniert werden kann.
	 * 
	 * @param character
	 * @param hud
	 * @param location
	 */

	public Letter(Character character, HUD hud, Rect location)
	{
		super(hud, location);
		setup(hud, location);
		this.character = character;
	}

	/**
	 * Erzeugt ein Letter objekt, bei dem der Character nicht vordefiniert werden
	 * kann.
	 * 
	 * @param hud
	 * @param location
	 */

	public Letter(HUD hud, Rect location)
	{
		super(hud, location);
		setup(hud, location);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);
		displayLetter(graphics);
		displayHighlight(graphics);
	}

	@Override
	protected void displayOutline(Graphics2D graphics)
	{
		if (!displayOutline)
			return;

		graphics.setColor(Color.red);
		graphics.setStroke(new BasicStroke(innerStrokeSize));
		graphics.drawRect(location.getX(), location.getY(), location.getW(), location.getH());
	}

	public final void selectLetter()
	{
		this.letterSelected = true;
	}

	public final void unSelectLetter()
	{
		this.letterSelected = false;
	}

	/**
	 * Ändert den Character, welchen dieses Letter objekt anzeigt
	 * 
	 * @param newCharacter
	 */

	public final void changeCharacter(char newCharacter)
	{
		this.character = newCharacter;
	}

	/**
	 * Ließt das Character objekt dieses Letter objektes aus und gibt dieses zurück.
	 * 
	 * @return
	 */

	public final Character readCharacter()
	{
		return character;
	}

	protected void displayHighlight(Graphics2D graphics)
	{
		if (!isLetterSelected())
			return;

		graphics.setColor(highlight);
		graphics.fillRect(location.getX(), location.getY(), location.getW(), location.getH());

	}

	protected void displayLetter(Graphics2D graphics)
	{
		if (character == null)
			return;

		int rawPositionX = location.getX() + location.getW() / 2;
		int rawPositionY = location.getY() + location.getH() / 2;

		int charSize = graphics.getFontMetrics().stringWidth(character + "");

		int xCenter = rawPositionX - charSize / 2;
		int yCenter = rawPositionY + charSize / 2;

		xCenter -= innerStrokeSize;
		yCenter += innerStrokeSize;

		graphics.setFont(font);
		graphics.setColor(outlineColor);
		graphics.drawString(character + "", xCenter, yCenter);
	}

	private final void setup(HUD hud, Rect location)
	{
		location.setW(Letter.LETTER_SIZE_X);
		location.setH(Letter.LETTER_SIZE_Y);
	}

	public final boolean isDisplayOutline()
	{
		return displayOutline;
	}

	public final boolean isLetterSelected()
	{
		return letterSelected;
	}
}
