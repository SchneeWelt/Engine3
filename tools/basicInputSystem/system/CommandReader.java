package tools.basicInputSystem.system;

/**
 * Ließt den Command aus einer dafür vorgesehenen String sequez aus.
 */

public class CommandReader
{
	/**
	 * Ließt aus dem eingabe String den Command aus
	 * 
	 * @param input
	 * @return
	 */

	public final String readCommand(String input)
	{
		if (input == null)
			return "";
		
		return input.split(" ")[0];
	}
}
