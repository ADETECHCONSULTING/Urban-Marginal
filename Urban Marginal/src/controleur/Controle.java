package controleur;

import java.net.ServerSocket;

import javax.swing.JFrame;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.Connexion;
import outils.connexion.ServeurSocket;
import vue.Arene;
import vue.Choice;
import vue.EntreeJeu;

public class Controle implements Global {
	private EntreeJeu frmEntreeJeu;	
	private Jeu leJeu;
	private Arene frmArene;
	private Choice frmChoixJoueur;
	private Connexion connexion;
	
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
		if(uneFrame instanceof Choice){
			evenementChoixJoueur(info);
		}
		
	}

	private void evenementEntreeJeu(Object info) {
		if((String)info == "serveur"){
			new ServeurSocket(this, PORT);
			leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			frmArene = new Arene();
			frmArene.setVisible(true);
		}
		else{
			new ClientSocket((String)info, PORT, this).isConnexionOk();
			leJeu = new JeuClient();
			frmArene = new Arene();
			leJeu.setConnexion(connexion);
			frmEntreeJeu.dispose();
			frmChoixJoueur = new Choice(this);
			frmChoixJoueur.setVisible(true);
		}
		
	}
	
	private void evenementChoixJoueur(Object info){
			((modele.JeuClient)this.leJeu).envoi(info);
			frmChoixJoueur.dispose();
			frmArene.setVisible(true);
	}
	
	public void setConnexion(Connexion connexion){
		this.connexion = connexion;
	}
	
	public void receptionInfo(Connexion connexion, Object info){
		leJeu.reception(info);
	}

}


