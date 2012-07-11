package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import controlling.InputController;

import main.Hero;

public class Client extends Thread{
	Socket zumServer;
	ClientThread ct;
	public Client() throws UnknownHostException, IOException {
		zumServer = new Socket("localhost", 4711);
		}
	public void run() {
		while(true) {
			try {
				
				for (int i=0; i<8; i++) {
					zumServer.getOutputStream().write(InputController.getKeysNetwork(i).getBytes());
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
