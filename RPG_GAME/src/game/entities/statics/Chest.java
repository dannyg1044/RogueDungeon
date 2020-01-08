package game.entities.statics;

import java.awt.Graphics;

import game.gfx.Assets;
import game.items.Item;
import game.run.Handler;
import game.tiles.Tile;

public class Chest extends StaticEntity{

	public Chest(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x =12;
		bounds.y =10;
		bounds.width = 75;
		bounds.height =65;
	}
	@Override
	public void die() {
		int i = 1 + (int)(Math.random() * ((2 - 1) + 1));
		if (i==1) {
			handler.getWorld().getItemManager().addItem(Item.daggerItem.createNew((int)x,(int)y));
		}else if (i ==2) {
			handler.getWorld().getItemManager().addItem(Item.lightsaberItem.createNew((int)x,(int)y));
		}else if(i ==3) {
			handler.getWorld().getItemManager().addItem(Item.swordItem.createNew((int)x,(int)y));
		}
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.chest, (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width, height, null);
	}

}
