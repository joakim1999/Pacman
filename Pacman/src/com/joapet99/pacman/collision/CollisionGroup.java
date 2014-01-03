package com.joapet99.pacman.collision;

import java.util.ArrayList;

import org.newdawn.slick.geom.Vector2f;
import com.joapet99.pacman.entity.Block;
import com.joapet99.pacman.entity.MovableEntity;

public class CollisionGroup{
	public ArrayList<CollisionLine> collisionLines;
	public Block lowest;
	public Block highest;
	public ArrayList<MovableEntity> exception;
	public int id;
	
	public CollisionGroup(int id, ArrayList<CollisionLine> list, Block blockWithLowest, Block blockWithHighest, ArrayList<MovableEntity> collisionException){
		this.id = id;
		this.collisionLines = list;
		this.lowest = blockWithLowest;
		this.highest = blockWithHighest;
		this.exception = collisionException;
		makeCollisionLines();
	}
	
	public int getId(){
		return id;
	}
	
	public void makeCollisionLines(){
		System.out.println("Starting to write collision lines");
		if(lowest.getPosition().x == highest.getPosition().x && lowest.getPosition().y < highest.getPosition().y){
			collisionLines.add(new CollisionLine(collisionLines.size(), 2, new Vector2f(lowest.getPosition().x, lowest.getPosition().y), new Vector2f(lowest.getPosition().x + 32, lowest.getPosition().y)));
			for(MovableEntity target : exception){
				collisionLines.get(collisionLines.size() - 1).createCollisionRule(target, false);
			}
			collisionLines.add(new CollisionLine(collisionLines.size(), 3, new Vector2f(highest.getPosition().x, highest.getPosition().y + 32), new Vector2f(highest.getPosition().x + 32, highest.getPosition().y + 32)));
			for(MovableEntity target : exception){
				collisionLines.get(collisionLines.size() - 1).createCollisionRule(target, false);
			}
			collisionLines.add(new CollisionLine(collisionLines.size(), 0, new Vector2f(lowest.getPosition().x, lowest.getPosition().y), new Vector2f(highest.getPosition().x, highest.getPosition().y + 32)));
			for(MovableEntity target : exception){
				collisionLines.get(collisionLines.size() - 1).createCollisionRule(target, false);
			}
			collisionLines.add(new CollisionLine(collisionLines.size(), 1, new Vector2f(lowest.getPosition().x + 32, lowest.getPosition().y), new Vector2f(highest.getPosition().x + 32, highest.getPosition().y + 32)));
			for(MovableEntity target : exception){
				collisionLines.get(collisionLines.size() - 1).createCollisionRule(target, false);
			}
		}
		else if(lowest.getPosition().x < highest.getPosition().x && lowest.getPosition().y == highest.getPosition().y){
			collisionLines.add(new CollisionLine(collisionLines.size(), 2, new Vector2f(lowest.getPosition().x, lowest.getPosition().y), new Vector2f(highest.getPosition().x + 32, highest.getPosition().y)));
			for(MovableEntity target : exception){
				collisionLines.get(collisionLines.size() - 1).createCollisionRule(target, false);
			}
			collisionLines.add(new CollisionLine(collisionLines.size(), 3, new Vector2f(lowest.getPosition().x, lowest.getPosition().y + 32), new Vector2f(highest.getPosition().x + 32, highest.getPosition().y + 32)));
			for(MovableEntity target : exception){
				collisionLines.get(collisionLines.size() - 1).createCollisionRule(target, false);
			}
			collisionLines.add(new CollisionLine(collisionLines.size(), 0, new Vector2f(lowest.getPosition().x, lowest.getPosition().y), new Vector2f(lowest.getPosition().x, lowest.getPosition().y + 32)));
			for(MovableEntity target : exception){
				collisionLines.get(collisionLines.size() - 1).createCollisionRule(target, false);
			}
			collisionLines.add(new CollisionLine(collisionLines.size(), 1, new Vector2f(highest.getPosition().x + 32, highest.getPosition().y), new Vector2f(highest.getPosition().x + 32, highest.getPosition().y + 32)));
			for(MovableEntity target : exception){
				collisionLines.get(collisionLines.size() - 1).createCollisionRule(target, false);
			}
		}
		else{
			System.out.println("This block group does not match one of the block group requirements of position");
		}
		System.out.println("All lines succesfully created");
	}
	
	
	public boolean checkCollision(CollisionGroup current, MovableEntity entity){
		for(CollisionLine cl : collisionLines){
			if(cl.getDirection() == 0){
				if(cl.checkCollisionRules(entity)){
					entity.canMoveRight = false;
					return true;
				}
			}
			else if(cl.getDirection() == 1){
				if(cl.checkCollisionRules(entity)){
					entity.canMoveLeft = false;
					return true;
				}
			}
			else if(cl.getDirection() == 2){
				if(cl.checkCollisionRules(entity)){
					entity.canMoveDown = false;
		    		return true;
				}
			}
			else if(cl.getDirection() == 3){
				if(cl.checkCollisionRules(entity)){
					entity.canMoveUp = false;
		    		return true;
				}
			}
		}
		return false;
	}
}
