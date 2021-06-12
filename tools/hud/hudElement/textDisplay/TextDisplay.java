package tools.hud.hudElement.textDisplay;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import tools.background.BetterBackground;
import tools.hud.HUD;
import tools.hud.hudElement.HUDElement;
import tools.hud.hudElement.button.Button;
import tools.hud.hudElement.button.ButtonEvent;
import tools.hud.hudElement.button.OnButtonClick;
import tools.hud.hudElement.textDisplay.page.Page;
import tools.hud.hudElement.textDisplay.page.PageFactory;
import tools.hud.hudElement.textDisplay.page.letter.Letter;
import tools.hud.hudElement.textDisplay.page.line.Line;
import tools.rect.Rect;

/**
 * Das Text Display kann buchstaben anzeigen, so dass text lesbar wird.
 * 
 * Wird der Wert transparent auf true gesetzt, so wird nur noch der Eigentliche
 * Text angezeigt, objekte, wie der Hintergrund fallen weg, auch die TextDisplay
 * umrandung ist betroffen.
 * 
 * Ein TextDisplay speichert seine Buchstaben auf einem Page obejekt. Das Page
 * objekt ist eine Liste aus Buchstaben und Zeilen, jeder Buchstabe ist dabei
 * bereits bei Initialisierung des Page objektes existent.
 */

public class TextDisplay extends HUDElement implements OnButtonClick
{
	private final int lineOffset = 2;
	private boolean transparent = false;
	private int thisPosition = 0;

	private Page page;
	protected Cursor cursor;
	private Button selector;
	private BetterBackground background;
	private TextDisplayCoordinator textDisplayCoordinator;

	/**
	 * @param keepSize    true: Verändert die w und die h dimension nicht. Kann
	 *                    dafür sorgen, dass Charakter außerhalb des TextDisplays
	 *                    angezeigt werden. false: eine w von 1 bedeutet, dass in x
	 *                    richtung genau ein charakter erezugt werden soll. h wirkt
	 *                    dann für die y achse. Die Breite und Höhe des Textdisplays
	 *                    werden dann automatisch angepasst.
	 * @param message
	 * @param location    Syntax: x und y entsprechen dem Punkt, auf dem das
	 *                    TextDisplay gesetzt werden soll. Der W und H wert ist die
	 *                    Anzahl an anzeigbaren Charactern in die x und die y achsen
	 *                    richtung. Der Wert muss mindestens 1 für beide sein. Die
	 *                    Zahl eins würde dann bedeuten, dass genau ein Character in
	 *                    dem TextFeld angezeigt werden kann. Ist der keepSize auf
	 *                    true, wird die w und die h dimension nicht verändert!
	 * @param hud
	 * @param transparten true: Zeigt objekte wie den Hintergrund nicht an und
	 *                    fokusiert sich nur auf das anzeigen des Textes.
	 * 
	 */

	public TextDisplay(boolean tranparent, boolean keepSize, Rect location, HUD hud)
	{
		super(hud, mapLocation(keepSize, location));
		setTransparent(tranparent);
		setup();
	}

	/**
	 * @param keepSize true: Verändert die w und die h dimension nicht. Kann dafür
	 *                 sorgen, dass Charakter außerhalb des TextDisplays angezeigt
	 *                 werden. false: eine w von 1 bedeutet, dass in x richtung
	 *                 genau ein charakter erezugt werden soll. h wirkt dann für die
	 *                 y achse. Die Breite und Höhe des Textdisplays werden dann
	 *                 automatisch angepasst.
	 * @param message
	 * @param location Syntax: x und y entsprechen dem Punkt, auf dem das
	 *                 TextDisplay gesetzt werden soll. Der W und H wert ist die
	 *                 Anzahl an anzeigbaren Charactern in die x und die y achsen
	 *                 richtung. Der Wert muss mindestens 1 für beide sein. Die Zahl
	 *                 eins würde dann bedeuten, dass genau ein Character in dem
	 *                 TextFeld angezeigt werden kann. Ist der keepSize auf true,
	 *                 wird die w und die h dimension nicht verändert!
	 * @param hud
	 */

	public TextDisplay(boolean keepSize, Rect location, HUD hud)
	{
		super(hud, mapLocation(keepSize, location));
		setup();
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);

		/* background layer */
		if (!transparent)
			background.draw(graphics);

