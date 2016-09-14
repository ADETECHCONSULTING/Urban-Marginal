package outils.connexion;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientSocket {
	private boolean connexionOk = false;
	public ClientSocket(String ip, int port, Object leRecepteur){
		Socket socket;
		 //rajouter un private et mettre un getter
		try {
			socket = new Socket(ip, port);
			System.out.println("La connexion au serveur s'est bien déroulé");
			connexionOk = true;
			new Connexion(socket, leRecepteur);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "le serveur est indisponible");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "l'adresse IP est incorrect");
		}
		
		
	}
	/**
	 * @return the connexionOk
	 */
	public boolean isConnexionOk() {
		return connexionOk;
	}
	/**
	 * @param connexionOk the connexionOk to set
	 */
	public void setConnexionOk(boolean connexionOk) {
		this.connexionOk = connexionOk;
	}
	
	
	

}
