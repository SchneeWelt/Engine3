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
 * If the image is null then the image will not be rendered on display. Moreover,
 * the displayImage() method will cancel the render operation until the image is
 * non null anymore.
 * 
 * You can change wether the image is shown or not -> displayImage
 */

public class IRect extends VRect
{
	private boolean displayImage = true;

	private BufferedImage image = null;

	/* clone constructor */
	public IRect(IRect iRect)
	{
		super(iRect);
		setImage(iRect.getImage());
		setDisplayImage(iRect.isDisplayImage());
	}

	public IRect(int x, int y, BufferedImage image)
	{
		super(x, y);
		setImage(image);
	}

	public IRect(int x, int y, int w, int h, BufferedImage image)
	{
		super(x, y, w, h);
		setImage(image);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		if (isDisplayImage() && image != null)
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

	public final boolean isDisplayImage()
	{
		return displayImage;
	}

	public final void setDisplayImage(boolean displayImage)
	{
		this.displayImage = displayImage;
	}
}
