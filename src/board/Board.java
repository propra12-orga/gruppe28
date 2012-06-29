package board;
import main.Bombe;
import main.Hero;
import main.Mainframe;
import main.Upgrades;

import java.awt.*;
//import java.util.ListIterator;

import javax.swing.JPanel;

public class Board extends JPanel {
	/**
	 * Die Klasse Board stellt das Spielfeld dar. Sie initialisiert es und ist auch f�r das Zeichnen zust�ndig.
	 * @author Dustin
	 */


	
	private static int destructableCounter=0;
	private static boolean hasExit=false;
	static int gelegtebomben =0;
	
	public static void setHasExit(boolean b) {
		hasExit=b;
	}
	public static boolean getHasExit() {
		return hasExit;
	}
	public static void incDestructableCounter() {
		destructableCounter++;
	}
	public static void decDestructableCounter() {
		destructableCounter--;
	}
	public static int getDestructableCounter() {
		return destructableCounter;
	}
	private void clearDestructableCounter() {
		destructableCounter=0;
	}
	
	private static final long serialVersionUID = 1L;
	
	
	
	public static Tile[][] map;
	public Board() {
		map = new Tile[21][13];
		for (int row=0; row <LevelReader.r; row++) {
			for (int col=0; col <LevelReader.c; col++) {
				map[col][row]=new Tile(1);
				
			}
		}
	}
	/**
	 * Zeichenfunktion, iteriert durch das Spielfeld und zeichnet die Felder nach ihrer TileId. 
	 * Dann wird die Bombe und zuletzt die Heroes gezeichnet.
	 */
	public void paint(Graphics g) {
		//Spielfeld
		Graphics2D g2d = (Graphics2D) g;
		for (int row=0; row <LevelReader.r; row++) {
			for (int col=0; col <LevelReader.c; col++) {
				g2d.drawImage(map[col][row].getImg(), col*50, row*50, null);
				
				
			}
		}
		
		
		//Bombe zeichnen
		if (Bombe.bombenliste.isEmpty()==false) {
			//ListIterator<Bombe> it = Bombe.bombenliste.listIterator();
			for(Bombe bombe : Bombe.bombenliste) {
			//int i=0;
			//do {
				//it.next();
				if (bombe.istSichtbar() == true) {
					if (bombe.isExplodiert() == true) {
						//Explosion zeichnen
						g.setColor(new Color(250, 0, 0));
						g2d.drawImage(Tileset.getBomb(8), bombe.getBombex()*50, bombe.getBombey()*50, null);
						for (int u=1; u <= (bombe.getExplosionsvektor()[0]-1); u++) {
							if(u!=(bombe.getExplosionsvektor()[0]-1)) {
								g2d.drawImage(Tileset.getBomb(0), bombe.getBombex()*50, (bombe.getBombey()-u)*50, null);
							}
							if(u==(bombe.getExplosionsvektor()[0]-1)) {
								g2d.drawImage(Tileset.getBomb(4), bombe.getBombex()*50, (bombe.getBombey()-u)*50, null);
							}							
				        }
				        for (int d=1; d <= (bombe.getExplosionsvektor()[2]-1); d++) {
				        	if(d!=(bombe.getExplosionsvektor()[2]-1)) {
				        		g2d.drawImage(Tileset.getBomb(3), bombe.getBombex()*50, (bombe.getBombey()+d)*50, null);
				        	}
				        	if(d==(bombe.getExplosionsvektor()[2]-1)) {
				        		g2d.drawImage(Tileset.getBomb(7), bombe.getBombex()*50, (bombe.getBombey()+d)*50, null);
							}
				        }
				        for (int r=1; r <= (bombe.getExplosionsvektor()[1]-1); r++) {
				        	if(r!=(bombe.getExplosionsvektor()[1]-1)) {
				        		g2d.drawImage(Tileset.getBomb(1), (bombe.getBombex()+r)*50, bombe.getBombey()*50, null);
				        	}
				        	if(r==(bombe.getExplosionsvektor()[1]-1)) {
				        		g2d.drawImage(Tileset.getBomb(5), (bombe.getBombex()+r)*50, bombe.getBombey()*50, null);
							}
				        }
				        for (int l=1; l <= (bombe.getExplosionsvektor()[3]-1); l++) {
				        	if(l!=(bombe.getExplosionsvektor()[3]-1)) {
				        		g2d.drawImage(Tileset.getBomb(2), (bombe.getBombex()-l)*50, bombe.getBombey()*50, null);
				        	}
				        	if(l==(bombe.getExplosionsvektor()[3]-1)) {
				        		g2d.drawImage(Tileset.getBomb(6), (bombe.getBombex()-l)*50, bombe.getBombey()*50, null);
							}
				        }
				        
					}
					else {
						//Mittelpunkt der Bombe
						g2d.drawImage(Tileset.getBomb(9), bombe.getBombex()*50, bombe.getBombey()*50, null);
					}
				}
			//i++;
	        };//while(it.hasNext());
		}
		// Upgrades all up in this bitch
				if (Upgrades.upgradeliste.isEmpty()==false)
				{
					for(Upgrades upgrade : Upgrades.upgradeliste)
					{
						g2d.drawImage(Tileset.getHero1(), upgrade.getupgradex()*50 , upgrade.getupgradey()*50, null);
					}
				}
		//Heros zeichnen
		g2d.drawImage(Tileset.getHero1(), Hero.heroliste.get(0).getxPixelPosition(), Hero.heroliste.get(0).getyPixelPosition(), null);
		if(Mainframe.twoplayer==true) {
			g2d.drawImage(Tileset.getHero2(), Hero.heroliste.get(1).getxPixelPosition(), Hero.heroliste.get(1).getyPixelPosition(), null);
		}
		if(Mainframe.threeplayer==true) {
			g2d.drawImage(Tileset.getHero2(), Hero.heroliste.get(1).getxPixelPosition(), Hero.heroliste.get(1).getyPixelPosition(), null);
			g2d.drawImage(Tileset.getHero3(), Hero.heroliste.get(2).getxPixelPosition(), Hero.heroliste.get(2).getyPixelPosition(), null);
		}
		if(Mainframe.fourplayer==true) {
			g2d.drawImage(Tileset.getHero2(), Hero.heroliste.get(1).getxPixelPosition(), Hero.heroliste.get(1).getyPixelPosition(), null);
			g2d.drawImage(Tileset.getHero3(), Hero.heroliste.get(2).getxPixelPosition(), Hero.heroliste.get(2).getyPixelPosition(), null);
			g2d.drawImage(Tileset.getHero4(), Hero.heroliste.get(3).getxPixelPosition(), Hero.heroliste.get(3).getyPixelPosition(), null);
		}

		
        
        
	}
	public void createLevel(int[][] level) {
		
		clearDestructableCounter();
		for (int j=0; j<LevelReader.r; j++) {
			for (int i=0; i<LevelReader.c; i++) {
				map[i][j]= new Tile(level[i][j]);
				if (level[i][j] == 4) {
					Board.incDestructableCounter();
				}
				if (level[i][j] == 3) {
					setHasExit(true);
				}
			}
		}
	}
	
	
	
	
	}
