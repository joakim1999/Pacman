package com.joapet99.pacman.movement;

import org.newdawn.slick.GameContainer;

import com.joapet99.pacman.entity.Entity;

public class Movement {
	MovementType type;
	Entity owner;
	
	public Movement(MovementType typeOfMovement, Entity owner){
		this.type = typeOfMovement;
		this.owner = owner;
	}
	
	public void update(GameContainer container, int delta){
		((MovementInputHandler)type.getMovementHandler()).setInput(container.getInput());
		owner.setPosition(owner.getPosition().add(type.getMovementHandler().getMovement()));
	}
}
