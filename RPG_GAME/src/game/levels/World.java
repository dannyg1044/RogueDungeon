package game.levels;

import java.awt.Graphics;
import java.util.Arrays;

import game.entities.EntityManager;
import game.entities.Player.Knight;
import game.entities.statics.Chest;
import game.items.ItemManager;
import game.run.Game;
import game.run.Handler;
import game.tiles.Tile;
import game.utils.Utils;

public class World {
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private Handler handler;
	//Entities
	private EntityManager entityManager;
	
	private ItemManager itemManager;
	
	public World(Handler handler, String path) {
		this.handler=handler;
		entityManager = new EntityManager(handler, new Knight(handler, 100, 100));
		itemManager = new ItemManager(handler);
		roomOneChestGen();
		roomTwoChestGen();
		roomThreeChestGen();
		roomFourChestGen();
		roomFiveChestGen();
		loadWorld(path);
		
		entityManager.getKnight().setX(spawnX);
		entityManager.getKnight().setY(spawnY);
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+4]);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x<0||y<0||x>=width||y>=height) {
			return Tile.floorTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null) {
			return Tile.floorTile;
		}
		return t;
	}
	
	
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
		
	}
	public void render(Graphics g) {
		int xStart=(int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
		int xEnd=(int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILE_WIDTH+1);
		int yStart=(int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);
		int yEnd=(int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILE_HEIGHT+1);
		
		for(int y=yStart; y<yEnd; y++) {
			for(int x=xStart; x<xEnd; x++) {
				getTile(x,y).render(g, (int)(x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int)(y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private void roomOneChestGen() {
		int k = 1 + (int)(Math.random() * ((2 - 1) + 1));
		for(int i=0; i<k; i++) {
			entityManager.addEntity(new Chest(handler, 100 + (int)(Math.random() * ((800 - 100) + 1)), 100 + (int)(Math.random() * ((500 - 100) + 1))));
		}
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void roomTwoChestGen() {
		int k = 1 + (int)(Math.random() * ((2 - 1) + 1));
		for(int i=0; i<k; i++) {
			entityManager.addEntity(new Chest(handler, 1000 + (int)(Math.random() * ((1700 - 1000) + 1)), 100 + (int)(Math.random() * ((500 - 100) + 1))));
		}
	}
	private void roomThreeChestGen() {
		int k = 1 + (int)(Math.random() * ((2 - 1) + 1));
		for(int i=0; i<k; i++) {
			entityManager.addEntity(new Chest(handler, 1000 + (int)(Math.random() * ((1700 - 1000) + 1)), 
					700 + (int)(Math.random() * ((1100 - 700) + 1))));
		}
	}
	private void roomFourChestGen() {
		int k = 1 + (int)(Math.random() * ((2 - 1) + 1));
		for(int i=0; i<k; i++) {
			entityManager.addEntity(new Chest(handler, 100 + (int)(Math.random() * ((800 - 100) + 1)), 
					700 + (int)(Math.random() * ((1100 - 700) + 1))));
		}
	}
	private void roomFiveChestGen() {
		int k = 1 + (int)(Math.random() * ((3 - 1) + 1));
		for(int i=0; i<k; i++) {
			entityManager.addEntity(new Chest(handler, 100 + (int)(Math.random() * ((1700 - 100) + 1)), 
					1300 + (int)(Math.random() * ((1700 - 1300) + 1))));
		}
	}

}
