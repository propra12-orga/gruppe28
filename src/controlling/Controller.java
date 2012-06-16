package controlling;
//import java.util.LinkedList;

import board.Board;

import main.Bombe;
import main.Hero;

/**
 * Die Controller-Klasse enth�lt den Bewegungslogarithmus der Spielfigur.
 * Den Bewegungs-methoden wird ein int Wert �bergeben um zu bestimmen, welche Spielfigur bewegt werden soll.
 * 
 * @author Sebastian
 *
 */

public class Controller {
	//public static LinkedList<Controller> controllerliste = new LinkedList<Controller>();
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
			for(int n=0; n<(Hero.heroliste.size()-1); n++) {
				Hero.heroliste.get(n).setStartPosition(n);
				Hero.heroliste.get(n).setscorecount(n, Hero.heroliste.get(n).getscorecount());
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + " Kills = " + Hero.heroliste.get(0).getkillcount() + " Deaths = " + Hero.heroliste.get(0).getdeathcount() + " Tiles = " + Hero.heroliste.get(0).gettilecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + " Kills = " + Hero.heroliste.get(1).getkillcount() + " Deaths = " + Hero.heroliste.get(1).getdeathcount() + " Tiles = " + Hero.heroliste.get(1).gettilecount());
			for(int k=0; k<(Hero.heroliste.size()-1); k++) {
				Hero.heroliste.get(k).tilecount = 0;
				Hero.heroliste.get(k).killcount = 0;
				Hero.heroliste.get(k).scorecount = 0;
				Hero.heroliste.get(k).deathcount = 0;
			}		
			
		}
		if(Hero.heroliste.get(i).getisalive() == false){
			Hero.heroliste.get(i).setStartPosition(i);
		}
		}
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
			for(int n=0; n<(Hero.heroliste.size()-1); n++) {
				Hero.heroliste.get(n).setStartPosition(n);
				Hero.heroliste.get(n).setscorecount(n, Hero.heroliste.get(n).getscorecount());
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + " Kills = " + Hero.heroliste.get(0).getkillcount() + " Deaths = " + Hero.heroliste.get(0).getdeathcount() + " Tiles = " + Hero.heroliste.get(0).gettilecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + " Kills = " + Hero.heroliste.get(1).getkillcount() + " Deaths = " + Hero.heroliste.get(1).getdeathcount() + " Tiles = " + Hero.heroliste.get(1).gettilecount());
			for(int k=0; k<2; k++) {
				Hero.heroliste.get(k).tilecount = 0;
				Hero.heroliste.get(k).killcount = 0;
				Hero.heroliste.get(k).scorecount = 0;
				Hero.heroliste.get(k).deathcount = 0;
			}
		}
		if(Hero.heroliste.get(i).getisalive() == false){
			Hero.heroliste.get(i).setStartPosition(i);
		}
	}

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
			for(int n=0; n<(Hero.heroliste.size()-1); n++) {
				Hero.heroliste.get(n).setStartPosition(n);
				Hero.heroliste.get(n).setscorecount(n, Hero.heroliste.get(n).getscorecount());
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + " Kills = " + Hero.heroliste.get(0).getkillcount() + " Deaths = " + Hero.heroliste.get(0).getdeathcount() + " Tiles = " + Hero.heroliste.get(0).gettilecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + " Kills = " + Hero.heroliste.get(1).getkillcount() + " Deaths = " + Hero.heroliste.get(1).getdeathcount() + " Tiles = " + Hero.heroliste.get(1).gettilecount());
			for(int k=0; k<2; k++) {
				Hero.heroliste.get(k).tilecount = 0;
				Hero.heroliste.get(k).killcount = 0;
				Hero.heroliste.get(k).scorecount = 0;
				Hero.heroliste.get(k).deathcount = 0;
			}
		}	
		if(Hero.heroliste.get(i).getisalive() == false){
			Hero.heroliste.get(i).setStartPosition(i);
		}
	}
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
			for(int n=0; n<(Hero.heroliste.size()-1); n++) {
				Hero.heroliste.get(n).setStartPosition(n);
				Hero.heroliste.get(n).setscorecount(n, Hero.heroliste.get(n).getscorecount());
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + " Kills = " + Hero.heroliste.get(0).getkillcount() + " Deaths = " + Hero.heroliste.get(0).getdeathcount() + " Tiles = " + Hero.heroliste.get(0).gettilecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + " Kills = " + Hero.heroliste.get(1).getkillcount() + " Deaths = " + Hero.heroliste.get(1).getdeathcount() + " Tiles = " + Hero.heroliste.get(1).gettilecount());
			for(int k=0; k<2; k++) {
				Hero.heroliste.get(k).tilecount = 0;
				Hero.heroliste.get(k).killcount = 0;
				Hero.heroliste.get(k).scorecount = 0;
				Hero.heroliste.get(k).deathcount = 0;
			}
	}
		if(Hero.heroliste.get(i).getisalive() == false){
			Hero.heroliste.get(i).setStartPosition(i);
		}
	}
}
