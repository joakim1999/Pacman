package com.joapet99.pacman.ghostbehavior;

import org.newdawn.slick.GameContainer;

import com.joapet99.pacman.entity.Entity;
import com.joapet99.pacman.entity.Ghost;

public abstract class Behavior {
	Entity target;
	Ghost owner;
	
	public abstract void update(GameContainer container, int delta);
	
	public void setTarget(Entity target){
		this.target = target;
	}
	
	public void setOwner(Ghost owner){
		this.owner = owner;
	}
	
	public Entity getTarget(){
		return target;
	}
	public Ghost getGhost(){
		return owner;
	}
}
