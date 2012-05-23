import java.awt.*;

	
import java.lang.Object;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;


import javax.swing.JPanel;

public class Board extends JPanel {
	public Tile[][] map;
	public Board() {
		map = new Tile[14][12];
		for (int col=0; col <=11; col++) {
			for (int row=0; row <=13; row++) {
				if ((col==0) || (row==0) || (col==11) || (row==13)) {
					this.map[row][col]=(new Tile(2));
				}
				else if ((col==5 && row==5)) {
					this.map[row][col]=(new Tile(3));
				}
				else {
					this.map[row][col]=(new Tile(1));
				}
				
			}
		}
	}
	
	public void movementRight(Graphics hero, Graphics nohero){
		if(map[Hero.getxCoord()+1][Hero.getyCoord()].getTileId() != 0){
			do{
			Hero.xPixelPosition=Hero.getxCoord()+1;
			Hero.eraseHero(nohero);
			
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			Hero.drawHero(hero);
			}while(InputController.moveRight == true);
		}
		else if(map[Hero.getxCoord()+1][Hero.getyCoord()].getTileId() == 0){
				Hero.drawHero(nohero);
			}
			else if(map[Hero.getxCoord()+1][Hero.getyCoord()].getTileId() == 3){
				Menu m = new Menu();
				m.setVisible(true);
			}
		}
	public void movementLeft(Graphics hero, Graphics nohero){
		if(map[Hero.getxCoord()-1][Hero.getyCoord()].getTileId() != 0){
			do{
			Hero.xPixelPosition=Hero.getxCoord()-1;
			
			Hero.eraseHero(nohero);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			Hero.drawHero(hero);
			}while(InputController.moveLeft == true);
		}
		else if(map[Hero.getxCoord()-1][Hero.getyCoord()].getTileId() == 0){
			Hero.drawHero(hero);
			}
			else if(map[Hero.getxCoord()-1][Hero.getyCoord()].getTileId() == 3){
				Menu m = new Menu();
				m.setVisible(true);
			}
		}
	public void movementUp(Graphics hero, Graphics nohero){
		if(map[Hero.getxCoord()][Hero.getyCoord()-1].getTileId() != 0){
				do{
			Hero.xPixelPosition=Hero.getyCoord()-1;
			Hero.eraseHero(nohero);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			Hero.drawHero(hero);
			}while(InputController.moveUp == true);
		}
		else if(map[Hero.getxCoord()][Hero.getyCoord()-1].getTileId() == 0){
				Hero.drawHero(hero);
			}
			else if(map[Hero.getxCoord()][Hero.getyCoord()-1].getTileId() == 3){
				Menu m = new Menu();
				m.setVisible(true);
			}
		}
	public void movementDown(Graphics hero, Graphics nohero){
		if(map[Hero.getxCoord()][Hero.getyCoord()+1].getTileId() != 0){
			do{
			Hero.xPixelPosition=Hero.getyCoord()+1;
			Hero.eraseHero(nohero);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			Hero.drawHero(hero);
			}while(InputController.moveDown == true);
		}
		else if(map[Hero.getxCoord()][Hero.getyCoord()+1].getTileId() == 0){
				Hero.drawHero(hero);
			}
			else if(map[Hero.getxCoord()][Hero.getyCoord()+1].getTileId() == 3){
				Menu m = new Menu();
				m.setVisible(true);
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
				if (col==5&&row==5) {
					g.drawOval(row*75, col*75, 75, 75);
				}
				else if ((col==0) || (row==0) || (col==11) || (row==13)) {
					Graphics2D g2d = (Graphics2D) g;
					g2d.setPaint(Color.black);
				    g2d.fill(new Rectangle2D.Double(row*75, col*75, 75, 75));
				}
				else {
					g.drawImage(map[row][col].getImg(),row*75, col*75,  null);
				}
				
			}
		}
		g.setColor(new Color(250, 0, 0));
        g.fillOval(Hero.getxPixelPosition(), Hero.getyPixelPosition(), 70, 70);
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
