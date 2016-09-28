package modele;

import controleur.Controle;
import outils.connexion.Connexion;

public class JeuServeur extends Jeu {

	@Override
	public void setConnexion(Connexion connexion) {
	}

	@Override
	public void reception(Object info) {
		System.out.println(info);
	}

	@Override
	public void deconnexion(Connexion connexion) {
		
	}
	
	public JeuServeur(Controle controle){
		super.controle = controle;
	}
	
}
