package Menu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BackGroundPane extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img = null;
	
BackGroundPane(String imagefile) {
	if(imagefile != null) {
		MediaTracker mt =new MediaTracker(this);
		img=Toolkit.getDefaultToolkit().getImage(imagefile);
		mt.addImage(img, 0);
		try{
			mt.waitForAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(img,  0,0,this.getWidth(),this.getHeight(),this);
}
}
