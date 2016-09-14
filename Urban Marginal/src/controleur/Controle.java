package controleur;

import java.net.ServerSocket;

import javax.swing.JFrame;

import outils.connexion.ClientSocket;
import outils.connexion.ServeurSocket;
import vue.EntreeJeu;

public class Controle {
	private EntreeJeu frmEntreeJeu;	
	public static void main(String[] args) {
		new Controle();
	}
	
	
	public Controle(){ // Controleur qui appelle EntreeJeu et affiche la fenetre
		frmEntreeJeu = new EntreeJeu(this);
		frmEntreeJeu.setVisible(true);
	}
	
	public void evenementVue(JFrame uneFrame, Object info){
		if(uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
		
	}

	private void evenementEntreeJeu(Object info) {
		if((String)info == "serveur"){
			new ServeurSocket(this, 6666);
		}
		else{
			new ClientSocket((String)info, 6666, this).isConnexionOk();
		}
		
	}

}


