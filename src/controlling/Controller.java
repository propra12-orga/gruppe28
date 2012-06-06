package controlling;
import board.Board;

import main.Bombe;
import main.Hero;


public class Controller {
	public static void movementRight(){
		if (Board.map[(Hero.getxCoord()+1)][Hero.getyCoord()].getTileId()%2 != 0) {
			Hero.setxPixelPosition(Hero.getxPixelPosition()+Hero.getSpeed());
			Hero.setxCoord();
		}
		else if(Board.map[Hero.getxCoord()+1][Hero.getyCoord()].getTileId()%2 == 0) {
				if (Hero.getxPixelPosition()<(Hero.getxCoord()+1)*75 - 75/2) {
					Hero.setxPixelPosition(Hero.getxPixelPosition()+Hero.getSpeed());
					Hero.setxCoord();
				}
			}
		if(Board.map[Hero.getxCoord()][Hero.getyCoord()].getTileId() == 3){
			Hero.setxPixelPosition(100);
			Hero.setyPixelPosition(100);
			Hero.setxCoord();
			Hero.setyCoord();
			Bombe.bombenliste.clear();
			}
		}
	public static void movementLeft(){
		if (Board.map[(Hero.getxCoord()-1)][Hero.getyCoord()].getTileId()%2 != 0) {
			Hero.setxPixelPosition(Hero.getxPixelPosition()-Hero.getSpeed());
			Hero.setxCoord();
		}
		else if(Board.map[Hero.getxCoord()-1][Hero.getyCoord()].getTileId()%2 == 0) {
			if (Hero.getxPixelPosition()>Hero.getxCoord()*75 + 75/2) {
				Hero.setxPixelPosition(Hero.getxPixelPosition()-Hero.getSpeed());
				Hero.setxCoord();
			}
		}
		if(Board.map[Hero.getxCoord()][Hero.getyCoord()].getTileId() == 3){
			Hero.setxPixelPosition(100);
			Hero.setyPixelPosition(100);
			Hero.setxCoord();
			Hero.setyCoord();
			Bombe.bombenliste.clear();
		}
	}

	public static void movementUp(){
		if (Board.map[(Hero.getxCoord())][Hero.getyCoord()-1].getTileId()%2 != 0) {
				Hero.setyPixelPosition(Hero.getyPixelPosition()-Hero.getSpeed());
				Hero.setyCoord();
		}
		else if(Board.map[Hero.getxCoord()][Hero.getyCoord()-1].getTileId()%2 == 0) {
			if (Hero.getyPixelPosition()>Hero.getyCoord()*75 + 75/2) {
				Hero.setyPixelPosition(Hero.getyPixelPosition()-Hero.getSpeed());
				Hero.setyCoord();
			}
		}
		if(Board.map[Hero.getxCoord()][Hero.getyCoord()].getTileId() == 3){
			Hero.setxPixelPosition(100);
			Hero.setyPixelPosition(100);
			Hero.setxCoord();
			Hero.setyCoord();
			Bombe.bombenliste.clear();
		}		
	}
	public static void movementDown(){
		if (Board.map[Hero.getxCoord()][Hero.getyCoord()+1].getTileId()%2 != 0) {
			Hero.setyPixelPosition(Hero.getyPixelPosition()+Hero.getSpeed());
			Hero.setyCoord();
		}
		else if (Board.map[Hero.getxCoord()][Hero.getyCoord()+1].getTileId()%2 == 0) {
			if (Hero.getyPixelPosition()<(Hero.getyCoord()+1)*75 - 75/2) {
				Hero.setyPixelPosition(Hero.getyPixelPosition()+Hero.getSpeed());
				Hero.setyCoord();
			}
		}
		else if(Board.map[Hero.getxCoord()][Hero.getyCoord()+1].getTileId() == 0){
				}
			if(Board.map[Hero.getxCoord()][Hero.getyCoord()].getTileId() == 3){
				Hero.setxPixelPosition(100);
				Hero.setyPixelPosition(100);
				Hero.setxCoord();
				Hero.setyCoord();
				Bombe.bombenliste.clear();
		}
	}
}
