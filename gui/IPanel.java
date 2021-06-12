package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import globalValues.Globals;
import tools.rect.Rect;

public class IPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	/* Auf diesem BufferedImage objekt malt das IFrame */
	private BufferedImage canvas = createCanvas(); // static...

	public IPanel()
	{
		setupSize();

		addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseMoved(MouseEvent mouseEvent)
			{
				updateMouseLocation(mouseEvent);
				Globals.getMouseEventHandler().triggerOnMouseMove(mouseEvent);
			}

			@Override
			public void mouseDragged(MouseEvent mouseEvent)
			{
				updateMouseLocation(mouseEvent);
				Globals.getMouseEventHandler().triggerOnMouseDrag(mouseEvent);
			}
		});

		addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				Globals.setMousePressed(false);
				Globals.getMouseEventHandler().triggerOnMouseRelease(e);
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				Globals.setMousePressed(true);
				Globals.getMouseEventHandler().triggerOnMousePress(e);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(canvas, 0, 0, null);
	}

	private final void updateMouseLocation(MouseEvent mouseEvent)
	{
		int x = (int) mouseEvent.getPoint().getX();
		int y = (int) mouseEvent.getPoint().getY();
		Globals.setMouseLocation(new Rect(x, y));
	}

	private final BufferedImage createCanvas()
	{
		int type = BufferedImage.TYPE_INT_ARGB;
		int w = Globals.SCREEN_DIMENSION.getRoundW();
		int h = Globals.SCREEN_DIMENSION.getRoundH();

		return new BufferedImage(w, h, type);
	}

	private final void setupSize()
	{
		int w = Globals.SCREEN_DIMENSION.getRoundW();
		int h = Globals.SCREEN_DIMENSION.getRoundH();

		setSize(new Dimension(w, h));
	}

	public final BufferedImage getCanvas() // static ...
	{
		return canvas;
	}

	/**
	 * Gibt das Graphics objekt des Canvas objektes zurück. Diese Methode sollte mit
	 * jedem Tick aufgerufen werden, um das neuste Graphics2D objekt zu bekommen.
	 * 
	 * @return
	 */

	public final Graphics2D getCanvasGraphics()
	{
		return (Graphics2D) canvas.getGraphics();
	}
}
