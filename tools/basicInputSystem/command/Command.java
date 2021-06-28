package tools.basicInputSystem.command;

import java.util.ArrayList;

/**
 * Beschreibt abstrakt jeden Befehl, der im CommandTerminal getätigt werden
 * kann. Der String command enthällt den Befehl, der für eine sub class gillt.
 * 
 * Ein Command folgt stehts dieser syntax: NAME_DES_COMMANDS <ERSTER_PARAMETER>
 * <N_TER_PARAMTER> Es sind unendlich viele Paramter möglich.
 * 
 * Ein Beispiel: kill <allPlayers> Beispiel zwei: hallo <Das ist ein Text> <für
 * Rosa>
 * 
 * Natürlich geht auch: kill </all>. Eventuell ist ein paramter Befehl dann
 * besser zu verstehen.... Ein paramter muss immer mit einer spitzen klammer
 * nach rechts starten und mit einer spitzen klammer nach rechts enden. Alles
 * zwischen diesen Klammern wird dann als paramter aufgefasst.
 */

public abstract class Command
{
	protected String command = "";

	/**
	 * @param command Der Name des Befehls, der in die Console eingeben werden soll
	 *                , damit etwas passiert.
	 */

	public Command(String command)
	{
		this.command = command;
	}

	/**
	 * Führt einen Befehlt aus. Mit methoden aufruf wird eine Liste aus Strings
	 * übergeben, die als paramerter des Befehls dienen. Element 0 aus der liste ist
	 * der erste parameter. Theoretisch sind unendlich viele parameter möglich.
	 * 
	 * @param params
	 */

	public void executeCommand(ArrayList<String> params)
	{
	}

	/**
	 * Wird von der Help klasse aufgerufen. Diese Methode sollte einen String
	 * zurückgeben, dessen Inhalt infos zu der kindsklasse einer Kommandklasse
	 * enthällt. Der Inhalt, der hier zurückgeben wird, wir von der Help klasse in
	 * der Konsole ausgegeben.
	 * 
	 * @return
	 */

	public String getSpecificCommandInfo()
	{
		return "";
	}

	public final String getCommand()
	{
		return command;
	}
}
