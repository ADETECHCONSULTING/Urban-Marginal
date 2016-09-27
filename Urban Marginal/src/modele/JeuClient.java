package modele;

import outils.connexion.Connexion;

public class JeuClient extends Jeu {
private Connexion connexion;
	@Override
	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}

	@Override
	public void reception(Connexion connexion, Object info) {
		
	}

	@Override
	public void deconnexion(Connexion connexion) {
		
	}

}
