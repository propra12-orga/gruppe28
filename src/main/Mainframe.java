package main;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.Writer;

import java.io.IOException;

//import javax.swing.JFileChooser;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import controlling.EditorInputController;
import controlling.InputController;

import Menu.Charactereinstellungen;
import Menu.Charactereinstellungen2;
import Menu.Grafikeinstellungen;
import Menu.Sound;
import Menu.Spielstart;
import Menu.Statistik;
import board.Board;
import board.Editorboard;
import board.GameSaver;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import network.Server;
//import javax.swing.SwingUtilities;
import board.LevelReader;
//import board.Tileset;


public class Mainframe extends JFrame{
	/**
	 * 
	 */
	public static Mainframe mf = new Mainframe();
	public static boolean twoplayer=true;
	public static boolean threeplayer=false;
	public static boolean fourplayer=false;
	public static boolean sound=true;
	static String grasString = "Gras";
	static String iceString = "Eis";
	static String spaceString = "Weltraum";
	static String alphaString = "Alpha";
	static String desertString = "W�ste";	
	public static File test = new File("res/Maps/1.txt");
	public static HighscoreEntry[] highscore = new HighscoreEntry[5];
	
	public static boolean mapeditor =false;
	static int score = 0;
	static int score2 = 0;
	static JLabel statusbar;
	public static InputController ic = new controlling.InputController();
	static EditorInputController eic = new controlling.EditorInputController();
	
	public static Editorboard board1 = new Editorboard();
	public static Board beard = new Board();
	
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
		statusbar = new JLabel();
		JMenu menu = new JMenu("Menue");
        menu.setMnemonic(KeyEvent.VK_M);
        
