package main;

import java.util.TimerTask;

import board.Board;

public class Bombe extends TimerTask {
public static Bombe bombenarray[] = { new Bombe(), new Bombe()};
int bombenreichweite = 3;
int reichweitel = 0;
int reichweiter = 0;
int reichweiteo = 0;
int reichweiteu = 0;
private int bombex = 0;
private int bombey = 0;
private boolean sichtbar = false;
private boolean explodiert = false;
private int[] explosionsvektor = new int[4];

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
public boolean isExplodiert() {
	return explodiert;
}
public void setExplodiert(boolean explodiert) {
	this.explodiert = explodiert;
}

public void run() {
	this.setExplodiert(true);
 while (reichweitel <= bombenreichweite && Board.map[bombex-reichweitel][bombey].getTileId()%2 == 1)
 	{
	 reichweitel+=1;
	}
 while (reichweiter <= bombenreichweite && Board.map[bombex+reichweiter][bombey].getTileId()%2 == 1)
	{
	 reichweiter+=1;
	}
 while (reichweiteu <= bombenreichweite && Board.map[bombex][bombey+reichweiteu].getTileId()%2 == 1)
	{
	 reichweiteu+=1;
	}
 while (reichweiteo <= bombenreichweite && Board.map[bombex][bombey-reichweiteo].getTileId()%2 == 1)
	{
	 reichweiteo+=1;
	}
 this.getExplosionsvektor()[0] = reichweiteo;
 this.getExplosionsvektor()[1] = reichweiter;
 this.getExplosionsvektor()[2] = reichweiteu;
 this.getExplosionsvektor()[3] = reichweitel;
 reichweiteo=reichweiter=reichweiteu=reichweitel=0;
 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 this.setSichtbar(false);
 this.setExplodiert(false);
}

public int[] getExplosionsvektor() {
	return explosionsvektor;
}
public void setExplosionsvektor(int[] explosionsvektor) {
	this.explosionsvektor = explosionsvektor;
}
}