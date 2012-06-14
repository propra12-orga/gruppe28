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
			Hero.heroliste.get(0).setxPixelPosition(55);
			Hero.heroliste.get(0).setyPixelPosition(55);
			Hero.heroliste.get(0).setxCoord();
			Hero.heroliste.get(0).setyCoord();
			Hero.heroliste.get(0).setisalive(true);
			Hero.heroliste.get(1).setxPixelPosition(561);
			Hero.heroliste.get(1).setyPixelPosition(55);
			Hero.heroliste.get(1).setxCoord();
			Hero.heroliste.get(1).setyCoord();
			Hero.heroliste.get(1).setisalive(true);
			Bombe.bombenliste.clear();
		}
		if(Hero.heroliste.get(i).getisalive() == false){
			if(i==0){
				Hero.heroliste.get(0).setxPixelPosition(55);
				Hero.heroliste.get(0).setyPixelPosition(55);
				Hero.heroliste.get(0).setxCoord();
				Hero.heroliste.get(0).setyCoord();
				Hero.heroliste.get(0).setisalive(true);
			}
			if(i==1){
				Hero.heroliste.get(1).setxPixelPosition(561);
				Hero.heroliste.get(1).setyPixelPosition(55);
				Hero.heroliste.get(1).setxCoord();
				Hero.heroliste.get(1).setyCoord();
				Hero.heroliste.get(1).setisalive(true);
			}
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
			Hero.heroliste.get(0).setxPixelPosition(55);
			Hero.heroliste.get(0).setyPixelPosition(55);
			Hero.heroliste.get(0).setxCoord();
			Hero.heroliste.get(0).setyCoord();
			Hero.heroliste.get(0).setisalive(true);
			Hero.heroliste.get(1).setxPixelPosition(561);
			Hero.heroliste.get(1).setyPixelPosition(55);
			Hero.heroliste.get(1).setxCoord();
			Hero.heroliste.get(1).setyCoord();
			Hero.heroliste.get(1).setisalive(true);
			Bombe.bombenliste.clear();
		}
		if(Hero.heroliste.get(i).getisalive() == false){
			if(i==0){
				Hero.heroliste.get(0).setxPixelPosition(55);
				Hero.heroliste.get(0).setyPixelPosition(55);
				Hero.heroliste.get(0).setxCoord();
				Hero.heroliste.get(0).setyCoord();
				Hero.heroliste.get(0).setisalive(true);
			}
			if(i==1){
				Hero.heroliste.get(1).setxPixelPosition(561);
				Hero.heroliste.get(1).setyPixelPosition(55);
				Hero.heroliste.get(1).setxCoord();
				Hero.heroliste.get(1).setyCoord();
				Hero.heroliste.get(1).setisalive(true);
			}
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
			Hero.heroliste.get(0).setxPixelPosition(55);
			Hero.heroliste.get(0).setyPixelPosition(55);
			Hero.heroliste.get(0).setxCoord();
			Hero.heroliste.get(0).setyCoord();
			Hero.heroliste.get(0).setisalive(true);
			Hero.heroliste.get(1).setxPixelPosition(561);
			Hero.heroliste.get(1).setyPixelPosition(55);
			Hero.heroliste.get(1).setxCoord();
			Hero.heroliste.get(1).setyCoord();			
			Hero.heroliste.get(1).setisalive(true);
			Bombe.bombenliste.clear();
		}	
		if(Hero.heroliste.get(i).getisalive() == false){
			if(i==0){
				Hero.heroliste.get(0).setxPixelPosition(55);
				Hero.heroliste.get(0).setyPixelPosition(55);
				Hero.heroliste.get(0).setxCoord();
				Hero.heroliste.get(0).setyCoord();
				Hero.heroliste.get(0).setisalive(true);
			}
			if(i==1){
				Hero.heroliste.get(1).setxPixelPosition(561);
				Hero.heroliste.get(1).setyPixelPosition(55);
				Hero.heroliste.get(1).setxCoord();
				Hero.heroliste.get(1).setyCoord();
				Hero.heroliste.get(1).setisalive(true);
			}
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
			Hero.heroliste.get(0).setxPixelPosition(55);
			Hero.heroliste.get(0).setyPixelPosition(55);
			Hero.heroliste.get(0).setxCoord();
			Hero.heroliste.get(0).setyCoord();
			Hero.heroliste.get(0).setisalive(true);
			Hero.heroliste.get(1).setxPixelPosition(561);
			Hero.heroliste.get(1).setyPixelPosition(55);
			Hero.heroliste.get(1).setxCoord();
			Hero.heroliste.get(1).setyCoord();
			Hero.heroliste.get(1).setisalive(true);
			Bombe.bombenliste.clear();
	}
		if(Hero.heroliste.get(i).getisalive() == false){
			if(i==0){
				Hero.heroliste.get(0).setxPixelPosition(55);
				Hero.heroliste.get(0).setyPixelPosition(55);
				Hero.heroliste.get(0).setxCoord();
				Hero.heroliste.get(0).setyCoord();
				Hero.heroliste.get(0).setisalive(true);
			}
			if(i==1){
				Hero.heroliste.get(1).setxPixelPosition(561);
				Hero.heroliste.get(1).setyPixelPosition(55);
				Hero.heroliste.get(1).setxCoord();
				Hero.heroliste.get(1).setyCoord();
				Hero.heroliste.get(1).setisalive(true);
			}
		}
		}
	}
