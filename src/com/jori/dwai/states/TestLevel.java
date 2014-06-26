package com.jori.dwai.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.jori.dwai.characters.Jori;
import com.jori.dwai.util.Logger;
import com.jori.dwai.util.MapReader;
import com.jori.dwai.util.MapReader.LANDTYPE;
import com.jori.dwai.util.Tile;


public class TestLevel extends BaseLevel{
	
	public TestLevel(int state, String fileName) {
		super(state, fileName);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame s)
			throws SlickException {
		super.init(gc,s);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		super.render(gc, s, g);
		Tile[][] tiledMap = super.getTiledMap();
		
		for (int i = 0; i < tiledMap.length; i++) {
			for (int j = 0; j < tiledMap.length; j++) {
				Logger.log(super.getGrassImage()+"", "tiledMapTest");
				switch(tiledMap[i][j].getLandType()){
					case CLEAR:
						break;
					case GRASS:
						g.drawImage(super.getGrassImage(), i*32, j*32);
						break;
					case WALL:
						g.drawImage(super.getWallImage(),i*32,j*32);
						break;
					default:
						break;
				
				}
				
				
				
			}
		}
		Jori.getInstance().render(g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		super.update(gc, s, delta);
		Jori.getInstance().update(gc.getInput(), delta);
		
	}
}
