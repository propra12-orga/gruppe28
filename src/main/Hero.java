package main;

import java.util.LinkedList;

/**
 * Instanzierbare Klasse um unsere Spielfiguren zu erschaffen.
 * (Figuren kommen in die "heroliste" und können von da aus abgerufen werden)
 * Sie enthält die Koordinaten, Geschwindigkeit und Zähler für die Statistik einer Figur.
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
	private int startPosition;
	private int killcount=0;
	private int deathcount=0;
	private int tilecount=0;
	private int scorecount=0;
	private int suicidecount=0;
	private int bombcount=0;
	private boolean isalive;
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
	/**
	 * Zählt die erwischten Gegner für die Statistik (wenn es mal funktioniert).
	 * @param i
	 * @param j
	 */
	public void setkillcount(int i, int j) {
		for(Bombe bombe : Bombe.bombenliste) {
			//for(int k=0;k<heroliste.size();k++) {
				if(bombe.getDroppedby()==j && heroliste.get(i).getisalive() == false) {
					heroliste.get(j).killcount=1+heroliste.get(j).getkillcount();
				}
			}
			//else if(i==1) {
			//	if(Bombe.bombenliste.get(j).getDroppedby()==1 && heroliste.get(0).getisalive() == false) {
			//		heroliste.get(1).killcount=++killcount;
			//	}
			//}
		//}
	}
	public int getdeathcount() {
		return deathcount;
	}
	/**
	 * Zählt die Tode des Helden für die Statistik.
	 * @param i
	 * @param deathcount
	 */
	public void setdeathcount(int deathcount) {
		this.deathcount=++deathcount;
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
	/**
	 * Berechnet die Punkte des Helden für die Statistik.
	 * @param i
	 * @param scorecount
	 */
	public void setscorecount(int i, int scorecount) {
		heroliste.get(i).scorecount=heroliste.get(i).gettilecount()+(heroliste.get(i).getkillcount()*5)-(heroliste.get(i).getSuicidecount()*3);
	}
	public int gettilecount() {
		return tilecount;
	}
	/**
	 * Zählt die zerstörten Wände für die Statistik.
	 * @param i
	 * @param tilecount
	 */
	public void settilecount(int i, int tilecount) {
		//for(Bombe bombe : Bombe.bombenliste) {
				//if(bombe.getDroppedby()==i && bombe.isTiledestroyed() == true) {
					heroliste.get(i).tilecount=++tilecount;
				//}
		//}
	}
	public int getStartPosition() {
		return startPosition;
	}
	/**
	 * Startpositionen der Helden.
	 * @param n
	 */
	public void setStartPosition(int n) {
		if(n==0) {
			heroliste.get(0).setxPixelPosition(55);
			heroliste.get(0).setyPixelPosition(55);
			heroliste.get(0).setxCoord();
			heroliste.get(0).setyCoord();
			heroliste.get(0).setisalive(true);
		}
		if(n==1) {
			heroliste.get(1).setxPixelPosition(561);
			heroliste.get(1).setyPixelPosition(55);
			heroliste.get(1).setxCoord();
			heroliste.get(1).setyCoord();
			heroliste.get(1).setisalive(true);
		}
	}
	public int getSuicidecount() {
		return suicidecount;
	}
	/**
	 * Zählt die Selbstmorde für die Statistik.
	 * @param i
	 * @param suicidecount
	 */
	public void setSuicidecount(int i, int suicidecount) {
		//for(Bombe bombe : Bombe.bombenliste) {
				//if(bombe.getDroppedby()==i && heroliste.get(i).getisalive() == false) {
					heroliste.get(i).suicidecount=++suicidecount;
				//}
		//}
	}
	public int resetdeathcount() {
		return deathcount=0;
	}
	public int resettilecount() {
		return tilecount=0;
	}
	public int resetsuicidecount() {
		return suicidecount=0;
	}
	public int resetkillcount() {
		return killcount=0;
	}
	public int resetscorecount() {
		return scorecount=0;
	}
	public int getBombcount() {
		return bombcount;
	}
	/**
	 * Zählt die gelegten Bomben des Helden, damit nicht zu viele auf dem Spielfeld sind.
	 * @param bombcount
	 */
	public void setBombcount(int bombcount) {
		this.bombcount = ++bombcount;
	}
	public int reducebombcount(int bombcount) {
		this.bombcount=--bombcount;
		return this.bombcount;
	}
}
