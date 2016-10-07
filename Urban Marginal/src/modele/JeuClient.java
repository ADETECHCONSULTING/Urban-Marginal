package modele;

<<<<<<< HEAD
import javax.swing.JPanel;

import controleur.Controle;
import outils.connexion.Connexion;

public class JeuClient extends Jeu {
private Connexion connexion;
private Controle controle;

	public JeuClient(Controle controle){
		this.controle = controle;
	}

	@Override
	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}

	@Override
	public void reception(Connexion connexion, Object info) {
		if(info instanceof JPanel){
			controle.evenementModele(this, "ajout panel murs", info);
		}
		if(info instanceof Label){
			controle.evenementModele(this, "ajout joueur", info);
		}
		if(info instanceof String){
			controle.evenementModele(this, "remplace chat", info);
		}
	}

	@Override
	public void deconnexion(Connexion connexion) {
		
	}
	
	public void envoi(Object info){
		super.envoi(connexion, info);
	}
=======
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controle;
import outils.connexion.Connection;

public class JeuClient extends Jeu {
	
	private Connection connection;
	
/**
 * @param controle 
 */
	public JeuClient(Controle controle) {
		super.controle = controle;

	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@Override
	public void reception(Connection connection, Object info) {
		if(info instanceof JPanel){
			controle.evemenementModele(this,"ajout panel murs", info);
		}
		if(info instanceof Label){
			controle.evemenementModele(this, "ajout joueur", info);
		}

	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub

	}
	
	public void envoi(Object info) {
		super.envoi(connection, info);

	}
	
	
>>>>>>> branch 'master' of https://github.com/gmanzola/TP-URBAN-MARGINAL.git

}
