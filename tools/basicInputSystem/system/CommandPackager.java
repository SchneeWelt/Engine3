package tools.basicInputSystem.system;

import java.util.ArrayList;

import tools.basicInputSystem.command.Command;
import tools.basicInputSystem.command.Exit;
import tools.basicInputSystem.command.Help;

/**
 * Verantwortlich für die erzeugung aller verwendbaren Commands, die während der
 * Laufzeit aufrufbar sind. Die Commands werden bei instanzierung einer Instanz
 * dieser Klasse erzeugt und können über den Befehl getCommans() als ArrayListe
 * aus Command objekten erhalten werden.
 */

public class CommandPackager
{
	private ArrayList<Command> commands = new ArrayList<Command>();

	public CommandPackager()
	{
		Exit exit = new Exit();
		
		commands.add(exit);
		commands.add(new Help(commands));
	}

	public final ArrayList<Command> getCommands()
	{
		return commands;
	}
}
