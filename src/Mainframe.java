
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Mainframe extends JFrame{
	/**
	 * 
	 */
	

	private static final long serialVersionUID = 1L;
	
	public Mainframe() {
		
		setSize(1050,926);
		setLocationRelativeTo(null);
		setTitle("Bomberman");
		//Board board = new Board();
		
		//board.createLevel(1);
		
	}
	public static void main (String[] args) throws InterruptedException, IOException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
		Mainframe mf = new Mainframe();
		Board board = new Board();
		mf.add(board);
		Tileset.initTileset();
		mf.setVisible(true);
		Hero.setxPixelPosition(100);
		Hero.setyPixelPosition(100);
		
		while(true) {
			board.repaint();
			Thread.sleep(1234);
			Hero.setyPixelPosition(Hero.getyPixelPosition()+1);
		}
		
		
	}
}