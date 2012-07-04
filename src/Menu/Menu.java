package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
       setContentPane(new BackGroundPane("res/Buttonimages/background.gif"));
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
       
       Icon icon = new ImageIcon("res/Buttonimages/exploman.gif");
       JLabel label  = new JLabel(icon);
       label.setAlignmentX(0.5f);
       
       add(Box.createRigidArea(new Dimension (0,25)));
       add(label);
       
       add(Box.createRigidArea(new Dimension (0,50)));
       
       JButton startButton = new JButton(new ImageIcon("res/Buttonimages/start.gif"));
       startButton.setBorderPainted(false);
       startButton.setContentAreaFilled(false);
       add(startButton);
       startButton.setAlignmentX(0.5f);
       startButton.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent event){
    		   Spielstart start = new Spielstart();
    		   start.setVisible(true);
    		   dispose();
    		   
    	   }}
       );
       

       add(Box.createRigidArea(new Dimension (0,25)));	
       
       JButton optionButton = new JButton(new ImageIcon("res/Buttonimages/option.gif"));
       optionButton.setBorderPainted(false);
       optionButton.setContentAreaFilled(false);
       add(optionButton);
       optionButton.setVisible(true);
       optionButton.setAlignmentX(0.5f);
       optionButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               Optionen opt = new Optionen();
               opt.setVisible(true);
    		   dispose();
           }
       });
       
       add(Box.createRigidArea(new Dimension (0,25)));
       
       JButton extrasButton = new JButton(new ImageIcon("res/Buttonimages/extras.gif"));
       extrasButton.setBorderPainted(false);
       extrasButton.setContentAreaFilled(false);
       add(extrasButton);
       extrasButton.setVisible(true);
       extrasButton.setAlignmentX(0.5f);
       extrasButton.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent event) {
    		   Extras ad = new Extras();
    		   ad.setVisible(true);
    		   dispose();
    	   }
       });
       
       add(Box.createRigidArea(new Dimension (0,25)));
       
       JButton quitButton = new JButton(new ImageIcon("res/Buttonimages/close.gif"));
       quitButton.setBorderPainted(false);
       quitButton.setContentAreaFilled(false);
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