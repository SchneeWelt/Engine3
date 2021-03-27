package tools.timer;

import java.awt.Graphics2D;

import main.Draw;

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

	private OnTimerTrigger target = null;

	public Timer(int max, OnTimerTrigger target)
	{
		setMax(max);
		resetCounter();
		setTarget(target);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		incrementCounter();

		if (counter > max)
		{
			resetCounter();
			target.onTimerTrigger();
		}
	}

	private final void resetCounter()
	{
		counter = MIN;
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
