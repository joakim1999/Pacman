package com.joapet99.pacman;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.joapet99.pacman.entity.Player;
import com.joapet99.pacman.movement.Movement;
import com.joapet99.pacman.movement.MovementType;

public class MainGameFile extends BasicGame{
	Player thePlayer;
	
	public MainGameFile(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics gr)
			throws SlickException {
		thePlayer.render(gr);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		thePlayer = new Player(0);
		thePlayer.setTexture(new Image("com/joapet99/pacman/textures/Pacman.png"));
		thePlayer.setPosition(new Vector2f(200, 200));
		thePlayer.setMovement(new Movement(MovementType.KEYBOARDMOVEMENT, thePlayer));
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		thePlayer.update(container, delta);
	}
	
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new MainGameFile("Pacman Alpha 1.0.0"));
		app.setDisplayMode(800, 600, false);
		app.start();
	}
}
