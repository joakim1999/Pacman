package com.joapet99.pacman.entity;

import java.util.ArrayList;

public class MovableEntity extends Entity{
	public boolean canMoveLeft = true;
	public boolean canMoveRight = true;
	public boolean canMoveUp = true;
	public boolean canMoveDown = true;
	public ArrayList<Integer> isCollidingFrom;
	
	public MovableEntity(EntityGroup group, int id) {
		super(group, id);
		isCollidingFrom = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getIsCollidingFrom(){
		return isCollidingFrom;
	}
}
