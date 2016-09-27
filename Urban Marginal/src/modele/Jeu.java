package modele;

import controleur.Controle;
import outils.connexion.Connexion;

public abstract class Jeu {
	protected Controle controle = new Controle();
	
	public abstract void setConnexion(Connexion connexion);
	
	public abstract void reception(Object info);
	
	public void envoi(Connexion connexion, Object info){
		connexion.envoi(info);
	}
	
	public abstract void deconnexion(Connexion connexion);
}


