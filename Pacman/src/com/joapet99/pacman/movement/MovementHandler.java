package com.joapet99.pacman.movement;

import org.newdawn.slick.geom.Vector2f;

public abstract class MovementHandler {
	public MovementHandler(){
		
	}
	
	public abstract float getMovementOnX();
	public abstract float getMovementOnY();
	
	public Vector2f getMovement(){
		return new Vector2f(getMovementOnX(), getMovementOnY());
	}
}
