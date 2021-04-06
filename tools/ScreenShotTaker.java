package tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.IPanel;

/**
 * This class takes a screenshot on what is currently painted on screen. The
 * screenShot is then safed into the res folder. If this folder is not already
 * available the folder will be created by this class. To take a screen shot
 * call the takeScreenShot() method.
 */

public class ScreenShotTaker
{
	private int counter = 1;
	
	public ScreenShotTaker()
	{
		tryToCreateResFolder();
	}

	public final void takeScreenShot()
	{
		File outputFile = new File("res/ScreenShot" + counter + ".png");
		BufferedImage screenShot = IPanel.getIImage();
		
		try
		{
			ImageIO.write(screenShot, "png", outputFile);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		counter ++;
	}

	private final void tryToCreateResFolder()
	{
		File resFolder = new File("res");

		if (!resFolder.exists())
		{
			resFolder.mkdir();
		}
	}
}
