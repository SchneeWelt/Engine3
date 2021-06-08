package objects.hud.hudElement.textDisplay;

public class Cursor
{
	private int currentLine = 0;
	private int currentLetter = 0;

	private TextDisplay connector;

	public Cursor(TextDisplay connector)
	{
		this.connector = connector;
	}

	/**
	 * Bewegt den Cursor nach links. Ist dies nicht möglich, so wird and das ende
	 * der vorheriegen Zeile gesprungen.
	 */

	public final void moveLeft()
	{
		if (!connector.available(currentLine, currentLetter - 1))
		{
			int maxLetter = connector.getMaxLettersPerLine();

			moveUp();
			jump(currentLine, maxLetter);
		} else
		{
			currentLetter--;
		}
	}

	public final void moveRight()
	{
		if (!connector.available(currentLine, currentLetter + 1))
		{
			moveDown();
			resetLetter();
		} else
		{
			currentLetter++;
		}
	}

	public final void moveUp()
	{
		if (!connector.available(currentLine - 1, currentLetter))
		{
			int maxLines = connector.getMaxLines();
			int maxLettersPerLine = connector.getMaxLettersPerLine();

			if (currentLetter == connector.getMinLettersPerLine() - 1)
			{
				jump(maxLines, maxLettersPerLine);
			} else
			{
				jump(maxLines, currentLetter);
			}
		} else
			currentLine--;
	}

	public final void moveDown()
	{
		if (!connector.available(currentLine + 1, currentLetter))
		{
			int maxLettersPerLine = connector.getMaxLettersPerLine();

			if (currentLetter == maxLettersPerLine)
			{
				resetLine();
				resetLetter();
			} else
			{
				resetLine();
			}
		} else
		{
			currentLine++;
		}
	}

	/**
	 * Springt an die gewünschte Stelle im Dokument. Die Methode kontrolliert die
	 * neue position nicht, es kann also auch außerhalb des Dokumentes gesprungen
	 * werden!
	 * 
	 * @param line
	 * @param letter
	 */

	public final void jump(int line, int letter)
	{
		this.currentLine = line;
		this.currentLetter = letter;
	}

	public final void resetLine()
	{
		currentLine = connector.getMinLines();
	}

	public final void resetLetter()
	{
		currentLetter = connector.getMinLettersPerLine();
	}

	/**
	 * @return Die line, auf der sich der cursor gerade befindet.
	 */

	public final int getLine()
	{
		return currentLine;
	}

	/**
	 * @return Die Letter, auf der sich der Cursor gerade befindet.
	 */

	public final int getLetter()
	{
		return currentLetter;
	}
}
