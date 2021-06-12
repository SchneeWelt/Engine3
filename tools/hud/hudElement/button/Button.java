package tools.hud.hudElement.button;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

import tools.background.BetterBackground;
import tools.hud.HUD;
import tools.hud.hudElement.HUDElement;
import tools.rect.Rect;

/**
 * Stellt einen Button grafisch dar. Über getter und Setter können außerdem noch
 * einstellungen gesetzt werden, ob der button unsichtbar setTransparen(true)
 * sein soll, oder ob er beim anlicken aufblinken soll
 * setAllowVisualFeedback(true).
 * 
 * Wird ein Button angeklickt, so ruft dieser das OnButtonClick event, dass ihm
 * in seinem Konstruktor mitgegeben wurde auf. Dabei wird auch immer die
 * ButtonId dieser Button instanz mit übergeben, um bei mehr als einem Button
 * nicht den überblick zu verlieren.
 */

public class Button extends HUDElement
{
	private boolean transparent = false;
	private boolean buttonSelected = false;
	private boolean sendVisuelFeedback = false;
	private boolean allowVisualFeedback = false;

	private ButtonEvent buttonEvent;
	private BetterBackground background;
	private OnButtonClick onButtonClick;
	private Color buttonShaderColor = new Color(0, 0, 0, 75);

	public Button(String buttonId, OnButtonClick onButtonClick, Rect location, HUD hud)
	{
		super(hud, location);
		setup(onButtonClick);
		buttonEvent.setButtonId(buttonId);
	}

	public Button(OnButtonClick onButtonClick, Rect location, HUD hud)
	{
		super(hud, location);
		setup(onButtonClick);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);

		/* graphics layer */
		if (!isTransparent())
		{
			displayBackground(graphics);
			displayButtonShader(graphics);

			/* click response */
			if (sendVisuelFeedback && allowVisualFeedback)
				sendVisualFeedback(graphics);
		}

		/* logic layer */
		computeButtonShader();
	}

	@Override
	protected void displayOutline(Graphics2D graphics)
	{
		if (isTransparent())
			return;

		super.displayOutline(graphics);
	}

	@Override
	public void onMouseRelease(MouseEvent e)
	{
		if (isElementSelected(e.getPoint()))
		{
			sendVisuelFeedback = true;
			onButtonClick.onButtonClick(buttonEvent);
		}
	}

	private final void setup(OnButtonClick onButtonClick)
	{
		this.onButtonClick = onButtonClick;
		buttonEvent = new ButtonEvent("noName");
		background = new BetterBackground(location, Color.cyan);
	}

	private final void displayBackground(Graphics2D graphics)
	{
		background.draw(graphics);
	}

	private final void displayButtonShader(Graphics2D graphics)
	{
		if (isButtonSelected())
		{
			graphics.setColor(buttonShaderColor);

			int x = Math.round(location.getX());
			int y = Math.round(location.getY());
			int w = Math.round(location.getW());
			int h = Math.round(location.getH());

			graphics.fillRect(x + STROKE_SIZE / 2, y + STROKE_SIZE / 2, w - STROKE_SIZE, h);
		}
	}

	private final void computeButtonShader()
	{
		if (isElementSelected())
		{
			setButtonSelected(true);
		} else
			setButtonSelected(false);
	}

	private final void sendVisualFeedback(Graphics2D graphics)
	{
		/* setup */
		int pastStrokeSize = STROKE_SIZE;
		Stroke past = graphics.getStroke();
		Color pastColor = graphics.getColor();

		/* effect */
		int strokeSize = 3;
		graphics.setColor(Color.white);
		graphics.setStroke(new BasicStroke(strokeSize));

		int x = Math.round(location.getX());
		int y = Math.round(location.getY());
		int w = Math.round(location.getW());
		int h = Math.round(location.getH());

		graphics.drawRect(x + strokeSize / 2, y + strokeSize / 2, w - strokeSize, h);

		/* sensoric reset */
		graphics.setColor(pastColor);
		strokeSize = pastStrokeSize;
		graphics.setStroke(past);
		sendVisuelFeedback = false;
	}

	public final void setTransparent(boolean transparent)
	{
		this.transparent = transparent;
	}

	public final ButtonEvent getButtonEvent()
	{
		return buttonEvent;
	}

	private final boolean isTransparent()
	{
		return transparent;
	}

	public final void setAllowVisuelFeedback(boolean allowVisualFeedback)
	{
		this.allowVisualFeedback = allowVisualFeedback;
	}

	private final boolean isButtonSelected()
	{
		return buttonSelected;
	}

	private final void setButtonSelected(boolean mouseOverButton)
	{
		this.buttonSelected = mouseOverButton;
	}
}
