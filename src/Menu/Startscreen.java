package Menu;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Startscreen extends JFrame implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	public Startscreen() {
        initStart();
    }
	
	public final void initStart() {
	JPanel panel = new JPanel();
    getContentPane().add(panel);
    panel.setLayout(null);
    setTitle("Exploman");
    setSize(800, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    Icon _icon = new ImageIcon("res/Buttonimages/startscreen.gif");
    JLabel _label  = new JLabel(_icon);
    add(_label);
	}
	
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Startscreen st = new Startscreen();
                st.setVisible(true);
            }
        });
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
