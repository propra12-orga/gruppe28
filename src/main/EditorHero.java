package main;
import java.util.Vector;


/**
 * Instanzierbare Klasse um unsere Spielfiguren zu erschaffen.
 * (Figuren kommen in die "heroliste" und können von da aus abgerufen werden)
 * Sie enthält die Koordinaten, Geschwindigkeit und Zähler für die Statistik einer Figur.
 * 
 * @author Sebastian
 *
 */

public class EditorHero {
	public static Vector<EditorHero> heroliste = new Vector<EditorHero>();
	int Hp;
	public int xCoord;
	public int yCoord;
	private int xPixelPosition;
	private int yPixelPosition;
	private int startPosition;
	public boolean exitreached=false;
	/*
	 * Koordinaten
	 */
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord() {
		this.xCoord = (this.xPixelPosition)/50;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord() {
		this.yCoord = (this.yPixelPosition)/50;
	}
	public int getxPixelPosition() {
		return xPixelPosition;
	}
	public void setxPixelPosition(int xPixelPosition) {
		this.xPixelPosition = xPixelPosition;
	}
	public int getyPixelPosition() {
		return yPixelPosition;
	}
	public void setyPixelPosition(int yPixelPosition) {
		this.yPixelPosition = yPixelPosition;
	}	
	public int getStartPosition() {
		return startPosition;
	}

}
