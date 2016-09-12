package outils.connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
	
	public void run(){
		Socket socket;
		while(true){
			try {
				System.out.println("le serveur attend...");
				socket = serverSocket.accept();
				System.out.println("le client est connecté");
			} catch (IOException e) {
			
				System.out.println("erreur grave sur le socket"+e);
				System.exit(0);
				;
			}
			
		}
		
		
		
	}
}
