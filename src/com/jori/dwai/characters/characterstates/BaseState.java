package com.jori.dwai.characters.characterstates;

import org.newdawn.slick.Input;

import com.jori.dwai.characters.BaseCharacter;

public interface BaseState<T extends BaseCharacter> {
	public void update(T character);
	void handleInput(T character, Input input);
}
