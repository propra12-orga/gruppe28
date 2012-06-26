package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Laden extends JFrame implements ActionListener {
	
	public Laden()  {
		JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(null);
		setSize(800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	       
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
	       
		add(Box.createRigidArea(new Dimension(0, 200)));
		JButton close = new JButton("Zurück");
		close.setAlignmentX(0.5f);
		add(close);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				}
		});
		add(Box.createRigidArea(new Dimension (0,50)));
	}
}


