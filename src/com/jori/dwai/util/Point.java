package com.jori.dwai.util;

public class Point {
	private int x,y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int distanceTo(Point p){
		int px = p.getX();
		int py = p.getY();
		
		
		int belowTheSqrt = (int) (Math.pow(y - py,2) + Math.pow(x - px, 2));
		
		int distance = (int) Math.sqrt(belowTheSqrt);
		
		return distance;
	}
	
	
	public static int calcDistance(Point p,Point p2){
		int x = p2.getX();
		int y = p2.getY();
		
		int px = p.getX();
		int py = p.getY();
		
		
		
		
		// Distance formula = dist = sqrt( (y - y2)^2 + (x - x2)^2 )
		
		int belowTheSqrt = (int) (Math.pow(y - py,2) + Math.pow(x - px, 2));
		
		int distance = (int) Math.sqrt(belowTheSqrt);
		
		return distance;
	}
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	
	
	
}
