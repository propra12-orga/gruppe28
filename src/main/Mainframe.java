package main;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import board.Board;
import board.LevelReader;
import board.Tileset;


public class Mainframe extends JFrame{
	/**
	 * 
	 */
	

	private static final long serialVersionUID = 1L;
	
	
	public Mainframe() {
		
		setSize(1050,926);
		setLocationRelativeTo(null);
		setTitle("Bomberman");
		
		
	}
	public static void main (String[] args) throws InterruptedException, IOException {
		board.Tileset.initTileset();
		Mainframe mf = new Mainframe();
		Board board = new Board();
		File test = new File("res/1.txt");
		
		board.createLevel(LevelReader.readLevel(test));
		mf.add(board);
		mf.addKeyListener(new controlling.InputController());
		mf.setVisible(true);
		Hero.setxPixelPosition(116);
		Hero.setyPixelPosition(116);
		Hero.setxCoord();
		Hero.setyCoord();
		
		LevelReader.ausgabe(LevelReader.readLevel(test));
				
		while(true) {
			board.repaint();
			Thread.sleep(45);
			}
		}
		
	}
