package com.joapet99.pacman.movement;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

public abstract class MovementHandler {
	Vector2f movementChange;
	
	public MovementHandler(){
	}
	
	public abstract float getMovementOnX();
	public abstract float getMovementOnY();
	
	public Vector2f getMovement(){
		return movementChange;
	}
	
	public void update(GameContainer container, int delta){
		movementChange = new Vector2f(getMovementOnX(), getMovementOnY());
	}
}
