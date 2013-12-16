package com.joapet99.pacman.entity;

import java.util.ArrayList;

public enum EntityGroup {
	PLAYER(true, true, new ArrayList<Integer>()),
	ENEMY(false, true, new ArrayList<Integer>());
	
	private boolean canInteract;
	private boolean canCollide;
	private ArrayList<Integer> ids;
	
	EntityGroup(boolean canInteract, boolean canCollide, ArrayList<Integer> ids){
		this.canInteract = canInteract;
		this.canCollide = canCollide;
		this.ids = ids;
	}
	
	public boolean canInteract(){
		return canInteract;
	}
	
	public boolean canCollide(){
		return canCollide;
	}
	
	public ArrayList<Integer> getIds(){
		return ids;
	}
}
