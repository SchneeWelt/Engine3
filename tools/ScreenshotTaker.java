package tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.IFrame;

/**
 * This class takes a screenshot on what is currently painted on screen. The
 * screenShot is then safed into the res folder. If this folder is not already
 * available the folder will be created by this class. To take a screen shot
 * call the takeScreenShot() method.
 */

public class ScreenshotTaker
{
	private int counter = 1;

	private String fileName = "screenshot";
	private String fileEnding = ".png";
	private String dir = "./data";
	private BufferedImage input;

	public ScreenshotTaker(IFrame iFrame)
	{
		createDataFolder();
		input = iFrame.getCanvas();
	}

	public final void takeScreenShot()
	{
		BufferedImage output = createOutput();

		for (int x = 0; x < output.getWidth(); x ++)
		{
			for (int y = 0; y < output.getHeight(); y ++)
			{
				int rgb = input.getRGB(x, y);
				output.setRGB(x, y, rgb);
			}
		}
		
		saveImage(output);
		incrementCounter();
	}

	private final BufferedImage createOutput()
	{
		int w = input.getWidth();
		int h = input.getHeight();
		int type = BufferedImage.TYPE_INT_ARGB;
		return new BufferedImage(w, h, type);
	}

	private final void saveImage(BufferedImage image)
	{
		File location = new File(dir + "/" + fileName + counter + fileEnding);

		try
		{
			ImageIO.write(image, fileEnding.replace(".", ""), location);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private final void createDataFolder()
	{
		File dataFolder = new File(dir);
		if (!dataFolder.exists())
			dataFolder.mkdir();
	}

	private final void incrementCounter()
	{
		counter++;
	}
}
