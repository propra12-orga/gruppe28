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

import main.HighscoreEntry;
import main.Mainframe;
import main.SortArray;

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
        add(Box.createRigidArea(new Dimension (0,25)));
        HighscoreEntry frst = Mainframe.highscore[0];
        HighscoreEntry scnd = Mainframe.highscore[1];
        HighscoreEntry thrd = Mainframe.highscore[2];
        HighscoreEntry frth = Mainframe.highscore[3];
        HighscoreEntry ffth = Mainframe.highscore[4];
        
        JLabel first = new JLabel("1."+ frst);
        JLabel second = new JLabel("2."+ scnd);
        JLabel third = new JLabel("3."+ thrd);
        JLabel fourth = new JLabel("4."+ frth);
        JLabel fifth = new JLabel("5."+ ffth);
        
        first.setFont(new Font("Bender", Font.BOLD, 20));
        first.setAlignmentX(0.5f);
        first.setForeground(Color.WHITE);
        second.setFont(new Font("Bender", Font.BOLD, 20));
        second.setAlignmentX(0.5f);
        second.setForeground(Color.WHITE);
        third.setFont(new Font("Bender", Font.BOLD, 20));
        third.setAlignmentX(0.5f);
        third.setForeground(Color.WHITE);
        fourth.setFont(new Font("Bender", Font.BOLD, 20));
        fourth.setAlignmentX(0.5f);
        fourth.setForeground(Color.WHITE);
        fifth.setFont(new Font("Bender", Font.BOLD, 20));
        fifth.setAlignmentX(0.5f);
        fifth.setForeground(Color.WHITE);
        
        add(first);
        add(Box.createRigidArea(new Dimension (0,10)));
        add(second);
        add(Box.createRigidArea(new Dimension (0,10)));
        add(third);
        add(Box.createRigidArea(new Dimension (0,10)));
        add(fourth);
        add(Box.createRigidArea(new Dimension (0,10)));
        add(fifth);
        add(Box.createRigidArea(new Dimension (0,10)));
        
        JButton close = new JButton(new ImageIcon("res/Buttonimages/zuruck.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
	    close.setVisible(true);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
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
	
