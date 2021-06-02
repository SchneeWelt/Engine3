package main;

import java.awt.Graphics2D;

import globalValues.Globals;
import gui.IFrame;
import gui.RepaintControler;
import in.Draw;

class Clock implements Draw
{
	private IFrame iFrame = new IFrame("Title");

	public Clock()
	{
		setup();

		/* game loop */
		while (true)
		{
			sleep();
			draw(iFrame.getCanvasGraphics());
			RepaintControler.getRepaintControler().repaintCanvas();
		}
	}

	@Override
	public void draw(Graphics2D graphics)
	{
	}

	private final void sleep()
	{
		/*
		 * Spiel Engines sollten nicht mehr über Thred.sleep() arbeiten. Da das hier
		 * aber eine resourcen günstiege Engine für alles mögliche sein soll ist das ok.
		 */

		try
		{
			Thread.sleep((int) Globals.getTickrate());
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private final void setup()
	{
		RepaintControler.initReapaintControler(iFrame);
	}
}
