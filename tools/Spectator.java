package tools.spectator;

import java.awt.event.KeyEvent;

import globalValues.GlobalValue;
import handler.OnKeyPress;
import tools.Camera;
import tools.keySet.KeySet;
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

public class Spectator implements OnKeyPress
{
	private final int SPEED = 8;
	
	private double spectatorZoom = 1;
	private final double ZOOM_INCREMENT = 0.2;

	private Camera camera = new Camera();
	private Rect spectatorLocation = new Rect(0, 0);
	private KeySet zoom = new KeySet(KeyEvent.VK_MINUS, KeyEvent.VK_PLUS, 0, 0);
	private KeySet movement = new KeySet(KeyEvent.VK_DOWN, KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);

	public Spectator()
	{
		GlobalValue.getKeyEventHandler().addOnKeyPress(this);
	}

	@Override
	public void onKeyPress(KeyEvent e)
	{
		int key = e.getKeyCode();

		/* movement */
		if (key == movement.moveDown())
		{
			spectatorLocation.incrementY(-SPEED);
		} else if (key == movement.moveUp())
		{
			spectatorLocation.incrementY(SPEED);
		} else if (key == movement.moveRight())
		{
			spectatorLocation.incrementX(-SPEED);
		} else if (key == movement.moveLeft())
		{
			spectatorLocation.incrementX(SPEED);
		}

		/* zoom */
		if (key == zoom.moveUp())
		{
			spectatorZoom -= ZOOM_INCREMENT;
		} else if (key == zoom.moveDown())
		{
			spectatorZoom += ZOOM_INCREMENT;
		}
		
		/* change camera location and zoom */
		camera.setZoom(spectatorZoom);
		camera.setOffsetX(spectatorLocation.getX());
		camera.setOffsetY(spectatorLocation.getY());
	}

	public final Camera getCamera()
	{
		return camera;
	}
}
