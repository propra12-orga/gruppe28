package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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


public class Credits extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Credits() {
		
		JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(null);
		
		setSize(800, 500);
		setContentPane(new BackGroundPane("res/Buttonimages/background.gif"));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        Icon icon = new ImageIcon("res/Buttonimages/exploman.gif");
        JLabel label  = new JLabel(icon);
        label.setAlignmentX(0.5f);
        
        add(Box.createRigidArea(new Dimension (0,25)));
        add(label);
        
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel name1 = new JLabel("Sebastian Alius");
        name1.setFont(new Font("Bender", Font.BOLD, 20));
        name1.setAlignmentX(0.5f);
        name1.setForeground(Color.WHITE);
        add(name1);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel name2 = new JLabel("Dustin Hartmann");
        name2.setFont(new Font("Bender", Font.BOLD, 20));
        name2.setAlignmentX(0.5f);
        name2.setForeground(Color.WHITE);
        add(name2);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel name3 = new JLabel("Sebastian Hartmann");
        name3.setFont(new Font("Bender", Font.BOLD, 20));
        name3.setAlignmentX(0.5f);
        name3.setForeground(Color.WHITE);
        add(name3);

        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel name4 = new JLabel("Fabio Huuk");
        name4.setFont(new Font("Bender", Font.BOLD, 20));
        name4.setAlignmentX(0.5f);
        name4.setForeground(Color.WHITE);
        add(name4);
        
        add(Box.createRigidArea(new Dimension(0, 50)));
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

	public void actionPerformed(ActionEvent event){
		new Credits();
	}
}


	
