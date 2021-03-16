package gui;

import java.awt.Dimension;
import java.awt.Point;

/**
 * I use this class quiet rarly however, it can be used to determine where to
 * repaint. Therefore, this class allows to not rerender the whole screen every
 * tick.
 * 
 * use initReapaintControler() to init this class. After that the repaint
 * controle can always be accesed by the static getRepaintControler() method.
 * 
 */

public class RepaintControler
{
	private IFrame iFrame = null;
	private static RepaintControler repaintControler = null;

	public RepaintControler(IFrame iFrame)
	{
		this.iFrame = iFrame;
	}

	public final void repaintIPanel(Point startLocation, Dimension repaintDimension)
	{
		iFrame.repaintIPanel(startLocation, repaintDimension);
	}

	public final void repaintIPanel()
	{
		iFrame.repaintIPanel();
	}

	public static final RepaintControler getRepaintControler()
	{
		return repaintControler;
	}

	public static final void initReapaintControler(IFrame iFrame)
	{
		repaintControler = (repaintControler == null) ? repaintControler = new RepaintControler(iFrame)
				: repaintControler;
	}
}
