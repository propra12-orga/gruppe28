package board;
import main.Bombe;
import main.Hero;
import java.awt.*;
import java.util.ListIterator;

import javax.swing.JPanel;

public class Board extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Tile[][] map;
	public Board() {
		map = new Tile[14][12];
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				map[row][col]=new Tile(1);
				
			}
		}
	}
	
	public void paint(Graphics g) {
		//Spielfeld
		Graphics2D g2d = (Graphics2D) g;
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				g2d.drawImage(map[row][col].getImg(), row*75, col*75, null);
				if (map[row][col].getTileId()==3) {
					g2d.drawImage(Tileset.getExit(), 5*75, 5*75, null);
				}
				
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
				        g.fillOval(Bombe.bombenliste.get(i).getBombex()*75+7, Bombe.bombenliste.get(i).getBombey()*75+7, 60, 60);
				        for (int u=0; u < Bombe.bombenliste.get(i).getExplosionsvektor()[0]; u++) {
				        	g.fillOval(Bombe.bombenliste.get(i).getBombex()*75+7, (Bombe.bombenliste.get(i).getBombey()-u)*75+7, 60, 60);
				        }
				        for (int d=0; d < Bombe.bombenliste.get(i).getExplosionsvektor()[2]; d++) {
				        	g.fillOval(Bombe.bombenliste.get(i).getBombex()*75+7, (Bombe.bombenliste.get(i).getBombey()+d)*75+7, 60, 60);
				        }
				        for (int r=0; r < Bombe.bombenliste.get(i).getExplosionsvektor()[1]; r++) {
				        	g.fillOval((Bombe.bombenliste.get(i).getBombex()+r)*75+7, (Bombe.bombenliste.get(i).getBombey())*75+7, 60, 60);
				        }
				        for (int l=0; l < Bombe.bombenliste.get(i).getExplosionsvektor()[3]; l++) {
				        	g.fillOval((Bombe.bombenliste.get(i).getBombex()-l)*75+7, Bombe.bombenliste.get(i).getBombey()*75+7, 60, 60);
				        }
				        
					}
					else {
						//Mittelpunkt der Bombe
						g2d.drawImage(Tileset.getBomb(), Bombe.bombenliste.get(i).getBombex()*75, Bombe.bombenliste.get(i).getBombey()*75, null);
					}
				}
			i++;
	        }while(it.hasNext());
		}
        
		//Hero zeichnen
		g.setColor(new Color(250, 0, 0));
        g.fillOval(Hero.getxPixelPosition()-34, Hero.getyPixelPosition()-34, 70, 70);
        g2d.setPaint(Color.black);
        g2d.drawOval(Hero.getxPixelPosition(), Hero.getyPixelPosition(), 2, 2);
        
        
        
	}
	public void createLevel(int[][] level) {
		
		for (int j=0; j<12; j++) {
			for (int i=0; i<14; i++) {
				map[i][j]= new Tile(level[i][j]);
			}
		}
	}
	
}
