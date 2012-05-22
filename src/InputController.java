import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputController implements KeyListener
	{
	public static boolean moveRight = false;
	public static boolean moveLeft = false;
	public static boolean moveDown = false;
	public static boolean moveUp = false;
	
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) moveUp = true;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) moveDown = true;
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) moveLeft = true;
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) moveRight = true;
	}
	
	public void keyReleased(KeyEvent e)
	{
	if (e.getKeyCode() == KeyEvent.VK_UP) moveUp = false;
	else if (e.getKeyCode() == KeyEvent.VK_DOWN) moveDown = false;
	else if (e.getKeyCode() == KeyEvent.VK_LEFT) moveLeft = false;
	else if (e.getKeyCode() == KeyEvent.VK_RIGHT) moveRight = false;
	}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
		moveUp = true;
		moveDown = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
		moveUp = false;
		moveDown = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
		moveLeft = true;
		moveRight = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
		moveRight = true;
		moveLeft = false;
		}
			
	}
}