package modele;

import java.util.ArrayList;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connexion;

public class JeuServeur extends Jeu implements Global {
	private ArrayList<Mur> lesMurs = new ArrayList<>();

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
		Label.setNbLabel(0);
	}
	
	public void constructionMurs(){
		for(int i = 0 ; i < NBMURS; i++){
			lesMurs.add(new Mur());
			controle.evenementModele(this, "ajout mur",lesMurs.get(i).getLabel().getjLabel());
		}
	}
}
