package modele;

import controleur.Controle;
<<<<<<< HEAD
import outils.connexion.Connexion;

public abstract class Jeu {
	protected Controle controle;
	
	public abstract void setConnexion(Connexion connexion);
	
	public abstract void reception(Connexion connexion, Object info);
	
	public void envoi(Connexion connexion, Object info){
		connexion.envoi(info);
	}
	
	public abstract void deconnexion(Connexion connexion);
}


=======
import outils.connexion.Connection;

public abstract class Jeu {

	protected Controle controle;

	public abstract void setConnection(Connection connection);

	public abstract void reception(Connection connection, Object info);

	public void envoi(Connection connection, Object info) {
		connection.envoi(info);
	}

	public abstract void deconnection(Connection connection);

}
>>>>>>> branch 'master' of https://github.com/gmanzola/TP-URBAN-MARGINAL.git
