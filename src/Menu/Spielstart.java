package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Mainframe;

public class Spielstart extends JFrame implements ActionListener {
	public Spielstart() {
		
		JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(null);	
		setSize(800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        add(Box.createRigidArea(new Dimension (0,50)));
        JButton Singleplayer = new JButton("An einem PC");
        add(Singleplayer);
        Singleplayer.setAlignmentX(0.5f);
        Singleplayer.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     		   try {
				Mainframe.initGame();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			}
     	   }}
        ); 
        
        add(Box.createRigidArea(new Dimension (0,50)));
        JButton Multiplayer = new JButton("Netzwerk");
        add(Multiplayer);
        Multiplayer.setAlignmentX(0.5f);
        /*Multiplayer.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent event){
      		                                                           HIER MUSS AUF den MP VERLINKT WERDEN!!!!
      	   }}
         );*/
        
        add(Box.createRigidArea(new Dimension(0, 200)));
        JButton zurück = new JButton("Zurück");
        add(zurück);
        zurück.setAlignmentX(0.5f);
        zurück.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
        add(Box.createRigidArea(new Dimension(0, 50)));
        
	}
}
