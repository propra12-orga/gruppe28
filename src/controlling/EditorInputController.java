package controlling;


import main.EditorHero;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import board.Editorboard;
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
		
		/**
		 * Tastenbelegung für Spieler 2.
		 */
		if (keys.contains(KeyEvent.VK_UP)) {
			Controller.movementEditorUp(0);
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				
			}
		}
		else if (keys.contains(KeyEvent.VK_DOWN)) {
			Controller.movementEditorDown(0);
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				
			}
		}
		if (keys.contains(KeyEvent.VK_LEFT)) {
			Controller.movementEditorLeft(0);
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				
			}
		}
		else if (keys.contains(KeyEvent.VK_RIGHT)) {
			Controller.movementEditorRight(0);
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				
			}
		}
		if (keys.contains(KeyEvent.VK_SPACE)) {
			Editorboard.map[EditorHero.heroliste.get(0).getxCoord()][EditorHero.heroliste.get(0).getyCoord()].setTileId(2);
			Editorboard.map[EditorHero.heroliste.get(0).getxCoord()][EditorHero.heroliste.get(0).getyCoord()].setImg(Tileset.getTile(1, Tile.getTileset()));
		}
		else if (keys.contains(KeyEvent.VK_CONTROL)) {
			Editorboard.map[EditorHero.heroliste.get(0).getxCoord()][EditorHero.heroliste.get(0).getyCoord()].setTileId(1);
			Editorboard.map[EditorHero.heroliste.get(0).getxCoord()][EditorHero.heroliste.get(0).getyCoord()].setImg(Tileset.getTile(0, Tile.getTileset()));
		}
		else if (keys.contains(KeyEvent.VK_ALT)) {
			Editorboard.map[EditorHero.heroliste.get(0).getxCoord()][EditorHero.heroliste.get(0).getyCoord()].setTileId(4);
			Editorboard.map[EditorHero.heroliste.get(0).getxCoord()][EditorHero.heroliste.get(0).getyCoord()].setImg(Tileset.getTile(3, Tile.getTileset()));
		}
	}
	}
	
}