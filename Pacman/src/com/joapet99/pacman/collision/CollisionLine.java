package com.joapet99.pacman.collision;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import com.joapet99.pacman.entity.Entity;
import com.joapet99.pacman.entity.MovableEntity;


// Make a line that checks if a object collides into it. Good for making a wall collision
public class CollisionLine {
	int direction;
	Vector2f startLine;
	Vector2f endLine;
	int id;
	ArrayList<CollisionRule> rules;
	int counter;
	public Vector2f newPosition;
	
	public CollisionLine(int id,int direction, Vector2f startLine, Vector2f endLine){
		//direction = where to collision should be activated. 0=right 1=left 2=up
		this.direction = direction;
		//startLine = where the collision line should start
		this.startLine = startLine;
		//endLine = where the collision line should end
		this.endLine = endLine;
		//id = unique identification number to know the difference between the lines
		this.id = id;
		rules = new ArrayList<CollisionRule>();
		counter = 1;
	}
	
	public int getDirection(){
		return direction;
	}

	// A method to make rules An example is: cl1.createCollisionRule(yourObject, isItAllowedToGoThrough?)
	public void createCollisionRule(MovableEntity ent, boolean letThrough){
		if(counter == 1){
			CollisionRule rule1 = new CollisionRule(ent, letThrough);
			rules.add(rule1);
			counter++;
			System.out.println("created rule1");
		}
		else if(counter == 2){
			CollisionRule rule2 = new CollisionRule(ent, letThrough);
			rules.add(rule2);
			counter++;
			System.out.println("created rule2");
		}
		else if(counter == 3){
			CollisionRule rule3 = new CollisionRule(ent, letThrough);
			rules.add(rule3);
			counter++;
			System.out.println("created rule3");
			
		}
		else if(counter == 4){
			CollisionRule rule4 = new CollisionRule(ent, letThrough);
			rules.add(rule4);
			counter++;
			System.out.println("created rule4");
		}
		else if(counter == 5){
			CollisionRule rule5 = new CollisionRule(ent, letThrough);
			rules.add(rule5);
			counter++;
			System.out.println("created rule5");
		}
	}
	
	//Check if the rules has been breaked
	public boolean checkCollisionRules(Entity ent){
		Range range = new Range(ent);
		for(int i = 0;i<rules.size();i++){
			if(direction == 0 && rules.get(i).ent.getId() == ent.getId() && rules.get(i) != null){
				if(range.getRange("+").x > startLine.x && range.getRange("+").y > startLine.y && range.getRange("-").y < endLine.y && range.getRange("+").x < startLine.x + 5){
					System.out.println("Collision Line " + id + ": Breaked rule: " + "rule" + (i + 1));
					return true;
				}
			}
			
			if(direction == 1 && rules.get(i).ent == ent){
				if(range.getRange("-").x < startLine.x && range.getRange("+").y > startLine.y && range.getRange("-").y < endLine.y && range.getRange("-").x > startLine.x - 5){
					System.out.println("Collision Line " + id + ": Breaked rule: " + "rule" + (i + 1));
					return true;
				}
			}
			
			if(direction == 2 && rules.get(i).ent == ent){
				if(range.getRange("+").x > startLine.x && range.getRange("+").y > startLine.y && range.getRange("+").y < startLine.y + 16 && range.getRange("-").x < endLine.x){
					System.out.println("Collision Line " + id + ": Breaked rule: " + "rule" + (i + 1));
					return true;
				}
			}
			if(direction == 3 && rules.get(i).ent == ent){
				if(range.getRange("+").x > startLine.x && range.getRange("-").y < startLine.y && range.getRange("-").y > startLine.y - 16 && range.getRange("-").x < endLine.x){
					System.out.println("Collision Line " + id + ": Breaked rule: " + "rule" + (i + 1));
					return true;
				}
			}
		}
		return false;
	}
	
	//A method for drawing the line is not necessary for the collision to work
	public void drawLine(Graphics g){
		g.drawLine((int)startLine.x, (int)startLine.y, (int)endLine.x, (int)endLine.y);
	}
}
