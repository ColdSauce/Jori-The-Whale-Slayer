package com.jori.dwai.characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import com.jori.dwai.characters.characterstates.BaseState;
import com.jori.dwai.characters.characterstates.JumpingState;
import com.jori.dwai.characters.characterstates.WalkingState;
import com.jori.dwai.util.DIRECTION;
import com.jori.dwai.util.Logger;
import com.jori.dwai.util.Point;

// Jori's x and y is in the tiled system. Such as 1 2 3 instead of 0 32 64
public class Jori extends MovableCharacter{
	private BaseState<Jori> currentState;
	
	private Jori(Image[] frames) {
		super(frames,new Point(32,32));
	}

	//SINGLETON PATTERN
	private static Jori instance = null;

	public static Jori getInstance() {
		if (instance == null) {

			try {
				
				Image img = new Image("res/characters/jori.png");
				Logger.log(img+"","jori image");
				//TODO: Get jori to make frames
				Image[] frames = {img};
				instance = new Jori(frames);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return instance;
	}
	

	@Override
	public void update(Input input, int delta) {
		if(input.isKeyPressed(Input.KEY_SPACE)){
			setCurrentState(new JumpingState<Jori>());
		}
		else if(input.isKeyPressed(Input.KEY_LEFT)){
			setCurrentState(new WalkingState<Jori>());
			setDirection(DIRECTION.LEFT);
		}
		else if(input.isKeyPressed(Input.KEY_RIGHT)){
			setCurrentState(new WalkingState<Jori>());
			setDirection(DIRECTION.RIGHT);
		}
		else if(input.isKeyPressed(Input.KEY_UP)){
			setCurrentState(new WalkingState<Jori>());
			setDirection(DIRECTION.UP);
		}
		else if(input.isKeyPressed(Input.KEY_DOWN)){
			setCurrentState(new WalkingState<Jori>());
			setDirection(DIRECTION.DOWN);
		}
		
		currentState.update(this);

	}
	
	@Override
	public void render(Graphics g){
		super.render(g);
		
	}

	@Override
	public Image getStandingImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getJumpingImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getRunningImage(DIRECTION dir) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void move(DIRECTION dir) {
		
		
	}
	public void setCurrentState(BaseState<Jori> state){
		this.currentState = state;
	}
}
