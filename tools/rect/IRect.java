package tools.rect;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * The IRect or ImageRect is a VisibleRect wich can display an image or texture
 * on it. The Image has to be parsed with the creation of this object. However,
 * this can be changed afterwards using setters and getters for the image.
 * 
 * To draw the IRect on screen just use the draw() method.
 * 
 * The Image has its x and y position at the x and y position of the Rect. The
 * Image is always the same size as the w (width) and the h (height) value of
 * the Rect.
 * 
 * If the image is null then the image will no be rendered on display. Moreover,
 * the displayImage() method will cancel the render operation until the image is
 * not null anymore.
 */

public class IRect extends VRect
{
	private BufferedImage image = null;

	public IRect(int x, int y, BufferedImage image)
	{
		super(x, y);
	}

	public IRect(int x, int y, int w, int h, BufferedImage image)
	{
		super(x, y, w, h);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);

		if (isDisplayRect())
			displayImage(graphics);
	}

	private final void displayImage(Graphics2D graphics)
	{
		if (image == null)
			return;

		graphics.drawImage(image, x, y, w, h, null);
	}

	public final BufferedImage getImage()
	{
		return image;
	}

	public final void setImage(BufferedImage image)
	{
		this.image = image;
	}
}
