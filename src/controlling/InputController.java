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
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Controller.movementUp();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Controller.movementDown();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Controller.movementLeft();
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Controller.movementRight();
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
				b.setBombex(Hero.getxCoord());
				b.setBombey(Hero.getyCoord());
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