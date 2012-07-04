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



public class Extras extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Extras() {
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
        
        add(Box.createRigidArea(new Dimension(0, 50)));
        JButton Statistik = new JButton(new ImageIcon("res/Buttonimages/stat.gif"));
        Statistik.setBorderPainted(false);
        Statistik.setContentAreaFilled(false);
		Statistik.setVisible(true);
		Statistik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Statistik sta = new Statistik();
				sta.setVisible(true);
	    		   dispose();
			}
		});
		Statistik.setAlignmentX(0.5f);
		add(Statistik);
		
		add(Box.createRigidArea(new Dimension (0,25)));
		JButton Karteneditor = new JButton(new ImageIcon("res/Buttonimages/editor.gif"));
		Karteneditor.setBorderPainted(false);
        Karteneditor.setContentAreaFilled(false);
		Karteneditor.setVisible(true);
		Karteneditor.setAlignmentX(0.5f);
		add(Karteneditor);
		/*Karteneditor.addActionListener(new ActionListener() {
	     	   public void actionPerformed(ActionEvent event){
	     		                                                           HIER MUSS AUF DEN KE VERLINKT WERDEN!!!!
	     	   }}
	     	   ); */
		
		add(Box.createRigidArea(new Dimension (0,25)));
		
		JButton creditsButton = new JButton(new ImageIcon("res/Buttonimages/extras.gif"));
		creditsButton.setBorderPainted(false);
		creditsButton.setContentAreaFilled(false);
	       add(creditsButton);
	       creditsButton.setVisible(true);
	       creditsButton.setAlignmentX(0.5f);
	       creditsButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent event) {
	               Credits ad = new Credits();
	               ad.setVisible(true);
	    		   dispose();
	           }
	       });
	       
	    add(Box.createRigidArea(new Dimension (0,50)));
		
	    JButton close = new JButton(new ImageIcon("res/Buttonimages/zuruck.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
	    close.setVisible(true);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
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
