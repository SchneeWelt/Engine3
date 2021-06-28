package tools.background;

import java.awt.Color;
import java.awt.Graphics2D;

import in.Draw;
import tools.rect.Rect;
import tools.rect.VRect;

public class BetterBackground implements Draw
{
	private VRect pane;
	
	public BetterBackground(Rect location, Color backgroundColor)
	{
		pane = new VRect(location, backgroundColor);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		pane.draw(graphics);
	}
	
	public final void setLocation(Rect location)
	{
		pane.setX(location.getX());
		pane.setY(location.getY());
		pane.setW(location.getW());
		pane.setH(location.getH());
	}
	
	public final void setBackgroundColor(Color backgroundColor)
	{
		pane.setColor(backgroundColor);
	}
}
