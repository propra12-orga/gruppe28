package board;




import java.awt.*;

import java.awt.Graphics;
import javax.swing.JPanel;

import main.Bombe;
import main.Hero;

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
				else if ((col==5 && row==5)) {
					map[row][col]=(new Tile(3));
				}
				else {
					map[row][col]=(new Tile(1));
				}
				
			}
		}
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				if (col==5&&row==5) {
					g.drawOval(row*75, col*75, 75, 75);
				}
				else if ((col==0) || (row==0) || (col==11) || (row==13)) {
					
				    g2d.drawImage(map[row][col].getImg(), row*75, col*75, null);
				}
				else {
					
					//Boden zeichnen
					//g2d.drawImage(Tileset.getTile(0, 0), row*75, col*75, null);
					g2d.drawImage(map[row][col].getImg(), row*75, col*75, null);
					
				}
				
				
			}
		}
		//Hero zeichnen
		g.setColor(new Color(250, 0, 0));
        g.fillOval(Hero.getxPixelPosition()-34, Hero.getyPixelPosition()-34, 70, 70);
        g2d.setPaint(Color.black);
        g2d.drawOval(Hero.getxPixelPosition(), Hero.getyPixelPosition(), 2, 2);
        
        //Bombe zeichnen
        g.setColor(new Color(10, 01, 10));
    	g.fillOval(Bombe.bombex, Bombe.bombey, 75, 75);
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
