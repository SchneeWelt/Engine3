package tools.basicInputSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Verantwortlich für das Auslesen von Text aus der Console. Der Reader läuft in
 * einem eigens dafür vorgesehenen Thread. Der Thread wird bei erzeugung einer
 * Instanz dieser Klasse automatisch gestartet.
 */

public class ConsoleReader implements Runnable
{
	private boolean running = true;

	private String lastInput = "";
	private BufferedReader reader;
	private String errorMessage = "[Error] could not read console input\nIn class ConsoleReader";

	public ConsoleReader()
	{
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run()
	{
		while (running)
			readInput();
	}

	private final void readInput()
	{
		try
		{
			lastInput = reader.readLine();
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(errorMessage);
		}
	}

	/**
	 * Schließt diesen ConsoleReader, damit hört der Reader auf aus der Console zu
	 * lesen. Gleichzeitig wird der interne Thread loop gestoppt.
	 */

	public final void close()
	{
		try
		{
			reader.close();
			running = false;
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Gibt den String zurück, der zuletz in die Console eingeben wurde und von
	 * diesem Reader erfasst worden ist.
	 * 
	 * @return
	 */

	public final String getLastInput()
	{
		return lastInput;
	}
}
