package controlling;
//import java.util.LinkedList;

import board.Board;

import main.Bombe;
import main.Hero;

/**
 * Die Controller-Klasse enthält den Bewegungslogarithmus der Spielfigur.
 * Den Bewegungs-methoden wird ein int Wert übergeben um zu bestimmen, welche Spielfigur bewegt werden soll.
 * 
 * @author Sebastian
 *
 */

public class Controller {
	/**
	 * Bewegung nach rechts.
	 * @param i
	 */
	public static void movementRight(int i){
		if (Board.map[(Hero.heroliste.get(i).getxCoord()+1)][Hero.heroliste.get(i).getyCoord()].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()+Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setxCoord();
		}
		else if(Board.map[Hero.heroliste.get(i).getxCoord()+1][Hero.heroliste.get(i).getyCoord()].getTileId()%2 == 0) {
				if (Hero.heroliste.get(i).getxPixelPosition()<(Hero.heroliste.get(i).getxCoord()+1)*50 - (54- Hero.heroliste.get(i).getSpeed())) {
					Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()+Hero.heroliste.get(i).getSpeed());
					Hero.heroliste.get(i).setxCoord();
				}
			}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			for(int n=0; n<Hero.heroliste.size(); n++) {
				Hero.heroliste.get(n).setStartPosition(n);
				Hero.heroliste.get(n).setscorecount(n, Hero.heroliste.get(n).getscorecount());
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + " Gegner erwischt = " + Hero.heroliste.get(0).getkillcount() + " Tode = " + Hero.heroliste.get(0).getdeathcount() + " Wände zerstört = " + Hero.heroliste.get(0).gettilecount() + " Selbstmorde = " + Hero.heroliste.get(0).getSuicidecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + " Gegner erwischt = " + Hero.heroliste.get(1).getkillcount() + " Tode = " + Hero.heroliste.get(1).getdeathcount() + " Wände zerstört = " + Hero.heroliste.get(1).gettilecount() + " Selbstmorde = " + Hero.heroliste.get(1).getSuicidecount());
			for(Hero hero : Hero.heroliste) {
				hero.resettilecount();
				hero.resetkillcount();
				hero.resetscorecount();
				hero.resetdeathcount();
				hero.resetsuicidecount();
			}		
			
		}
		if(Hero.heroliste.get(i).getisalive() == false){
			Hero.heroliste.get(i).setdeathcount(Hero.heroliste.get(i).getdeathcount());
			//Hero.heroliste.get(i).setkillcount(i);
			for(Bombe bombe : Bombe.bombenliste) {
				if(bombe.getDroppedby()==i && Hero.heroliste.get(i).getisalive() == false) {
					 Hero.heroliste.get(i).setSuicidecount(i, Hero.heroliste.get(i).getSuicidecount());
					 Hero.heroliste.get(i).setStartPosition(i);
				 }
			}
			//Hero.heroliste.get(i).setStartPosition(i);
		}
		}
	/**
	 * Bewegung nach links.
	 * @param i
	 */
	public static void movementLeft(int i){
		//int i=0;
		if (Board.map[(Hero.heroliste.get(i).getxCoord()-1)][Hero.heroliste.get(i).getyCoord()].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()-Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setxCoord();
		}
		else if(Board.map[Hero.heroliste.get(i).getxCoord()-1][Hero.heroliste.get(i).getyCoord()].getTileId()%2 == 0) {
			if (Hero.heroliste.get(i).getxPixelPosition()>Hero.heroliste.get(i).getxCoord()*50 + (15- Hero.heroliste.get(i).getSpeed())) {
				Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()-Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setxCoord();
			}
		}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			for(int n=0; n<Hero.heroliste.size(); n++) {
				Hero.heroliste.get(n).setStartPosition(n);
				Hero.heroliste.get(n).setscorecount(n, Hero.heroliste.get(n).getscorecount());
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + " Gegner erwischt = " + Hero.heroliste.get(0).getkillcount() + " Tode = " + Hero.heroliste.get(0).getdeathcount() + " Wände zerstört = " + Hero.heroliste.get(0).gettilecount() + " Selbstmorde = " + Hero.heroliste.get(0).getSuicidecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + " Gegner erwischt = " + Hero.heroliste.get(1).getkillcount() + " Tode = " + Hero.heroliste.get(1).getdeathcount() + " Wände zerstört = " + Hero.heroliste.get(1).gettilecount() + " Selbstmorde = " + Hero.heroliste.get(1).getSuicidecount());
			for(Hero hero : Hero.heroliste) {
				hero.resettilecount();
				hero.resetkillcount();
				hero.resetscorecount();
				hero.resetdeathcount();
				hero.resetsuicidecount();
			}
		}
		if(Hero.heroliste.get(i).getisalive() == false){
			Hero.heroliste.get(i).setdeathcount(Hero.heroliste.get(i).getdeathcount());
			//Hero.heroliste.get(i).setkillcount(i);
			for(Bombe bombe : Bombe.bombenliste) {
				if(bombe.getDroppedby()==i && Hero.heroliste.get(i).getisalive() == false) {
					 Hero.heroliste.get(i).setSuicidecount(i, Hero.heroliste.get(i).getSuicidecount());
					 Hero.heroliste.get(i).setStartPosition(i);
				 }
			}
			//Hero.heroliste.get(i).setStartPosition(i);
		}
	}
	/**
	 * Bewegung nach oben.
	 * @param i
	 */
	public static void movementUp(int i){
		//int i=0;
		if (Board.map[(Hero.heroliste.get(i).getxCoord())][Hero.heroliste.get(i).getyCoord()-1].getTileId()%2 != 0) {
				Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()-Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setyCoord();
		}
		else if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()-1].getTileId()%2 == 0) {
			if (Hero.heroliste.get(i).getyPixelPosition()>Hero.heroliste.get(i).getyCoord()*50 + (15- Hero.heroliste.get(i).getSpeed())) {
				Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()-Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setyCoord();
			}
		}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			for(int n=0; n<Hero.heroliste.size(); n++) {
				Hero.heroliste.get(n).setStartPosition(n);
				Hero.heroliste.get(n).setscorecount(n, Hero.heroliste.get(n).getscorecount());
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + " Gegner erwischt = " + Hero.heroliste.get(0).getkillcount() + " Tode = " + Hero.heroliste.get(0).getdeathcount() + " Wände zerstört = " + Hero.heroliste.get(0).gettilecount() + " Selbstmorde = " + Hero.heroliste.get(0).getSuicidecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + " Gegner erwischt = " + Hero.heroliste.get(1).getkillcount() + " Tode = " + Hero.heroliste.get(1).getdeathcount() + " Wände zerstört = " + Hero.heroliste.get(1).gettilecount() + " Selbstmorde = " + Hero.heroliste.get(1).getSuicidecount());
			for(Hero hero : Hero.heroliste) {
				hero.resettilecount();
				hero.resetkillcount();
				hero.resetscorecount();
				hero.resetdeathcount();
				hero.resetsuicidecount();
			}
		}	
		if(Hero.heroliste.get(i).getisalive() == false){
			Hero.heroliste.get(i).setdeathcount(Hero.heroliste.get(i).getdeathcount());
			//Hero.heroliste.get(i).setkillcount(i);
			for(Bombe bombe : Bombe.bombenliste) {
				if(bombe.getDroppedby()==i && Hero.heroliste.get(i).getisalive() == false) {
					 Hero.heroliste.get(i).setSuicidecount(i, Hero.heroliste.get(i).getSuicidecount());
					 Hero.heroliste.get(i).setStartPosition(i);
				 }
			}
			//Hero.heroliste.get(i).setStartPosition(i);
		}
	}
	/**
	 * Bewegung nach unten.
	 * @param i
	 */
	public static void movementDown(int i){
		//int i=0;
		if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()+1].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()+Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setyCoord();
		}
		else if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()+1].getTileId()%2 == 0) {
			if (Hero.heroliste.get(i).getyPixelPosition()<(Hero.heroliste.get(i).getyCoord()+1)*50 - (54- Hero.heroliste.get(i).getSpeed())) {
				Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()+Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setyCoord();
			}
		}
		else if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()+1].getTileId() == 0){
				}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			for(int n=0; n<Hero.heroliste.size(); n++) {
				Hero.heroliste.get(n).setStartPosition(n);
				Hero.heroliste.get(n).setscorecount(n, Hero.heroliste.get(n).getscorecount());
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + " Gegner erwischt = " + Hero.heroliste.get(0).getkillcount() + " Tode = " + Hero.heroliste.get(0).getdeathcount() + " Wände zerstört = " + Hero.heroliste.get(0).gettilecount() + " Selbstmorde = " + Hero.heroliste.get(0).getSuicidecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + " Gegner erwischt = " + Hero.heroliste.get(1).getkillcount() + " Tode = " + Hero.heroliste.get(1).getdeathcount() + " Wände zerstört = " + Hero.heroliste.get(1).gettilecount() + " Selbstmorde = " + Hero.heroliste.get(1).getSuicidecount());
			for(Hero hero : Hero.heroliste) {
				hero.resettilecount();
				hero.resetkillcount();
				hero.resetscorecount();
				hero.resetdeathcount();
				hero.resetsuicidecount();
			}
	}
		if(Hero.heroliste.get(i).getisalive() == false){
			Hero.heroliste.get(i).setdeathcount(Hero.heroliste.get(i).getdeathcount());
			//Hero.heroliste.get(i).setkillcount(i);
			for(Bombe bombe : Bombe.bombenliste) {
				if(bombe.getDroppedby()==i && Hero.heroliste.get(i).getisalive() == false) {
					 Hero.heroliste.get(i).setSuicidecount(i, Hero.heroliste.get(i).getSuicidecount());
					 Hero.heroliste.get(i).setStartPosition(i);
				 }
			}
			//Hero.heroliste.get(i).setStartPosition(i);
		}
	}
}
