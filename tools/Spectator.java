package tools;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import globalValues.Globals;
import handler.in.OnKeyPress;
import handler.in.OnKeyRelease;
import in.Draw;
import tools.rect.Rect;

/**
 * The Spectator is a debug class wich is used to specatate the world. To use
 * the Spectator use the arrow keys also call the getCamera().camera() method
 * with every new frame. The camera call should be the first call in every new
 * frame creation.
 * 
 * Use the plus and minus keys to zoom in and out.
 * 
 *
 */

public class Spectator implements OnKeyPress, OnKeyRelease, Draw
{
	private int inc, dec;
	private double spectatorZoom = 1;
	private int left, right, up, down;

	private final int SPEED = 8;
	private final double ZOOM_INCREMENT = 0.2;

	private Camera camera = new Camera();
	private Rect spectatorLocation = new Rect(0, 0);
	private Rect spectatorAccelaration = new Rect(0, 0);

	public Spectator()
	{
		inc = KeyEvent.VK_PLUS;
		dec = KeyEvent.VK_MINUS;
		
		up = KeyEvent.VK_UP;
		left = KeyEvent.VK_LEFT;
		down = KeyEvent.VK_DOWN;
		right = KeyEvent.VK_RIGHT;
		
		

		Globals.getKeyEventHandler().addOnKeyPress(this);
		Globals.getKeyEventHandler().addOnKeyRelease(this);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		/* compute location values */
		spectatorLocation.incrementX(spectatorAccelaration.getX());
		spectatorLocation.incrementY(spectatorAccelaration.getY());

		/* change camera location and zoom */
		camera.setZoom(spectatorZoom);
		camera.setOffsetX(spectatorLocation.getX());
		camera.setOffsetY(spectatorLocation.getY());
	}

	@Override
	public void onKeyRelease(KeyEvent e)
	{
		int key = e.getKeyCode();

		/* movement */
		if (key == down)
		{
			spectatorAccelaration.setY(0);
		} else if (key == up)
		{
			spectatorAccelaration.setY(0);
		} else if (key == right)
		{
			spectatorAccelaration.setX(0);
		} else if (key == left)
		{
			spectatorAccelaration.setX(0);
		}
	}

	@Override
	public void onKeyPress(KeyEvent e)
	{
		int key = e.getKeyCode();

		/* movement */
		if (key == down)
		{
			spectatorAccelaration.setY(-SPEED);
		} else if (key == up)
		{
			spectatorAccelaration.setY(+SPEED);
		} else if (key == right)
		{
			spectatorAccelaration.setX(-SPEED);
		} else if (key == left)
		{
			spectatorAccelaration.setX(+SPEED);
		}

		/* zoom */
		if (key == inc)
		{
			spectatorZoom -= ZOOM_INCREMENT;
		} else if (key == dec)
		{
			spectatorZoom += ZOOM_INCREMENT;
		}
	}

	public final Camera getCamera()
	{
		return camera;
	}
}
