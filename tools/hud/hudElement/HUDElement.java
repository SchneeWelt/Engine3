package tools.hud.hudElement;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import globalValues.Globals;
import handler.MouseEventHandler;
import handler.in.OnKeyPress;
import handler.in.OnKeyRelease;
import handler.in.OnMousePress;
import handler.in.OnMouseRelease;
import in.Draw;
import tools.hud.HUD;
import tools.rect.Rect;

/**
 * Beschreibt abstrakt jedes Element auf dem HUD.
 */

public abstract class HUDElement implements Draw, OnKeyRelease, OnKeyPress, OnMouseRelease, OnMousePress
{
	protected final int STROKE_SIZE = 4;

	protected HUD hud;
	protected Color outlineColor = Color.blue;
	protected Rect location = new Rect(0, 0, 0, 0);
	protected BasicStroke outlineStroke = new BasicStroke(STROKE_SIZE);

	public HUDElement(HUD hud, Rect location)
	{
		this.hud = hud;
		this.location = location;

		MouseEventHandler m = Globals.getMouseEventHandler();
		m.addOnMouseRelease(this);
		m.addOnMousePress(this);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		displayOutline(graphics);
	}

	@Override
	public void onMousePress(MouseEvent e)
	{

	}

	@Override
	public void onMouseRelease(MouseEvent e)
	{

	}

	@Override
	public void onKeyPress(KeyEvent e)
	{

	}

	@Override
	public void onKeyRelease(KeyEvent e)
	{

	}

	protected void displayOutline(Graphics2D graphics)
	{
		graphics.setColor(outlineColor);
		graphics.setStroke(outlineStroke);

		int x = Math.round(location.getX());
		int y = Math.round(location.getY());
		int w = Math.round(location.getW());
		int h = Math.round(location.getH());

		graphics.drawRect(x, y, w, h);
	}

	/**
	 * @return true, wenn sich die Maus zum Zeitpunkt des Aufrufes über diesem
	 *         HUDElement befindet.
	 */

	protected final boolean isElementSelected()
	{
		Rect mouseLocation = new Rect(Globals.getMouseLocation().getX(), Globals.getMouseLocation().getY());

		int x = Math.round(location.getX());
		int y = Math.round(location.getY());
		int w = Math.round(location.getW());
		int h = Math.round(location.getH());

		return new Rectangle(x, y, w, h).contains(new Point((int) mouseLocation.getX(), (int) mouseLocation.getY()));
	}

	/**
	 * @param mouseLocation
	 * @return true, wenn sich die Maus zum Zeitpunkt des Aufrufes innerhalb dieses
	 *         HUDElements befindet.
	 */

	protected final boolean isElementSelected(Point mouseLocation)
	{
		int x = Math.round(location.getX());
		int y = Math.round(location.getY());
		int w = Math.round(location.getW());
		int h = Math.round(location.getH());

		return new Rectangle(x, y, w, h).contains(mouseLocation);
	}

	public final Rect getLocation()
	{
		return location;
	}

	public final void setLocation(Rect location)
	{
		this.location = location;
	}
}
