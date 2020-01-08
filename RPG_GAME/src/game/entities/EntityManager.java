package game.entities;

import java.awt.Graphics;
import java.util.*;

import game.entities.Player.Knight;
import game.run.Handler;

public class EntityManager {
	
	private Handler handler;
	private Knight knight;

	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY()+a.getHeight() < b.getY()+b.getHeight()) {
				return -1;
			}
			return 1;
		}
		
	};
	
	public EntityManager(Handler handler, Knight knight) {
		this.handler=handler;
		this.knight=knight;
		entities = new ArrayList<Entity>();
		addEntity(knight);
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e=it.next();
			e.tick();
			if(!e.isActive()) {
				it.remove();
			}
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Knight getKnight() {
		return knight;
	}

	public void setKnight(Knight knight) {
		this.knight = knight;
	}


	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
