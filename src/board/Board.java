package board;
import main.Bombe;
import main.Hero;




import java.awt.*;

import java.awt.Graphics;
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
				if ((col==0) || (row==0) || (col==11) || (row==13)) {
					map[row][col]=(new Tile(2));
				}
				else {
					map[row][col]=(new Tile(1));
				}
				
			}
		}
		map[5][5].setExit();
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				g2d.drawImage(map[row][col].getImg(), row*75, col*75, null);
				
				
			}
		}
		
		
		//Bombe zeichnen
		for (int i=0; i<2; i++)  {
			if (Bombe.bombenarray[i].istSichtbar() == true) {
	        	g2d.drawImage(Tileset.getBomb(), Bombe.bombenarray[i].getBombex()*75, Bombe.bombenarray[i].getBombey()*75, null);
	        }
		}
        
		//Hero zeichnen
		g.setColor(new Color(250, 0, 0));
        g.fillOval(Hero.getxPixelPosition()-34, Hero.getyPixelPosition()-34, 70, 70);
        g2d.setPaint(Color.black);
        g2d.drawOval(Hero.getxPixelPosition(), Hero.getyPixelPosition(), 2, 2);
        
        
        
	}
	public void createLevel(int a) {
		map[0][0].setTileId(1);
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				map[row][col].setTileId(1);
				
				
				//TODO die drawImage methode implementieren
				//TODO Level aus Textdateien einlesen lassen (dafuer int a als id benutzen).
			}
		}
		
	}
	public void setExit(int x, int y) {
		map[x][y].setTileId(3);
		
	}
}
