package com.joapet99.pacman.entity;

import org.newdawn.slick.GameContainer;

public class Ghost extends MovableEntity{
	GhostType type;
	
	public Ghost(int id, GhostType ghostType, Entity target) {
		super(EntityGroup.ENEMY, id);
		this.type = ghostType;
		type.getBehavior().setTarget(target);
		type.getBehavior().setOwner(this);
	}
	
	public void update(GameContainer container, int delta){
		type.getBehavior().setOwner(this);
		type.getBehavior().update(container, delta);
	}
	
	public GhostType getGhostType(){
		return type;
	}
}