		/* foreground layer */
		selector.draw(graphics);
		displayMessage(graphics);
	}

	@Override
	public void onButtonClick(ButtonEvent e)
	{
		/* erlaube nun auf diesem textDisplay zu schreiben */
		textDisplayCoordinator.changeTextDisplay(thisPosition);
	}

	/**
	 * Gibt den Inhalt des TextDisplay objektes als String zurück. Zeilenumbrüche
	 * gehen dabei verloren.
	 */

	@Override
	public String toString()
	{
		String result = "";

		ArrayList<Line> lines = readLines();

		for (Line line : lines)
		{
			for (Letter letter : line.letters())
			{
				char tempCharacter = letter.readCharacter();
				result += tempCharacter + "";
			}
		}

		return result;
	}

	@Override
	protected void displayOutline(Graphics2D graphics)
	{
		if (!transparent)
			super.displayOutline(graphics);
	}

	/**
	 * Ändert einen Character c auf dem TextDisplay in Zeile line und Ziffer letter.
	 * Das Letter objekt wird dabei nicht verändert, lediglich der Character des
	 * Letter Objektes wird mit dem newCharacter wert überschrieben.
	 * 
	 * Wenn diese Methode einen null pointer wirft, bedeutet das hier meistens, dass
	 * auf einen Character zugegriffen wurde, der nicht in der liste enthalten ist.
	 * Beispieleweise list.size() = 20 -> list.get(22) ist ein null pointer.
	 * 
	 * @param line
	 * @param letter
	 * @param newCharacter
	 */

	public final void changeCharacter(char newCharacter, int line, int letter)
	{
		page.readLine(line).readLetter(letter).changeCharacter(newCharacter);
	}

	/**
	 * Ein Character wird gelöscht.Das bedeutet, dass der Character eines Letter
	 * objektes auf den space character geändert wird. Das Letter objekt wird also
	 * nicht aus dem Page objekt entfernt!
	 * 
	 * @param line
	 * @param letter
	 */

	public final void deleteCharacter(int line, int letter)
	{
		page.readLine(line).readLetter(letter).changeCharacter(' ');
	}

	/**
	 * Gibt das Letter objekt in Zeile line und Ziffer letter zurück.
	 * 
	 * @param line
	 * @param letter
	 * @return
	 */

	public final Letter readLetter(int line, int letter)
	{
		return page.readLine(line).readLetter(letter);
	}

	/**
	 * Schreibt alle Zeilen aus dem input Parameter in dieser Form in das zugrunde
	 * liegende TextDisplay objekt. Die Zeilen müssen dafür so lang sein, wie dieses
	 * Page objekt es erlaubt. Längere Zeilen werden Fehler erzeugen.
	 * 
	 * @param lines: Eine ArrayList aus Line objekten
	 */

	public final void writeLines(ArrayList<Line> lines)
	{
		/*
		 * in dieser Methode fehlt die übergangs verwaltung von einer auf die nächste
		 * Zeile, falls die vorheriege Zeile zu lang war
		 */

		int index = 0;
		for (Line line : lines)
		{
			/* breche ab, wenn das ende aller zeilen erreicht ist */
			if (!page.checkLine(index))
				break;

			writeLine(index, line);
			index++;
		}
	}

	/**
	 * Schreib den String allLines in das TextDisplay. Dabei wird davon ausgegangen,
	 * dass das TextDisplay objekt komplett mit line und letter objekten gefüllt
	 * ist.
	 * 
	 * @param allLines
	 */

	public final void writeLines(String allLines)
	{
		ArrayList<Line> lines = readLines();

		for (int i = 0; i < lines.size(); i++)
		{
			Line line = lines.get(i);

			for (int m = 0; m < line.size(); m++)
			{
				int positionInString = i * 10 + m;

				if (allLines.length() <= positionInString)
					break;

				line.readLetter(m).changeCharacter(allLines.charAt(positionInString));
			}
		}
	}

	public final void writeLine(int lineIndex, Line line)
	{
		page.changeLine(lineIndex, line);
	}

	/**
	 * Tauscht ein Letter objekt in Zeile line auf Ziffer letter mit einem anderen
	 * Letter objekt, newLetter.
	 * 
	 * @param line
	 * @param letter
	 * @param newLetter
	 */

	public final void changeLetter(int line, int letter, Letter newLetter)
	{
		page.readLine(line).changeLetter(letter, newLetter);
	}

	/**
	 * Liest den kompletten Text aus dem TextDisplay aus und gibt ihn als Liste von
	 * Line objekten zurück. Das erste Objekt aus der Liste ist die erste Zeile des
	 * urpsrünglichen Inhaltes dieses TextDisplays.
	 * 
	 * @return
	 */

	public final ArrayList<Line> readLines()
	{
		return page.lines();
	}

	/**
	 * Gibt die Zeile auf der Position index aus dem zurgrunde liegenden Page objekt
	 * zurück.
	 * 
	 * @return
	 */

	public final Line readLine(int index)
	{
		return page.lines().get(index);
	}

	/**
	 * Gibt dem Letter objekt in Zeile line auf Ziffer letter bekannt, dass es sich
	 * hervorheben soll.
	 * 
	 * Bricht den Vorgang ab, wenn kein Letter objekt auf Zeile line und Ziffer
	 * letter existiert.
	 * 
	 * @param line
	 * @param letter
	 */

	public final void highlightCharacter(int line, int letter)
	{
		if (line > getMaxLines())
			return;

		if (letter > getMaxLettersPerLine())
			return;

		page.readLine(line).readLetter(letter).selectLetter();
	}

	/**
	 * Gibt dem Letter objekt in Zeile line auf Ziffer letter bekannt, dass es sich
	 * nicht mehr hervorheben soll. Ist das Letter objekt ohnehinn nicht
	 * hervorgehoben, passiert nichts.
	 * 
	 * Bricht den Vorgang ab, wenn kein Letter objekt auf Zeile line und Ziffer
	 * letter existiert.
	 * 
	 * @param line
	 * @param letter
	 */

	public final void undoCharacterHighlight(int line, int letter)
	{
		if (line > getMaxLines())
			return;

		if (letter > getMaxLettersPerLine())
			return;

		page.readLine(line).readLetter(letter).unSelectLetter();
	}

	/**
	 * Gibt die letzte Zeile zurück. Mit dem Zählen wird dabei nicht bei 0, sondern
	 * bei 1 begonnen. Sprich, wird eine 1 zurückgeben, so handelt es sich um die
	 * erste Zeile auf dem Page objekt. Die erste Zeile ist die oberste Zeile des
	 * TextDisplay objektes.
	 */

	public final int totalLines()
	{
		return page.totalLines();
	}

	/**
	 * Findet heraus, ob ein Letter objekt auf Zeile line und Ziffer letter
	 * existiert. Ist dem so, wird true zurückgegeben.
	 * 
	 * @param line
	 * @param letter
	 * 
	 * @return
	 */

	public final boolean available(int line, int letter)
	{
		boolean state = true;

		if (line < page.getMinLines())
			state = false;

		if (line > page.getMaxLines())
			state = false;

		if (letter < page.getMinLettersPerLine())
			state = false;

		if (letter > page.getMaxLettersPerLine())
			state = false;

		return state;

	}

	private final void displayMessage(Graphics2D graphics)
	{
		for (Line l : page.lines())
			for (Letter c : l.letters())
				c.draw(graphics);
	}

	private final void connectTextDisplayCoordinator()
	{
		textDisplayCoordinator = hud.getTextDisplayCoordinator();
	}

	private final void addTextDisplayCoordinator()
	{
		thisPosition = textDisplayCoordinator.getLastTextDisplayAdded();
		textDisplayCoordinator.addTextDisplay(this);
	}

	private final void createPage()
	{
		float xStart = location.getX() + Letter.LETTER_SIZE_X;
		float yStart = location.getY() + Letter.LETTER_SIZE_Y;
		PageFactory pageFactory = new PageFactory(lineOffset, (int) xStart, (int) yStart, cursor, location, hud);

		page = pageFactory.getPage();
	}

	private final void createCursor()
	{
		cursor = new Cursor(this);
	}

	private final void createBackground()
	{
		background = new BetterBackground(location, Color.black);
	}

	/**
	 * Wird in allen Konstruktoren aufgerufen.
	 */

	private final void setup()
	{
		createCursor();
		createPage();
		createSelector();
		createBackground();
		connectTextDisplayCoordinator();
		addTextDisplayCoordinator();
	}

	private final void createSelector()
	{
		selector = new Button("selector", this, location, hud);
		selector.setTransparent(true);
	}

	private static final Rect mapLocation(boolean keepSize, Rect location)
	{
		if (!keepSize)
		{
			location.setW(Letter.LETTER_SIZE_X * location.getW());
			location.setH(Letter.LETTER_SIZE_Y * location.getH());
		}

		return location;
	}

	public final void setTransparent(boolean transparent)
	{
		this.transparent = transparent;
	}

	/**
	 * Gibt die Maximal erlaubt anzahl an Letter Objekten pro Zeile aus dem momentan
	 * ausgewählten Page objekt zurück.
	 * 
	 * @return
	 */

	public final int getMaxLettersPerLine()
	{
		return page.getMaxLettersPerLine();
	}

	/**
	 * Gibt die minimal erlaubte anzahl an Letter Objekten pro Zeile aus dem
	 * momentan ausgewählten Page objekt zurück.
	 * 
	 * @return
	 */

	public final int getMinLettersPerLine()
	{
		return page.getMinLettersPerLine();
	}

	/**
	 * Gibt die Anzahl an Zeilen in diesem TextDisplay objekt zurück
	 * 
	 * @return
	 */

	public final int getMaxLines()
	{
		return page.getMaxLines();
	}

	public final int getMinLines()
	{
		return page.getMinLines();
	}
}
