package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Optionen extends JFrame implements ActionListener {
	public Optionen() {
		JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(null);	
		setSize(800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        add(Box.createRigidArea(new Dimension (0,50)));
        JButton character = new JButton("Charaktereinstellugnen");
        add(character);
        character.setAlignmentX(0.5f);
        character.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     	   		Charactereinstellungen character = new Charactereinstellungen();
     	   		character.setVisible(true);
     	   }}
        ); 
        
        add(Box.createRigidArea(new Dimension (0,50)));
        JButton Grafikeinstellungen = new JButton("Grafikeinstellungen");
        add(Grafikeinstellungen);
        Grafikeinstellungen.setAlignmentX(0.5f);
        Grafikeinstellungen.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     		  Grafikeinstellungen grafik = new Grafikeinstellungen();
     	   		grafik.setVisible(true);
     	   }}
        );
        
        add(Box.createRigidArea(new Dimension (0,50)));
        JButton Sound = new JButton("Sound");
        add(Sound);
        Sound.setAlignmentX(0.5f);
        Sound.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     		  Sound sound = new Sound();
     	   		sound.setVisible(true);
     	   }}
        );
        
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
