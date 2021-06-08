package objects.hud.hudElement.textDisplay.page;

import java.util.ArrayList;

import objects.hud.hudElement.textDisplay.page.line.Line;

/**
 * Ein Page objekt ist für die Speicherung des Inhaltes einer Seit eines
 * TextDisplay objektes verantwortlich. Es gibt dafür unteraderem seine größe,
 * also die Anzahl von Zeilen und Buchstaben pro Zeile an.
 * 
 * Die Daten über die Letter Objekte werden in einer ArrayList gespeichert, die
 * Line objekte enhällt.
 */

public class Page
{
	private int maxLines = 12;
	private int maxLettersPerLine = 12;

	private ArrayList<Line> page = new ArrayList<Line>();

	/**
	 * Fügt dem Page objekt eine neue Zeile hinzu.
	 */

	public final void appendLine()
	{
		page.add(new Line());
	}

	/**
	 * Gibt das Line objekt der jeweiliegen zeile index zurück.
	 * 
	 * @param index
	 * @return
	 */

	public final Line readLine(int index)
	{
		return page.get(index);
	}

	/**
	 * Tauscht an der Stelle index ein Line objekt mit einem anderen aus. Mit dem
	 * anderen ist das parameter objekt newLine gemeint.
	 * 
	 * @param line
	 * @param newLine
	 */

	public final void changeLine(int index, Line newLine)
	{
		page.set(index, newLine);
	}

	/**
	 * Löschte eine Zeile auf stelle index
	 * 
	 * @param index
	 */

	public final void deleteLine(int index)
	{
		page.remove(index);
	}

	public final void deleteLastLine()
	{
		int lastLine = page.size() - 1;
		deleteLine(lastLine);
	}

	/**
	 * Gibt die Anzahl aller Zeilen innerhalb dieses Page objektes in form eines int
	 * zurück.
	 * 
	 * @return
	 */

	public final int totalLines()
	{
		return page.size();
	}

	/**
	 * Gibt die Liste, die alle Line objekte dieses Page objektes enthällt zurück
	 * 
	 * @return
	 */

	public final ArrayList<Line> lines()
	{
		return page;
	}

	/**
	 * Schaut, ob der inputParameter lineIndex sich innerhalb der list alle Zeilen
	 * diese Objektes befindet.
	 * 
	 * Ist der eingegebene lineIndex also ein tatsächlich valieder lineIndex der
	 * Liste, sprich innerhalb dieser, so wird true zurück gegeben.
	 * 
	 * @param lineIndex
	 * @return
	 */

	public final boolean checkLine(int lineIndex)
	{
		// 1 2 3 -> 3
		// 0 1 2

		return (page.size() > lineIndex);
	}

	/**
	 * Gibt die Maximal erlaubt anzahl an Line objekten in diesem Page objekt zurück
	 * 
	 * 
	 * @return
	 */

	public final int getMaxLines()
	{
		return maxLines;
	}

	public final int getMinLines()
	{
		return 0;
	}

	public final int getMinLettersPerLine()
	{
		return 0;
	}

	/**
	 * Gibt die maximal erlaubte anzahl an Letter objekten innerhalb eines Line
	 * objektes zurück.
	 * 
	 * @return
	 */

	public final int getMaxLettersPerLine()
	{
		return maxLettersPerLine;
	}

	public final void setMaxLines(int maxLines)
	{
		this.maxLines = maxLines;
	}

	public final void setMaxLettersPerLine(int maxLettersPerLine)
	{
		this.maxLettersPerLine = maxLettersPerLine;
	}
}
