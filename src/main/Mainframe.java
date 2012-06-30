package main;

import java.io.File;
//import java.io.FileWriter;
//import java.io.Writer;

import java.io.IOException;

//import javax.swing.JFileChooser;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import controlling.InputController;

import board.Board;
import board.Tile;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
//import javax.swing.SwingUtilities;
import board.LevelReader;
//import board.Tileset;


public class Mainframe extends JFrame{
	/**
	 * 
	 */
	public static boolean twoplayer=true;
	public static boolean threeplayer=false;
	public static boolean fourplayer=false;
	public static boolean sound=true;
	static String grasString = "Gras";
	static String iceString = "Eis";
	static String spaceString = "Weltraum";
	static String alphaString = "Alpha";
	static String desertString = "Wüste";
	
	private static final long serialVersionUID = 1L;
		
	public Mainframe() {
		initUI();
		//setSize(1065,710);
		setSize((LevelReader.c*50)+15,(LevelReader.r*50)+60);
		setLocationRelativeTo(null);
		setTitle("Bomberman");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public final void initUI() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menü");
        menu.setMnemonic(KeyEvent.VK_ESCAPE);

        JMenu snd = new JMenu("Ton");
        snd.setMnemonic(KeyEvent.VK_T);
        JCheckBox toggle = new JCheckBox("Ton an/aus", true);
        toggle.setFocusable(false);
		toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JCheckBox source =(JCheckBox) e.getSource();
				boolean state = source.isSelected();
				if(state){
					sound=true;
				}else{
					sound=false;
				}}});
        add(toggle);
        
        JMenu tset = new JMenu("Grafik");
        tset.setMnemonic(KeyEvent.VK_G);
        JRadioButton gras = new JRadioButton(grasString);
        gras.setActionCommand(grasString);
        gras.setSelected(true);
        
        JRadioButton ice = new JRadioButton(iceString);
        ice.setActionCommand(iceString);
        ice.setSelected(true);
        
        JRadioButton space = new JRadioButton(spaceString);
        space.setActionCommand(spaceString);
        space.setSelected(true);
        
        JRadioButton alpha = new JRadioButton(alphaString);
        alpha.setActionCommand(alphaString);
        alpha.setSelected(true);
        
        JRadioButton desert = new JRadioButton(desertString);
        desert.setActionCommand(desertString);
        desert.setSelected(true);
        
        ButtonGroup group = new ButtonGroup();
        group.add(gras);
        group.add(ice);
        group.add(space);
        group.add(alpha);
        group.add(desert);
        
        gras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=0;
            }
        });
        ice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=1;
            }
        });
        space.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=2;
            }
        });
        alpha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=3;
            }
        });
        desert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tile.tileset=4;
            }
        });
        JMenuItem eMenuItem = new JMenuItem("Beenden");
        eMenuItem.setMnemonic(KeyEvent.VK_B);
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        menu.add(tset);
        tset.add(gras);
        tset.add(ice);
        tset.add(desert);
        tset.add(space);
        tset.add(alpha);
        menu.add(snd);
        snd.add(toggle);
        menu.add(eMenuItem);
        menubar.add(menu);
        setJMenuBar(menubar);
	}
	public final static void initGame() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException{
		board.Tileset.initTileset();
		board.Tileset.initBombset();
		board.Tileset.initHeroset();
		Mainframe mf = new Mainframe();
		Board board = new Board();
		File test = new File("res/Maps/1.txt");
		if(sound==true){
			//JukeBox.playGamemusic()
		}
		Hero bm1 = new Hero();
		Hero.heroliste.add(bm1);
		if(twoplayer==true){
			Hero bm2 = new Hero();
			Hero.heroliste.add(bm2);
		}
		if(twoplayer==false && threeplayer==true){
			Hero bm2 = new Hero();
			Hero.heroliste.add(bm2);
			Hero bm3 = new Hero();
			Hero.heroliste.add(bm3);
		}
		if(twoplayer==false && threeplayer==false && fourplayer==true){
			Hero bm2 = new Hero();
			Hero.heroliste.add(bm2);
			Hero bm3 = new Hero();
			Hero.heroliste.add(bm3);
			Hero bm4 = new Hero();
			Hero.heroliste.add(bm4);
		}
		InputController ic = new controlling.InputController();
		ic.start();
		
		board.createLevel(LevelReader.readLevel(test));
		mf.add(board);
		mf.addKeyListener(ic);
		mf.setVisible(true);
		for(int i=0; i<(Hero.heroliste.size()); i++) {
			setStartPosition(i);
		}
		LevelReader.ausgabe(LevelReader.readLevel(test));
		
		while(true) {
			board.repaint();
			Thread.sleep(45);
			}
		}
	public static void main (String[] args) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException{
		initGame();
	}
	/**
	 * Startpositionen der Helden.
	 * @param n
	 */
	public static void setStartPosition(int n) {
		if(n==0) {
			Hero.heroliste.get(0).setxPixelPosition(51);
			Hero.heroliste.get(0).setyPixelPosition(51);
			Hero.heroliste.get(0).setxCoord();
			Hero.heroliste.get(0).setyCoord();
			Hero.heroliste.get(0).setisalive(true);
		}
		if(n==1) {
			Hero.heroliste.get(1).setxPixelPosition((LevelReader.c*50)-99);
			Hero.heroliste.get(1).setyPixelPosition(51);
			Hero.heroliste.get(1).setxCoord();
			Hero.heroliste.get(1).setyCoord();
			Hero.heroliste.get(1).setisalive(true);
		}
		if(n==2) {
			Hero.heroliste.get(2).setxPixelPosition(51);
			Hero.heroliste.get(2).setyPixelPosition((LevelReader.r*50)-99);
			Hero.heroliste.get(2).setxCoord();
			Hero.heroliste.get(2).setyCoord();
			Hero.heroliste.get(2).setisalive(true);
		}
		if(n==3) {
			Hero.heroliste.get(3).setxPixelPosition((LevelReader.c*50)-99);
			Hero.heroliste.get(3).setyPixelPosition((LevelReader.r*50)-99);
			Hero.heroliste.get(3).setxCoord();
			Hero.heroliste.get(3).setyCoord();
			Hero.heroliste.get(3).setisalive(true);
		}
	}
		
	}
