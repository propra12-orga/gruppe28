package main;

import java.io.File;
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
		int[][] asd = new int[1][2]; //austauschen
		board.createLevel(asd);
		mf.add(board);
		mf.addKeyListener(new controlling.InputController());
		mf.setVisible(true);
		Hero.setxPixelPosition(116);
		Hero.setyPixelPosition(116);
		Hero.setxCoord();
		Hero.setyCoord();
		/*JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(mf);//rückgabewert speichern
		if(returnVal == JFileChooser.APPROVE_OPTION) {//überprüfen ob rückgabewert dem Zustand entspricht, den der chooser haben müsste wenn der Benutzer auf den öffnen knopf geklickt hat.
		File test = new File(chooser.getSelectedFile().getAbsolutePath());
		
		LevelReader.ausgabe(LevelReader.readLevel());
		
		}*/
		
		while(true) {
			board.repaint();
			Thread.sleep(45);
			}
		}
		
	}
