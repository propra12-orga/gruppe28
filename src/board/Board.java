package board;
import main.Bombe;
import main.Hero;
import main.Mainframe;

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
		for (int col=0; col <=12; col++) {
			for (int row=0; row <=20; row++) {
				map[row][col]=new Tile(1);
				
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
		for (int col=0; col <=12; col++) {
			for (int row=0; row <=20; row++) {
				g2d.drawImage(map[row][col].getImg(), row*50, col*50, null);
				
				
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
		//Heros zeichnen
		g2d.drawImage(Tileset.getHero(0, 2), Hero.heroliste.get(0).getxPixelPosition()-9, Hero.heroliste.get(0).getyPixelPosition()-9, null);
		if(Mainframe.twoplayer==true) {
			g2d.drawImage(Tileset.getHero(3, 2), Hero.heroliste.get(1).getxPixelPosition()-9, Hero.heroliste.get(1).getyPixelPosition()-9, null);
		}

		
        
        
	}
	public void createLevel(int[][] level) {
		
		clearDestructableCounter();
		for (int j=0; j<13; j++) {
			for (int i=0; i<21; i++) {
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
