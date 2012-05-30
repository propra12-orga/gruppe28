package controlling;

import main.Bombe;
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
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Bombe b = new Bombe();
			Bombe.bombenarray[0]=b;
			b.legeBombe();
		}
	}
	
	public void keyReleased(KeyEvent e)	{
		
		}

	public void keyTyped(KeyEvent e) {
				
	}
	
}