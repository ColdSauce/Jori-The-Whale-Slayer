package com.jori.dwai.characters;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.jori.dwai.util.Logger;

// Jori's x and y is in the tiled system. Such as 1 2 3 instead of 0 32 64
public class Jori extends BaseCharacter{
	

	
	private Jori(Image img) {
		super(img);
	}
	 
	
	
	//SINGLETON PATTERN
	private static Jori instance = null;
	public static Jori getInstance(){
		if(instance == null){

			try {
				instance = new Jori(new Image("characters/jori.png"));
			} catch (Exception e) {
				Logger.logErr("Could not load picture for Jori!",Jori.class);
			}
		}
		return instance;
	}
	
	
	
	
}
