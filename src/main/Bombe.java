package main;

//import java.util.LinkedList;
import java.io.IOException;
import java.util.Vector;
//import java.util.ListIterator;
import java.util.TimerTask;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//import controlling.InputController;

//import controlling.InputController;
import board.Board;
import board.JukeBox;
import board.Tile;
import board.Tileset;


public class Bombe extends TimerTask {
public static Vector<Bombe> bombenliste = new Vector<Bombe>();
int bombenreichweite;
int ausbreitung =0;
int reichweitel = 0;
int reichweiter = 0;
int reichweiteo = 0;
int reichweiteu = 0;
int s=0;
int[] blub = new int[2];
boolean drop = false;
int upgradex;
int upgradey;
boolean ausbreiten = true;
private boolean wartend = true;
private int bombex = 0;
private int bombey = 0;
private boolean sichtbar = false;
public boolean explodiert = false;
public boolean doppel =false;
private int droppedby;
private int killedplayer;
private boolean tiledestroyed = false;
private int tiledestroyedscounter = 0;
private int[] explosionsvektor = new int[4];

public int getBombenreichweite() {	
	return bombenreichweite;
}
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
	bombenreichweite= 2+Hero.heroliste.get(droppedby).getreach();
	while (s <=10 && this.isExplodiert() ==  false)
	{
	 try {
		Thread.sleep(300);
	 } catch (InterruptedException e1) {
		//e1.printStackTrace();
	 }	
	 s++;
	}
	this.setExplodiert(true);
	if(Mainframe.sound==true){
	try {
		JukeBox.playSoundeffect("boom");
	} catch (LineUnavailableException e1) {
		e1.printStackTrace();
	} catch (UnsupportedAudioFileException e1) {
		e1.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	}
	for(int k=0; k<Hero.heroliste.size();k++) {
		if(droppedby==k && explodiert==true)
		{
			Hero.heroliste.get(k).reducebombcount(Hero.heroliste.get(k).getBombcount()); 
		}
	}
	
 while (ausbreitung <= bombenreichweite && Board.map[bombex-reichweitel][bombey].getTileId() == 1)
 	{
	 //ListIterator<Bombe> it = Bombe.bombenliste.listIterator();	
	 	 if (bombenliste.size()!=0) {
		 //while(it.hasNext()) {
	 		 for(Bombe bombe : bombenliste){
			 if (Bombe.bombenliste.size()!=1) {
				 for (int f=1; f<bombenliste.size(); f++)
				 {
			 if(bombe.isExplodiert()==false){
				 
				 if(Board.map[this.getBombex()-reichweitel][this.getBombey()] == Board.map[bombe.getBombex()][bombe.getBombey()]) {
					 bombe.setExplodiert(true);
					 bombe.doppel=true;
					 System.out.println("Doppel!");				 
					 }
			 }
			 }
			 }
			 //it.next();			 		 	
	  }
	 }
	 for (i=0; i<(Hero.heroliste.size()); i++) 
	 {
		 if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()] == Board.map[bombex-reichweitel][bombey])
		 {			
			 if(Hero.heroliste.get(i).getarmored()==false)
			 {
			 Hero.heroliste.get(i).setisalive(false);
			 Hero.heroliste.get(i).setdeathcount(Hero.heroliste.get(i).getdeathcount());
			 this.setKilledplayer(i);
			 if(Mainframe.sound==true){
			 try {
					JukeBox.playSoundeffect("scream");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
			 Mainframe.setStartPosition(i);
			 }
			 if(Hero.heroliste.get(i).getarmored()==true)
			 {
				 Hero.heroliste.get(i).setarmored(false);
			 }
		 }
	 }
	 if (ausbreiten == true)
	 {
		 if (Board.map[bombex-(reichweitel+1)][bombey].getTileId() ==4)
		 {
			 if (Board.getHasExit()==false) {
				 double z=Math.random();
				 if (z<(double)1/Board.getDestructableCounter()) {
					 Board.map[bombex-(reichweitel+1)][bombey].setTileId(3);
					 Board.map[bombex-(reichweitel+1)][bombey].setImg(Tileset.getTile(2, Tile.getTileset()));
					 Board.setHasExit(true);
					 if(Mainframe.sound==true){
					 try {
							JukeBox.playSoundeffect("door");
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						} catch (UnsupportedAudioFileException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					 }
				 }
				 else {
					 Board.map[bombex-(reichweitel+1)][bombey].setTileId(1);
					 Board.map[bombex-(reichweitel+1)][bombey].setImg(Tileset.getTile(0, Tile.getTileset()));
					 double u=Math.random();
					 if(u<0.05)
					 {
							upgradex=bombex-(reichweitel+1);
							upgradey=bombey;						
							drop=true;
					 }
				 }
			 }
			 else {
				 Board.map[bombex-(reichweitel+1)][bombey].setTileId(1);
				 Board.map[bombex-(reichweitel+1)][bombey].setImg(Tileset.getTile(0, Tile.getTileset()));
				 double u=Math.random();
				 if(u<0.05)
				 {
						upgradex=bombex-(reichweitel+1);
						upgradey=bombey;						
						drop=true;
				 }
			 }
			 Board.decDestructableCounter();
			 ausbreiten = false;
			 tiledestroyed=true;
			 this.setTiledestroyedscounter(this.getTiledestroyedscounter());
		 }		 
		 reichweitel ++;
	 }
	 ausbreitung ++;
	 //i=0;
	}
 
 ausbreitung =0;
 ausbreiten=true;
 
 while (ausbreitung <= bombenreichweite && Board.map[bombex+reichweiter][bombey].getTileId() == 1)
	{
	 //ListIterator<Bombe> it = Bombe.bombenliste.listIterator();	
 	 if (bombenliste.size()!=0) {
	 //while(it.hasNext()) {
 		 for(Bombe bombe : bombenliste){
		 if (Bombe.bombenliste.size()!=1) {
			 for (int f=1; f<bombenliste.size(); f++)
			 {
		 if(bombe.isExplodiert()==false){
			 
			 if(Board.map[this.getBombex()+reichweiter][this.getBombey()] == Board.map[bombe.getBombex()][bombe.getBombey()]) {
				 bombe.setExplodiert(true);
				 bombe.doppel=true;
				 System.out.println("Doppel!");				 
				 }
		 }
		 }
		 }
		 //it.next();			 		 	
  }
 }
	 for (i=0; i<(Hero.heroliste.size()); i++)
	 {
		 if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()] == Board.map[bombex+reichweiter][bombey])
		 {			 
			 if(Hero.heroliste.get(i).getarmored()==false)
			 {
			 Hero.heroliste.get(i).setisalive(false);
			 Hero.heroliste.get(i).setdeathcount(Hero.heroliste.get(i).getdeathcount());
			 this.setKilledplayer(i);
			 if(Mainframe.sound==true){
			 try {
					JukeBox.playSoundeffect("scream");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
			 Mainframe.setStartPosition(i);
			 }
			 if(Hero.heroliste.get(i).getarmored()==true)
			 {
				 Hero.heroliste.get(i).setarmored(false);
			 }
		 }
	 }
	 if (ausbreiten == true)
	 {
		 if (Board.map[bombex+(reichweiter+1)][bombey].getTileId() ==4)
		 {
			 if (Board.getHasExit()==false) {
				 double z=Math.random();
				 if (z<(double)1/Board.getDestructableCounter()) {
					 Board.map[bombex+(reichweiter+1)][bombey].setTileId(3);
					 Board.map[bombex+(reichweiter+1)][bombey].setImg(Tileset.getTile(2, Tile.getTileset()));
					 Board.setHasExit(true);
					 if(Mainframe.sound==true){
					 try {
							JukeBox.playSoundeffect("door");
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						} catch (UnsupportedAudioFileException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					 }
				 }
				 else {
					 Board.map[bombex+(reichweiter+1)][bombey].setTileId(1);
					 Board.map[bombex+(reichweiter+1)][bombey].setImg(Tileset.getTile(0, Tile.getTileset()));
					 double u=Math.random();
					 if(u<0.05)
					 {
						upgradex=bombex+(reichweiter+1);
						upgradey=bombey;
						drop=true;
					 }
				 }
			 }
			 else {
				 Board.map[bombex+(reichweiter+1)][bombey].setTileId(1);
				 Board.map[bombex+(reichweiter+1)][bombey].setImg(Tileset.getTile(0, Tile.getTileset()));
				 double u=Math.random();
				 if(u<0.05)
				 {
					upgradex=bombex+(reichweiter+1);
					upgradey=bombey;
					drop=true;
				 }
			 }
			 Board.decDestructableCounter();
			 ausbreiten = false;
			 tiledestroyed=true;
			 this.setTiledestroyedscounter(this.getTiledestroyedscounter());
		 }		 
		 reichweiter ++;
	 }
	 ausbreitung ++;
	}
 
 ausbreitung =0;
 ausbreiten=true;
 
 while (ausbreitung <= bombenreichweite && Board.map[bombex][bombey+reichweiteu].getTileId() == 1)
	{
	 //ListIterator<Bombe> it = Bombe.bombenliste.listIterator();	
 	 if (bombenliste.size()!=0) {
	 //while(it.hasNext()) {
 		 for(Bombe bombe : bombenliste) {
		 if (Bombe.bombenliste.size()!=1) {
			 for (int f=1; f<bombenliste.size(); f++)
			 {
		 if(bombe.isExplodiert()==false){
			 
			 if(Board.map[this.getBombex()][this.getBombey()+reichweiteu] == Board.map[bombe.getBombex()][bombe.getBombey()]) {
				 bombe.setExplodiert(true);
				 bombe.doppel=true;
				 System.out.println("Doppel!");				 
				 }
		 }
		 }
		 }
		 //it.next();			 		 	
  }
 }
	 for (i=0; i<(Hero.heroliste.size()); i++)
	 {
		 if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()] == Board.map[bombex][bombey+reichweiteu])
		 {
		 if(Hero.heroliste.get(i).getarmored()==false)
		 {
		 Hero.heroliste.get(i).setisalive(false);
		 Hero.heroliste.get(i).setdeathcount(Hero.heroliste.get(i).getdeathcount());
		 this.setKilledplayer(i);
		 if(Mainframe.sound==true){
		 try {
				JukeBox.playSoundeffect("scream");
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		 Mainframe.setStartPosition(i);
		 }
		 if(Hero.heroliste.get(i).getarmored()==true)
		 {
			 Hero.heroliste.get(i).setarmored(false);
		 }
		 }
	 }
	 if (ausbreiten == true)
	 {
		 if (Board.map[bombex][bombey+(reichweiteu+1)].getTileId() == 4)
		 {
			 if (Board.getHasExit()==false) {
				 double z=Math.random();
				 if (z<(double)1/Board.getDestructableCounter()) {
					 Board.map[bombex][bombey+(reichweiteu+1)].setTileId(3);
					 Board.map[bombex][bombey+(reichweiteu+1)].setImg(Tileset.getTile(2, Tile.getTileset()));
					 Board.setHasExit(true);
					 if(Mainframe.sound==true){
					 try {
							JukeBox.playSoundeffect("door");
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						} catch (UnsupportedAudioFileException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					 }
				 }
				 else {
					 Board.map[bombex][bombey+(reichweiteu+1)].setTileId(1);
					 Board.map[bombex][bombey+(reichweiteu+1)].setImg(Tileset.getTile(0, Tile.getTileset()));
					 double u = Math.random();
					 if(u<0.05)
					 {
						upgradex=bombex;
						upgradey=bombey+(reichweiteu+1);						
						 drop=true;
					 }
				 }
			 }
			 else {
				 Board.map[bombex][bombey+(reichweiteu+1)].setTileId(1);
				 Board.map[bombex][bombey+(reichweiteu+1)].setImg(Tileset.getTile(0, Tile.getTileset()));
				 double u = Math.random();
				 if(u<0.05)
				 {
					upgradex=bombex;
					upgradey=bombey+(reichweiteu+1);						
					 drop=true;
				 }
			 }
			 Board.decDestructableCounter();
			 ausbreiten=false;
			 tiledestroyed=true;
			 this.setTiledestroyedscounter(this.getTiledestroyedscounter());
		 }		 
		 reichweiteu ++;
	 }	
	 ausbreitung ++;
	}
 
 ausbreitung=0;
 ausbreiten=true;
 
 while (ausbreitung <= bombenreichweite && Board.map[bombex][bombey-reichweiteo].getTileId() == 1)
	{
	 //ListIterator<Bombe> it = Bombe.bombenliste.listIterator();	
 	 if (bombenliste.size()!=0) {
	 //while(it.hasNext()) {
 		 for(Bombe bombe : bombenliste) {
		 if (Bombe.bombenliste.size()!=1) {
			 for (int f=1; f<bombenliste.size(); f++)
			 {
		 if(bombe.isExplodiert()==false){
			 
			 if(Board.map[this.getBombex()][this.getBombey()-reichweiteo] == Board.map[bombe.getBombex()][bombe.getBombey()]) {
				 bombe.setExplodiert(true);
				 bombe.doppel=true;
				 System.out.println("Doppel!");				 
				 }
		 }
		 }
		 }
		 //it.next();			 		 	
  }
 }
	 for (i=0; i<(Hero.heroliste.size()); i++)
	 {
		 if (Board.map[Hero.heroliste.get(i).getxCoord()][Hero.heroliste.get(i).getyCoord()] == Board.map[bombex][bombey-reichweiteo])
		 {			
			 if(Hero.heroliste.get(i).getarmored()==false)
			 {
			 Hero.heroliste.get(i).setisalive(false);
			 Hero.heroliste.get(i).setdeathcount(Hero.heroliste.get(i).getdeathcount());
			 this.setKilledplayer(i);
			 if(Mainframe.sound==true){
			 try {
					JukeBox.playSoundeffect("scream");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
			 Mainframe.setStartPosition(i);
			 }
			 if(Hero.heroliste.get(i).getarmored()==true)
			 {
				 Hero.heroliste.get(i).setarmored(false);
			 }
		 }
	 }
	 if (ausbreiten == true)
	 {
		 if (Board.map[bombex][bombey-(reichweiteo+1)].getTileId() == 4)
		 {
			 if (Board.getHasExit()==false) {
				 double z=Math.random();
				 if (z<(double)1/Board.getDestructableCounter()) {
					 Board.map[bombex][bombey-(reichweiteo+1)].setTileId(3);
					 Board.map[bombex][bombey-(reichweiteo+1)].setImg(Tileset.getTile(2, Tile.getTileset()));
					 Board.setHasExit(true);
					 if(Mainframe.sound==true){
					 try {
						JukeBox.playSoundeffect("door");
					} catch (LineUnavailableException e) {
						e.printStackTrace();
					} catch (UnsupportedAudioFileException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					 }
				 }
				 else {
					 Board.map[bombex][bombey-(reichweiteo+1)].setTileId(1);
					 Board.map[bombex][bombey-(reichweiteo+1)].setImg(Tileset.getTile(0, Tile.getTileset()));
					 double u=Math.random();
					 if(u<0.05)
					 {
						upgradex=bombex;
						upgradey=bombey-(reichweiteo+1);						
						 drop=true;
					 }
				 }
			 }
			 else {

				 Board.map[bombex][bombey-(reichweiteo+1)].setTileId(1);
				 Board.map[bombex][bombey-(reichweiteo+1)].setImg(Tileset.getTile(0, Tile.getTileset()));
				 double u=Math.random();
				 if(u<0.05)
				 {
					upgradex=bombex;
					upgradey=bombey-(reichweiteo+1);						
					 drop=true;
				 }
			 }
			 Board.decDestructableCounter();
			 ausbreiten=false;
			 tiledestroyed=true;
			 this.setTiledestroyedscounter(this.getTiledestroyedscounter());
		 }		 
		 reichweiteo ++;
	 }	
	 ausbreitung ++;
	}
 
 this.getExplosionsvektor()[0] = reichweiteo;
 this.getExplosionsvektor()[1] = reichweiter;
 this.getExplosionsvektor()[2] = reichweiteu;
 this.getExplosionsvektor()[3] = reichweitel;
 reichweiteo=reichweiter=reichweiteu=reichweitel=0;
 if(this.isTiledestroyed() == true) {
	for(int j=0; j<this.getTiledestroyedscounter();j++) {
		Hero.heroliste.get(this.getDroppedby()).settilecount(Hero.heroliste.get(this.getDroppedby()).gettilecount());
	}
 }
 if(this.getDroppedby()==this.killedplayer && Hero.heroliste.get(this.killedplayer).getisalive() == false && this.doppel==false) 
 {
	 Hero.heroliste.get(this.killedplayer).setSuicidecount(Hero.heroliste.get(this.killedplayer).getSuicidecount());
 }
 else
 {
	 Hero.heroliste.get(this.getDroppedby()).setkillcount(Hero.heroliste.get(this.getDroppedby()).getkillcount());
 }
 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
 if(bombenliste.size()!=0) {
	 bombenliste.remove(0);
 }
 if (drop==true)
 {
	 Upgrades g = new Upgrades();
		g.setupgradex(upgradex);
		g.setupgradey(upgradey);		 
		 Upgrades.upgradeliste.add(g);
		 g.run();		 
 }
 this.resetTiledestroyedscounter(this.getTiledestroyedscounter());
 this.setSichtbar(false);
 this.setExplodiert(false);
 }

public int[] getExplosionsvektor() {
	return explosionsvektor;
	}
public void setExplosionsvektor(int[] explosionsvektor) {
	this.explosionsvektor = explosionsvektor;
	}
public boolean isTiledestroyed() {
	return tiledestroyed;
}
public void setTiledestroyed(boolean tiledestroyed) {
	this.tiledestroyed = tiledestroyed;
}
public int getDroppedby() {
	return droppedby;
}
public void setDroppedby(int droppedby) {
	this.droppedby = droppedby;
}
public int getTiledestroyedscounter() {
	return tiledestroyedscounter;
}
public void setTiledestroyedscounter(int tiledestroyedscounter) {
	this.tiledestroyedscounter = ++tiledestroyedscounter;
}
public void resetTiledestroyedscounter(int tiledestroyedscounter) {
	this.tiledestroyedscounter = 0;
}
public int getKilledplayer() {
	return killedplayer;
}
public void setKilledplayer(int killedplayer) {
	this.killedplayer = killedplayer;
}

}  
