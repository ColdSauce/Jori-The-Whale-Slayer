package com.jori.dwai.util;

import com.jori.dwai.util.MapReader.LANDTYPE;

public class Tile {
	private int x,y;
	private LANDTYPE landType;
	private boolean solid;
	protected Tile(int x, int y){
		this.x = x;
		this.y = y;
		//default land type will be clear
		landType = LANDTYPE.CLEAR;
		
		//default solidity is not solid
		this.solid = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setLandType(LANDTYPE landType){
		if(landType == LANDTYPE.WALL){
			solid = true;
		}
		
		this.landType = landType;
	}
	public LANDTYPE getLandType(){
		return landType;
	}
	
	public boolean isSolid(){
		return solid;
	}
	
	
}