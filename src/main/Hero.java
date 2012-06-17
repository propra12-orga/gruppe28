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
	private int startPosition;
	private int killcount=0;
	private int deathcount=0;
	private int tilecount=0;
	private int scorecount=0;
	private int suicidecount=0;
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
	public void setkillcount(int i, int killcount) {
		for(j=0; j < Bombe.bombenliste.size(); j++) {
			if(i==0) {
				if(Bombe.bombenliste.get(j).getDroppedby()==0 /* && Bombe.bombenliste.get(j).isExplodiert()==true */&& heroliste.get(1).getisalive() == false) {
					heroliste.get(0).killcount=++killcount;

				}
			}
			else if(i==1) {
				if(Bombe.bombenliste.get(j).getDroppedby()==1/* && Bombe.bombenliste.get(j).isExplodiert()==true */&& heroliste.get(0).getisalive() == false) {
					heroliste.get(1).killcount=++killcount;
				}
			}
		}
	}
	public int getdeathcount() {
		return deathcount;
	}
	public void setdeathcount(int i, int deathcount) {
		heroliste.get(i).deathcount=++deathcount;
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
	public void setscorecount(int i, int scorecount) {
		heroliste.get(i).scorecount=heroliste.get(i).gettilecount()+(heroliste.get(i).getkillcount()*5)-(heroliste.get(i).getSuicidecount()*3);
	}
	public int gettilecount() {
		return tilecount;
	}
	public void settilecount(int i, int tilecount) {
		for(Bombe bombe : Bombe.bombenliste) {
				if(bombe.getDroppedby()==i && Bombe.bombenliste.get(j).isTiledestroyed() == true) {
					heroliste.get(i).tilecount=++tilecount;
				}
		}
	}
	public int getStartPosition() {
		return startPosition;
	}
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
	public void setSuicidecount(int i, int suicidecount) {
		for(Bombe bombe : Bombe.bombenliste) {
				if(bombe.getDroppedby()==i/* && heroliste.get(i).getisalive() == false*/) {
					heroliste.get(i).suicidecount=++suicidecount;
				}
		}
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
}
