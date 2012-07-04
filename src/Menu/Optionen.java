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

public class Optionen extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Optionen() {
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
        JButton character = new JButton(new ImageIcon("res/Buttonimages/char.gif"));
        character.setBorderPainted(false);
        character.setContentAreaFilled(false);
        add(character);
        character.setAlignmentX(0.5f);
        character.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     	   		Charactereinstellungen character = new Charactereinstellungen();
     	   		character.setVisible(true);
     		   dispose();
     	   }}
        ); 
        
        add(Box.createRigidArea(new Dimension (0,25)));
        JButton Grafikeinstellungen = new JButton(new ImageIcon("res/Buttonimages/grafik.gif"));
        Grafikeinstellungen.setBorderPainted(false);
        Grafikeinstellungen.setContentAreaFilled(false);
        add(Grafikeinstellungen);
        Grafikeinstellungen.setAlignmentX(0.5f);
        Grafikeinstellungen.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     		  Grafikeinstellungen grafik = new Grafikeinstellungen();
     	   		grafik.setVisible(true);
     		   dispose();
     	   }}
        );
        
        add(Box.createRigidArea(new Dimension (0,25)));
        JButton Sound = new JButton(new ImageIcon("res/Buttonimages/ton.gif"));
        Sound.setBorderPainted(false);
        Sound.setContentAreaFilled(false);
        add(Sound);
        Sound.setAlignmentX(0.5f);
        Sound.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     		  Sound sound = new Sound();
     	   		sound.setVisible(true);
     		   dispose();
     	   }}
        );
        
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
