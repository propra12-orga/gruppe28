package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Laden extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Laden()  {
		JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(null);
		setSize(800, 500);
		setContentPane(new BackGroundPane("res/Buttonimages/background.gif"));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	       
        Icon icon = new ImageIcon("res/Buttonimages/exploman.gif");
        JLabel label  = new JLabel(icon);
        label.setAlignmentX(0.5f);
        
        add(Box.createRigidArea(new Dimension (0,25)));
        add(label);
        
	   	add(Box.createRigidArea(new Dimension (0,50)));
		JButton slot1 = new JButton("Slot 1");
		add(slot1);
		/* slot1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
																	HIER MUSS AUS SPEICHERSTÄNDE VERLINTK WERDEN111
																	Mehr Slot-Buttons auf Anfrage oder selber machen ;)
			}
		}); */
		slot1.setAlignmentX(0.5f);
	       
		add(Box.createRigidArea(new Dimension(0, 50)));
		JButton close = new JButton(new ImageIcon("res/Buttonimages/zuruck.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setAlignmentX(0.5f);
		add(close);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				}
		});
		add(Box.createRigidArea(new Dimension (0,150)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


