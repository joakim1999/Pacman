package com.joapet99.pacman.collision;

import com.joapet99.pacman.entity.MovableEntity;

public class CollisionRule {
	MovableEntity ent;
	boolean letThrough;
	public CollisionRule(MovableEntity ent, boolean letThrough){
		this.ent = ent;
		this.letThrough = letThrough;
	}
}
