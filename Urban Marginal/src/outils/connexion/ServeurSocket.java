package outils.connexion;

import java.io.IOException;
import java.net.ServerSocket;

public class ServeurSocket extends Thread {
	private Object leRepertoire;
	private ServerSocket serverSocket; 
	public ServeurSocket(Object leRepertoire, int port){
		this.leRepertoire = leRepertoire;
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("erreur grave création socket serveur " +e);
			System.exit(0);
		}super.start();
	}
	
}
