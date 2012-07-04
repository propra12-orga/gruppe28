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
import javax.swing.SwingUtilities;

import main.Mainframe;

public class Spielstart extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Spielstart() {
		
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
        JButton Singleplayer = new JButton(new ImageIcon("res/Buttonimages/single.gif"));
        Singleplayer.setBorderPainted(false);
        Singleplayer.setContentAreaFilled(false);
        add(Singleplayer);
        Singleplayer.setAlignmentX(0.5f);
        Singleplayer.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     		   dispose();
     		  SwingUtilities.invokeLater(new Runnable() {
     	            public void run() {
     		   Mainframe.twoplayer=false;
     		   Mainframe mf = new Mainframe();
			mf.setVisible(true);
     		   
     		   }});
     		}}); 
     
        add(Box.createRigidArea(new Dimension (0,25)));
        JButton Multiplayer = new JButton(new ImageIcon("res/Buttonimages/net.gif"));
        Multiplayer.setBorderPainted(false);
        Multiplayer.setContentAreaFilled(false);
        add(Multiplayer);
        Multiplayer.setAlignmentX(0.5f);
        /*Multiplayer.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent event){
      		                                                           HIER MUSS AUF den MP VERLINKT WERDEN!!!!
      	   }}
         );*/
        
        add(Box.createRigidArea(new Dimension (0,25)));
        
        JButton ladenButton = new JButton(new ImageIcon("res/Buttonimages/load.gif"));
        ladenButton.setBorderPainted(false);
        ladenButton.setContentAreaFilled(false);
        //add(ladenButton);
        ladenButton.setVisible(true);
        ladenButton.setAlignmentX(0.5f);
        ladenButton.addActionListener(new ActionListener(){
     	   public void actionPerformed(ActionEvent event){
     		   Laden laden = new Laden();
     		   laden.setVisible(true);
    		   dispose();
     	   }
        });
        
        add(Box.createRigidArea(new Dimension(0, 50)));
        JButton close = new JButton(new ImageIcon("res/Buttonimages/zuruck.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
        add(close);
        close.setAlignmentX(0.5f);
        close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
        add(Box.createRigidArea(new Dimension(0, 150)));
        
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
