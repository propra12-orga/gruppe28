package main;

import java.io.File;
//import java.io.FileWriter;
//import java.io.Writer;

import java.io.IOException;

//import javax.swing.JFileChooser;
import javax.swing.JFrame;

import controlling.InputController;

//import controlling.Controller;

import board.Board;
import board.LevelReader;
//import board.Tileset;


public class Mainframe extends JFrame{
	/**
	 * 
	 */
	public static boolean twoplayer=true;

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
		if(twoplayer==true){
			Hero bm2 = new Hero();
			Hero.heroliste.add(bm2);
		}
		//Controller ctrl1 = new Controller();
		//Controller.controllerliste.add(ctrl1);
		//Controller ctrl2 = new Controller();
		//Controller.controllerliste.add(ctrl2);
		InputController ic = new controlling.InputController();
		ic.start();
		
		board.createLevel(LevelReader.readLevel(test));
		mf.add(board);
		mf.addKeyListener(ic);
		mf.setVisible(true);
		for(int i=0; i<(Hero.heroliste.size()); i++) {
			Hero.heroliste.get(i).setStartPosition(i);
		}
		
		LevelReader.ausgabe(LevelReader.readLevel(test));
				
		while(true) {
			board.repaint();
			Thread.sleep(45);
			}
		}
		
	}