        JMenuItem main = new JMenuItem(new ImageIcon("res/Buttonimages/restart.gif"));
        main.setBorderPainted(false);
        main.setContentAreaFilled(false);
        main.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		mapeditor=false;
        		beard.setHasExit(false);
        		board1.setVisible(false);
        		beard.setVisible(true);
        		mf.removeKeyListener(eic);
        		mf.addKeyListener(ic);
        		mf.add(beard);
        		Spielstart me = new Spielstart();
        		me.setVisible(true);
        		File test = new File("res/Maps/1.txt");
                try {
					beard.createLevel(LevelReader.readLevel(test));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                Upgrades.upgradeliste.removeAllElements();
                for(int i=0; i<(Hero.heroliste.size()); i++) {
        			Mainframe.setStartPosition(i);
        		}
        	}
        });
        
        JMenuItem sve = new JMenuItem(new ImageIcon("res/Buttonimages/save.gif"));
        sve.setBorderPainted(false);
        sve.setContentAreaFilled(false);
        sve.setMnemonic(KeyEvent.VK_G);
        sve.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		JFileChooser chooser = new JFileChooser();
        		if(mapeditor==false){
        			try {
        				File f = new File(new File("save").getCanonicalPath());
        				chooser.setCurrentDirectory(f);
        			} catch (IOException e2) {
        				e2.printStackTrace();
        			}
        		}
        			if(mapeditor==true){
            			try {
            				File f = new File(new File("res/Maps").getCanonicalPath());
            				chooser.setCurrentDirectory(f);
            			} catch (IOException e2) {
            				e2.printStackTrace();
            			}
        			}
        		int re = chooser.showSaveDialog(null); 
				if(re == JFileChooser.APPROVE_OPTION){
        			try {
					GameSaver.saveGame(chooser.getSelectedFile().getCanonicalFile());
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}}
        	}
        });
        JMenuItem load = new JMenuItem(new ImageIcon("res/Buttonimages/load.gif"));
        load.setBorderPainted(false);
        load.setContentAreaFilled(false);
        load.setMnemonic(KeyEvent.VK_G);
        load.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		JFileChooser chooser = new JFileChooser();
        		if(mapeditor==false){
        			try {
        				File f = new File(new File("save").getCanonicalPath());
        				chooser.setCurrentDirectory(f);
        			} catch (IOException e2) {
        				e2.printStackTrace();
        			}
        		}
        			if(mapeditor==true){
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
        		if(mapeditor==false){
        			beard.createLevel(GameSaver.loadlevel);
        		}
        		if(mapeditor==true){
        			board1.createLevel(GameSaver.loadlevel);
        		}
        		}
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
        		mapeditor=true;
        		beard.setVisible(false);
        		//Editorboard board = new Editorboard();
        		File test = new File("res/Maps/kartenedit.txt");
        		board1.setVisible(true);

        		try {
					board1.createLevel(LevelReader.readLevel(test));
					LevelReader.ausgabe(LevelReader.readLevel(test));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        		mf.addKeyListener(eic);
        		mf.add(board1);
        		try {
					Karteneditor.initGame();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				}    
        		
        	}
        });
        
        JMenuItem stat = new JMenuItem(new ImageIcon("res/Buttonimages/stat.gif"));
        stat.setBorderPainted(false);
        stat.setContentAreaFilled(false);
        stat.setMnemonic(KeyEvent.VK_G);
        stat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		File f = new File("res/hs.txt");
        		try {
                    FileReader fR = new FileReader(f);
                    char[] c = new char[(int) f.length()];
                    fR.read(c);
     
                    String s = new String(c);
                    String[] entrys = s.split("\n");
     
                    for (int i = 0; i < entrys.length; i++) 
                    {
                        if (i < 5) {
                            String[] entry = entrys[i].split(":");
                            highscore[i] = new HighscoreEntry(entry[0], Integer.parseInt(entry[1]));
                        }
                    }
                    fR.close();
                    
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
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
        menu.add(sve);
        menu.add(load);
        menu.add(ch);
        menu.add(grafik);
        menu.add(ton);
        menu.add(stat);
        menu.add(editor);
        menu.add(eMenuItem);
        menubar.add(menu);
        menubar.add(Box.createRigidArea(new Dimension(((LevelReader.c-5)*50)/2, 0)));
        menubar.add(statusbar);
        setJMenuBar(menubar);
        
        
        
	}
	public final static void initGame() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException{
		board.Tileset.initTileset();
		board.Tileset.initBombset();
		board.Tileset.initHeroset();
		board.Tileset.initUpgradeset();
		
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
		if(InputController.network==false){
			ic.start();
    		eic.start();
		}
		if(InputController.network==true) {
			
			Server s = new Server();
			s.start();
		}
		mf.setVisible(true);
		mapeditor=false;
		mf.addKeyListener(ic);
		mf.add(beard);
		Spielstart me = new Spielstart();
		me.setVisible(true);
		File test = new File("res/Maps/1.txt");
        try {
			beard.createLevel(LevelReader.readLevel(test));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for(int i=0; i<(Hero.heroliste.size()); i++) {
			setStartPosition(i);
		}
		Charactereinstellungen.setHero(0,0,0);
		Charactereinstellungen2.setHero2(1,0,1);
		LevelReader.ausgabe(LevelReader.level);
		while(true) {
			if(mapeditor==false){
			if(twoplayer==true){
				statusbar.setText(Charactereinstellungen.name1.getText()+": " +score+
						" || "+Charactereinstellungen2.name2.getText()+": " +score2);
			}
			if(twoplayer==false){
				statusbar.setText(Charactereinstellungen.name1.getText()+": " +score);
			}
			if(Hero.heroliste.size() != 0){
	            Hero.heroliste.get(0).setscorecount();
	            score = Hero.heroliste.get(0).getscorecount();
	            if(Hero.heroliste.size() > 1){
	            	Hero.heroliste.get(1).setscorecount();
	            	score2 = Hero.heroliste.get(1).getscorecount();
	            }
			}
			}
			if(mapeditor==true){
				statusbar.setText("Taste <1> = begehbares Feld, Taste <2> = unzerst�rbares Feld, Taste <3> = zerst�rbares Feld");
			}
			if(mapeditor==false){
				beard.repaint();
			}
			if(mapeditor==true){
				board1.repaint();
			}
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
		Hero.heroliste.get(n).speedupgrade=false;
		Hero.heroliste.get(n).speed=5;
		Hero.heroliste.get(n).setarmored(false);
		Hero.heroliste.get(n).setReachupgrade(false);
		Hero.heroliste.get(n).reach=0;
		Hero.heroliste.get(n).ammo=0;
		Hero.heroliste.get(n).setAmmoupgrade(false);
		
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
