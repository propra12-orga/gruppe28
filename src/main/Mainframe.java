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

import Menu.Charactereinstellungen;
import Menu.Charactereinstellungen2;
import Menu.Grafikeinstellungen;
import Menu.Laden;
import Menu.Sound;
import Menu.Spielstart;
import Menu.Statistik;
import board.Board;
import board.Tileset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		setTitle("Exploman");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public final void initUI() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menü");
        menu.setMnemonic(KeyEvent.VK_M);
        
        JMenuItem main = new JMenuItem(new ImageIcon("res/Buttonimages/restart.gif"));
        main.setBorderPainted(false);
        main.setContentAreaFilled(false);
        main.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		Spielstart me = new Spielstart();
        		me.setVisible(true);
        	}
        });
        
        JMenuItem save = new JMenuItem(new ImageIcon("res/Buttonimages/save.gif"));
        save.setBorderPainted(false);
        save.setContentAreaFilled(false);
        save.setMnemonic(KeyEvent.VK_G);
        save.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		
        	}
        });
        JMenuItem load = new JMenuItem(new ImageIcon("res/Buttonimages/load.gif"));
        load.setBorderPainted(false);
        load.setContentAreaFilled(false);
        load.setMnemonic(KeyEvent.VK_G);
        load.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		Laden load = new Laden();
        		load.setVisible(true);
        	}
        });

        JMenuItem ch = new JMenuItem(new ImageIcon("res/Buttonimages/char.gif"));
        ch.setBorderPainted(false);
        ch.setContentAreaFilled(false);
        ch.setMnemonic(KeyEvent.VK_G);
        ch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		Charactereinstellungen chr = new Charactereinstellungen();
        		chr.setVisible(true);
        	}
        });
        
        JMenuItem grafik = new JMenuItem(new ImageIcon("res/Buttonimages/grafik.gif"));
        grafik.setBorderPainted(false);
        grafik.setContentAreaFilled(false);
        grafik.setMnemonic(KeyEvent.VK_G);
        grafik.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		Grafikeinstellungen gr = new Grafikeinstellungen();
        		gr.setVisible(true);
        	}
        });
        
        JMenuItem ton = new JMenuItem(new ImageIcon("res/Buttonimages/ton.gif"));
        ton.setBorderPainted(false);
        ton.setContentAreaFilled(false);
        ton.setMnemonic(KeyEvent.VK_G);
        ton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		Sound snd = new Sound();
        		snd.setVisible(true);
        	}
        });
        
        JMenuItem editor = new JMenuItem(new ImageIcon("res/Buttonimages/editor.gif"));
        editor.setBorderPainted(false);
        editor.setContentAreaFilled(false);
        editor.setMnemonic(KeyEvent.VK_G);
        editor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		
        	}
        });
        
        JMenuItem stat = new JMenuItem(new ImageIcon("res/Buttonimages/stat.gif"));
        stat.setBorderPainted(false);
        stat.setContentAreaFilled(false);
        stat.setMnemonic(KeyEvent.VK_G);
        stat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		Statistik snd = new Statistik();
        		snd.setVisible(true);
        	}
        });
        
        JMenuItem eMenuItem = new JMenuItem(new ImageIcon("res/Buttonimages/close.gif"));
        eMenuItem.setMnemonic(KeyEvent.VK_B);
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        menu.add(main);
        menu.add(save);
        menu.add(load);
        menu.add(ch);
        menu.add(grafik);
        menu.add(ton);
        menu.add(stat);
        menu.add(editor);
        menu.add(eMenuItem);
        menubar.add(menu);
        setJMenuBar(menubar);
        
	}
	public final static void initGame() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException{
		board.Tileset.initTileset();
		board.Tileset.initBombset();
		board.Tileset.initHeroset();
		board.Tileset.initUpgradeset();
		Mainframe mf = new Mainframe();
		Board board = new Board();
		File test = new File("res/Maps/1.txt");
		
		if(sound==true){
			//JukeBox.playGamemusic();
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
			Tileset.getHero(i);
		}
		LevelReader.ausgabe(LevelReader.readLevel(test));
		if(twoplayer==true){
			Charactereinstellungen2 chr2 = new Charactereinstellungen2();
			chr2.setVisible(true);
		}
		Charactereinstellungen chr = new Charactereinstellungen();
		chr.setVisible(true);
		Spielstart start = new Spielstart();
		start.setVisible(true);
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
			Hero.heroliste.get(0).setxPixelPosition(50);
			Hero.heroliste.get(0).setyPixelPosition(50);
			Hero.heroliste.get(0).setxCoord();
			Hero.heroliste.get(0).setyCoord();
			Hero.heroliste.get(0).setisalive(true);
		}
		if(n==3) {
			Hero.heroliste.get(3).setxPixelPosition((LevelReader.c*50)-100);
			Hero.heroliste.get(3).setyPixelPosition(50);
			Hero.heroliste.get(3).setxCoord();
			Hero.heroliste.get(3).setyCoord();
			Hero.heroliste.get(3).setisalive(true);
		}
		if(n==2) {
			Hero.heroliste.get(2).setxPixelPosition(50);
			Hero.heroliste.get(2).setyPixelPosition((LevelReader.r*50)-100);
			Hero.heroliste.get(2).setxCoord();
			Hero.heroliste.get(2).setyCoord();
			Hero.heroliste.get(2).setisalive(true);
		}
		if(n==1) {
			Hero.heroliste.get(1).setxPixelPosition((LevelReader.c*50)-100);
			Hero.heroliste.get(1).setyPixelPosition((LevelReader.r*50)-100);
			Hero.heroliste.get(1).setxCoord();
			Hero.heroliste.get(1).setyCoord();
			Hero.heroliste.get(1).setisalive(true);
		}
	}
		
	}
