package objects.hud.hudElement.textDisplay;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import globalValues.GlobalValue;
import handler.OnKeyPress;
import handler.OnKeyRelease;

/**
 * Sorgt dafür, dass immer nur auf einem TextDisplay zur Zeit geschrieben werden
 * kann.
 */

public class TextDisplayCoordinator implements OnKeyPress, OnKeyRelease
{
	private int currentSelected = 0;
	private int lastTextDisplayAdded = 0;

	private ArrayList<TextDisplay> list = new ArrayList<TextDisplay>();

	public TextDisplayCoordinator()
	{
		GlobalValue.getKeyEventHandler().addOnKeyPress(this);
		GlobalValue.getKeyEventHandler().addOnKeyRelease(this);
	}

	@Override
	public void onKeyRelease(KeyEvent e)
	{
		getCurrentSelectedTextDisplay().onKeyRelease(e);
	}

	@Override
	public void onKeyPress(KeyEvent e)
	{
		getCurrentSelectedTextDisplay().onKeyPress(e);
	}

	public final void addTextDisplay(TextDisplay textDisplay)
	{
		list.add(textDisplay);
		lastTextDisplayAdded++;
	}

	public final void changeTextDisplay(int newCurrentSelected)
	{
		setCurrentSelected(newCurrentSelected);
	}

	public final int getLastTextDisplayAdded()
	{
		return lastTextDisplayAdded;
	}

	private final void setCurrentSelected(int currentSelected)
	{
		this.currentSelected = currentSelected;
	}

	private final TextDisplay getCurrentSelectedTextDisplay()
	{
		return list.get(currentSelected);
	}
}
