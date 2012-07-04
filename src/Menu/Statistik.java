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

public class Statistik extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Statistik()  {
		
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
        
        add(Box.createRigidArea(new Dimension (0,50)));
        add(label);
        
        JButton close = new JButton(new ImageIcon("res/Buttonimages/zuruck.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
	    close.setVisible(true);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				Extras ex = new Extras();
				ex.setVisible(true);
			}
		});
		close.setAlignmentX(0.5f);
		add(close);
		
		add(Box.createRigidArea(new Dimension (0,150)));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	
