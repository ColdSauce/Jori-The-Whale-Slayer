package com.jori.dwai.characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.jori.dwai.util.Logger;
import com.jori.dwai.util.Point;
import com.jori.dwai.util.Tile;

// Jori's x and y is in the tiled system. Such as 1 2 3 instead of 0 32 64
public class Jori extends BaseCharacter {

	private double speed = .01;
	private Jori(Image img) {
		super(img);
	}

	//SINGLETON PATTERN
	private static Jori instance = null;

	public static Jori getInstance() {
		if (instance == null) {

			try {
				
				Image img = new Image("res/characters/jori.png");
				Logger.log(img+"","jori image");
				instance = new Jori(img);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return instance;
	}

	public void move(Point p, Tile[][] tiledMap) {

		int x = p.getX() / 32;
		int y = p.getY() / 32;

		//if (p.distanceTo(super.getP()) <= 32) {

			Tile workingTile = tiledMap[x][y];
			if (workingTile.isSolid()) {
				return;
			}

			super.setP(p);

		//}

	}

	public void render(Graphics g){
		
		g.drawImage(super.getImage(), super.getP().getX(), super.getP().getY());	
		
	}
	
	public void update(Input i, Tile[][] tiledMap, int delta) {
		Point p = super.getP();
		if (i.isKeyDown(Input.KEY_LEFT)) {

			p.setX((int)(p.getX()-(speed*(delta/1000.0))));

			move(p, tiledMap);

		}

		 if (i.isKeyDown(Input.KEY_UP)) {
			p.setY((int)(p.getY()-(speed*(delta/1000.0))));
			move(p, tiledMap);
		}  
		 
		if (i.isKeyDown(Input.KEY_DOWN)) {
			p.setY((int)(p.getY()+(speed*(delta/1000.0))));

			move(p, tiledMap);
		}  
		if (i.isKeyDown(Input.KEY_RIGHT)) {
			p.setX((int)(p.getX()+(speed*(delta/1000.0))));

			move(p, tiledMap);
	}
		 

}
}
