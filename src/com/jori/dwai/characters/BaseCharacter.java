package com.jori.dwai.characters;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import com.jori.dwai.GameObject;
import com.jori.dwai.characters.characterstates.BaseState;
import com.jori.dwai.util.Point;

public abstract class BaseCharacter extends GameObject{


	private Image img;
	private Point p;
	public BaseCharacter(Image img, Point p){
		super(img,p);
		this.img = img;
		this.p = p;
	}

	public Image getImg() {
		return img;
	}



	public void setImg(Image img) {
		this.img = img;
	}


 
	public Point getP() {
		return p;
	}



	public void setP(Point p) {
		this.p = p;
	}

	public abstract void update(Input input, int delta);






}