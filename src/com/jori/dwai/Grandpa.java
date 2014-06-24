package com.jori.dwai;

import org.newdawn.slick.BigImage;
import org.newdawn.slick.SlickException;

public class Grandpa extends GenericChar {
	private BigImage gramps;

	private Jori jori;

	public Grandpa() {
		super();
	}

	public Grandpa(int i, int j) {

		super(i, j);
	}

	public BigImage getGrandpa() {
		return gramps;
	}

	public void createVariables() throws SlickException {
		gramps = new BigImage("/res/pics of chars/grandpaDown.png");
		jori = Jori.getJori();
	}

}
