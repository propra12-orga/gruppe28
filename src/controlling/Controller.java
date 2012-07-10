package controlling;

//import java.util.LinkedList;

//import java.awt.Rectangle;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import board.Board;
import board.JukeBox;
import board.LevelReader;

import main.Bombe;
import main.EditorHero;
import main.EndGame;
import main.Hero;
import main.Mainframe;
import main.SortArray;

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
	
	private static final long serialVersionUID = 1L;
	public static void movementEditorRight(int i) {
		//int i=0;
		if(EditorHero.heroliste.get(0).getxCoord()!=LevelReader.c-1)
		{
		EditorHero.heroliste.get(i).setxPixelPosition(EditorHero.heroliste.get(i).getxPixelPosition()+50);
		EditorHero.heroliste.get(i).setxCoord();
		}
	}
	public static void movementRight(int i){
		if (Board.map[(Hero.heroliste.get(i).getxPixelPosition()+39+Hero.heroliste.get(i).getSpeed())/50][Hero.heroliste.get(i).getyPixelPosition()/50].getTileId()%2 != 0
				&& Board.map[(Hero.heroliste.get(i).getxPixelPosition()+39+Hero.heroliste.get(i).getSpeed())/50][(Hero.heroliste.get(i).getyPixelPosition()+39)/50].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()+Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setxCoord();
		}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			Hero.heroliste.get(i).exitreached=true;
			for(int n=0; n<Hero.heroliste.size(); n++) {
				if(Mainframe.sound==true){
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
			new SortArray();
			InputController.keys.clear();
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
	public static void movementEditorLeft(int i) {
		//int i=0;
		if(EditorHero.heroliste.get(0).getxCoord()!=0)
		{
		EditorHero.heroliste.get(i).setxPixelPosition(EditorHero.heroliste.get(i).getxPixelPosition()-50);
		EditorHero.heroliste.get(i).setxCoord();
		}
	}
	public static void movementLeft(int i){
		//int i=0;
		if (Board.map[(Hero.heroliste.get(i).getxPixelPosition()-Hero.heroliste.get(i).getSpeed())/50][Hero.heroliste.get(i).getyPixelPosition()/50].getTileId()%2 != 0
				&& Board.map[(Hero.heroliste.get(i).getxPixelPosition()-Hero.heroliste.get(i).getSpeed())/50][(Hero.heroliste.get(i).getyPixelPosition()+39)/50].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setxPixelPosition(Hero.heroliste.get(i).getxPixelPosition()-Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setxCoord();
		}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			Hero.heroliste.get(i).exitreached=true;
			for(int n=0; n<Hero.heroliste.size(); n++) {
				if(Mainframe.sound==true){
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
			new SortArray();
			InputController.keys.clear();
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
	public static void movementEditorUp(int i) {
		//int i=0;
		if(EditorHero.heroliste.get(0).getyCoord()!=0)
		{
		EditorHero.heroliste.get(i).setyPixelPosition(EditorHero.heroliste.get(i).getyPixelPosition()-50);
		EditorHero.heroliste.get(i).setyCoord();
		}
	}
	public static void movementUp(int i){
		//int i=0;
		if (Board.map[(Hero.heroliste.get(i).getxPixelPosition())/50][(Hero.heroliste.get(i).getyPixelPosition()-Hero.heroliste.get(i).getSpeed())/50].getTileId()%2 != 0
				&& Board.map[(Hero.heroliste.get(i).getxPixelPosition()+39)/50][(Hero.heroliste.get(i).getyPixelPosition()-Hero.heroliste.get(i).getSpeed())/50].getTileId()%2 != 0) {
				Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()-Hero.heroliste.get(i).getSpeed());
				Hero.heroliste.get(i).setyCoord();
		}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			Hero.heroliste.get(i).exitreached=true;
			for(int n=0; n<Hero.heroliste.size(); n++) {
				if(Mainframe.sound==true){
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
			new SortArray();
			InputController.keys.clear();
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
	public static void movementEditorDown(int i) {
		//int i=0;
		if(EditorHero.heroliste.get(0).getyCoord()!= LevelReader.r-1)
		{
		EditorHero.heroliste.get(i).setyPixelPosition(EditorHero.heroliste.get(i).getyPixelPosition()+50);
		EditorHero.heroliste.get(i).setyCoord();
		}
	}
	public static void movementDown(int i) {
		//int i=0;
		if (Board.map[(Hero.heroliste.get(i).getxPixelPosition())/50][(Hero.heroliste.get(i).getyPixelPosition()+39+Hero.heroliste.get(i).getSpeed())/50].getTileId()%2 != 0
				&& Board.map[(Hero.heroliste.get(i).getxPixelPosition()+39)/50][(Hero.heroliste.get(i).getyPixelPosition()+39+Hero.heroliste.get(i).getSpeed())/50].getTileId()%2 != 0) {
			Hero.heroliste.get(i).setyPixelPosition(Hero.heroliste.get(i).getyPixelPosition()+Hero.heroliste.get(i).getSpeed());
			Hero.heroliste.get(i).setyCoord();
		}
		if(Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()].getTileId() == 3){
			Hero.heroliste.get(i).exitreached=true;
			for(int n=0; n<Hero.heroliste.size(); n++) {
				if(Mainframe.sound==true){
				try {
					JukeBox.playSoundeffect("gatewalk");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
			new SortArray();
			InputController.keys.clear();
			EndGame end = new EndGame();
	 		   end.setVisible(true);
	}
	}
}
