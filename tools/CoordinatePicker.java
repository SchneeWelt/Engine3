package tools;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import globalValues.GlobalValue;
import handler.OnMousePress;
import tools.printer.DebugPrinter;

/**
 * Once the CoordinatePicker is initialized it will print the current mouse
 * coordinate in Pixels on screen when pressing the left mouse button.
 * 
 * output will look like this: "[debug] Pointing at: (163, 189)". 163 represents
 * the x value, 189 represents the y value
 *
 */

public class CoordinatePicker implements OnMousePress
{
	private DebugPrinter printer = new DebugPrinter();

	public CoordinatePicker()
	{
		GlobalValue.getMouseEventHandler().addOnMousePress(this);
	}

	@Override
	public void onMousePress(MouseEvent e)
	{
		if (SwingUtilities.isLeftMouseButton(e))
		{
			printMouseLocation(e.getPoint());
		}
	}

	private final void printMouseLocation(Point mouseLocation)
	{
		String message = "Pointing at: " + "(" + mouseLocation.x + ", " + mouseLocation.y + ")";
		printer.print(message);
	}
}
