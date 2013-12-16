package com.joapet99.pacman.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.joapet99.pacman.movement.Movement;

public class Entity{
	EntityGroup group;
	int id;
	Image texture;
	Vector2f position;
	Movement movement;
	
	public Entity(EntityGroup group, int id){
		this.group = group;
		this.id = id;
	}
	
	public EntityGroup getEntityGroup(){
		return group;
	}
	
	public int getId(){
		return id;
	}
	
	public void setTexture(Image texture){
		this.texture = texture;
	}
	
	public Image getTexture(){
		return texture;
	}
	
	public void setPosition(Vector2f position){
		this.position = position;
	}
	
	public Vector2f getPosition(){
		return position;
	}
	
	public void render(Graphics gr){
		gr.drawImage(texture, position.x, position.y);
	}
	
	public void setMovement(Movement movement){
		this.movement = movement;
	}
	
	public Movement getMovement(){
		return movement;
	}
	
	public void update(GameContainer container, int delta){
		if(movement != null){
			movement.update(container, delta);
		}
	}
}
