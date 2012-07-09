package board;

import main.EditorHero;
import java.awt.*;
//import java.util.ListIterator;

import javax.swing.JPanel;

import controlling.EditorInputController;

public class Editorboard extends JPanel {
	/**
	 * Die Klasse Board stellt das Spielfeld dar. Sie initialisiert es und ist auch f�r das Zeichnen zust�ndig.
	 * @author Dustin
	 */


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
		
		g2d.drawImage(Tileset.getTile(EditorInputController.auswahl-1, Tile.tileset), EditorHero.heroliste.get(0).getxPixelPosition()-1, EditorHero.heroliste.get(0).getyPixelPosition()-1, null);
		g2d.drawRect(EditorHero.heroliste.get(0).getxPixelPosition()-1, EditorHero.heroliste.get(0).getyPixelPosition()-1, 50, 50);
		
	}
	public void createLevel(int[][] level) {
		
				for (int j=0; j<LevelReader.r; j++) {
			for (int i=0; i<LevelReader.c; i++) {
				map[i][j]= new Tile(level[i][j]);
			}
		}
	}
	
	
	
	
	}
