package objects.hud.hudElement.textDisplay.page.line;

import java.util.ArrayList;

import objects.hud.hudElement.textDisplay.page.letter.Letter;

/**
 * Speichert n Letter objekte in einer ArrayListe. Diese ArrayListe stellt somit
 * eine Zeile text dar.
 */

public class Line
{
	private ArrayList<Letter> line = new ArrayList<Letter>();

	/**
	 * Gibt den Inhalt dieser Zeile in form eines String objektes zurück.
	 */

	@Override
	public String toString()
	{
		String result = "";
		
		for (Letter letter : line)
		{
			result += letter.readCharacter() + "";
		}
		
		return result;
	}

	/**
	 * Löscht den Inhalt dieser Line. Intern wird dabei der clear command der
	 * ArrayList für die line ausgeführt.
	 */

	public final void clearLine()
	{
		line.clear();
	}

	/**
	 * Löscht eine Letter auf stelle index innerhalb dieses Line objektes.
	 * 
	 * @param index
	 */

	public final void deleteLetter(int index)
	{
		line.remove(index);
	}

	/**
	 * Löscht die letzte letter innerhalb dieses line objektes.
	 * 
	 */

	public final void deleteLastLetter()
	{
		int lastLetter = line.size() - 1;
		line.remove(lastLetter);
	}

	/**
	 * Tauscht ein Letter objekt mit einem anderen Letter objekt, newLetter auf
	 * Stelle index innerhalb dieses Line Objektes.
	 * 
	 * @param index
	 * @param newLetter
	 */

	public final void changeLetter(int index, Letter newLetter)
	{
		line.set(index, newLetter);
	}

	/**
	 * Fügt dem Line objekt ein Letter objekt an das ende der Zeile hinzu.
	 * 
	 * @param newLetter
	 */

	public final void appendLetter(Letter newLetter)
	{
		line.add(newLetter);
	}

	/**
	 * Gibt das Letter objet auf stelle index zurück.
	 * 
	 * @param index
	 * @return
	 */

	public final Letter readLetter(int index)
	{
		return line.get(index);
	}

	/**
	 * Schaut, ob der inputParameter letterIndex innerhalb der internen Liste dieses
	 * Line objektes befindlich ist. Ist dem so, sprich kann mit dem Wert des
	 * letterIndex auf ein Objekt der liste zugegriffen werden, wird true
	 * zurückgeben.
	 * 
	 * @param letterIndex
	 * @return
	 */

	public final boolean checkLetters(int letterIndex)
	{
		return (line.size() > letterIndex);
	}

	/**
	 * Gibt die Anzahl an Letter objekten in diesem Line objekt zurück.
	 * 
	 * intern wird der size() befehl der ArrayListe aufgerufen.
	 * 
	 * @return
	 */

	public final int size()
	{
		return line.size();
	}

	/**
	 * Gibt die Liste aller Letter objekte in diesem Line objekt zurück.
	 * 
	 * @return
	 */

	public final ArrayList<Letter> letters()
	{
		return line;
	}
}
