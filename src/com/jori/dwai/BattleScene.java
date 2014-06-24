package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BattleScene extends BasicGameState {
	private Image battleScene;
	private Image hit;
	private int life = 100;
	private int enemyLife = 100;
	private boolean playerTurn = false;
	private Jori jori;
	private Whale whale;
	private Image whalePic;
	private Image player;
	private int damage;
	private boolean isHit = false;
	private int howManyHearts;
	private int howManyHeartsWhale;
	private Image heart;
	private Image whaleHeart;
	private Image hit2;
	private boolean isHit2 = false;
	private int drawWhaleX = 400;
	private int drawWhaleY = 300;
	private int alphaOfHit2 = 0;
	private float alphaOfHit = 0;

	public BattleScene(int state) {

	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		whaleHeart = new Image("res/Fight/whaleHeart.png");
		heart = new Image("/res/Fight/heart.png");

		battleScene = new Image("/res/Background/battleScene.png");
		// 50% chance you attack first
		playerTurn = (Math.random() * 500 < 250);
		hit = new Image("/res/Fight/fireattack.png");
		jori = Jori.getJori();
		whale = new Whale();
		whalePic = new Image("res/pics of chars/whale.png");
		hit2 = new Image("res/Fight/fireattack.png");
		hit2.setAlpha(0);
		hit.setAlpha(alphaOfHit);

		player = new Image("/res/Fight/fightShip.png");

	}

	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {

		battleScene.draw(0, 0);

		whalePic.draw(drawWhaleX, drawWhaleY);
		player.draw(0, 400);
		hit.draw(600, 400);
		hit2.draw(0, 400);
		int x = 64;
		for (int i = 0; i < howManyHearts; i++) {
			heart.draw(x, 40);
			x += 32;
		}
		int x2 = 320 + 64 + 32 + 32;
		for (int i = 0; i < howManyHeartsWhale; i++) {
			whaleHeart.draw(x2, 40);
			x2 += 32;
		}

	}

	public void playerFight() {
		damage = jori.getAttack();

		// testing for critical damage.
		// when damage is critical, it will be 3 times as powerful
		if ((int) Math.random() * 100 == 67) {
			// critical is true
			damage = (damage) * 3;
		}

		// There's a 50 percent chance that you'll attack
		if (Math.random() * 6000 < 3000) {
			if (damage > 0) {
				enemyLife -= damage;
				isHit = true;
			}
		}
		playerTurn = false;

	}

	public void enemyFight() {

		damage = whale.getAttack();
		// testing for critical damage.
		// when damage is critical, it will be 3 times as powerful
		// 177*3 133*3
		if (((int) Math.random() * 100) == 67) {
			// critical is true
			damage = (damage) * 3;
		}
		// 50% chance of enemy attack
		if (Math.random() * 6000 < 3000)
			if (damage > 0) {
				life -= damage;
				isHit2 = true;
			}
		// change turn
		playerTurn = true;
	}

	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		if (jori.isMutant()) {
			whalePic = new Image("/res/pics of chars/MutantWhale.png");
			player = new Image("/res/Fight/fightShipFire.png");
			whale.multiplyAttack(3);
		}
		if (!jori.didRun()) {
			enemyLife = 100;

			jori.changeRan(true);
		}
		// enemyLife = whale.getLife();
		howManyHearts = (int) (life / 10);
		howManyHeartsWhale = (int) (enemyLife / 10);
		if (life <= 0) {
			// If you die, the game ends..
			gc.exit();
		}
		if (enemyLife <= 0) {
			if (jori.isMutant()) {
				jori.mWhaleDefeated();

			}
			// raises the health and attack of jori
			jori.increaseAttack(5);
			jori.increaseHealth(3);
			// Changes the variable that you have killed a whale so the quest
			// 1 works.
			jori.changeKilling();
			// Quest 3 works as well now
			// you need to kill 2 whales for the quest to be complete
			jori.changeWhaleMeat(10);
			// go back to where you came from

			s.enterState(12);
		}
		Input input = gc.getInput();
		// Initiates the fight
		//

		if (input.isKeyPressed(Input.KEY_SPACE)) {
			if (playerTurn) {
				playerFight();
			} else {
				enemyFight();
			}
		}

		// just fades the hit box in and out...
		if (isHit) {
			alphaOfHit += 0.1f;
			hit.setAlpha(alphaOfHit);
			if (alphaOfHit >= 1) {
				alphaOfHit = 0;
				hit.setAlpha(alphaOfHit);
				isHit = false;
			}
		}
		if (isHit2) {
			alphaOfHit2 += 0.1f;
			hit2.setAlpha(alphaOfHit2);
			if (alphaOfHit2 >= 1) {
				alphaOfHit2 = 0;
				hit2.setAlpha(alphaOfHit2);
				isHit2 = false;
			}
		}
	}

	public int getID() {
		return 7;
	}
}
