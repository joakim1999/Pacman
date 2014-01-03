package com.joapet99.pacman.collision;

import org.newdawn.slick.geom.Vector2f;

import com.joapet99.pacman.entity.Entity;

public class Range{
	Entity object1;
	Entity object2;
	public Range(Entity object1){
		this.object1 = object1;
	}
	/*
	 *  +
	 *   --------|
	 *   |       |
	 *   |       |
	 *   |       |
	 *   |--------
	 *            -
	 */
	
	//gets the position of one of the pools
	public Vector2f getRange(String pool){
		if(pool.equals("-")){
			return new Vector2f(object1.getPosition());
		}
		if(pool.equals("+")){
			return new Vector2f(object1.getPosition().x + object1.getTexture().getWidth(), object1.getPosition().y + object1.getTexture().getHeight());
		}
		return null;
	}
}
