package main;

import java.util.LinkedList;

/**
 * Instanzierbare Klasse um unsere Spielfiguren zu erschaffen.
 * Sie enth�lt die Koordinaten und Geschwindigkeit einer Figur.
 * 
 * @author Sebastian
 *
 */

public class Hero {
	public static LinkedList<Hero> heroliste = new LinkedList<Hero>();
	int Hp;
	private int xCoord;
	private int yCoord;
	private int xPixelPosition;
	private int yPixelPosition;
	private int speed=10;
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
		this.xCoord = this.xPixelPosition/75;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord() {
		this.yCoord = this.yPixelPosition/75;
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
	
		
}
