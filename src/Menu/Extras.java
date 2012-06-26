package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Extras extends JFrame implements ActionListener {
	public Extras() {
		JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(null);
		setSize(800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        add(Box.createRigidArea(new Dimension(0, 100)));
		JButton Statistik = new JButton("Statistik");
		Statistik.setVisible(true);
		Statistik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Statistik sta = new Statistik();
				sta.setVisible(true);
			}
		});
		Statistik.setAlignmentX(0.5f);
		add(Statistik);
		
		add(Box.createRigidArea(new Dimension (0,50)));
		JButton Karteneditor = new JButton("Karteneditor");
		Karteneditor.setVisible(true);
		Karteneditor.setAlignmentX(0.5f);
		add(Karteneditor);
		/*Karteneditor.addActionListener(new ActionListener() {
	     	   public void actionPerformed(ActionEvent event){
	     		                                                           HIER MUSS AUF DEN KE VERLINKT WERDEN!!!!
	     	   }}
	     	   ); */
		
		add(Box.createRigidArea(new Dimension (0,50)));
		
		JButton creditsButton = new JButton("Credits");
	       add(creditsButton);
	       creditsButton.setVisible(true);
	       creditsButton.setAlignmentX(0.5f);
	       creditsButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent event) {
	               Credits ad = new Credits();
	               ad.setVisible(true);
	           }
	       });
	       
	    add(Box.createRigidArea(new Dimension (0,50)));
		
		JButton close = new JButton("Zurück");
	    close.setVisible(true);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		close.setAlignmentX(0.5f);
		add(close);
		
		add(Box.createRigidArea(new Dimension (0,300)));
	}

}
