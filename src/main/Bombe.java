package main;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TimerTask;

import controlling.InputController;
import board.Board;


public class Bombe extends TimerTask {
public static LinkedList<Bombe> bombenliste = new LinkedList<Bombe>();
int bombenreichweite = 3;
int reichweitel = 0;
int reichweiter = 0;
int reichweiteo = 0;
int reichweiteu = 0;
int d=0;
private boolean wartend = true;
private int bombex = 0;
private int bombey = 0;
private boolean sichtbar = false;
public boolean explodiert = false;
private int[] explosionsvektor = new int[4];
public boolean getwartend() {
	return wartend;
}
public void setwartend(boolean wartend) {
	this.wartend = wartend;
}
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
	int i=0;
	this.setExplodiert(true);
 while (reichweitel <= bombenreichweite && Board.map[bombex-reichweitel][bombey].getTileId() == 1)
 	{
	// ListIterator<Bombe> it = Bombe.bombenliste.listIterator();
	 /*for (d=0; d<=InputController.Bombenzahl(); d++)
	 {
	 if (bombenliste.isEmpty()!=true) {
		 while(it.hasNext()) {
			 if(bombenliste.get(d).isExplodiert()==false){
				 if(Board.map[this.getBombex()-reichweitel][this.getBombey()] == Board.map[bombenliste.get(d).getBombex()][bombenliste.get(d).getBombey()]) {
					 bombenliste.get(i).run();
					 System.out.println("Doppel!");
					 }
			 }
			 it.next();
		 }
			 
			 
		 }*/
	 //}
	 for (i=0; i<2; i++) 
	 {
		 if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()] == Board.map[bombex-reichweitel][bombey])
		 {
			 Hero.heroliste.get(i).setisalive(false);
		 }
	 }
	 
	 reichweitel+=1;
	 //i=0;
	}

 
 while (reichweiter <= bombenreichweite && Board.map[bombex+reichweiter][bombey].getTileId() == 1)
	{
	 for (i=0; i<2; i++)
	 {
		 if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()] == Board.map[bombex+reichweiter][bombey])
		 {
			 Hero.heroliste.get(i).setisalive(false);
		 }
	 }
	 reichweiter+=1;
	}
 while (reichweiteu <= bombenreichweite && Board.map[bombex][bombey+reichweiteu].getTileId() == 1)
	{
	 for (i=0; i<2; i++)
	 {
		 if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()] == Board.map[bombex][bombey+reichweiteu])
		 {
			 Hero.heroliste.get(i).setisalive(false);
		 }
	 }
	 reichweiteu+=1;
	}
 while (reichweiteo <= bombenreichweite && Board.map[bombex][bombey-reichweiteo].getTileId() == 1)
	{
	 for (i=0; i<2; i++)
	 {
		 if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()] == Board.map[bombex][bombey-reichweiteo])
		 {
			 Hero.heroliste.get(i).setisalive(false);
		 }
	 }
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
 bombenliste.remove(this);
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
