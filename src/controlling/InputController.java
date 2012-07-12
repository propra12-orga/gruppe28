package controlling;

import main.Bombe;

import main.Hero;
import main.Mainframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.Vector;

/**
 * Die InputController-Klasse regelt die Tastenbelegung zur Steuerung der Spielfiguren.
 * Den verschiedenen Richtungsmethoden wird ein int Wert �bergeben um zu bestimmen welche Figur bewegt werden soll.
 * 
 * @author Sebastian
 *
 */

public class InputController extends Thread implements KeyListener
	{
	public static Vector<Integer> keys = new Vector<Integer>();
	public static boolean network = false;
	String[] keysNetwork = new String[8];
	
	public void keyPressed(KeyEvent e) {
		if (network == false) {
		if (!keys.contains(e.getKeyCode()))
			keys.add(e.getKeyCode());
		}
		else {
			if(e.equals(KeyEvent.VK_W)) {
				for (int i=0; i<8; i++) {
					if(!keysNetwork[i].equals("0up")){
						keysNetwork[i]="0up";
					}
				}
			}
			else if (e.equals(KeyEvent.VK_D)) {
				for (int i=0; i<8; i++) {
					if(!keysNetwork[i].equals("0right")){
						keysNetwork[i]="0right";
					}
				}
			}
			else if (e.equals(KeyEvent.VK_S)) {
				for (int i=0; i<8; i++) {
					if(!keysNetwork[i].equals("0down")){
						keysNetwork[i]="0down";
					}
				}
			}
			else if (e.equals(KeyEvent.VK_A)) {
				for (int i=0; i<8; i++) {
					if(!keysNetwork[i].equals("0left")){
						keysNetwork[i]="0left";
					}
				}
			}
			else if (e.equals(KeyEvent.VK_UP)) {
				for (int i=0; i<8; i++) {
					if(!keysNetwork[i].equals("1up")){
						keysNetwork[i]="1up";
					}
				}
			}
			else if (e.equals(KeyEvent.VK_RIGHT)) {
				for (int i=0; i<8; i++) {
					if(!keysNetwork[i].equals("1right")){
						keysNetwork[i]="1right";
					}
				}
			}
			else if (e.equals(KeyEvent.VK_DOWN)) {
				for (int i=0; i<8; i++) {
					if(!keysNetwork[i].equals("1down")){
						keysNetwork[i]="1down";
					}
				}
			}
			else if (e.equals(KeyEvent.VK_LEFT)) {
				for (int i=0; i<8; i++) {
					if(!keysNetwork[i].equals("1left")){
						keysNetwork[i]="1left";
					}
				}
			}
		}
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
		 * Tastenbelegung f�r Spieler 1.
		 */
		if (keys.contains(KeyEvent.VK_W)) {
			Controller.movement(0, -1, ((Hero.heroliste.get(0).getxPixelPosition())/50), ((Hero.heroliste.get(0).getyPixelPosition()-Hero.heroliste.get(0).getSpeed())/50),
					((Hero.heroliste.get(0).getxPixelPosition()+39)/50), ((Hero.heroliste.get(0).getyPixelPosition()-Hero.heroliste.get(0).getSpeed())/50), "y");
		}
		else if (keys.contains(KeyEvent.VK_S)) {
			Controller.movement(0, 1, ((Hero.heroliste.get(0).getxPixelPosition())/50), ((Hero.heroliste.get(0).getyPixelPosition()+39+Hero.heroliste.get(0).getSpeed())/50),
					((Hero.heroliste.get(0).getxPixelPosition()+39)/50), ((Hero.heroliste.get(0).getyPixelPosition()+39+Hero.heroliste.get(0).getSpeed())/50), "y");
		}
		if (keys.contains(KeyEvent.VK_A)) {
			Controller.movement(0, -1, ((Hero.heroliste.get(0).getxPixelPosition()-Hero.heroliste.get(0).getSpeed())/50), (Hero.heroliste.get(0).getyPixelPosition()/50), 
					((Hero.heroliste.get(0).getxPixelPosition()-Hero.heroliste.get(0).getSpeed())/50), ((Hero.heroliste.get(0).getyPixelPosition()+39)/50), "x");
		}
		else if (keys.contains(KeyEvent.VK_D)) {
			Controller.movement(0, 1, ((Hero.heroliste.get(0).getxPixelPosition()+39+Hero.heroliste.get(0).getSpeed())/50), (Hero.heroliste.get(0).getyPixelPosition()/50), 
					((Hero.heroliste.get(0).getxPixelPosition()+39+Hero.heroliste.get(0).getSpeed())/50), ((Hero.heroliste.get(0).getyPixelPosition()+39)/50), "x");
		}
		if (keys.contains(KeyEvent.VK_CONTROL)) {
			boolean blocked=false;
			
			
			for(Bombe bombe : Bombe.bombenliste) {
				if (bombe.getBombex() == Hero.heroliste.get(0).getxCoord() && bombe.getBombey() == Hero.heroliste.get(0).getyCoord()) {
					blocked=true;
				}
			}
			if (blocked!=true) {
			if(Hero.heroliste.get(0).getBombcount()<=2+Hero.heroliste.get(0).getammo()){
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
		 * Tastenbelegung f�r Spieler 2.
		 */
		if(Mainframe.twoplayer==true){
		if (keys.contains(KeyEvent.VK_UP)) {
			Controller.movement(1, -1, ((Hero.heroliste.get(1).getxPixelPosition())/50), ((Hero.heroliste.get(1).getyPixelPosition()-Hero.heroliste.get(1).getSpeed())/50),
					((Hero.heroliste.get(1).getxPixelPosition()+39)/50), ((Hero.heroliste.get(1).getyPixelPosition()-Hero.heroliste.get(1).getSpeed())/50), "y");
		}
		else if (keys.contains(KeyEvent.VK_DOWN)) {
			Controller.movement(1, 1, ((Hero.heroliste.get(1).getxPixelPosition())/50), ((Hero.heroliste.get(1).getyPixelPosition()+39+Hero.heroliste.get(1).getSpeed())/50),
					((Hero.heroliste.get(1).getxPixelPosition()+39)/50), ((Hero.heroliste.get(1).getyPixelPosition()+39+Hero.heroliste.get(1).getSpeed())/50), "y");
		}
		if (keys.contains(KeyEvent.VK_LEFT)) {
			Controller.movement(1, -1, ((Hero.heroliste.get(1).getxPixelPosition()-Hero.heroliste.get(1).getSpeed())/50), (Hero.heroliste.get(1).getyPixelPosition()/50), 
					((Hero.heroliste.get(1).getxPixelPosition()-Hero.heroliste.get(1).getSpeed())/50), ((Hero.heroliste.get(1).getyPixelPosition()+39)/50), "x");
		}
		else if (keys.contains(KeyEvent.VK_RIGHT)) {
			Controller.movement(1, 1, ((Hero.heroliste.get(1).getxPixelPosition()+39+Hero.heroliste.get(1).getSpeed())/50), (Hero.heroliste.get(1).getyPixelPosition()/50), 
					((Hero.heroliste.get(1).getxPixelPosition()+39+Hero.heroliste.get(1).getSpeed())/50), ((Hero.heroliste.get(1).getyPixelPosition()+39)/50), "x");
		}
		if (keys.contains(KeyEvent.VK_SPACE)) {
			boolean blocked=false;
			for(Bombe bombe : Bombe.bombenliste) {
				if (bombe.getBombex() == Hero.heroliste.get(1).getxCoord() && bombe.getBombey() == Hero.heroliste.get(1).getyCoord()) {
					blocked=true;
				}
			}
			if (blocked!=true) {
			if(Hero.heroliste.get(1).getBombcount()<=2+Hero.heroliste.get(1).getammo()){
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
	public static void setNetwork(boolean b) {
		network = true;
	}
	
}