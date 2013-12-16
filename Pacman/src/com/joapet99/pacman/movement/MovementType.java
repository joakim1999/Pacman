package com.joapet99.pacman.movement;

public enum MovementType {
	KEYBOARDMOVEMENT(new MovementInputHandler(2));
	
	private MovementHandler handler;
	
	MovementType(MovementHandler handler){
		this.handler = handler;
	}
	
	public MovementHandler getMovementHandler(){
		return handler;
	}
}
