//Not used anymore
//Deprecated
//Replacement: CollsionLine.checkCollisionRules
package com.joapet99.pacman.collision;

import java.awt.Color;
import org.newdawn.slick.geom.Vector2f;

import com.joapet99.pacman.entity.Entity;

@Deprecated
public class CollisionHandler {
	public Entity object1;
	public Entity object2;
	public Entity objects[];
	public String idsT;
	public String idsB = "";
	public boolean isColliding = false;
	public boolean isCollidingFromLeft = false;
	public boolean isCollidingFromRight = false;
	public boolean isCollidingFromTop = false;
	public boolean isCollidingFromBottom = false;
	public boolean isAlreadyAddedToIds = false;
	public String isCollidingLeft = "";
	public String isCollidingRight = "";
	public String isCollidingTop = "";
	public String isCollidingBottom = "";
	public float collisionAdd = 0.0F;
	public Vector2f newPosition;
	public float calculateAdd;
	public float neededCalculateAdd;
	public Range rad;
	public Range rad1;
	public CollisionHandler(Entity object1, Entity object2){
		this.object1 = object1;
		this.object2 = object2;
		rad = new Range(object1);
		rad1 = new Range(object2);
		idsT = "";
	}
	public CollisionHandler(Entity object1, Entity objects[]){
		this.object1 = object1;
		this.objects = objects;
		idsT = "";
	}
    public void setExtendedCollisionDistance(float par1){
		collisionAdd = par1;
	}
	public void checkCollisionFromLeft(){
		if(rad.getRange("-").x <= rad1.getRange("+").x/* && rad.getRange("-").x > rad1.getRange("+").x - 9*/ && rad.getRange("+").y > rad1.getRange("-").y + 4){
			isCollidingFromLeft = true;
		}
		else{
			isCollidingFromLeft = false;
		}
	}
	public void checkCollisionFromRight(){
		Range rad = new Range(object1);
		Range rad1 = new Range(object2);
		if(rad.getRange("+").x >= rad1.getRange("-").x/* && rad.getRange("+").x < rad1.getRange("-").x + 9 */&& rad.getRange("+").y > rad1.getRange("-").y + 9){
			isCollidingFromRight = true;
		}
		else{
			isCollidingFromRight = false;
		}
	}
	public void checkCollisionFromTop(){
		Range rad = new Range(object1);
		Range rad1 = new Range(object2);
		Vector2f position = object1.getPosition();
		if(rad.getRange("+").y >= rad1.getRange("-").y && rad.getRange("+").y < rad1.getRange("-").y + 8 && rad.getRange("+").x > rad1.getRange("-").x && rad.getRange("-").x < rad1.getRange("+").x){
			isCollidingFromTop = true;
		}
		else{
			isCollidingFromTop = false;
		}
	}
	public void checkCollisionFromBottom(){
		Range rad = new Range(object1);
		Range rad1 = new Range(object2);
		if(rad.getRange("-").y >= rad1.getRange("+").y && rad.getRange("+").y < rad1.getRange("-").y - 8 && rad.getRange("+").x > rad1.getRange("-").x && rad.getRange("-").x < rad1.getRange("+").x){
			isCollidingFromBottom = true;
		}
		else{
			isCollidingFromBottom = false;
		}
	}
	public void checkCollisionGroup(boolean full){
		for(int i = 0;i < objects.length;i++){
			if(full == true){
				object2 = objects[i];
				isCollidingFromLeft = false;
				isCollidingFromRight = false;
				isCollidingFromTop = false;
				isCollidingFromBottom = false;
				checkCollisionFromLeft();
				checkCollisionFromRight();
				checkCollisionFromTop();
				checkCollisionFromBottom();
				if(isCollidingFromLeft==true && isCollidingFromTop == false){
					isCollidingLeft += "true";
				}
				else{
					isCollidingLeft += "false";
				}
				if(isCollidingFromRight==true && isCollidingFromTop == false){
					isCollidingRight += "true";
				}
				else{
					isCollidingRight += "false";
				}
				if(isCollidingFromBottom){
					idsB += objects[i].getId();
					isCollidingBottom += "true";
				}
				else{
					isCollidingBottom += "false";
				}
				if(isCollidingFromTop == true){
					idsT += objects[i].getId();
					isCollidingTop += "true";
				}
				else{
					isCollidingTop += "false";
				}
			}
		}
	}
	
}
