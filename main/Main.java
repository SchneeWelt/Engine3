
import java.awt.Graphics2D;

import globalValues.Globals;
import gui.IFrame;
import gui.RepaintControler;
import in.Draw;

public class Main implements Draw
{
	/*
	* The draw() methode is constantly called. Therefore, it can be represented as main loop. 
	* Although objects are mostly initialized in the Header of a class the setup method exists for initializing 
	* Objects it is only called one time when the program starts. 
	*/


	private IFrame iFrame = new IFrame("");

	public Main()
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
	
	/*
	 * Die Draw methode wird mit jeden neuen Tick neu aufgerufen. Nur wenn auch die
	 * repaintCanvas() methode aufgerufen wird, wird ebenfalls eine Aktualisierte
	 * Version des graphics objektes mit übergeben.
	 */

	@Override
	public final void draw(Graphics2D graphics)
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

	public static void main(String[] args)
	{
		new Main();
	}
}
