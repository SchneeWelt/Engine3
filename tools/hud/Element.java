package objects.hud;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import handler.MouseEventHandler;
import handler.in.OnMousePress;
import handler.in.OnMouseRelease;
import in.Draw;
import objects.abstracts.Vector;
import system.Globals;
import tools.background.BetterBackground;
import tools.rect.Rect;

public abstract class Element implements Draw, OnMouseRelease, OnMousePress
{

	protected Frame frame;
	protected Rect location;
	/**
	 * This is used when the screen draw with translation. For example when the
	 * screen coordinates gets translated so that 0, 0 is in screen center. This
	 * offset vector is therefore used to still have the right mouse location.
	 */
	protected Vector offsetForMouseInput;
	protected BetterBackground background;

	public Element(Rect location)
	{
		this.location = location;

		offsetForMouseInput = new Vector(2);
		frame = new Frame(location, Color.blue);
		background = new BetterBackground(location, Color.white);

		connect(Globals.getMouseEventHandler());
	}

	public Element(Rect location, MouseEventHandler mouseEventHandler)
	{
		this.location = location;

		background = new BetterBackground(location, Color.white);

		connect(mouseEventHandler);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		background.draw(graphics);
		frame.draw(graphics);
	}

	@Override
	public void onMousePress(MouseEvent e)
	{

	}

	@Override
	public void onMouseRelease(MouseEvent e)
	{

	}

	public final void connect(MouseEventHandler mouseEventHandler)
	{
		mouseEventHandler.addOnMouseRelease(this);
		mouseEventHandler.addOnMousePress(this);
	}

	protected final boolean isElementSelected(MouseEvent mouseEvent)
	{
		int x = Math.round(location.getX() + offsetForMouseInput.get(0));
		int y = Math.round(location.getY() + offsetForMouseInput.get(1));
		int w = Math.round(location.getW());
		int h = Math.round(location.getH());

		return new Rectangle(x, y, w, h).contains(mouseEvent.getPoint());
	}

	public final Rect getLocation()
	{
		return location;
	}

	public final void setLocation(Rect location)
	{
		this.location = location;
	}

	public Frame getFrame()
	{
		return frame;
	}

	public final void setBackgroundColor(Color backgroundColor)
	{
		background.setBackgroundColor(backgroundColor);
	}

	public Vector getOffsetForMouseInput()
	{
		return offsetForMouseInput;
	}

	public void setOffsetForMouseInput(Vector offsetForMouseInput)
	{
		this.offsetForMouseInput = offsetForMouseInput;
	}
}
