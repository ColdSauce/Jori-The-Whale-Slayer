package com.jori.dwai.characters.characterstates;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

import com.jori.dwai.characters.MovableCharacter;

public class WalkingState<T extends MovableCharacter> implements BaseState<T>{

	
	
	@Override
	public void update(T character) {
		new Animation(character.getFrames(),1).start();
		
	}

	@Override
	public void handleInput(T character, Input input) {
		
		
	}
	
	
	

}
