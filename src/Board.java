import java.awt.*;

import java.awt.Graphics;


import javax.swing.JPanel;

public class Board extends JPanel {
	public Tile[][] map;
	public Board() {
		map = new Tile[14][12];
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				this.map[row][col]=(new Tile(1));
			}
		}
	}
	
	/*public void paint(Graphics g, int a, int b) {
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(map[a][b].getImg(), a*75, b*75, null);
		g.dispose();
		}*/
	public void paint(Graphics g) {
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				if (col==10&&row==10) {
					g.drawOval(row*75, col*75, 75, 75);
				}
				g.drawRect(row*75, col*75, 75, 75);
				
				
			}
		}
	}
	public void createLevel(int a) {
		this.map[0][0].setTileId(1);
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				this.map[row][col].setTileId(1);
				
				
				//TODO die drawImage methode implementieren
				//TODO Level aus Textdateien einlesen lassen (dafuer int a als id benutzen).
			}
			}
		
	}
	public void setExit(int x, int y) {
		this.map[x][y].setTileId(3);
		
	}
}
