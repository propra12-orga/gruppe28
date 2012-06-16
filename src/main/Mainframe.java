package main;

import java.io.File;
//import java.io.FileWriter;
//import java.io.Writer;

import java.io.IOException;

//import javax.swing.JFileChooser;
import javax.swing.JFrame;

//import controlling.Controller;

import board.Board;
import board.LevelReader;
//import board.Tileset;


public class Mainframe extends JFrame{
	/**
	 * 
	 */
	

	private static final long serialVersionUID = 1L;
		
	public Mainframe() {
		
		setSize(665,688);
		setLocationRelativeTo(null);
		setTitle("Bomberman");
		
		
	}
	public static void main (String[] args) throws InterruptedException, IOException {
		board.Tileset.initTileset();
		board.Tileset.initBombset();
		Mainframe mf = new Mainframe();
		Board board = new Board();
		File test = new File("res/1.txt");
		Hero bm1 = new Hero();
		Hero.heroliste.add(bm1);
		Hero bm2 = new Hero();
		Hero.heroliste.add(bm2);
		//Controller ctrl1 = new Controller();
		//Controller.controllerliste.add(ctrl1);
		//Controller ctrl2 = new Controller();
		//Controller.controllerliste.add(ctrl2);
		
		board.createLevel(LevelReader.readLevel(test));
		mf.add(board);
		mf.addKeyListener(new controlling.InputController());
		mf.setVisible(true);
		int i=0;
		Hero.heroliste.get(i).setxPixelPosition(55);
		Hero.heroliste.get(i).setyPixelPosition(55);
		Hero.heroliste.get(i).setxCoord();
		Hero.heroliste.get(i).setyCoord();
		i++;
		Hero.heroliste.get(i).setxPixelPosition(561);
		Hero.heroliste.get(i).setyPixelPosition(55);
		Hero.heroliste.get(i).setxCoord();
		Hero.heroliste.get(i).setyCoord();
		
		LevelReader.ausgabe(LevelReader.readLevel(test));
				
		while(true) {
			board.repaint();
			Thread.sleep(45);
			}
		}
		
	}
