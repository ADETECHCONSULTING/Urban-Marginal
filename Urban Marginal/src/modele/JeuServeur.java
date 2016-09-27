package modele;

import controleur.Controle;
import outils.connexion.Connexion;

public class JeuServeur extends Jeu {

	@Override
	public void setConnexion(Connexion connexion) {
	}

	@Override
	public void reception(Connexion connexion, Object info) {
		
	}

	@Override
	public void deconnexion(Connexion connexion) {
		
	}
	
	public JeuServeur(Controle controle){
		super.controle = controle;
	}
	
}
