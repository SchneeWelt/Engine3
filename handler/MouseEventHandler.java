package handler;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseEventHandler
{
	private ArrayList<OnMousePress> onMousePressList = new ArrayList<OnMousePress>();
	private ArrayList<OnMouseRelease> onMouseReleaseList = new ArrayList<OnMouseRelease>();

	public final void triggerOnMousePress(MouseEvent e)
	{
		for (OnMousePress p : onMousePressList)
			p.onMousePress(e);
	}

	public final void triggerOnMouseRelease(MouseEvent e)
	{
		for (OnMouseRelease p : onMouseReleaseList)
			p.onMouseRelease(e);
	}

	public final void addOnMouseRelease(OnMouseRelease onMouseRelease)
	{
		onMouseReleaseList.add(onMouseRelease);
	}

	public final void addOnMousePress(OnMousePress onMousePress)
	{
		onMousePressList.add(onMousePress);
	}
}
