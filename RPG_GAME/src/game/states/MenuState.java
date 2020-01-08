package game.states;

import java.awt.Color;
import java.awt.Graphics;

import game.gfx.Assets;
import game.run.Handler;
import game.ui.ClickListener;
import game.ui.UIImageButton;
import game.ui.UIManager;

public class MenuState extends State{
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObjects(new UIImageButton(300, 200, 400, 120, Assets.play, new ClickListener(){

			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObjects(new UIImageButton(375, 375, 250, 250, Assets.quit, new ClickListener(){

			@Override
			public void onClick() {
				System.exit(1);
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 1000, 700);
		g.drawImage(Assets.title, 280, 5, 425, 175, null);
		uiManager.render(g);
	}

}
