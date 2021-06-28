package tools.timer;

public class TimerEvent
{
	private String timerId = "";
	
	public TimerEvent(String timerId)
	{
		setId(timerId);
	}
	
	public final void setId(String timerId)
	{
		this.timerId = timerId;
	}
	
	public final String getTimerId()
	{
		return timerId;
	}
}
