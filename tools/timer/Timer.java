package tools.timer;

import java.awt.Graphics2D;

import in.Draw;

/**
 * The Timer class is a timer which trigger the onTimerTrigger() event when the
 * timer has reached the max value defined in the constructor. After the timer
 * had triggered the onTimerTrigger() method it will then reset the timer and
 * starts counting from zero again.
 * 
 * To led the timer work the draw() method has to be called every tick. One
 * draw() call means another tick for the timer.
 * 
 *
 */

public class Timer implements Draw
{
	private int max = 30;
	private int counter = 0;
	private final int MIN = 0;
	private final int INCREMENT_PER_TICK = 1;

	private TimerEvent timerEvent;
	private OnTimerTrigger target;

	public Timer(int max, OnTimerTrigger target, String timerId)
	{
		setup(max, target);
		timerEvent = new TimerEvent(timerId);
	}
	
	public Timer(int max, OnTimerTrigger target)
	{
		setup(max, target);
		timerEvent = new TimerEvent("default");
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		incrementCounter();

		if (counter > max)
		{
			resetTimer();
			target.onTimerTrigger(timerEvent);
		}
	}
	
	private final void setup(int max, OnTimerTrigger target)
	{
		setMax(max);
		resetTimer();
		setTarget(target);
	}
	
	public final void resetTimer()
	{
		counter = MIN;
	}
	
	public final int getCurrentCount()
	{
		return counter;
	}
	
	public final String getTimerId()
	{
		return timerEvent.getTimerId();
	}

	private final void incrementCounter()
	{
		counter += INCREMENT_PER_TICK;
	}

	private final void setMax(int max)
	{
		this.max = max;
	}

	private final void setTarget(OnTimerTrigger target)
	{
		this.target = target;
	}
}
