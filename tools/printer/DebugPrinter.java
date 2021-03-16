package tools.printer;

public class DebugPrinter extends Printer
{
	@Override
	public void print(String message)
	{
		System.out.println("[debug] " + message);
	}
}
