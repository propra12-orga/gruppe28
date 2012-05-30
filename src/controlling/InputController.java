package controlling;

import main.Bombe;
import main.Hero;

import java.awt.event.KeyEvent;



import java.awt.event.KeyListener;
import java.util.Timer;

public class InputController implements KeyListener
	{
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
			Bombe b = new Bombe();
			Bombe.bombenarray[0]=b;
			b.setBombex(Hero.getxCoord());
			b.setBombey(Hero.getyCoord());
			b.setSichtbar(true);
			Timer timer = new Timer();
			timer.schedule(b, 3000);
			
			
		}
	}
	
	public void keyReleased(KeyEvent e)	{
		
		}

	public void keyTyped(KeyEvent e) {
				
	}
	
}