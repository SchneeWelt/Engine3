package objects.hud.hudElement.textDisplay.page;

import objects.hud.HUD;
import objects.hud.hudElement.textDisplay.Cursor;
import objects.hud.hudElement.textDisplay.page.letter.ExtendetLetter;
import objects.hud.hudElement.textDisplay.page.letter.Letter;
import objects.hud.hudElement.textDisplay.page.line.Line;
import tools.rect.Rect;

/**
 * Bereitet ein Page objekt für seine Verwendung vor. Sobal eine Instanz dieser
 * Klasse erzeugt wurde, kann von dem zugrunde liegenden Objekt ein Page objekt
 * bezogen werden.
 * 
 * @param xStart
 * @param yStart
 * @param cursor
 */

public class PageFactory
{
	private int lineOffset = 2;

	private HUD hud;
	private Page page;
	private Rect location;

	public PageFactory(int lineOffset, int xStart, int yStart, Cursor cursor, Rect textDisplayLocation, HUD hud)
	{
		this.hud = hud;
		this.page = new Page();
		this.lineOffset = lineOffset;
		this.location = new Rect(textDisplayLocation);

		/*
		 * Gibt den Start für den Aufruf mehrerer Methoden, die zusammen das Page objekt
		 * für die verwendung vorbereiten.
		 */

		setupLines(xStart, yStart, 0, cursor);
	}

	/**
	 * Die Methdoe funktiniert gerade so, dass auf dem gesamten Page objekt bereits
	 * alle line und somit alle Letter objekte vor erzeugt werden.
	 * 
	 * @param x
	 * @param y
	 * @param line
	 * @param cursor
	 */

	private final void setupLines(int x, int y, int line, Cursor cursor)
	{
		/* funktion */
		/* dise Zeile soll eigentlich weg */
		page.appendLine();

//		int minLine = page.getMinLines();
//		if (line == minLine)
//		{
//			page.appendLine();
//			Line l = page.readLine(minLine);
//			Letter letter = new Letter(hud, new Rect(x, y));
//			l.appendLetter(letter);
//		}

		setupLine(x, y, line, 0, cursor);

		/* abbruch steuerung */
		int border = location.getY() + location.getH() - Letter.LETTER_SIZE_Y;
		if (y < border)
		{
			setupLines(x, y + Letter.LETTER_SIZE_Y + lineOffset, line += 1, cursor);
		} else if (y >= border)
		{
			/* diese zeile soll eigentlich weg */
			page.deleteLastLine();

			page.setMaxLines(line - 1);
			return;
		}
	}

	private final void setupLine(int x, int y, int line, int letter, Cursor cursor)
	{
		/*
		 * Dieser block soll eigentlich weg
		 * 
		 */
		Line l = page.readLine(line);
		ExtendetLetter le = new ExtendetLetter(line, letter, cursor, hud, new Rect(x, y));
		l.appendLetter(le);

		int border = location.getX() + location.getW() - Letter.LETTER_SIZE_X;

		if (x < border)
			setupLine(x += Letter.LETTER_SIZE_X, y, line, letter += 1, cursor);
		else if (x >= border)
		{
			/* diese Zeile soll eigentlich weg */
			page.readLine(line).deleteLastLetter();

			page.setMaxLettersPerLine(letter - 1);
			return;
		}
	}

	public final Page getPage()
	{
		return page;
	}
}
