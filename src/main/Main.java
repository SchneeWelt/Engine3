package main;

import java.awt.Graphics2D;

import globalValues.GlobalValue;
import gui.IFrame;
import gui.RepaintControler;

public class Main implements Draw
{
	private IFrame iFrame = new IFrame("Rect Game");

	public Main()
	{
		setup();

		/* game loop */
		while (true)
		{
			sleep();
			draw(iFrame.getIPanelGraphics());
			RepaintControler.getRepaintControler().repaintIPanel();
		}
	}

	/*
	 * The draw method is called every new tick.
	 */

	@Override
	public final void draw(Graphics2D graphics)
	{
		/* camera layer */

		/* background layer */

		/* foreground layer */
	}

	private final void sleep()
	{
		try
		{
			Thread.sleep((int) GlobalValue.getTickrate());
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private final void setup()
	{
		RepaintControler.initReapaintControler(iFrame);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
