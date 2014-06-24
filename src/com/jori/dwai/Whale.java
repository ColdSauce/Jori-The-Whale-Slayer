package com.jori.dwai;

public class Whale extends GenericChar {
	private int attack = 3;
	private int life = 100;

	public Whale() {
		super();
	}

	public void multiplyAttack(int amount) {
		attack *= amount;
	}

	public int getLife() {
		return life;
	}

	public int getAttack() {
		return attack;
	}
}
