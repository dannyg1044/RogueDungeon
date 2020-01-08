package game.states;

import java.awt.Graphics;

import game.run.Game;
import game.run.Handler;

public abstract class State {
	//state manager
	private static State currentState= null;
	
	public static void setState(State state) {
		currentState=state;
	}
	public static State getState() {
		return currentState;
	}
	protected Handler handler;
	public State(Handler handler) {
		this.handler=handler;
	}
	
	//CLASS
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
