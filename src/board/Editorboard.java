package board;
import main.Bombe;
import main.EditorHero;
import main.Hero;
import main.Karteneditor;
import main.Mainframe;
import main.Upgrades;

import java.awt.*;
import java.awt.geom.Rectangle2D;
//import java.util.ListIterator;

import javax.swing.JPanel;

public class Editorboard extends JPanel {
	/**
	 * Die Klasse Board stellt das Spielfeld dar. Sie initialisiert es und ist auch f�r das Zeichnen zust�ndig.
	 * @author Dustin
	 */


	
	private static int destructableCounter=0;
	private static boolean hasExit=false;
	static int gelegtebomben =0;
	
	public static void setHasExit(boolean b) {
		hasExit=b;
	}
	public static boolean getHasExit() {
		return hasExit;
	}
	public static void incDestructableCounter() {
		destructableCounter++;
	}
	public static void decDestructableCounter() {
		destructableCounter--;
	}
	public static int getDestructableCounter() {
		return destructableCounter;
	}
	private void clearDestructableCounter() {
		destructableCounter=0;
	}
	
	private static final long serialVersionUID = 1L;
	
	
	
	public static Tile[][] map;
	public Editorboard() {
		map = new Tile[21][13];
		for (int row=0; row <LevelReader.r; row++) {
			for (int col=0; col <LevelReader.c; col++) {
				map[col][row]=new Tile(1);
				
			}
		}
	}
	/**
	 * Zeichenfunktion, iteriert durch das Spielfeld und zeichnet die Felder nach ihrer TileId. 
	 * Dann wird die Bombe und zuletzt die Heroes gezeichnet.
	 */
	public void paint(Graphics g) {
		//Spielfeld
		Graphics2D g2d = (Graphics2D) g;
		for (int row=0; row <LevelReader.r; row++) {
			for (int col=0; col <LevelReader.c; col++) {
				g2d.drawImage(map[col][row].getImg(), col*50, row*50, null);
				
				
			}
		}
		

		g2d.draw(new Rectangle2D.Double(EditorHero.heroliste.get(0).getxPixelPosition(), EditorHero.heroliste.get(0).getyPixelPosition(), 50, 50));
			
	}
	public void createLevel(int[][] level) {
		
		clearDestructableCounter();
		for (int j=0; j<LevelReader.r; j++) {
			for (int i=0; i<LevelReader.c; i++) {
				map[i][j]= new Tile(level[i][j]);
				if (level[i][j] == 4) {
					Board.incDestructableCounter();
				}
				if (level[i][j] == 3) {
					setHasExit(true);
				}
			}
		}
	}
	
	
	
	
	}
