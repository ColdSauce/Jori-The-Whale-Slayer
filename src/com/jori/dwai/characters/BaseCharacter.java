package com.jori.dwai.characters;

import org.newdawn.slick.Image;

import com.jori.dwai.util.Point;

public abstract class BaseCharacter {
	

	private Point p;
	protected Image img;
	
	
	public BaseCharacter(Image img){
		this.img = img;
		p = new Point(32,32);
	}
	

	public void setP(Point p){
		this.p = p;
	}
	public Point getP() {
		return p;
	}

	public Image getImage(){
		return img;
	}


	
	
	
	
}
