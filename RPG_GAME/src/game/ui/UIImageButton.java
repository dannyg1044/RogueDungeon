package game.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{

	private BufferedImage bufferedImage;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage bufferedImage, ClickListener clicker) {
		super(x, y, width, height);
		this.bufferedImage=bufferedImage;
		this.clicker=clicker;
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(bufferedImage, (int)x, (int)y, width, height, null);
		}else {
			g.drawImage(bufferedImage, (int)x, (int)y, width, height, null);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
