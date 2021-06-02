package main;

import java.awt.Graphics2D;

public class Main extends Clock
{
	public Main()
	{
		super();
	}

	/*
	 * Die Draw methode wird mit jeden neuen Tick neu aufgerufen. Nur wenn auch die
	 * repaintCanvas() methode aufgerufen wird, wird ebenfalls eine Aktualisierte
	 * Version des graphics objektes mit übergeben.
	 */

	@Override
	public final void draw(Graphics2D graphics)
	{
		super.draw(graphics);

		/* camera layer */

		/* background layer */

		/* foreground layer */
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
