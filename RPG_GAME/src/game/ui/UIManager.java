package game.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import game.run.Handler;

public class UIManager {
	private ArrayList<UIObject> objects;
	private Handler handler;

	
	public ArrayList<UIObject> getObjects() {
		return objects;
	}


	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}


	public Handler getHandler() {
		return handler;
	}


	public void setHandler(Handler handler) {
		this.handler = handler;
	}


	public UIManager(Handler handler) {
		this.handler=handler;
		objects = new ArrayList<UIObject>();
	}
	
	
	public void tick() {
		for(UIObject o : objects) {
			o.tick();
		}
	}
	public void render(Graphics g) {
		for(UIObject o : objects) {
			o.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		for(UIObject o : objects) {
			o.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		for(UIObject o : objects) {
			o.onMouseRelease(e);
		}
	}
	
	public void addObjects(UIObject o) {
		objects.add(o);
	}
	
	public void removeObjects(UIObject o) {
		objects.remove(o);
	}

}
