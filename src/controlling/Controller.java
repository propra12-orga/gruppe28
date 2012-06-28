package controlling;

//import java.util.LinkedList;

//import java.awt.Rectangle;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import board.Board;
import board.JukeBox;

import main.Bombe;
import main.EndGame;
import main.Hero;
import main.Mainframe;

/**
 * Die Controller-Klasse enthält den Bewegungslogarithmus der Spielfigur.
 * Den Bewegungs-methoden wird ein int Wert übergeben um zu bestimmen, welche Spielfigur bewegt werden soll.
 * 
 * @author Sebastian
 *
 */

public class Controller extends JFrame {
	/**
	 * Bewegung nach rechts.
	 * @param i
	 */
	/*Rectangle h1 = Tileset.getBounds(0);
	Rectangle h2 = Tileset.getBounds(1);*/
	
	private static final long serialVersionUID = 1L;
	
	public static void movementRight(int i){
		if (Board.map[(Hero.heroliste.get(i).getxCoord()+1)][Hero.heroliste.get(i).getyCoord()].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()+Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setxCoord();
		}
		else if(Board.map[Hero.heroliste.get(i).getxCoord()+1][Hero.heroliste.get(i).getyCoord()].getTileId()%2 == 0) {
				if (Hero.heroliste.get(i).getxPixelPosition()<(Hero.heroliste.get(i).getxCoord()+1)*50 - (40- Hero.heroliste.get(i).getSpeed())) {
					Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()+Hero.heroliste.get(i).getSpeed());
					Hero.heroliste.get(i).setxCoord();
				}
			}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			for(int n=0; n<Hero.heroliste.size(); n++) {
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Mainframe.setStartPosition(n);
				Hero.heroliste.get(n).setscorecount();
				
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + 
					" Gegner erwischt = " + Hero.heroliste.get(0).getkillcount() + 
					" Tode = " + Hero.heroliste.get(0).getdeathcount() + 
					" Wände zerstört = " + Hero.heroliste.get(0).gettilecount() + 
					" Selbstmorde = " + Hero.heroliste.get(0).getSuicidecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + 
					" Gegner erwischt = " + Hero.heroliste.get(1).getkillcount() + 
					" Tode = " + Hero.heroliste.get(1).getdeathcount() + 
					" Wände zerstört = " + Hero.heroliste.get(1).gettilecount() + 
					" Selbstmorde = " + Hero.heroliste.get(1).getSuicidecount());
			for(Hero hero : Hero.heroliste) {
				hero.resettilecount();
				hero.resetkillcount();
				hero.resetscorecount();
				hero.resetdeathcount();
				hero.resetsuicidecount();
			}		
			EndGame end = new EndGame();
 		   end.setVisible(true);
		}
		}
	/**
	 * Bewegung nach links.
	 * @param i
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 */
	public static void movementLeft(int i){
		//int i=0;
		if (Board.map[(Hero.heroliste.get(i).getxCoord()-1)][Hero.heroliste.get(i).getyCoord()].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()-Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setxCoord();
		}
		else if(Board.map[Hero.heroliste.get(i).getxCoord()-1][Hero.heroliste.get(i).getyCoord()].getTileId()%2 == 0) {
			if (Hero.heroliste.get(i).getxPixelPosition()>Hero.heroliste.get(i).getxCoord()*50 + (Hero.heroliste.get(i).getSpeed())) {
				Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()-Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setxCoord();
			}
		}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			for(int n=0; n<Hero.heroliste.size(); n++) {
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Mainframe.setStartPosition(n);
				Hero.heroliste.get(n).setscorecount();
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + 
					" Gegner erwischt = " + Hero.heroliste.get(0).getkillcount() + 
					" Tode = " + Hero.heroliste.get(0).getdeathcount() + 
					" Wände zerstört = " + Hero.heroliste.get(0).gettilecount() + 
					" Selbstmorde = " + Hero.heroliste.get(0).getSuicidecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + 
					" Gegner erwischt = " + Hero.heroliste.get(1).getkillcount() + 
					" Tode = " + Hero.heroliste.get(1).getdeathcount() + 
					" Wände zerstört = " + Hero.heroliste.get(1).gettilecount() + 
					" Selbstmorde = " + Hero.heroliste.get(1).getSuicidecount());
			for(Hero hero : Hero.heroliste) {
				hero.resettilecount();
				hero.resetkillcount();
				hero.resetscorecount();
				hero.resetdeathcount();
				hero.resetsuicidecount();
			}
			EndGame end = new EndGame();
	 		   end.setVisible(true);
		}
	}
	/**
	 * Bewegung nach oben.
	 * @param i
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 */
	public static void movementUp(int i){
		//int i=0;
		if (Board.map[(Hero.heroliste.get(i).getxCoord())][Hero.heroliste.get(i).getyCoord()-1].getTileId()%2 != 0) {
				Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()-Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setyCoord();
		}
		else if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()-1].getTileId()%2 == 0) {
			if (Hero.heroliste.get(i).getyPixelPosition()>Hero.heroliste.get(i).getyCoord()*50 + (Hero.heroliste.get(i).getSpeed())) {
				Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()-Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setyCoord();
			}
		}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			for(int n=0; n<Hero.heroliste.size(); n++) {
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Mainframe.setStartPosition(n);
				Hero.heroliste.get(n).setscorecount();
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + 
					" Gegner erwischt = " + Hero.heroliste.get(0).getkillcount() + 
					" Tode = " + Hero.heroliste.get(0).getdeathcount() + 
					" Wände zerstört = " + Hero.heroliste.get(0).gettilecount() + 
					" Selbstmorde = " + Hero.heroliste.get(0).getSuicidecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + 
					" Gegner erwischt = " + Hero.heroliste.get(1).getkillcount() + 
					" Tode = " + Hero.heroliste.get(1).getdeathcount() + 
					" Wände zerstört = " + Hero.heroliste.get(1).gettilecount() + 
					" Selbstmorde = " + Hero.heroliste.get(1).getSuicidecount());
			for(Hero hero : Hero.heroliste) {
				hero.resettilecount();
				hero.resetkillcount();
				hero.resetscorecount();
				hero.resetdeathcount();
				hero.resetsuicidecount();
			}
			EndGame end = new EndGame();
	 		   end.setVisible(true);
		}	
	}
	/**
	 * Bewegung nach unten.
	 * @param i
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 */
	public static void movementDown(int i) {
		//int i=0;
		if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()+1].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()+Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setyCoord();
		}
		else if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()+1].getTileId()%2 == 0) {
			if (Hero.heroliste.get(i).getyPixelPosition()<(Hero.heroliste.get(i).getyCoord()+1)*50 - (40- Hero.heroliste.get(i).getSpeed())) {
				Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()+Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setyCoord();
			}
		}
		else if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()+1].getTileId() == 0){
				}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			for(int n=0; n<Hero.heroliste.size(); n++) {
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Mainframe.setStartPosition(n);
				Hero.heroliste.get(n).setscorecount();
			}
			Bombe.bombenliste.clear();
			System.out.println("Spieler 1: Punkte = " + Hero.heroliste.get(0).getscorecount() + 
					" Gegner erwischt = " + Hero.heroliste.get(0).getkillcount() + 
					" Tode = " + Hero.heroliste.get(0).getdeathcount() + 
					" Wände zerstört = " + Hero.heroliste.get(0).gettilecount() + 
					" Selbstmorde = " + Hero.heroliste.get(0).getSuicidecount());
			System.out.println("Spieler 2: Punkte = " + Hero.heroliste.get(1).getscorecount() + 
					" Gegner erwischt = " + Hero.heroliste.get(1).getkillcount() + 
					" Tode = " + Hero.heroliste.get(1).getdeathcount() + 
					" Wände zerstört = " + Hero.heroliste.get(1).gettilecount() + 
					" Selbstmorde = " + Hero.heroliste.get(1).getSuicidecount());
			for(Hero hero : Hero.heroliste) {
				hero.resettilecount();
				hero.resetkillcount();
				hero.resetscorecount();
				hero.resetdeathcount();
				hero.resetsuicidecount();
			}
			EndGame end = new EndGame();
	 		   end.setVisible(true);
	}
	}
}
