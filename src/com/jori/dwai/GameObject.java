package com.jori.dwai;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.jori.dwai.util.Point;

public abstract class GameObject implements GameObjectInterface {
	private Point p;
	private Image img;
	public GameObject(Image img, Point p){
		this.img = img;
		this.p = p;
	}
	
	@Override
	public void render(Graphics g){
		g.drawImage(img,p.getX(),p.getY());
	}
	public Image getImg() {
		return img;
	}

	public Point getP() {
		return p;
	}
}
