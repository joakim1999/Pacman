package com.joapet99.pacman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import com.joapet99.pacman.collision.CollisionGroup;
import com.joapet99.pacman.collision.CollisionLine;
import com.joapet99.pacman.entity.Block;
import com.joapet99.pacman.entity.Entity;
import com.joapet99.pacman.entity.EntityGroup;
import com.joapet99.pacman.entity.Ghost;
import com.joapet99.pacman.entity.GhostType;
import com.joapet99.pacman.entity.MovableEntity;
import com.joapet99.pacman.entity.Player;
import com.joapet99.pacman.movement.Movement;
import com.joapet99.pacman.movement.MovementType;

public class MainGameFile extends BasicGame{
	Player thePlayer;
	Ghost enemy;
	ArrayList<CollisionGroup> collisionGroups;
	ArrayList<Block> blocks;
	ArrayList<CollisionLine> collisionLines;
	ArrayList<MovableEntity> movableEntities;
	
	public MainGameFile(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics gr)
			throws SlickException {
		thePlayer.render(gr);
		enemy.render(gr);
		for(Block b : blocks){
			b.render(gr);
		}
		for(CollisionLine cl : collisionLines){
			cl.drawLine(gr);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		collisionLines = new ArrayList<CollisionLine>();
		collisionGroups = new ArrayList<CollisionGroup>();
		movableEntities = new ArrayList<MovableEntity>();
		blocks = new ArrayList<Block>();
		thePlayer = new Player(0);
		thePlayer.setTexture(new Image("com/joapet99/pacman/textures/Pacman.png"));
		thePlayer.setPosition(new Vector2f(200, 200));
		thePlayer.setMovement(new Movement(MovementType.KEYBOARDMOVEMENT, thePlayer));
		movableEntities.add(thePlayer);
		enemy = new Ghost(0, GhostType.RED, thePlayer);
		enemy.setTexture(new Image("com/joapet99/pacman/textures/RedGhost.png"));
		enemy.setPosition(new Vector2f(32,32));
		movableEntities.add(enemy);
		try {
			loadLevelFile(new File("Level1"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		for(CollisionLine cl : collisionLines){
			if(cl.checkCollisionRules(thePlayer)){
				thePlayer.getIsCollidingFrom().add(cl.getDirection());
			}
			if(cl.checkCollisionRules(enemy)){
				enemy.getIsCollidingFrom().add(cl.getDirection());
			}
		}
		for(MovableEntity entity : movableEntities){
			if(entity.getIsCollidingFrom().contains(0)){
				entity.canMoveRight = false;
			}
			else{
				entity.canMoveRight = true;
			}
			if(entity.getIsCollidingFrom().contains(1)){
				entity.canMoveLeft = false;
			}
			else{
				entity.canMoveLeft = true;
			}
			if(entity.getIsCollidingFrom().contains(2)){
				entity.canMoveDown = false;
			}
			else{
				entity.canMoveDown = true;
			}
			if(entity.getIsCollidingFrom().contains(3)){
				thePlayer.canMoveUp = false;
			}
			else{
				entity.canMoveUp = true;
			}
			entity.getIsCollidingFrom().clear();
		}
		thePlayer.update(container, delta);
	}
	
	public void loadLevelFile(File levelFile) throws IOException, SlickException{
		BufferedReader br = new BufferedReader(new FileReader(levelFile));
		String line;
		while((line = br.readLine()) != null){
			if(line.startsWith("Block")){
				String[] information = line.split(" ");
				Block b = new Block(Integer.parseInt(information[1]));
				blocks.add(b);
				b.setTexture(new Image(information[2]));
				b.setPosition(new Vector2f(Integer.parseInt(information[3]), Integer.parseInt(information[4])));
			}
			if(line.startsWith("CollisionGroup")){
				String[] information = line.split(" ");
				int lowestId = Integer.parseInt(information[2]);
				int highestId = Integer.parseInt(information[3]);
				Block lowest = null;
				Block highest = null;
				
				for(Block b : blocks){
					if(b.getId() == lowestId){
						lowest = b;
					}
					else if(b.getId() == highestId){
						highest = b;
					}
				}
				
				collisionGroups.add(new CollisionGroup(Integer.parseInt(information[1]), collisionLines, lowest, highest, movableEntities));
			}
		}
		br.close();
	}
	
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new MainGameFile("Pacman Alpha 1.0.0"));
		app.setDisplayMode(800, 576, false);
		app.start();
	}
}
