package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connexion;

public class JeuServeur extends Jeu implements Global {
	private ArrayList<Mur> lesMurs = new ArrayList<>();
	private Hashtable<Connexion, Joueur> lesJoueurs = new Hashtable<>();

	@Override
	public void setConnexion(Connexion connexion) {
		lesJoueurs.put(connexion, new Joueur());
		controle.evenementModele(this, "envoi panel murs", connexion);
	}

	@Override
	public void reception(Object info) {
		String[] infos = ((String)info).split(SEPARE);
		switch(Integer.parseInt(infos[0])){
		case PSEUDO :
			lesJoueurs.get(info).initPerso(infos[1], Integer.parseInt(infos[2]));
			break;
		}
	}

	@Override
	public void deconnexion(Connexion connexion) {
		
	}
	
	public JeuServeur(Controle controle){
		super.controle = controle;
		Label.setNbLabel(0);
	}
	
	public void constructionMurs(){
		for(int i = 0 ; i < NBMURS; i++){
			lesMurs.add(new Mur());
			controle.evenementModele(this, "ajout mur",lesMurs.get(i).getLabel().getjLabel());
		}
	}
}
