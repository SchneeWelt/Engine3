package tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Provides methods for loading images into ram.
 * 
 * @author jaapi
 *
 */

public class ImageLoader
{
	public static final BufferedImage loadImage(String path)
	{
		try
		{
			return ImageIO.read(new File(path));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static final BufferedImage loadImageInstance(int x, int y, int w, int h, String path)
	{
		return loadImage(path).getSubimage(x, y, w, h);
	}
	
	public static final BufferedImage loadImageInstance(int x, int y, int w, int h, BufferedImage parent)
	{
		return parent.getSubimage(x, y, w, h);
	}
}
