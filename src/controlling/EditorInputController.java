package controlling;


import main.EditorHero;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import board.Editorboard;
import board.LevelReader;
import board.Tile;
import board.Tileset;

/**
 * Die InputController-Klasse regelt die Tastenbelegung zur Steuerung der Spielfiguren.
 * Den verschiedenen Richtungsmethoden wird ein int Wert übergeben um zu bestimmen welche Figur bewegt werden soll.
 * 
 * @author Sebastian
 *
 */

public class EditorInputController extends Thread implements KeyListener
	{
	public static Vector<Integer> keys = new Vector<Integer>();
	public static boolean moveUp = false;
	public static int auswahl=1; 
	public void keyPressed(KeyEvent e) {
		if (!keys.contains(e.getKeyCode()))
			keys.add(e.getKeyCode());		
	}
	public void keyReleased(KeyEvent e)	{
		keys.removeElement(e.getKeyCode());
		}

	public void keyTyped(KeyEvent e) {
				
	}
	public void run() {
		while(true) {
			try{
				sleep(50);
			}
			catch(InterruptedException e) {
				
			}

		if (keys.contains(KeyEvent.VK_UP)) {
			Controller.movementEditor(0, -1, EditorHero.heroliste.get(0).getyCoord(), 1, "y");
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				
			}
		}
		else if (keys.contains(KeyEvent.VK_DOWN)) {
			Controller.movementEditor(0, 1, EditorHero.heroliste.get(0).getyCoord(), LevelReader.r-2, "y");
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				
			}
		}
		if (keys.contains(KeyEvent.VK_LEFT)) {
			Controller.movementEditor(0, -1, EditorHero.heroliste.get(0).getxCoord(), 1, "x");
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				
			}
		}
		else if (keys.contains(KeyEvent.VK_RIGHT)) {
			Controller.movementEditor(0, 1, EditorHero.heroliste.get(0).getxCoord(), LevelReader.c-2, "x");
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				
			}
		}
		if (keys.contains(KeyEvent.VK_1)) {
			auswahl=1;
		}
		else if (keys.contains(KeyEvent.VK_2)) {
			auswahl=2;
		}
		else if (keys.contains(KeyEvent.VK_3)) {
			auswahl=4;
		}

		if (keys.contains(KeyEvent.VK_SPACE)) {
			Editorboard.map[EditorHero.heroliste.get(0).getxCoord()][EditorHero.heroliste.get(0).getyCoord()].setTileId(auswahl);
			Editorboard.map[EditorHero.heroliste.get(0).getxCoord()][EditorHero.heroliste.get(0).getyCoord()].setImg(Tileset.getTile(auswahl-1, Tile.getTileset()));
		}
		}
	}
	
}