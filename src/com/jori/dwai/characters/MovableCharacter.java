package com.jori.dwai.characters;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import com.jori.dwai.util.DIRECTION;
import com.jori.dwai.util.Point;

public abstract class MovableCharacter extends BaseCharacter{
	private DIRECTION currentDirection;
	private Image[] frames;
	public MovableCharacter(Image[] frames, Point p) {
		super(frames[0], p);
		this.frames = frames;
	}
	
	public  abstract void move(DIRECTION dir);
	public  abstract Image getStandingImage();
	public  abstract Image getJumpingImage();
	public  abstract Image getRunningImage(DIRECTION dir);
	
	public DIRECTION getDirection(){
		return currentDirection;
	}
	public void setDirection(DIRECTION dir){
		this.currentDirection = dir;
	}

	public Image[] getFrames(){
		return frames;
	}
}
