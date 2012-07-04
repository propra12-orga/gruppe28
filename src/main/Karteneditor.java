package main;

import java.io.File;
//import java.io.FileWriter;
//import java.io.Writer;

import java.io.IOException;

//import javax.swing.JFileChooser;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import controlling.EditorInputController;
import board.Editorboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.SwingUtilities;
import board.LevelReader;
//import board.Tileset;


public class Karteneditor extends JFrame{
	/**
	 * 
	 */
	boolean karteneditor;
	
	public  boolean getkarteneditor()
	{
		return karteneditor;
	}
	public void setkarteneditor(boolean karteneditor)
	{
		this.karteneditor=karteneditor;
	}
	
	private static final long serialVersionUID = 1L;
		
	public Karteneditor() {
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
        menu.setMnemonic(KeyEvent.VK_ESCAPE);        
        JMenuItem eMenuItem = new JMenuItem("Beenden");
        eMenuItem.setMnemonic(KeyEvent.VK_B);
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        menu.add(eMenuItem);
        menubar.add(menu);
        setJMenuBar(menubar);
	}
	public final static void initGame() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException{
		board.Tileset.initTileset();
		board.Tileset.initBombset();
		board.Tileset.initHeroset();
		board.Tileset.initUpgradeset();
		Karteneditor mf = new Karteneditor();
		Editorboard board = new Editorboard();
		File test = new File("res/Maps/kartenedit.txt");
		EditorHero bm1 = new EditorHero();
		EditorHero.heroliste.add(bm1);		
		EditorInputController ic = new controlling.EditorInputController();
		ic.start();
		
		board.createLevel(LevelReader.readLevel(test));
		mf.add(board);
		mf.addKeyListener(ic);
		mf.setVisible(true);
		for(int i=0; i<(EditorHero.heroliste.size()); i++) {
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
			EditorHero.heroliste.get(0).setxPixelPosition(51);
			EditorHero.heroliste.get(0).setyPixelPosition(51);
			EditorHero.heroliste.get(0).setxCoord();
			EditorHero.heroliste.get(0).setyCoord();			
		}
	}
		
	}
