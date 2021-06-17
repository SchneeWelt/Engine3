package tools.basicInputSystem.command;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Help extends Command
{
	private String helpSequenz = "";
	private Hashtable<String, Command> hashtable;

	public Help(ArrayList<Command> allCommands)
	{
		super("help");
		createHelpSequenz(allCommands);
		createHashtable(allCommands);
	}

	@Override
	public void executeCommand(ArrayList<String> params)
	{
		super.executeCommand(params);

		if (params.size() >= 1)
		{
			printSpecificCommandInfo(params);
		} else
		{
			System.out.println(helpSequenz);
		}
	}
	
	private final void printSpecificCommandInfo(ArrayList<String> params)
	{
		Enumeration<String> e = hashtable.keys();

		for (int i = 0; i < hashtable.size(); i++)
		{
			String key = e.nextElement();

			if (params.get(0).equals(key))
			{
				String out = hashtable.get(key).getSpecificCommandInfo();
				System.out.println(out);
			}
		}
	}

	private final void createHashtable(ArrayList<Command> allCommands)
	{
		hashtable = new Hashtable<String, Command>();

		for (int i = 0; i < allCommands.size(); i++)
		{
			Command c = allCommands.get(i);
			String s = allCommands.get(i).getCommand();

			hashtable.put(s, c);
		}
	}

	private final void createHelpSequenz(ArrayList<Command> allCommands)
	{
		String result = "\n";
		result = result.concat("All commands available:\n");

		/* füge den help befehlt zu der Liste hinzu */
		result += "help, ";

		int index = 0;
		for (Command c : allCommands)
		{
			if (index > 0)
				result = result.concat(", ");

			if (index % 3 == 0 && index != 0)
				result += "\n";

			result = result.concat(c.getCommand());

			index++;
		}

		result += "\nyust type: help <COMMAND_NAME> \n";
		result += "to get more informatio about a command";

		helpSequenz = result;
	}
}
