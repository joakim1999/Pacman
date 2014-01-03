package com.joapet99.pacman.movement;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

import com.joapet99.pacman.entity.Entity;
import com.joapet99.pacman.entity.Player;

public class Movement {
	MovementType type;
	Entity owner;
	
	public Movement(MovementType typeOfMovement, Entity owner){
		this.type = typeOfMovement;
		this.owner = owner;
	}
	
	public void update(GameContainer container, int delta){
		((MovementInputHandler)type.getMovementHandler()).update(container, delta);
		if(owner instanceof Player){
			if(((Player)owner).canMoveLeft == false){
				System.out.println("MAJAHI! MAJAHA!");
				if(type.getMovementHandler().getMovementOnX() < 0){
					System.out.println("Doing a sub thingy!");
					type.getMovementHandler().getMovement().sub(new Vector2f(type.getMovementHandler().getMovementOnX(), 0));
				}
			}
			if(((Player)owner).canMoveRight == false){
				if(type.getMovementHandler().getMovementOnX() > 0){
					System.out.println("Doing a sub thingy!");
					type.getMovementHandler().getMovement().sub(new Vector2f(type.getMovementHandler().getMovementOnX(), 0));
				}
			}
			if(((Player)owner).canMoveDown == false){
				if(type.getMovementHandler().getMovementOnY() > 0){
					System.out.println("Doing a sub thingy!");
					type.getMovementHandler().getMovement().sub(new Vector2f(0, type.getMovementHandler().getMovementOnY()));
				}
			}
			if(((Player)owner).canMoveUp == false){
				if(type.getMovementHandler().getMovementOnY() < 0){
					System.out.println("Doing a sub thingy!");
					type.getMovementHandler().getMovement().sub(new Vector2f(0, type.getMovementHandler().getMovementOnY()));
				}
			}
		}
		owner.setPosition(owner.getPosition().add(type.getMovementHandler().getMovement()));
	}
}
