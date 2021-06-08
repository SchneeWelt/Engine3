package tools.hud.hudElement.textDisplay;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tools.hud.HUD;
import tools.rect.Rect;

/**
 * Zeigt im grunde ein TextDisplay an. Kann aber Character auf diesem durch
 * keyBoard eingabe verändern.
 * 
 * Außerdem existiert ein Scrollbar objekt, was dafür sorgt, dass mehr Zeilen
 * existieren können, als auf einmal angezeigt werden können. Das Scrollbar
 * objekt wird rechts von dem eigentlichen TextDisplay aus angezeigt.
 */

public class ExtendedTextDisplay extends TextDisplay 
{
	private CharacterHighlighter characterHighlighter;

	public ExtendedTextDisplay(boolean keepSize, Rect location, HUD hud)
	{
		super(keepSize, location, hud);

		characterHighlighter = new CharacterHighlighter(this, cursor);
		characterHighlighter.draw(null);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);
		characterHighlighter.draw(graphics);
	}

	@Override
	public void onKeyPress(KeyEvent e)
	{
		super.onKeyPress(e);
		handleKeyInput(e);
	}

	private final void handleKeyInput(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		/* enter bewegung */
		if (keyCode == KeyEvent.VK_ENTER)
		{
			cursor.moveDown();
			cursor.resetLetter();
			return;
		}

		/* backspace bewegung */
		if (keyCode == KeyEvent.VK_BACK_SPACE)
		{
			cursor.moveLeft();
			deleteCharacter(cursor.getLine(), cursor.getLetter());
			return;
		}

		/* entf bewegung */
		if (keyCode == KeyEvent.VK_DELETE)
		{
			deleteCharacter(cursor.getLine(), cursor.getLetter());
			cursor.moveRight();
			return;
		}

		/* pfeiltasten bewegung */
		if (keyCode == KeyEvent.VK_RIGHT)
		{
			cursor.moveRight();
			return;
		} else if (keyCode == KeyEvent.VK_LEFT)
		{
			cursor.moveLeft();
			return;
		} else if (keyCode == KeyEvent.VK_DOWN)
		{
			cursor.moveDown();
			return;
		} else if (keyCode == KeyEvent.VK_UP)
		{
			cursor.moveUp();
			return;
		}

		/* normales forwärts schreiben */
		char key = e.getKeyChar();

		/* charakter nur schreiben, wenn kein shift, alt oder altgr, sowie caps einfg */
		if (isValidKeyCode(e))
		{
			changeCharacter(key, cursor.getLine(), cursor.getLetter());
			cursor.moveRight();
		}
	}

	/**
	 * Vergleicht zwei character in form einer dezimal zahl. 
	 * 
	 * @param keyCode
	 * @param comparator
	 * @return true, wenn der keyCode nicht dem comparator entspricht.
	 */

	private final boolean compare(int keyCode, int comparator)
	{
		return keyCode != comparator;
	}

	/**
	 * @param e
	 * @return true, wenn e nicht shift, caps, alt, altgr oder einfg und noch nen
	 *         paar andere ist...
	 */

	private final boolean isValidKeyCode(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		return (compare(keyCode, KeyEvent.VK_SHIFT) && compare(keyCode, KeyEvent.VK_ALT)
				&& compare(keyCode, KeyEvent.VK_CAPS_LOCK) && compare(keyCode, KeyEvent.VK_INSERT)
				&& compare(keyCode, KeyEvent.VK_COPY) && compare(keyCode, KeyEvent.VK_CONTROL));
	}
}
