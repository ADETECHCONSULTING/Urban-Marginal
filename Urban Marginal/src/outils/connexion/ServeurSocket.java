package outils.connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocket extends Thread {
<<<<<<< HEAD
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
				new Connexion(socket, leRepertoire);
			} catch (IOException e) {
			
				System.out.println("erreur grave sur le socket"+e);
				System.exit(0);
				;
			}
			
		}
		
		
		
	}
}
=======

	private Object leRecepteur;
	private ServerSocket serverSocket;

	public ServeurSocket(Object leRecepteur, int port) {

		this.leRecepteur = leRecepteur;
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("erreur grave lors de la création du socket serveur : " + e);
			System.exit(0);
		}
		super.start();
	}

	public void run() {
		Socket socket;
		while (true) {
			try {
				System.out.println("le serveur attend..");
				socket = serverSocket.accept();
				System.out.println("Un client s'est connecté");
				new Connection(socket, leRecepteur);

			} catch (IOException e) {
				System.out.println("erreur lors de la création du socket : " + e);
				System.exit(0);
			}

		}

	}

}
>>>>>>> branch 'master' of https://github.com/gmanzola/TP-URBAN-MARGINAL.git
