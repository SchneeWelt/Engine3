package tools.printer;

public class ErrorPrinter extends Printer
{
	@Override
	public void print(String message)
	{
		System.err.println("[error] " + message);
	}
}
