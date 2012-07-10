package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import controlling.InputController;

import main.Hero;

public class Client {
	Socket zumServer;
	ClientThread ct;
	public Client(ClientThread ct) {
		this.ct=ct;
	}
	public void sendMessage() {
		try {
			zumServer = new Socket("localhost", 4711);
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
