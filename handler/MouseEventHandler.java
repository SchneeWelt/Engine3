package handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import handler.in.OnMouseDrag;
import handler.in.OnMouseMove;
import handler.in.OnMousePress;
import handler.in.OnMouseRelease;
import handler.in.OnMouseWheelMove;

public class MouseEventHandler
{
	private ArrayList<OnMouseMove> onMouseMoveList = new ArrayList<OnMouseMove>();
	private ArrayList<OnMouseDrag> onMouseDragList = new ArrayList<OnMouseDrag>();
	private ArrayList<OnMousePress> onMousePressList = new ArrayList<OnMousePress>();
	private ArrayList<OnMouseRelease> onMouseReleaseList = new ArrayList<OnMouseRelease>();
	private ArrayList<OnMouseWheelMove> onMouseWheelMoveList = new ArrayList<OnMouseWheelMove>();

	public final void triggerOnMouseWheelMove(MouseWheelEvent e)
	{
		for (OnMouseWheelMove m : onMouseWheelMoveList)
			m.onMouseWheelMove(e);
	}
	
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
	
	public final void addOnMouseWheelMove(OnMouseWheelMove onMouseWheelMove)
	{
		onMouseWheelMoveList.add(onMouseWheelMove);
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
