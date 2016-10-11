package modele;

import controleur.Controle;
import outils.connexion.Connexion;

public abstract class Jeu {

	protected Controle controle;

	public abstract void setConnection(Connexion connection);

	public abstract void reception(Connexion connection, Object info);

	public void envoi(Connexion connection, Object info) {
		connection.envoi(info);
	}

	public abstract void deconnection(Connexion connection);

}
