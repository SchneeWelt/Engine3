package tools.basicInputSystem.system;

import java.util.ArrayList;

public class ParamReader
{
	private String startSequenz = "<";
	private String stopSequenz = ">";

	/**
	 * Bei: encrypt <Hi ich bin Text> wird "hi ich bin Text" als parameter
	 * ausgelesen. Methode arbeitet Rekursiev.
	 * 
	 * @param input
	 * @return
	 */

	public final ArrayList<String> readParams(String input, ArrayList<String> params)
	{
		if (!input.contains(startSequenz) | !input.contains(stopSequenz))
			return params;
			
		int start = input.indexOf(startSequenz) + 1;
		int stop = input.indexOf(stopSequenz);
		
		String param = input.substring(start, stop);
		params.add(param);
		
		input = input.replace(startSequenz + param + stopSequenz, "");
		
		return readParams(input, params);
	}
}
