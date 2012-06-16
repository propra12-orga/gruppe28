package board;
import main.Bombe;
import main.Hero;
import java.awt.*;
import java.util.ListIterator;

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
	
	public int getgelegteBomben()
	{
		return gelegtebomben;
	}
	public void addBombe(int s)
	{
		this.gelegtebomben += s;
	}
	public void minBombe(int s)
	{
		this.gelegtebomben -=s;
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
		map = new Tile[13][13];
		for (int col=0; col <=12; col++) {
			for (int row=0; row <=12; row++) {
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
			for (int row=0; row <=12; row++) {
				g2d.drawImage(map[row][col].getImg(), row*50, col*50, null);
				
				
			}
		}
		
		
		//Bombe zeichnen
		if (Bombe.bombenliste.isEmpty()==false) {
			ListIterator<Bombe> it = Bombe.bombenliste.listIterator();
			int i=0;
			do {
				it.next();
				if (Bombe.bombenliste.get(i).istSichtbar() == true) {
					if (Bombe.bombenliste.get(i).isExplodiert() == true) {
						//Explosion zeichnen
						g.setColor(new Color(250, 0, 0));
						g2d.drawImage(Tileset.getBomb(8), Bombe.bombenliste.get(i).getBombex()*50, Bombe.bombenliste.get(i).getBombey()*50, null);
						for (int u=1; u <= (Bombe.bombenliste.get(i).getExplosionsvektor()[0]-1); u++) {
							if(u!=(Bombe.bombenliste.get(i).getExplosionsvektor()[0]-1)) {
								g2d.drawImage(Tileset.getBomb(0), Bombe.bombenliste.get(i).getBombex()*50, (Bombe.bombenliste.get(i).getBombey()-u)*50, null);
							}
							if(u==(Bombe.bombenliste.get(i).getExplosionsvektor()[0]-1)) {
								g2d.drawImage(Tileset.getBomb(4), Bombe.bombenliste.get(i).getBombex()*50, (Bombe.bombenliste.get(i).getBombey()-u)*50, null);
							}							
				        }
				        for (int d=1; d <= (Bombe.bombenliste.get(i).getExplosionsvektor()[2]-1); d++) {
				        	if(d!=(Bombe.bombenliste.get(i).getExplosionsvektor()[2]-1)) {
				        		g2d.drawImage(Tileset.getBomb(3), Bombe.bombenliste.get(i).getBombex()*50, (Bombe.bombenliste.get(i).getBombey()+d)*50, null);
				        	}
				        	if(d==(Bombe.bombenliste.get(i).getExplosionsvektor()[2]-1)) {
				        		g2d.drawImage(Tileset.getBomb(7), Bombe.bombenliste.get(i).getBombex()*50, (Bombe.bombenliste.get(i).getBombey()+d)*50, null);
							}
				        }
				        for (int r=1; r <= (Bombe.bombenliste.get(i).getExplosionsvektor()[1]-1); r++) {
				        	if(r!=(Bombe.bombenliste.get(i).getExplosionsvektor()[1]-1)) {
				        		g2d.drawImage(Tileset.getBomb(1), (Bombe.bombenliste.get(i).getBombex()+r)*50, Bombe.bombenliste.get(i).getBombey()*50, null);
				        	}
				        	if(r==(Bombe.bombenliste.get(i).getExplosionsvektor()[1]-1)) {
				        		g2d.drawImage(Tileset.getBomb(5), (Bombe.bombenliste.get(i).getBombex()+r)*50, Bombe.bombenliste.get(i).getBombey()*50, null);
							}
				        }
				        for (int l=1; l <= (Bombe.bombenliste.get(i).getExplosionsvektor()[3]-1); l++) {
				        	if(l!=(Bombe.bombenliste.get(i).getExplosionsvektor()[3]-1)) {
				        		g2d.drawImage(Tileset.getBomb(2), (Bombe.bombenliste.get(i).getBombex()-l)*50, Bombe.bombenliste.get(i).getBombey()*50, null);
				        	}
				        	if(l==(Bombe.bombenliste.get(i).getExplosionsvektor()[3]-1)) {
				        		g2d.drawImage(Tileset.getBomb(6), (Bombe.bombenliste.get(i).getBombex()-l)*50, Bombe.bombenliste.get(i).getBombey()*50, null);
							}
				        }
				        
					}
					else {
						//Mittelpunkt der Bombe
						g2d.drawImage(Tileset.getBomb(9), Bombe.bombenliste.get(i).getBombex()*50, Bombe.bombenliste.get(i).getBombey()*50, null);
					}
				}
			i++;
	        }while(it.hasNext());
		}
		//Heros zeichnen

		int i=0;
		g2d.drawImage(Tileset.getHero(), Hero.heroliste.get(i).getxPixelPosition()-9, Hero.heroliste.get(i).getyPixelPosition()-9, null);
		i++;
		g2d.drawImage(Tileset.getHero2(), Hero.heroliste.get(i).getxPixelPosition()-9, Hero.heroliste.get(i).getyPixelPosition()-9, null);
        
        
	}
	public void createLevel(int[][] level) {
		
		clearDestructableCounter();
		for (int j=0; j<13; j++) {
			for (int i=0; i<13; i++) {
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
