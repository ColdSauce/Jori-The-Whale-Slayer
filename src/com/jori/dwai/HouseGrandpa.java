package com.jori.dwai;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class HouseGrandpa extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private BigImage grandpaHead;
	private BigImage house;
	private BigImage talk;
	private int grandpaX = 5 * 32;
	private int grandpaY = 10 * 32;
	private Jori jori;
	private Grandpa grandpa;
	// private Audio conf;
	private Music conf;
	private boolean runOnce = true;
	private boolean lockMovement = false;
	private String history = "Long before the crew of whale wars existed, there were two cultures living in the lands we know as Wakinoshita and Armpit. These cultures were called the Kunimichi, and Genpachi. These two cultures always fought each other over land but respected each other as well. When time came, they got together for the spiritual celebration known as the Olmarur. Citizens from both cultures went to a mystic island called Ushi. After the day was done, both cultures would go back to their homeland and catch some whales together. Some foreigners outside of the land of Dwai came on the day of Olmarur and introduced themselves. The people of Dwai were very happy to see the foreigners and asked them to celebrate in the holiday with them. When the day was done, as was tradition, the people of Dwai would go and hunt whales together. The greatest whale slayer at the time, known as Omari caught about 39 whales in one hour, or so legend tells. When the foreigners saw this, they were disgusted at these “savages”. The foreigners couldn’t take more of this “brutality” and fled to their home town outside of Dwai. The people of Dwai were very sad that the foreigners left without saying goodbye, as was custom in both the cultures. Two moons past and there was no word of the foreigners."
			+ "The Sighting"
			+ "Then, one day, out in the horizon, a woman from the culture of Gempachi, saw something that she would tell her children and grandchildren from the rest of time. A giant boat, far bigger than anything both cultures had ever seen was approaching the main land of her culture. She started screaming as loud as her throat and lungs were capable of. Her husband, Kaibara, heard her violent screams and threw the blankets onto the floor and put on his work pants with haste. His face was blank. Emotionless. Looking at his wife, his eyes were bewildered at the site of such a beast of a boat. Running, as fast as he could, Kaibara, passed the Dark Forest, the Tree of Laughter, and got to the Fortress of Light. Climbing up the stairs, a friend of his, Nemoto , greeted him but,Kaibara, pushed him off and began racing to the grand master, known as, Tsushima Tetsui. The King took a deep breath and grabbed his horn. Kaibara hadn’t heard such a majestic, and deep sound even from the strongest whales. "
			+ "It had begun” Said Kaibara"
			+

			"Dwai citizens, from both cultures, had the same apocalyptic prophecy. A great warrior will come from out the seas and destroy the entire world with his monster called “Mootantee”. The king of Kaibara sent out a message to the king of Kunimichi and told him what he saw. When the message came, the eyes of the king were dreary. His face, tired. The king of Kunimichi told his officials to prepare for war. Everyone’s face was grim. The two people just had a war known as the Rage of the Toiret. They didn’t want another war that would just end in a stalemate as always. The king informed them even worse news. “There is a foreign boat in the sea and it appears to be capable of immense violence that we have never seen before i’m afraid."
			+ "Rumors spread throughout the land of Dwai. Everyone was hearing different things. Some said that the king was dead, others said that it wasn’t a boat but a monster. No one knew what to expect but were preparing for the worst. Both kings agreed to ally against this vicious enemy. The boat was at sea for 3 moons and no one dared to go near it. Both kings began wartime preparations of a massive caliber. Fortresses of sizes never thought before possible were created at such a short amount of time and both cultures soon realized that they weren’t so different and ended up combining under the rule of the two kings. The two kings decided to send a scout to see what was going on with the giant ship. The scout approached the ship and was greeted with a water cannon to the face. History books of the events after this have been burned and no records have been found to this date. The only known event is that the foreigners, now known as “The Whale Wars Crew”, took over the country of Armpit and expelled all the foreigners. The culture of Kunimichi was integrated with the culture of Gempachi and is now known as Sanou.";
	private boolean shouldTalk = false;

	public HouseGrandpa(int state) {

	}

	// one constructor is so that the game states work ^^^ and the other one on
	// the bottom is so that
	// it is possible to instantiate this method.
	public HouseGrandpa() {
		// TODO Auto-generated constructor stub
	}

	// All of these methods are explained in HomeTownLand, they are the same
	// methods with different
	// variables but they all do the same thing
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		grandpa = new Grandpa(5 * 32, 10 * 32);
		grandpaHead = new BigImage("/res/pics of chars/Grandpa/grandpaHead.png");
		jori = Jori.getJori();

		talk = new BigImage("/res/convo.png");
		house = new BigImage("/res/TMX files/pics/1HouseGrandpa.png");
		jori.makeGuy();
		this.checkCollision();
		grandpa.createVariables();
		conf = new Music("/res/sounds/Voices/void.wav");
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		// When a draw method is called, it draws the picture while overlapping
		// any other pictures
		// Think of "layers" in photoshop
		house.draw(0, 0);
		if (!lockMovement) {
			jori.getGuy().draw(jori.getX(), jori.getY());
		} else {
			jori.getGuy().draw(5 * 32, 11 * 32);
		}

		grandpa.getGrandpa().draw(grandpa.getX(), grandpa.getY());

	}

	public void update(GameContainer container, StateBasedGame s, int delta)
			throws SlickException {
		System.out.println(jori.didRun());
		if (!jori.didRun()) {
			jori.changeX(5 * 32);
			jori.changeY(19 * 32);

		}
		jori.changeRan(true);
		do {
			jori.takeInArray(mapArray);
		} while (false);
		// If the user decides to go outside, he must go to the door, this
		// method tests if jori
		// is at the door.
		if (jori.getX() == 5 * 32 && jori.getY() == 21 * 32) {
			jori.changeX(8 * 32);
			jori.changeY(18 * 32);
			jori.changeRan(false);
			s.enterState(2);
			// jori.changeY(18*32);
		}

		Input input = container.getInput();
		// The following method calls the conversation method because the user
		// pressed enter and is close enough
		// where he can talk to grandpa.
		if (input.isKeyPressed(Input.KEY_ENTER)
				&& jori.isClose(grandpaX, grandpaY)) {
			shouldTalk = true;
		}

		//
		if (!conf.playing()) {
			if (shouldTalk) {
				// talk.draw(grandpaX + 300, grandpaY + 300);
				// grandpaHead.draw(grandpaX + 300, grandpaY + 300);
				if (!runOnce) {
					int rnd = (int) (Math.random() * 4) + 1;
					conf = new Music("/res/sounds/Voices/Confucius" + rnd
							+ ".wav");
					conf.play();

				} else {
					conf = new Music("/res/sounds/Voices/GrandpaOpen.wav");
					conf.play();
				}

				runOnce = false;
				shouldTalk = false;
			}
			if (input.isKeyPressed(Input.KEY_Y)) {
				jori.increaseKarma(1000000);
				conf = new Music("/res/sounds/Voices/GrandpaYesSpeech.wav");
				conf.play();
			}

			if (input.isKeyPressed(Input.KEY_N)) {
				jori.decreaseKarma(1000000);
				conf = new Music("/res/sounds/Voices/GrandpaNoSpeech.wav");
				conf.play();
			}
		}
		jori.takeInInput(input);
		if (container.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(9);
			s.enterState(11);
		}
		if (!conf.playing())
			jori.testKeys();
		jori.makeCollisionEasier();

		lockMovement = conf.playing();

	}

	public Jori getJori() {
		return jori;
	}

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public int[][] checkCollision() {
		mcc(17, 16);
		mcc(16, 16);
		mcc(15, 16);
		mcc(14, 15);
		mcc(14, 14);
		mcc(14, 13);
		mcc(14, 12);
		mcc(15, 12);
		mcc(16, 12);
		mcc(17, 12);
		mcc(17, 11);
		mcc(17, 10);
		mcc(17, 9);
		mcc(17, 8);
		mcc(17, 7);
		mcc(16, 7);
		mcc(15, 7);
		mcc(14, 7);
		mcc(13, 7);
		mcc(12, 7);
		mcc(11, 7);
		mcc(10, 7);
		mcc(9, 7);
		mcc(9, 8);
		mcc(9, 9);
		mcc(9, 10);
		mcc(9, 11);
		mcc(9, 12);
		mcc(9, 13);
		mcc(8, 13);
		mcc(7, 13);
		mcc(6, 13);
		mcc(5, 13);
		mcc(5, 14);
		mcc(5, 15);
		mcc(5, 16);
		mcc(6, 16);
		mcc(7, 16);
		mcc(8, 16);
		mcc(9, 16);
		mcc(10, 16);
		mcc(11, 16);
		mcc(11, 15);
		mcc(12, 15);
		mcc(14, 15);
		mcc(14, 14);
		mcc(14, 13);
		mcc(15, 15);
		mcc(16, 15);
		mcc(17, 15);
		mcc(18, 15);
		mcc(18, 14);
		mcc(19, 11);
		mcc(18, 11);
		mcc(18, 10);
		mcc(18, 9);
		mcc(18, 8);
		mcc(18, 7);
		mcc(18, 6);
		mcc(18, 5);
		mcc(18, 4);
		mcc(19, 4);
		mcc(20, 4);
		mcc(18, 7);
		mcc(19, 7);
		mcc(20, 8);
		mcc(21, 7);
		mcc(22, 8);
		mcc(23, 8);
		mcc(23, 7);
		mcc(24, 7);
		mcc(25, 7);
		mcc(25, 8);
		mcc(25, 9);
		mcc(25, 10);
		mcc(24, 9);
		mcc(24, 10);
		mcc(24, 11);
		mcc(24, 12);
		mcc(25, 9);
		mcc(25, 10);
		mcc(25, 11);
		mcc(25, 12);
		mcc(25, 13);
		mcc(25, 14);
		mcc(25, 15);
		mcc(25, 16);
		mcc(25, 17);
		mcc(25, 18);
		mcc(25, 19);
		mcc(24, 19);
		mcc(23, 19);
		mcc(22, 19);
		mcc(21, 19);
		mcc(20, 19);
		mcc(19, 19);
		mcc(18, 19);
		mcc(17, 19);
		mcc(16, 19);
		mcc(15, 19);
		mcc(14, 19);
		mcc(13, 19);
		mcc(12, 19);
		mcc(11, 19);
		mcc(10, 19);
		mcc(9, 19);
		mcc(8, 19);
		mcc(7, 19);
		mcc(7, 19);
		mcc(7, 20);
		mcc(6, 21);
		// mcc(5,21);
		mcc(4, 21);
		mcc(4, 20);
		mcc(4, 19);
		mcc(4, 18);
		mcc(3, 18);
		mcc(2, 18);
		mcc(2, 17);
		mcc(2, 16);
		mcc(3, 16);
		mcc(3, 15);
		mcc(17, 10);
		mcc(16, 10);
		mcc(15, 10);
		mcc(15, 11);
		mcc(8, 10);
		mcc(8, 11);
		mcc(8, 12);
		mcc(7, 11);
		mcc(6, 8);
		mcc(6, 7);
		mcc(7, 7);
		mcc(8, 7);
		mcc(5, 6);
		mcc(5, 7);
		mcc(4, 8);
		mcc(4, 7);
		mcc(4, 6);
		mcc(6, 5);
		mcc(7, 5);
		mcc(8, 5);
		mcc(8, 6);
		mcc(7, 6);
		mcc(6, 6);
		mcc(5, 6);
		mcc(19, 10);
		mcc(19, 12);
		mcc(21, 11);
		mcc(21, 10);
		mcc(22, 10);
		mcc(22, 11);
		mcc(24, 15);
		mcc(24, 16);
		mcc(6, 20);
		mcc(3, 14);
		mcc(3, 9);
		mcc(3, 10);
		mcc(3, 11);
		mcc(3, 12);
		mcc(3, 13);
		mcc(12, 14);
		mcc(12, 13);
		mcc(12, 12);
		mcc(11, 12);
		mcc(10, 12);

		return mapArray;
	}

	public int getID() {
		return 9;
	}

}
