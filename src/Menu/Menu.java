package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


//import board.Board;
//import board.LevelReader;


public class Menu extends JFrame {
	
	
	private static final long serialVersionUID = 1L;

	public Menu() {
        initUI();
    }

    public final void initUI() {

    	
       JPanel panel = new JPanel();
       getContentPane().add(panel);
       panel.setLayout(null);
       setTitle("Menu");
       setSize(800, 500);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
       
       add(Box.createRigidArea(new Dimension (0,50)));
       
       JButton startButton = new JButton("Spiel starten");
       add(startButton);
       startButton.setAlignmentX(0.5f);
       startButton.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent event){
    		   Spielstart start = new Spielstart();
    		   start.setVisible(true);
    		   
    	   }}
       );
       
       add(Box.createRigidArea(new Dimension (0,50)));
       
       JButton ladenButton = new JButton("Spiel laden");
       add(ladenButton);
       ladenButton.setVisible(true);
       ladenButton.setAlignmentX(0.5f);
       ladenButton.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent event){
    		   Laden laden = new Laden();
    		   laden.setVisible(true);
    	   }
       });

       add(Box.createRigidArea(new Dimension (0,50)));	
       
       JButton optionButton = new JButton("Optionen");
       add(optionButton);
       optionButton.setVisible(true);
       optionButton.setAlignmentX(0.5f);
       optionButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               Optionen opt = new Optionen();
               opt.setVisible(true);
           }
       });
       
       add(Box.createRigidArea(new Dimension (0,50)));
       
       JButton extrasButton = new JButton("Extras");
       add(extrasButton);
       extrasButton.setVisible(true);
       extrasButton.setAlignmentX(0.5f);
       extrasButton.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent event) {
    		   Extras ad = new Extras();
    		   ad.setVisible(true);
    	   }
       });
       
       add(Box.createRigidArea(new Dimension (0,50)));
       
       JButton quitButton = new JButton("Spiel verlassen");
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });
       add(quitButton);
       quitButton.setAlignmentX(0.5f);
       add(Box.createRigidArea(new Dimension (0,150)));

    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Menu ex = new Menu();
                ex.setVisible(true);
            }
        });
        
    }
}