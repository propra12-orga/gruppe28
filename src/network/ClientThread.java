package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.locks.Lock;

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
			//verarbeitung vom Server
			//Schicken an alle Clients
		}
		
	}
}
