package objects.hud.button;

public class ButtonEvent
{
	private String buttonId = "";

	public ButtonEvent(String buttonId)
	{
		this.buttonId = buttonId;
	}

	public final String getButtonId()
	{
		return buttonId;
	}

	public final void setButtonId(String buttonId)
	{
		this.buttonId = buttonId;
	}
}
