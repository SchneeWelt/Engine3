package gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import globalValues.Globals;
import tools.rect.Rect;

public class IFrame extends JFrame
{
	private IPanel iPanel = new IPanel();

	public IFrame()
	{
		setup();
	}
	
	public IFrame(String title)
	{
		setTitle(title);
		setup();
	}
	
	public final Graphics2D getCanvasGraphics()
	{
		return iPanel.getCanvasGraphics();
	}
	
	public final BufferedImage getCanvas()
	{
		return iPanel.getCanvas();
	}

	public final void repaintCanvas(Rect area)
	{
		iPanel.repaint(new Rectangle(area.getX(), area.getH(), area.getW(), area.getH()));
	}

	public final void repaintCanvas()
	{
		iPanel.repaint();
	}
	
	private final void setup()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(iPanel);
		setSize();
		pack();
		addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				Globals.getKeyEventHandler().triggerOnKeyRelease(e);
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				Globals.getKeyEventHandler().triggerOnKeyPress(e);
			}
		});

		setLocationRelativeTo(null);

		setVisible(true);
	}

	private final void setSize()
	{
		int w = Globals.SCREEN_DIMENSION.getW();
		int h = Globals.SCREEN_DIMENSION.getH();
		getContentPane().setPreferredSize(new Dimension(w, h));
	}
}
