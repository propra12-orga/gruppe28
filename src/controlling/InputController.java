package controlling;

import main.Bombe;
import main.Hero;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ListIterator;
import java.util.Timer;

public class InputController implements KeyListener
	{
	public static boolean moveUp = false;
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Controller.movementUp(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			Controller.movementDown(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_A) {
			Controller.movementLeft(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
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
				int i=0;
				Bombe b = new Bombe();
				b.setBombex(Hero.heroliste.get(i).getxCoord());
				b.setBombey(Hero.heroliste.get(i).getyCoord());
				b.setSichtbar(true);
				Bombe.bombenliste.add(b);
				if (Bombe.bombenliste.isEmpty()==false) {
					System.out.println("Eine Bombe wurde gesetzt:" + Bombe.bombenliste.get(0).getBombex() + ", " + Bombe.bombenliste.get(0).getBombey());
				}
				Timer timer = new Timer();
				timer.schedule(b, 3000);
			//}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Controller.movementUp(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Controller.movementDown(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Controller.movementLeft(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
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
				int i=1;
				Bombe b = new Bombe();
				b.setBombex(Hero.heroliste.get(i).getxCoord());
				b.setBombey(Hero.heroliste.get(i).getyCoord());
				b.setSichtbar(true);
				Bombe.bombenliste.add(b);
				if (Bombe.bombenliste.isEmpty()==false) {
					System.out.println("Eine Bombe wurde gesetzt:" + Bombe.bombenliste.get(0).getBombex() + ", " + Bombe.bombenliste.get(0).getBombey());
				}
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