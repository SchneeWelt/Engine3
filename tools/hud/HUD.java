package objects.hud;

import java.awt.Color;
import java.awt.Graphics2D;

import globalValues.GlobalValue;
import main.Draw;
import objects.hud.dialog.DecryptorDialog;
import objects.hud.dialog.EncryptorDialog;
import objects.hud.dialog.Pipeline;
import objects.hud.dialog.keyDialog.KeyDialog;
import objects.hud.hudElement.textDisplay.TextDisplayCoordinator;
import tools.Background;
import tools.rect.Rect;

public class HUD implements Draw
{
	private int padding = 20;
	private int screenWidth = GlobalValue.getScreenDimension().width;

	private TextDisplayCoordinator textDisplayCoordinator;
	private DecryptorDialog decryptorDialog;
	private EncryptorDialog encryptorDialog;
	private Background background;
	private KeyDialog keyDialog;
	private Pipeline pipeline;

	public HUD()
	{
		setup();
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		/* background layer */
		background.draw(graphics);

		/* foreground layer */
		keyDialog.draw(graphics);
		decryptorDialog.draw(graphics);
		encryptorDialog.draw(graphics);
	}
	
	private final void setup()
	{
		createPipeline();
		createTextDisplayCoordinator();
		createKeyDialog();
		createEncryptorDialog();
		createDecryptorDialog();
		createBackground();
	}

	private final void createTextDisplayCoordinator()
	{
		textDisplayCoordinator = new TextDisplayCoordinator();
	}

	private final void createKeyDialog()
	{
		int width = 200;
		int height = 250;
		int x = screenWidth - 2 * padding - width;
		Rect location = new Rect(x, padding, width, height);
		keyDialog = new KeyDialog(location, this);
	}

	private final void createEncryptorDialog()
	{
		int width = 260;
		int height = 400;
		Rect location = new Rect(padding, padding, width, height);
		encryptorDialog = new EncryptorDialog(keyDialog, pipeline, location, this);
	}

	private final void createPipeline()
	{
		pipeline = new Pipeline();
	}

	private final void createDecryptorDialog()
	{
		int dist = 42;
		int width = 260;
		int height = 400;
		Rect location = new Rect(2 * padding + width + dist, padding, width, height);
		decryptorDialog = new DecryptorDialog(keyDialog, pipeline, location, this);
	}

	private final void createBackground()
	{
		Color c = Color.black;
		int hudWidth = GlobalValue.getScreenDimension().width;
		int hudHeight = GlobalValue.getScreenDimension().height;
		background = new Background(new Rect(0, 0, hudWidth, hudHeight), c);
	}

	public final TextDisplayCoordinator getTextDisplayCoordinator()
	{
		return textDisplayCoordinator;
	}
}
