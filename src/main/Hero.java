package main;
import java.util.Vector;


/**
 * Instanzierbare Klasse um unsere Spielfiguren zu erschaffen.
 * (Figuren kommen in die "heroliste" und können von da aus abgerufen werden)
 * Sie enthält die Koordinaten, Geschwindigkeit und Zähler für die Statistik einer Figur.
 * 
 * @author Sebastian
 *
 */

public class Hero {
	public static Vector<Hero> heroliste = new Vector<Hero>();
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
	public void setkillcount(int killcount) {
		this.killcount=++killcount;
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
	public void setscorecount(int scorecount) {
		this.scorecount=this.gettilecount()+(this.getkillcount()*5)-(this.getSuicidecount()*3);
	}
	public int gettilecount() {
		return tilecount;
	}
	/**
	 * Zählt die zerstörten Wände für die Statistik.
	 * @param i
	 * @param tilecount
	 */
	public void settilecount(int tilecount) {
		this.tilecount=++tilecount;
	}
	public int getStartPosition() {
		return startPosition;
	}
	
	public int getSuicidecount() {
		return suicidecount;
	}
	/**
	 * Zählt die Selbstmorde für die Statistik.
	 * @param i
	 * @param suicidecount
	 */
	public void setSuicidecount(int suicidecount) {
		this.suicidecount=++suicidecount;
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
