package com.joapet99.pacman.entity;

import com.joapet99.pacman.ghostbehavior.Behavior;
import com.joapet99.pacman.ghostbehavior.RedGhostBehavior;

public enum GhostType {
	BLUE(new RedGhostBehavior()),
	RED(new RedGhostBehavior()),
	GREEN(new RedGhostBehavior());
	
	Behavior behavior;
	
	GhostType(Behavior behavior){
		this.behavior = behavior;
	}
	
	public Behavior getBehavior(){
		return behavior;
	}
}
