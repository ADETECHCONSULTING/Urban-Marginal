package outils.connexion;

import java.io.*;
import java.net.Socket;

import javax.swing.JOptionPane;
public class Connexion extends Thread {
	private Object leRepertoire;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	public Connexion(Socket socket, Object leRepertoire){
		this.leRepertoire = leRepertoire;
		try {
			this.out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("probleme dans l'objet OUTPUT"+ e);
			System.exit(0);
		}
		try {
			this.in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("probleme dans l'objet INPUT"+ e);
			System.exit(0);
		}
		super.start();
	}
	
	public void run(){
		boolean inOk = true;
		Object reception;
		
		
		while(inOk == true){
			try {
				reception = in.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("probleme ce n'est pas un objet"+ e);
				System.exit(0);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "le client s'est deconnecté");
				inOk = false;
				try {
					in.close();
				} catch (IOException e1) {
					System.out.println("erreur dans la fermeture du INPUT"+ e);
				}
				
			}
		}
		
	}
	

}
