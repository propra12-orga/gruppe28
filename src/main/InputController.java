package main;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

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
		/*else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			try {
				Bombe.legeBombe();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}*/
	}
	
	public void keyReleased(KeyEvent e)	{
		
		}

	public void keyTyped(KeyEvent e) {
				
	}
	
}