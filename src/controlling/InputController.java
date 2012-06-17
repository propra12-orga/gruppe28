package controlling;

import main.Bombe;
import main.Hero;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.Vector;

/**
 * Die InputController-Klasse regelt die Tastenbelegung zur Steuerung der Spielfiguren.
 * Den verschiedenen Richtungsmethoden wird ein int Wert übergeben um zu bestimmen welche Figur bewegt werden soll.
 * 
 * @author Sebastian
 *
 */

public class InputController extends Thread implements KeyListener
	{
	Vector<Integer> keys = new Vector<Integer>();
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
		 * Tastenbelegung für Spieler 1.
		 */
		if (keys.contains(KeyEvent.VK_W)) {
			Controller.movementUp(0);
		}
		else if (keys.contains(KeyEvent.VK_S)) {
			Controller.movementDown(0);
		}
		if (keys.contains(KeyEvent.VK_A)) {
			Controller.movementLeft(0);
		}
		else if (keys.contains(KeyEvent.VK_D)) {
			Controller.movementRight(0);
		}
		if (keys.contains(KeyEvent.VK_X)) {
			boolean blocked=false;
			
			
			for(Bombe bombe : Bombe.bombenliste) {
				if (bombe.getBombex() == Hero.heroliste.get(0).getxCoord() && bombe.getBombey() == Hero.heroliste.get(0).getyCoord()) {
					blocked=true;
				}
			}
			if (blocked!=true) {
			if(Hero.heroliste.get(0).getBombcount()<=2){
				Bombe b = new Bombe();
				b.setBombex(Hero.heroliste.get(0).getxCoord());
				b.setBombey(Hero.heroliste.get(0).getyCoord());
				b.setSichtbar(true);
				b.setDroppedby(0);
				b.setExplodiert(false);
				Hero.heroliste.get(0).setBombcount(Hero.heroliste.get(0).getBombcount());
				Bombe.bombenliste.add(b);
				if (Bombe.bombenliste.isEmpty()==false) {
					System.out.println("Eine Bombe wurde gesetzt:" + Bombe.bombenliste.get(0).getBombex() + ", " + Bombe.bombenliste.get(0).getBombey());
				}
				Timer timer = new Timer();
				timer.schedule(b, 1);				
			}
			}
		}
		/**
		 * Tastenbelegung für Spieler 2.
		 */
		if (keys.contains(KeyEvent.VK_UP)) {
			Controller.movementUp(1);
		}
		else if (keys.contains(KeyEvent.VK_DOWN)) {
			Controller.movementDown(1);
		}
		if (keys.contains(KeyEvent.VK_LEFT)) {
			Controller.movementLeft(1);
		}
		else if (keys.contains(KeyEvent.VK_RIGHT)) {
			Controller.movementRight(1);
		}
		if (keys.contains(KeyEvent.VK_SPACE)) {
			boolean blocked=false;
			for(Bombe bombe : Bombe.bombenliste) {
				if (bombe.getBombex() == Hero.heroliste.get(1).getxCoord() && bombe.getBombey() == Hero.heroliste.get(1).getyCoord()) {
					blocked=true;
				}
			}
			if (blocked!=true) {
			if(Hero.heroliste.get(1).getBombcount()<=2){
				Bombe b = new Bombe();
				b.setBombex(Hero.heroliste.get(1).getxCoord());
				b.setBombey(Hero.heroliste.get(1).getyCoord());
				b.setSichtbar(true);
				b.setDroppedby(1);
				b.setExplodiert(false);
				Hero.heroliste.get(1).setBombcount(Hero.heroliste.get(1).getBombcount());
				Bombe.bombenliste.add(b);
				if (Bombe.bombenliste.isEmpty()==false) {
					System.out.println("Eine Bombe wurde gesetzt:" + Bombe.bombenliste.get(Bombe.bombenliste.size()-1).getBombex() + ", " + Bombe.bombenliste.get(Bombe.bombenliste.size()-1).getBombey());
				}
				Timer timer = new Timer();
				timer.schedule(b, 1);
			}
			}
		}
	}
		}
	
}