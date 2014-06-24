package com.jori.dwai;

import java.io.IOException;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.BigImage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class Menu extends BasicGameState {
	private int yPosRect = 50;
	// private BigImage whale;
	private Rectangle r = new Rectangle(0, 100, 896, yPosRect);
	private Music mainMusic;
	private BigImage background;

	public Menu(int state) {

	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		// whale = new BigImage("/res/Background/whale.png");
		background = new BigImage("/res/Background/backgroun.png");
		mainMusic = new Music("res/sounds/song_main.wav");
		// /.// mainMusic.play();
		// The following code was taken directly from the internet
		// You would need to know LWJGL in depth to make the mouse disapear
		Cursor emptyCursor = null;
		try {
			emptyCursor = new Cursor(1, 1, 0, 0, 1,
					BufferUtils.createIntBuffer(1), null);
		} catch (LWJGLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Mouse.setNativeCursor(emptyCursor);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		background.draw(0, 100);
	}

	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		Input in = gc.getInput();
		if (in.isKeyPressed(Input.KEY_ENTER)) {
			s.enterState(2);
		}

	}

	public int getID() {
		return 0;
	}
}