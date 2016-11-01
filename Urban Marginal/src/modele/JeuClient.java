package modele;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controle;
import outils.connexion.Connexion;
import outils.son.Son;

public class JeuClient extends Jeu {

	private Connexion connection;

	/**
	 * @param controle 
	 */
	public JeuClient(Controle controle) {
		super.controle = controle;

	}

	@Override
	public void setConnection(Connexion connection) {
		this.connection = connection;

	}

	@Override
	public void reception(Connexion connection, Object info) {
		if(info instanceof JPanel){
			controle.evemenementModele(this,"ajout panel murs", info);
			controle.evemenementModele(this, "ajout panel bonus", info);
		}
		if(info instanceof Label){
			controle.evemenementModele(this, "ajout joueur", info);
		}
		if(info instanceof String){
			controle.evemenementModele(this, "remplace chat", info);
		}
		if(info instanceof Integer){
			controle.evemenementModele(this, "son", info);
		}
		if(info instanceof JLabel){
			controle.evemenementModele(this, "ajout JLabel bonus", info);
		}
	}

	@Override

	public void deconnection(Connexion connection) {
		System.exit(0);
	}

	public void envoi(Object info) {
		super.envoi(connection, info);

	}



}
