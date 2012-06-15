package main;

import java.util.LinkedList;

/**
 * Instanzierbare Klasse um unsere Spielfiguren zu erschaffen.
 * (Figuren kommen in die "heroliste" und können von da aus abgerufen werden)
 * Sie enthält die Koordinaten und Geschwindigkeit einer Figur.
 * 
 * @author Sebastian
 *
 */

public class Hero {
	public static LinkedList<Hero> heroliste = new LinkedList<Hero>();
	int Hp;
	private int j;
	private int xCoord;
	private int yCoord;
	private int xPixelPosition;
	private int yPixelPosition;
	private int speed=10;
	public int killcount;
	public int deathcount;
	public int tilecount;
	public int scorecount;
	boolean isalive;
	public  int getHp() {
		return Hp;
	}
	public  void setHp(int hp) {
		Hp = hp;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord() {
		this.xCoord = this.xPixelPosition/50;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord() {
		this.yCoord = this.yPixelPosition/50;
	}
	public int getxPixelPosition() {
		return xPixelPosition;
	}
	public void setxPixelPosition(int xPixelPosition) {
		this.xPixelPosition = xPixelPosition;
	}
	public int getyPixelPosition() {
		return yPixelPosition;
	}
	public void setyPixelPosition(int yPixelPosition) {
		this.yPixelPosition = yPixelPosition;
	}
	public int getSpeed() {
		return speed;
	}
	public int getkillcount() {
		return killcount;
	}
	public void setkillcount(int killcount) {
		for(j=0; j < Bombe.bombenliste.size(); j++) {
		if(Bombe.bombenliste.get(j).isDroppedbyone()==true && Hero.heroliste.get(1).getisalive() == false) {
			Hero.heroliste.get(0).killcount++;
		}
		else if(Bombe.bombenliste.get(j).isDroppedbytwo()==true && Hero.heroliste.get(0).getisalive() == false) {
			Hero.heroliste.get(1).killcount++;
		}
			
		}
	}
	public int getdeathcount() {
		return deathcount;
	}
	public void setdeathcount(int deathcount) {
		if(isalive == false) {
			deathcount++;
			this.deathcount=deathcount;
		}
	}	
	public boolean getisalive() {
		return isalive;
	}
	public void setisalive(boolean isalive) {
		this.isalive = isalive;
	}
	public int getscorecount() {
		return scorecount;
	}
	public void setscorecount(int scorecount) {
		for(j=0; j < 2; j++)
		Hero.heroliste.get(j).scorecount=Hero.heroliste.get(j).tilecount+(Hero.heroliste.get(j).killcount*5);
	}
	public int gettilecount() {
		return tilecount;
	}
	public void settilecount(int tilecount) {
		for(j=0; j < Bombe.bombenliste.size(); j++) {
			if(Bombe.bombenliste.get(j).isDroppedbyone()==true && Bombe.bombenliste.get(j).isTiledestroyed() == true) {
				Hero.heroliste.get(0).tilecount++;
			}
			else if(Bombe.bombenliste.get(j).isDroppedbytwo()==true && Bombe.bombenliste.get(j).isTiledestroyed() == true) {
				Hero.heroliste.get(1).tilecount++;
			}
		}
	}		
}
