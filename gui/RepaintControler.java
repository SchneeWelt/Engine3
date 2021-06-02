package gui;

import tools.rect.Rect;

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
	private IFrame iFrame;
	private static RepaintControler repaintControler;

	public RepaintControler(IFrame iFrame)
	{
		this.iFrame = iFrame;
	}

	public final void repaintIPanel(Rect area)
	{
		iFrame.repaintCanvas(area);
	}

	public final void repaintCanvas()
	{
		iFrame.repaintCanvas();
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
