package handler;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import handler.in.OnMouseDrag;
import handler.in.OnMouseMove;
import handler.in.OnMousePress;
import handler.in.OnMouseRelease;

public class MouseEventHandler
{
	private ArrayList<OnMouseMove> onMouseMoveList = new ArrayList<OnMouseMove>();
	private ArrayList<OnMouseDrag> onMouseDragList = new ArrayList<OnMouseDrag>();
	private ArrayList<OnMousePress> onMousePressList = new ArrayList<OnMousePress>();
	private ArrayList<OnMouseRelease> onMouseReleaseList = new ArrayList<OnMouseRelease>();

	public final void triggerOnMousePress(MouseEvent e)
	{
		for (OnMousePress p : onMousePressList)
			p.onMousePress(e);
	}

	public final void triggerOnMouseDrag(MouseEvent e)
	{
		for (OnMouseDrag p : onMouseDragList)
			p.onMouseDrag(e);
	}

	public final void triggerOnMouseMove(MouseEvent e)
	{
		for (OnMouseMove p : onMouseMoveList)
			p.onMouseMove(e);
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

	public final void addOnMouseMove(OnMouseMove onMouseMove)
	{
		onMouseMoveList.add(onMouseMove);
	}

	public final void addOnMouseDrag(OnMouseDrag onMouseDrag)
	{
		onMouseDragList.add(onMouseDrag);
	}
}
