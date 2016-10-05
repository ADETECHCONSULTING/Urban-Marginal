package controleur;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import modele.Label;
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
		frmArene = new Arene();
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
			
			((JeuServeur)this.leJeu).constructionMurs();
			frmArene.setVisible(true);
		}
		else{
			 if (new ClientSocket((String)info, PORT, this).isConnexionOk()){
	                leJeu = new JeuClient(this);
	                leJeu.setConnexion(connexion);
	                frmArene = new Arene();
	                frmEntreeJeu.dispose();
	                frmChoixJoueur = new Choice(this);
	                frmChoixJoueur.setVisible(true);
	            }
		}
	}
	
	private void evenementChoixJoueur(Object info){
			((modele.JeuClient)this.leJeu).envoi(info);
			frmChoixJoueur.dispose();
			frmArene.setVisible(true);
	}
	
	public void setConnexion(Connexion connexion){
		this.connexion = connexion;
		if(leJeu instanceof JeuServeur){
			leJeu.setConnexion(connexion);
		}
	}
	
	public void receptionInfo(Connexion connexion, Object info){
		System.out.println("recepInfo");
		leJeu.reception(connexion, info);
	}
	
	public void evenementModele(Object unJeu, String ordre, Object info){
		if(unJeu instanceof JeuServeur){
			evenementJeuServeur(ordre, info);
		}
		if(unJeu instanceof JeuClient){
			evenementJeuClient(ordre, info);
		}
	}
	
	public void evenementJeuServeur(String ordre, Object info){
		if(ordre == "ajout mur"){
			frmArene.ajoutMur((JLabel)info);
		}
		if(ordre == "envoi panel murs"){
			((modele.JeuServeur)leJeu).envoi((outils.connexion.Connexion)info, frmArene.getJpnMurs());
		}
		if(ordre == "ajout joueur"){
			frmArene.ajoutJoueur((JLabel)info);
			
		}
	}
	
	public void evenementJeuClient(String ordre, Object info){
		if(ordre == "ajout panel murs"){
			frmArene.ajoutPanelMur((JPanel)info);
		}
		if(ordre == "ajout joueur"){
			frmArene.ajoutModifJoueur(((Label) info).getNumLabel(), ((Label)info).getjLabel());
		}
	}
}


