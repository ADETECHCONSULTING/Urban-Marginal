package outils.connexion;

import java.net.Socket;
public class Connexion extends Thread {
	private Object leRepertoire;
	public Connexion(Socket socket, Object leRepertoire){
		this.leRepertoire = leRepertoire;
	}
	

}
