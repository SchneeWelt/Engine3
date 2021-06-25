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
	private double max = 30;
	private double counter = 0;
	private final double MIN = 0;
	protected double INCREMENT_PER_TICK = 1;

	private TimerEvent timerEvent;
	private OnTimerTrigger target;

	public Timer(double max, OnTimerTrigger target, String timerId)
	{
		setup(max, target);
		timerEvent = new TimerEvent(timerId);
	}
	
	public Timer(double max, OnTimerTrigger target)
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
	
	private final void setup(double max, OnTimerTrigger target)
	{
		setMax(max);
		resetTimer();
		setTarget(target);
	}
	
	public final void resetTimer()
	{
		counter = MIN;
	}
	
	private final void incrementCounter()
	{
		counter += INCREMENT_PER_TICK;
	}
	
	public final double getMax()
	{
		return max;
	}

	public final double getCurrentCount()
	{
		return counter;
	}
	
	public final String getTimerId()
	{
		return timerEvent.getTimerId();
	}

	private final void setMax(double max)
	{
		this.max = max;
	}

	private final void setTarget(OnTimerTrigger target)
	{
		this.target = target;
	}
}
