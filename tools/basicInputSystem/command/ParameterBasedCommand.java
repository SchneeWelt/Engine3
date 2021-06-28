package tools.basicInputSystem.command;

import java.util.ArrayList;

/**
 * Dem Grunde nach die Command klasse, hier wird aber immer erwartet, dass
 * mindestens ein parameter bei ausführung eines commands mit geliefert wird.
 * Ist das nicht so, wird ein missing argument fehler ausgegeben.
 */

public class ParameterBasedCommand extends Command
{
	public ParameterBasedCommand(String command)
	{
		super(command);
	}

	@Override
	public void executeCommand(ArrayList<String> params)
	{
		super.executeCommand(params);

		if (params.isEmpty())
		{
			System.out.println("Missing Argument Error in class ParameterBasedCommand");
			return;
		}
	}
}
