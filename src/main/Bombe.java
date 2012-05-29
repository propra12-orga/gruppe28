package main;
import java.util.*;
import board.Board;

public class Bombe {
static int bombenreichweite = 3;
static int reichweitel = 0;
static int reichweiter = 0;
static int reichweiteo = 0;
static int reichweiteu = 0;
public static int bombex = 0;
public static int bombey = 0;
static boolean sichtbar = false;



public static int getBombex() {
	return bombex;
}
public static void setBombex(int bombex) {
	Bombe.bombex = bombex;
}
public static int getBombey() {
	return bombey;
}
public static void setBombey(int bombey) {
	Bombe.bombey = bombey;
}
public boolean isVisible() {
	return sichtbar;
}
public static void setVisible(boolean visible) {
	Bombe.sichtbar = visible;
}

public static void explosion() {
	
    
 while (reichweitel <= bombenreichweite && Board.map[bombex-reichweitel][bombey].getTileId()%4!=1)
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

}

public static void legeBombe() throws InterruptedException {
	Bombe.setBombex(Hero.getxCoord());
	Bombe.setBombey(Hero.getyCoord());
	Bombe.setVisible(true);
	Bombe.setBombex(553);
	Bombe.setBombey(553);
	Bombe.setVisible(false);
	Bombe.explosion();
	}
}