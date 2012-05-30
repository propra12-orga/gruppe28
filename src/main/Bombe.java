package main;

import board.Board;

import java.util.*;

public class Bombe {
public static Bombe bombenarray[] = { new Bombe(), new Bombe()};
int bombenreichweite = 3;
int reichweitel = 0;
int reichweiter = 0;
int reichweiteo = 0;
int reichweiteu = 0;
private int bombex = 0;
private int bombey = 0;
private boolean sichtbar = false;



public int getBombex() {
	return bombex;
}
public void setBombex(int bombex) {
	this.bombex = bombex;
}
public int getBombey() {
	return bombey;
}
public void setBombey(int bombey) {
	this.bombey = bombey;
}
public boolean istSichtbar() {
	return sichtbar;
}
public void setSichtbar(boolean sichtbar) {
	this.sichtbar = sichtbar;
}

/*public static void explosion() {
	
    
 while (this.reichweitel <= this.bombenreichweite && Board.map[this.bombex-reichweitel][this.bombey].getTileId()%4!=1)
 	{
	 Board.map[bombex-reichweitel][bombey].setTileId(1);
	 reichweitel+=1;
	}
 while (reichweiter <= bombenreichweite && Board.map[bombex+reichweiter][bombey].getTileId()%4!=1)
	{
	 Board.map[bombex+reichweiter][bombey].setTileId(1);
	 reichweiter+=1;
	}
 while (reichweiteu <= bombenreichweite && Board.map[bombex][bombey+reichweiteu].getTileId()%4!=1)
	{
	 Board.map[bombex][bombey+reichweiteu].setTileId(1);
	 reichweiteu+=1;
	}
 while (reichweiteo <= bombenreichweite && Board.map[bombex][bombey-reichweiteo].getTileId()%4!=1)
	{
	 Board.map[bombex][bombey-reichweiteo].setTileId(1);
	 reichweiteo+=1;
	}

}*/

public void legeBombe() {
	this.setBombex(Hero.getxCoord());
	this.setBombey(Hero.getyCoord());
	this.setSichtbar(true);
	/*Date date = new Date();
	long gelegt = date.getTime();
	while(date.getTime() < gelegt+3) {
		//Wartet bis
	}
	Bombe.explosion();
	*/
}
}