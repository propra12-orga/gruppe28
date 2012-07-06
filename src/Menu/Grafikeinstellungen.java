package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import main.Hero;
import main.Mainframe;
import main.Upgrades;

import board.Board;
import board.GameSaver;
import board.LevelReader;
import board.Tile;
import board.Tileset;

public class Grafikeinstellungen extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String grasString = "Gras";
	static String iceString = "Eis";
	static String spaceString = "Weltraum";
	static String alphaString = "Alpha";
	static String desertString = "Wüste";
	
	public Grafikeinstellungen() {
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
        JRadioButton gras = new JRadioButton(new ImageIcon("res/Buttonimages/gras.gif"));
        gras.setAlignmentX(0.5f);
        gras.setBorderPainted(false);
		gras.setContentAreaFilled(false);
        gras.setActionCommand(grasString);
        gras.setSelected(true);
        add(gras);
        
        //add(Box.createRigidArea(new Dimension (0,10)));
        JRadioButton ice = new JRadioButton(new ImageIcon("res/Buttonimages/ice.gif"));
        ice.setAlignmentX(0.5f);
        ice.setBorderPainted(false);
		ice.setContentAreaFilled(false);
        ice.setActionCommand(iceString);
        ice.setSelected(true);
        add(ice);
        
        //add(Box.createRigidArea(new Dimension (0,10)));
        JRadioButton space = new JRadioButton(new ImageIcon("res/Buttonimages/space.gif"));
        space.setAlignmentX(0.5f);
        space.setBorderPainted(false);
		space.setContentAreaFilled(false);
        space.setActionCommand(spaceString);
        space.setSelected(true);
        add(space);
        
        //add(Box.createRigidArea(new Dimension (0,10)));
        JRadioButton alpha = new JRadioButton(new ImageIcon("res/Buttonimages/alpha.gif"));
        alpha.setAlignmentX(0.5f);
        alpha.setBorderPainted(false);
		alpha.setContentAreaFilled(false);
        alpha.setActionCommand(alphaString);
        alpha.setSelected(true);
        add(alpha);
        
        //add(Box.createRigidArea(new Dimension (0,10)));
        JRadioButton desert = new JRadioButton(new ImageIcon("res/Buttonimages/desert.gif"));
        desert.setAlignmentX(0.5f);
        desert.setBorderPainted(false);
		desert.setContentAreaFilled(false);
        desert.setActionCommand(desertString);
        desert.setSelected(true);
        add(desert);
        
        //add(Box.createRigidArea(new Dimension (0,25)));
		JButton close = new JButton(new ImageIcon("res/Buttonimages/next.gif"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
	    close.setVisible(true);
		close.setAlignmentX(0.5f);
		add(close);
		/*
		Icon icon2 = new ImageIcon("res/Images/zuruck.gif");
	    JLabel label2  = new JLabel(icon2);
	    label2.setAlignmentX(0.5f);
	    */
		add(Box.createRigidArea(new Dimension (0,150)));
        
        ButtonGroup group = new ButtonGroup();
        group.add(gras);
        group.add(ice);
        group.add(space);
        group.add(alpha);
        group.add(desert);
        
        gras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=0;
                try {
					GameSaver.saveGame(new File("save/save.txt"));
					GameSaver.loadGame(new File("save/save.txt"));
				} catch (IOException e) {
					e.printStackTrace();
				}
                Mainframe.beard.createLevel(GameSaver.loadlevel);
            }
        });
        ice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=1;
                try {
					GameSaver.saveGame(new File("save/save.txt"));
					GameSaver.loadGame(new File("save/save.txt"));
				} catch (IOException e) {
					e.printStackTrace();
				}
                Mainframe.beard.createLevel(GameSaver.loadlevel);
            }
        });
        space.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=2;
                try {
					GameSaver.saveGame(new File("save/save.txt"));
					GameSaver.loadGame(new File("save/save.txt"));
				} catch (IOException e) {
					e.printStackTrace();
				}
                Mainframe.beard.createLevel(GameSaver.loadlevel);
            }
        });
        alpha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=3;
                try {
					GameSaver.saveGame(new File("save/save.txt"));
					GameSaver.loadGame(new File("save/save.txt"));
				} catch (IOException e) {
					e.printStackTrace();
				}
                Mainframe.beard.createLevel(GameSaver.loadlevel);
            }
        });
        desert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=4;
                try {
					GameSaver.saveGame(new File("save/save.txt"));
					GameSaver.loadGame(new File("save/save.txt"));
				} catch (IOException e) {
					e.printStackTrace();
				}
                Mainframe.beard.createLevel(GameSaver.loadlevel);
            }
        });
        close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
	
}
}
