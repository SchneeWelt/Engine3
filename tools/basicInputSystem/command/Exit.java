package tools.basicInputSystem.command;

import java.util.ArrayList;

/**
 * Ein stadartisierter Befehl, der das Programm stop.
 */

public class Exit extends Command
{
	public Exit()
	{
		super("exit");
	}

	@Override
	public void executeCommand(ArrayList<String> params)
	{
		super.executeCommand(params);
		shutdownB16();
	}

	@Override
	public String getSpecificCommandInfo()
	{
		String result = "\n";
		result += "Sy: exit\n";
		result += "This command will shutdown this program";
		return result;
	}

	private final void shutdownB16()
	{
		String message = "";
		message += "execute software shutdown";
		message += "\n";
		message += "[Worker] shutdown B16";
		message += "\n";
		message += "now offline";
		System.out.println(message);

		System.exit(1);
	}
}
