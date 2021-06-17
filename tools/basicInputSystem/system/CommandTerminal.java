package tools.basicInputSystem.system;

import java.util.ArrayList;

import in.Update;
import tools.basicInputSystem.ConsoleReader;
import tools.basicInputSystem.command.Command;

/**
 * Verarbeitet Commands indem entsprechende reaktionen auf bestimmte aktionen
 * eingeleitet werden.
 */

public class CommandTerminal implements Update
{
	private ParamReader paramReader = new ParamReader();
	private CommandReader commandReader = new CommandReader();
	private ConsoleReader consoleReader = new ConsoleReader();
	private CommandPackager commandPackager = new CommandPackager();

	@Override
	public void update()
	{
		processCommands();
	}

	private final void processCommands()
	{
		boolean foundCommand = false;

		String input = consoleReader.getLastInput();
		String command = commandReader.readCommand(input);
		ArrayList<String> emptyList = new ArrayList<String>();
		ArrayList<String> params = paramReader.readParams(input, emptyList);

		for (Command c : commandPackager.getCommands())
		{
			if (compareCommands(command, c))
			{
				c.executeCommand(params);
				foundCommand = true;
			}
		}

		if (!foundCommand)
		{
			System.out.println("[Error] could not read command...");
		}
	}

	/**
	 * Vergleicht zwei Befehle, gibt true zurück, wenn der Befehl der gleiche ist
	 * 
	 * @param command
	 * @param secondCommand
	 * 
	 * @return
	 */

	private final boolean compareCommands(String command, Command secondCommand)
	{
		return (command.equals(secondCommand.getCommand()));
	}
}
