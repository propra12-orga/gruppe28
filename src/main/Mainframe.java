package main;

import java.io.IOException;
import javax.swing.JFrame;

import board.Board;


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
		mf.add(board);
		mf.addKeyListener(new controlling.InputController());
		mf.setVisible(true);
		Hero.setxPixelPosition(116);
		Hero.setyPixelPosition(116);
		Hero.setxCoord();
		Hero.setyCoord();
		
		while(true) {
			board.repaint();
			Thread.sleep(25);
			}
		
		
	}
}