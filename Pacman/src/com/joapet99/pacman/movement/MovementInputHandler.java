package com.joapet99.pacman.movement;

import org.newdawn.slick.Input;

import com.joapet99.pacman.entity.Entity;

public class MovementInputHandler extends MovementHandler{
	Input in;
	int delta;
	float movementOnX = 0;
	float movementOnY = 0;
	float speed;
	
	public MovementInputHandler(float speed){
		this.speed = speed;
	}
	
	public void setInput(Input input){
		this.in = input;
	}
	
	public float getMovementOnX(){
		movementOnX = 0;
		if(in.isKeyDown(Input.KEY_A)){
			movementOnX -= speed;
		}
		if(in.isKeyDown(Input.KEY_D)){
			movementOnX += speed;
		}
		return movementOnX;
	}
	
	public float getMovementOnY(){
		movementOnY = 0;
		if(in.isKeyDown(Input.KEY_W)){
			movementOnY -= speed;
		}
		if(in.isKeyDown(Input.KEY_S)){
			movementOnY += speed;
		}
		return movementOnY;
	}
}
