package tools.hud.button;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import tools.background.BetterBackground;
import tools.hud.Element;
import tools.rect.Rect;

public class Button extends Element
{
	private boolean buttonHold = false;
	private boolean sendVisualFeedback = false;

	private ButtonEvent buttonEvent;
	private BetterBackground shader;
	private OnButtonHold onButtonHold;
	private OnButtonClick onButtonClick;

	public Button(OnButtonClick onButtonClick, Rect location)
	{
		super(location);
		setup(onButtonClick, null);
	}

	public Button(String buttonId, OnButtonHold onButtonHold, Rect location)
	{
		super(location);
		setup(null, onButtonHold);
		buttonEvent.setButtonId(buttonId);
	}
	
	public Button(String buttonId, OnButtonClick onButtonClick, Rect location)
	{
		super(location);
		setup(onButtonClick, null);
		buttonEvent.setButtonId(buttonId);
	}

	public Button(OnButtonHold onButtonHold, Rect location)
	{
		super(location);
		setup(null, onButtonHold);
	}

	public Button(String buttonId, OnButtonClick onButtonClick, OnButtonHold obButtonHold, Rect location)
	{
		super(location);
		setup(onButtonClick, onButtonHold);
		buttonEvent.setButtonId(buttonId);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);

		/* click response */
		if (sendVisualFeedback)
			sendVisualFeedback(graphics);

		if (buttonHold && onButtonHold != null)
		{
			sendVisualFeedback = true;
			onButtonHold.onButtonHold(buttonEvent);
		}
	}

	@Override
	public void onMousePress(MouseEvent mouseEvent)
	{
		super.onMousePress(mouseEvent);

		if (isElementSelected(mouseEvent))
			buttonHold = true;
	}

	@Override
	public void onMouseRelease(MouseEvent mouseEvent)
	{
		if (isElementSelected(mouseEvent))
		{
			sendVisualFeedback = true;
 
			if (onButtonClick != null)
				onButtonClick.onButtonClick(buttonEvent);
		}

		buttonHold = false;
	}

	private final void setup(OnButtonClick onButtonClick, OnButtonHold onButtonHold)
	{
		this.onButtonHold = onButtonHold;
		this.onButtonClick = onButtonClick;
		buttonEvent = new ButtonEvent("noName");
		shader = new BetterBackground(location, new Color(0, 0, 0, 100));

		frame.setStrokeSize(2);
	}

	private final void sendVisualFeedback(Graphics2D graphics)
	{
		shader.draw(graphics);
		sendVisualFeedback = false;
	}

	public final ButtonEvent getButtonEvent()
	{
		return buttonEvent;
	}
}