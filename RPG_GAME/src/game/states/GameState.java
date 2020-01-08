package game.states;

import java.awt.Graphics;

import game.entities.Player.Knight;
import game.levels.World;
import game.run.Game;
import game.run.Handler;
import game.tiles.Tile;

public class GameState extends State{
	
	private Knight knight;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/Worlds/World1.txt");
		handler.setWorld(world);
		
		
		
		
	}

	@Override
	public void tick() {
		world.tick();
		
	
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		
	}

}
