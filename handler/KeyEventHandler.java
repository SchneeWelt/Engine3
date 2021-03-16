package handler;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyEventHandler
{
	private ArrayList<OnKeyPress> onKeyPressList = new ArrayList<OnKeyPress>();
	private ArrayList<OnKeyRelease> onKeyReleaseList = new ArrayList<OnKeyRelease>();

	public final void triggerOnKeyPress(KeyEvent e)
	{
		for (OnKeyPress p : onKeyPressList)
			p.onKeyPress(e);
	}

	public final void triggerOnKeyRelease(KeyEvent e)
	{
		for (OnKeyRelease p : onKeyReleaseList)
			p.onKeyRelease(e);
	}

	public final void addOnKeyRelease(OnKeyRelease onKeyRelease)
	{
		onKeyReleaseList.add(onKeyRelease);
	}

	public final void addOnKeyPress(OnKeyPress onKeyPress)
	{
		onKeyPressList.add(onKeyPress);
	}
}
