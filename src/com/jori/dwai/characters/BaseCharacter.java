package com.jori.dwai.characters;

import org.newdawn.slick.Image;

import com.jori.dwai.util.Point;

public abstract class BaseCharacter {
	
	private int x,y;
	protected Image img;
	
	
	public BaseCharacter(Image img){
		this.img = img;
	}
	
	public void moveTo(Point p){
		//TODO: Check if the point is out of bounds.
		x = p.getX();
		y = p.getY();
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImage(){
		return img;
	}


	
	
	
	
}
