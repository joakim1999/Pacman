package com.joapet99.pacman.ghostbehavior;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

import com.joapet99.pacman.collision.Range;

public class RedGhostBehavior extends Behavior{
	float speed = 0.2F;
	
	@Override
	public void update(GameContainer container, int delta) {
		Range r1 = new Range(target);
		Range r2 = new Range(owner);
		if(r2.getRange("-").x < r1.getRange("-").x && owner.canMoveRight == true){
			System.out.println("Got through AI test");
			owner.setPosition(new Vector2f(owner.getPosition().x + speed * delta, owner.getPosition().y));
		}
		if(r2.getRange("-").x > r1.getRange("-").x && owner.canMoveLeft == true){
			System.out.println("Got through AI test");
			owner.setPosition(new Vector2f(owner.getPosition().x - speed * delta, owner.getPosition().y));
		}
		if(r2.getRange("-").y > r1.getRange("-").y && owner.canMoveUp == true){
			owner.setPosition(new Vector2f(owner.getPosition().x, owner.getPosition().y - speed * delta));
		}
		if(r2.getRange("-").y < r1.getRange("-").y && owner.canMoveDown == true){
			owner.setPosition(new Vector2f(owner.getPosition().x, owner.getPosition().y + speed * delta));
		}
		else{}
	}
}
