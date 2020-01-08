package game.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.gfx.Assets;
import game.run.Handler;

public class Item {
	public static Item[] items = new Item[256];
	public static Item swordItem = new Item(Assets.sword, "Sword", 0);
	public static Item lightsaberItem = new Item(Assets.lightsaber, "Lightsaber", 1);
	public static Item daggerItem = new Item(Assets.dagger, "Dagger", 2);
	
	public static final int ITEM_WIDTH = 32, ITEM_HEIGHT = 32, PICKED_UP = -1;
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected int x, y, count;
	
	public Item(BufferedImage texture, String name, int id) {
		this.texture=texture;
		this.name = name;
		this.id=id;
		count =1;
		
		items[id] = this;
	}
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		if(handler ==null) {
			return;
		}
		render(g,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()));
	}
	
	public Item createNew(int x2, int y2) {
		Item i = new Item(texture, name, id);
		i.setPosition(x2, y2);
		return i;
	}
	
	public void setPosition(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
	}
	
}
