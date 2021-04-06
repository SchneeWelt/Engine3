package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import globalValues.GlobalValue;

public class IPanel extends JPanel
{
	/* this is the image on which the whole program draws on */
	private static BufferedImage iImage = new BufferedImage(GlobalValue.getScreenDimension().width,
			GlobalValue.getScreenDimension().height, BufferedImage.TYPE_INT_RGB);

	public IPanel()
	{
		setSize(GlobalValue.getScreenDimension());

		addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseMoved(MouseEvent e)
			{
				GlobalValue.setMouseLocation(e.getPoint());
				GlobalValue.getMouseEventHandler().triggerOnMouseMove(e);
			}

			@Override
			public void mouseDragged(MouseEvent e)
			{
				GlobalValue.setMouseLocation(e.getPoint());
				GlobalValue.getMouseEventHandler().triggerOnMouseDrag(e);
			}
		});

		addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				GlobalValue.setMousePressed(false);
				GlobalValue.getMouseEventHandler().triggerOnMouseRelease(e);
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				GlobalValue.setMousePressed(true);
				GlobalValue.getMouseEventHandler().triggerOnMousePress(e);
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
	
	public static final BufferedImage getIImage()
	{
		return iImage;
	}

	public final Graphics2D getIPanelGraphics()
	{
		return (Graphics2D) iImage.getGraphics();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(iImage, 0, 0, null);
	}
}
