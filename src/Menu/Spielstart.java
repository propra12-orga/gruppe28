package Menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.GameSaver;

import controlling.InputController;

import main.Bombe;
import main.Mainframe;
import main.Upgrades;

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
        JButton Singleplayer = new JButton(new ImageIcon("res/Buttonimages/single3.gif"));
        Singleplayer.setBorderPainted(false);
        Singleplayer.setContentAreaFilled(false);
        add(Singleplayer);
        Singleplayer.setAlignmentX(0.5f);
        Singleplayer.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     		   dispose();
     		   Mainframe.twoplayer=false;
     		  Charactereinstellungen chr = new Charactereinstellungen();
				chr.setVisible(true);
     		}}); 
        
        add(Box.createRigidArea(new Dimension (0,25)));
        JButton Singleplayer2 = new JButton(new ImageIcon("res/Buttonimages/single2.gif"));
        Singleplayer2.setBorderPainted(false);
        Singleplayer2.setContentAreaFilled(false);
        add(Singleplayer2);
        Singleplayer2.setAlignmentX(0.5f);
        Singleplayer2.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent event){
     		   dispose();
     		   Mainframe.twoplayer=true;
     		  Charactereinstellungen chr = new Charactereinstellungen();
				chr.setVisible(true);
     		}}); 
     
        add(Box.createRigidArea(new Dimension (0,25)));
        JButton Multiplayer = new JButton(new ImageIcon("res/Buttonimages/net.gif"));
        Multiplayer.setBorderPainted(false);
        Multiplayer.setContentAreaFilled(false);
        add(Multiplayer);
        Multiplayer.setAlignmentX(0.5f);
        Multiplayer.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent event){
				InputController.setNetwork(true);
      	   }}
         );
        
        add(Box.createRigidArea(new Dimension (0,25)));
        
        JButton load = new JButton(new ImageIcon("res/Buttonimages/load.gif"));
        load.setBorderPainted(false);
        load.setContentAreaFilled(false);
        load.setAlignmentX(0.5f);
        load.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		JFileChooser chooser = new JFileChooser();
        		if(Mainframe.mapeditor==false){
        			try {
        				File f = new File(new File("save").getCanonicalPath());
        				chooser.setCurrentDirectory(f);
        			} catch (IOException e2) {
        				e2.printStackTrace();
        			}
        		}
        			if(Mainframe.mapeditor==true){
            			try {
            				File f = new File(new File("res/Maps").getCanonicalPath());
            				chooser.setCurrentDirectory(f);
            			} catch (IOException e2) {
            				e2.printStackTrace();
            			}
        			}
        		int re = chooser.showOpenDialog(null);
        		if(re == JFileChooser.APPROVE_OPTION){
        			try {
					GameSaver.loadGame(chooser.getSelectedFile().getCanonicalFile());
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        		Bombe.bombenliste.clear();
        		Upgrades.upgradeliste.clear();
        		if(Mainframe.mapeditor==false){
        			Mainframe.beard.createLevel(GameSaver.loadlevel);
        		}
        		if(Mainframe.mapeditor==true){
        			Mainframe.board1.createLevel(GameSaver.loadlevel);
        		}
        		}
        	}
        });

        //add(Box.createRigidArea(new Dimension(0, 25)));
        add(load);
        JButton close = new JButton(new ImageIcon("res/Buttonimages/next.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
        //add(close);
        close.setAlignmentX(0.5f);
        close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				Charactereinstellungen chr = new Charactereinstellungen();
				chr.setVisible(true);
			}
		});
        add(Box.createRigidArea(new Dimension(0, 150)));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
