package system;

import in.Update;

public class MaximumTickControl implements Update
{
	/*
	 * 1. Schau nach, wie lange es brauch einen frame zu rendern. 
	 * 2. Gleiche das Ergebnis mit dem Ergebnis von Globals.TICK_RATE ab
	 * 3. Reagiere auf das Ergebnis
	 */

	private long deltaTime;
	private long start, stop;
	private int decreasor = 1;

	@Override
	public void update()
	{
		computeDeltaTime();
		compareDeltaTime();
	}

	private final void compareDeltaTime()
	{
		if (isAboveGPUPerformance())
		{
			printError();
			decreaseTicks();
		} 
	}
	
	private final void printError()
	{
		String message = "[System] A Tick value of: " + Globals.TICKS;
		message += "\nIs to high!\nSo I decrease the Value to: " + (Globals.TICKS - decreasor);
		
		System.out.println(message);
	}
	
	private final void decreaseTicks()
	{
		Globals.TICKS -= decreasor;
		Globals.updateTickRate();
	}

	private final void computeDeltaTime()
	{
		deltaTime = stop - start;
	}

	public final void takeStart()
	{
		start = System.currentTimeMillis();
	}

	public final void takeStop()
	{
		stop = System.currentTimeMillis();
	}
	
	private final boolean isAboveGPUPerformance()
	{
		int tempDeltaTime = Math.round(deltaTime);
		int tempTickRate = (int) Math.round(Globals.TICK_RATE);
		
		return tempDeltaTime > tempTickRate;
	}
}
