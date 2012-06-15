package controlling;

import main.Bombe;
import main.Hero;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.ListIterator;
import java.util.Timer;

/**
 * Die InputController-Klasse regelt die Tastenbelegung zur Steuerung der Spielfiguren.
 * Den verschiedenen Richtungsmethoden wird ein int Wert übergeben um zu bestimmen welche Figur bewegt werden soll.
 * 
 * @author Sebastian
 *
 */

public class InputController implements KeyListener
	{
	public static boolean moveUp = false;
	/**
	 * Tastenbelegung für Spieler 1.
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			//Controller.controllerliste.get(0);
			Controller.movementUp(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			//Controller.controllerliste.get(0);
			Controller.movementDown(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_A) {
			//Controller.controllerliste.get(0);
			Controller.movementLeft(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			//Controller.controllerliste.get(0).movementRight(0);;
			Controller.movementRight(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_X) {
			/*boolean blocked=false;
			ListIterator<Bombe> it = Bombe.bombenliste.listIterator();
			
			while(it.hasNext()) {
				if (it.next().getBombex() == Hero.getxCoord() && it.next().getBombey() == Hero.getyCoord()) {
					blocked=true;
				}
			}
			if (blocked!=true) {*/
				Bombe b = new Bombe();
				b.setBombex(Hero.heroliste.get(0).getxCoord());
				b.setBombey(Hero.heroliste.get(0).getyCoord());
				b.setSichtbar(true);
				Bombe.bombenliste.add(b);
				if (Bombe.bombenliste.isEmpty()==false) {
					System.out.println("Eine Bombe wurde gesetzt:" + Bombe.bombenliste.get(0).getBombex() + ", " + Bombe.bombenliste.get(0).getBombey());
				}
				Bombe.bombenliste.getLast().setDroppedbyone(true);
				Timer timer = new Timer();
				timer.schedule(b, 3000);
			//}
		}
		/**
		 * Tastenbelegung für Spieler 2.
		 */
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			//Controller.controllerliste.get(1);
			Controller.movementUp(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			//Controller.controllerliste.get(1);
			Controller.movementDown(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			//Controller.controllerliste.get(1);
			Controller.movementLeft(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//Controller.controllerliste.get(1).movementRight(0);;
			Controller.movementRight(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			/*boolean blocked=false;
			ListIterator<Bombe> it = Bombe.bombenliste.listIterator();
			
			while(it.hasNext()) {
				if (it.next().getBombex() == Hero.getxCoord() && it.next().getBombey() == Hero.getyCoord()) {
					blocked=true;
				}
			}
			if (blocked!=true) {*/
				Bombe b = new Bombe();
				b.setBombex(Hero.heroliste.get(1).getxCoord());
				b.setBombey(Hero.heroliste.get(1).getyCoord());
				b.setSichtbar(true);
				Bombe.bombenliste.add(b);
				if (Bombe.bombenliste.isEmpty()==false) {
					System.out.println("Eine Bombe wurde gesetzt:" + Bombe.bombenliste.get(0).getBombex() + ", " + Bombe.bombenliste.get(0).getBombey());
				}
				Bombe.bombenliste.getLast().setDroppedbytwo(true);
				Timer timer = new Timer();
				timer.schedule(b, 3000);
			//}
		}
	}
	
	public void keyReleased(KeyEvent e)	{
		
		}

	public void keyTyped(KeyEvent e) {
				
	}
	
}