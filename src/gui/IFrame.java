package gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import globalValues.GlobalValue;

public class IFrame extends JFrame
{
	private IPanel iPanel = new IPanel();

	public IFrame()
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
				GlobalValue.getKeyEventHandler().triggerOnKeyRelease(e);
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				GlobalValue.getKeyEventHandler().triggerOnKeyPress(e);
			}
		});

		setLocationRelativeTo(null);

		setVisible(true);
	}
	
	public IFrame(String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		
		setTitle(title);

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
				GlobalValue.getKeyEventHandler().triggerOnKeyRelease(e);
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				GlobalValue.getKeyEventHandler().triggerOnKeyPress(e);
			}
		});

		setLocationRelativeTo(null);

		setVisible(true);
	}

	public final Graphics2D getIPanelGraphics()
	{
		return (Graphics2D) iPanel.getIPanelGraphics();
	}

	public final void repaintIPanel(Point startLocation, Dimension repaintDimension)
	{
		iPanel.repaint(new Rectangle(startLocation, repaintDimension));
	}

	public final void repaintIPanel()
	{
		iPanel.repaint();
	}

	private final void setSize()
	{
		getContentPane().setPreferredSize(GlobalValue.getScreenDimension());
	}
}
