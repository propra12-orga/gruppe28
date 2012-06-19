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
	public void setkillcount(int i, int killcount) {
					heroliste.get(i).killcount=++killcount;
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
					heroliste.get(i).tilecount=++tilecount;
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
			for(Bombe bombe : Bombe.bombenliste) {
				Hero.heroliste.get(0).setdeathcount(Hero.heroliste.get(0).getdeathcount());
			if(bombe.getDroppedby()==0 && Hero.heroliste.get(0).getisalive() == false) {
				 Hero.heroliste.get(0).setSuicidecount(0, Hero.heroliste.get(0).getSuicidecount());
				 //Hero.heroliste.get(i).setStartPosition(i);
			 }
			else{
				for(int j=0; j<Hero.heroliste.size();j++){
					if(bombe.getDroppedby()==j && Hero.heroliste.get(0).getisalive()==false) {
						Hero.heroliste.get(j).setkillcount(j, Hero.heroliste.get(j).getkillcount());
						//Hero.heroliste.get(i).setStartPosition(i);
					}
				}
			}
		}
			heroliste.get(0).setxPixelPosition(60);
			heroliste.get(0).setyPixelPosition(60);
			heroliste.get(0).setxCoord();
			heroliste.get(0).setyCoord();
			heroliste.get(0).setisalive(true);
		}
		if(n==1) {
			for(Bombe bombe : Bombe.bombenliste) {
				Hero.heroliste.get(1).setdeathcount(Hero.heroliste.get(1).getdeathcount());
				if(bombe.getDroppedby()==1 && Hero.heroliste.get(1).getisalive() == false) {
					 Hero.heroliste.get(1).setSuicidecount(1, Hero.heroliste.get(1).getSuicidecount());
					 //Hero.heroliste.get(i).setStartPosition(i);
				 }
				else{
					for(int j=0; j<Hero.heroliste.size();j++){
						if(bombe.getDroppedby()==j && Hero.heroliste.get(1).getisalive()==false) {
							Hero.heroliste.get(j).setkillcount(j, Hero.heroliste.get(j).getkillcount());
							//Hero.heroliste.get(i).setStartPosition(i);
						}
					}
				}
			}
			
			heroliste.get(1).setxPixelPosition(560);
			heroliste.get(1).setyPixelPosition(60);
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
					heroliste.get(i).suicidecount=++suicidecount;
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
