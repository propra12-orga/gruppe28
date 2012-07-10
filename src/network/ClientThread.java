package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.concurrent.locks.Lock;

import main.Bombe;
import main.Hero;

import controlling.Controller;

public class ClientThread extends Thread {
	int playerCount;
	Server server;
	Socket client;
	DataOutputStream os;
	DataInputStream is;
	Lock lock;
	String inc;
	public ClientThread(int pC, Server server, Socket client) {
		this.playerCount=pC;
		this.server=server;
		this.client=client;
		
		try {
			this.os=new DataOutputStream(client.getOutputStream());
			this.is=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Lock getWriteLock() {
		return lock;
	}
	public DataOutputStream getOutputStream() {
		return this.os;
	}
	
	public void run() {
		while(true) {
			try {
				inc=is.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//verarbeitung vom Server: Laufen
			
			boolean blocked = false;
			if (inc.equals("0up")) {
				Controller.movementUp(0);
			}
			else if (inc.equals("0right")) {
				Controller.movementRight(0);
			}
			else if (inc.equals("0down")) {
				Controller.movementDown(0);
			}
			else if (inc.equals("0left")) {
				Controller.movementLeft(0);
			}
			if (inc.equals("1up")) {
				Controller.movementUp(1);
			}
			else if (inc.equals("1right")) {
				Controller.movementRight(1);
			}
			else if (inc.equals("1down")) {
				Controller.movementDown(1);
			}
			else if (inc.equals("1left")) {
				Controller.movementLeft(1);
			}
			else if (inc.equals("0bomb")) {
				blocked=false;
				
				
				for(Bombe bombe : Bombe.bombenliste) {
					if (bombe.getBombex() == Hero.heroliste.get(0).getxCoord() && bombe.getBombey() == Hero.heroliste.get(0).getyCoord()) {
						blocked=true;
					}
				}
				if (blocked!=true) {
				if(Hero.heroliste.get(0).getBombcount()<=2+Hero.heroliste.get(0).getammo()){
					Bombe b = new Bombe();
					b.setBombex(Hero.heroliste.get(0).getxCoord());
					b.setBombey(Hero.heroliste.get(0).getyCoord());
					b.setSichtbar(true);
					b.setDroppedby(0);
					b.setExplodiert(false);
					Hero.heroliste.get(0).setBombcount(Hero.heroliste.get(0).getBombcount());
					Bombe.bombenliste.add(b);
					if (Bombe.bombenliste.isEmpty()==false) {
						System.out.println("Eine Bombe wurde gesetzt:" + Bombe.bombenliste.get(0).getBombex() + ", " + Bombe.bombenliste.get(0).getBombey());
					}
					Timer timer = new Timer();
					timer.schedule(b, 1);				
				}
			}
				
				
			else if (inc.equals("1bomb")) {
				blocked=false;
				for(Bombe bombe : Bombe.bombenliste) {
					if (bombe.getBombex() == Hero.heroliste.get(1).getxCoord() && bombe.getBombey() == Hero.heroliste.get(1).getyCoord()) {
						blocked=true;
					}
				}
				if (blocked!=true) {
				if(Hero.heroliste.get(1).getBombcount()<=2+Hero.heroliste.get(1).getammo()){
					Bombe b = new Bombe();
					b.setBombex(Hero.heroliste.get(1).getxCoord());
					b.setBombey(Hero.heroliste.get(1).getyCoord());
					b.setSichtbar(true);
					b.setDroppedby(1);
					b.setExplodiert(false);
					Hero.heroliste.get(1).setBombcount(Hero.heroliste.get(1).getBombcount());
					Bombe.bombenliste.add(b);
					if (Bombe.bombenliste.isEmpty()==false) {
						System.out.println("Eine Bombe wurde gesetzt:" + Bombe.bombenliste.get(Bombe.bombenliste.size()-1).getBombex() + ", " + Bombe.bombenliste.get(Bombe.bombenliste.size()-1).getBombey());
					}
					Timer timer = new Timer();
					timer.schedule(b, 1);
				}
				}
			}
		
		}
		
	}
}
}