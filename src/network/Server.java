package network;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Server extends Thread {
	
	static ArrayList<ClientThread> clientThreadslist = new ArrayList<ClientThread>();
	ServerSocket server;
	Socket client;
	private int playerCount;
	static int maxPlayers=2;
	public Server() throws IOException {
		ServerSocket server = new ServerSocket(4711);
		Socket client = null;
		playerCount=0;
		
	}
	public void run() {
		int playerCount=0;
		
		while(true) {			//Clients werden angenommen
			try {
				client=server.accept();
				clientThreadslist.add(new ClientThread(playerCount, this, server.accept()));
				playerCount++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(playerCount == maxPlayers) {
				break;
			}
		}
		try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMessages(String inc) {
		for(ClientThread cts : clientThreadslist) {
			Lock lock = cts.getWriteLock();
			lock.lock();
			try {
				cts.getOutputStream().writeUTF(inc);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			lock.unlock();
		}
	}
}
