package main;

import java.awt.Graphics2D;

import gui.IFrame;
import gui.RepaintControler;
import in.Draw;
import objects.Workbench;
import system.Globals;

public class Main implements Draw
{
	/*
	 * The draw() methode is constantly called. Therefore, it can be represented as
	 * main loop. Although objects are mostly initialized in the Header of a class
	 * the setup method exists for initializing Objects it is only called one time
	 * when the program starts.
	 */

	private IFrame iFrame = new IFrame("");

	public Main()
	{
		setup();

		/* main loop */
		while (Globals.running)
		{
			sleep();

			/* rendering and main computing */
			draw(iFrame.getCanvasGraphics());
			RepaintControler.getRepaintControler().repaintCanvas();
		}

		/* shutdown sequenz */
		onShutdown();
	}

	/*
	 * Die Draw methode wird mit jeden neuen Tick neu aufgerufen. Nur wenn auch die
	 * repaintCanvas() methode aufgerufen wird, wird ebenfalls eine Aktualisierte
	 * Version des graphics objektes mit übergeben.
	 */

	@Override
	public final void draw(Graphics2D graphics)
	{
		
	}

	/**
	 * This methode exists to define what shall happen when the program shutdowns.
	 * Note that a program shutdown is executet when the Globals.shutdown() method
	 * is called.
	 * 
	 */

	public final void onShutdown()
	{
		System.out.println("[System] shutdown..");
		System.exit(1);
	}

	private final void sleep()
	{
		/*
		 * Spiel Engines sollten nicht mehr über Thred.sleep() arbeiten. Da das hier
		 * aber eine resourcen günstiege Engine für alles mögliche sein soll ist das
		 * ok.
		 */

		try
		{
			Thread.sleep(Math.round(Globals.TICK_RATE));
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
