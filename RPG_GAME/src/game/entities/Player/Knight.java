package game.entities.Player;


import java.awt.Graphics;
import java.awt.Rectangle;


import game.entities.Entity;
import game.gfx.Assets;

import game.run.Handler;

public class Knight extends Player{
	
	//attack timer
	private long lastAttackTimer, attackCooldown = 100, attackTimer=attackCooldown;
	
	public Knight(Handler handler, float x, float y) {
		super(handler, x,y, Player.DEFAULT_WIDTH, Player.DEFAULT_HEIGHT);
		bounds.x =23;
		bounds.y =10;
		bounds.width = 48;
		bounds.height =54;
		
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}
	
	public void die() {
		System.out.println("Game Over");
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//attacks
		checkAttacks();
	}
	
	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown) {
			return;
		}
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if (handler.getKeyManager().aUp) {
			ar.x = cb.x+cb.width/2 - arSize/2;
			ar.y = cb.y-arSize;
		}else if (handler.getKeyManager().aDown) {
			ar.x = cb.x+cb.width/2 - arSize/2;
			ar.y = cb.y+cb.height;
		}else if (handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y+cb.height/2 - arSize/2;
		}else if (handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y+cb.height/2 - arSize/2;
		}else {
			return;
		}
		attackTimer = 0;
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.knight, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
			//	(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
			//	bounds.width, bounds.height);
	}
}
