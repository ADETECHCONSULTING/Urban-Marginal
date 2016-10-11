package modele;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controle;
import outils.connexion.Connexion;

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
		}
		if(info instanceof Label){
			controle.evemenementModele(this, "ajout joueur", info);
		}
		if(info instanceof String){
			controle.evemenementModele(this, "remplace chat", info);
		}

	}

	@Override
	public void deconnection(Connexion connection) {
		// TODO Auto-generated method stub

	}
	
	public void envoi(Object info) {
		super.envoi(connection, info);

	}
	
	

}
