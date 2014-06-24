package com.jori.dwai;

import org.newdawn.slick.BigImage;
import org.newdawn.slick.SlickException;

public class PandaEE {
	BigImage panda;
	private int pandaX = 11 * 32;
	int pandaY = 2;
	private boolean right = false;
	private boolean left = false;
	private int lagThePanda = 0;

	public PandaEE(int x, int y) {
		pandaX = x;
		pandaY = y;
	}

	public void createPandaBigImage() throws SlickException {
		panda = new BigImage("res/pics of chars/PandaLeft.png");
	}

	public BigImage returnPandaBigImage() {
		return panda;
	}

	public int pandaMove() throws SlickException {
		if (pandaX <= 11 * 32) {
			right = true;
			left = false;
		} else if (pandaX >= 16 * 32) {
			right = false;
			left = true;
		}
		lagThePanda++;
		if (right && (lagThePanda % 10 == 0)) {
			panda = new BigImage("res/pics of chars/pandaRight.png");
			pandaX += 32;
		}
		if (left && lagThePanda % 10 == 0) {
			panda = new BigImage("res/pics of chars/PandaLeft.png");
			pandaX -= 32;
		}
		return pandaX;
	}
}
