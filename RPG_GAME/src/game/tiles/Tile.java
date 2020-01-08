package game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//static stuff
	public static Tile[] tiles=new Tile[256];
	public static Tile doorTile = new DoorTile(2);
	public static Tile floorTile = new FloorTile(0);
	public static Tile wallTile = new WallTile(1);
	
	
	//CLASS
	protected BufferedImage texture;
	protected final int id;
	public static final int TILE_WIDTH=100, TILE_HEIGHT=100;
	
	public Tile(BufferedImage texture, int id) {
		this.texture=texture;
		this.id=id;
		
		tiles[id] = this;
	}
	
	public int getID() {
		return this.id;
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}

}
