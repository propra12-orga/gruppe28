package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.locks.Lock;

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
			}
		
			//Schicken an alle Clients
		}
		
	}