package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connexion;

public class JeuServeur extends Jeu implements Global {
	
	private ArrayList<Mur> lesMurs = new ArrayList<>();
	private Hashtable<Connexion, Joueur> lesJoueurs = new Hashtable<>() ;
	private ArrayList<Joueur> lesJoueursDansLordre = new ArrayList<>();
	private String laPhrase;
	

	public JeuServeur(Controle controle) {
		super.controle = controle;
		
		Label.setNbLabel(0);
	}
	
	public void constructionMurs(){
		for(int k = 0; k < NBMURS; k++){
			lesMurs.add(new Mur());
			controle.evemenementModele(this, "ajout mur", lesMurs.get(k).getLabel().getjLabel());
		}
		
	}

	@Override
	public void setConnection(Connexion connection) {
		lesJoueurs.put(connection, new Joueur(this));
		// envoi des murs creer en meme temps que l'enregistrement du joueur

	}

	@Override
	public void reception(Connexion connection, Object info) {
		
		String[] infos;
		infos = ((String)info).split(SEPARE);
		
		switch (Integer.parseInt(infos[0])){
		
		case PSEUDO :
			
			controle.evemenementModele(this,"envoi panel murs", connection);
			for(Joueur unJoueur : lesJoueursDansLordre){
				super.envoi(connection, unJoueur.getLabel());
				super.envoi(connection, unJoueur.getMessage());
				super.envoi(connection, unJoueur.getBoule().getLabel());
			}
		    lesJoueurs.get(connection).initPerso(infos[1], Integer.parseInt(infos[2]), lesJoueurs, lesMurs);
		    this.lesJoueursDansLordre.add(this.lesJoueurs.get(connection));
		    controle.evemenementModele(this, "ajout phrase", "*** "+lesJoueurs.get(connection).getPseudo()+" vient de se connecter ***");
		    break;    
		    
		case CHAT :
			
			laPhrase = lesJoueurs.get(connection).getPseudo() + " > " + infos[1];
			controle.evemenementModele(this, "ajout phrase", laPhrase);
			break;
		case ACTION:
			lesJoueurs.get(connection).action(Integer.parseInt(infos[1]), lesJoueurs, lesMurs);
			break;
		}
	}

	@Override
	public void deconnection(Connexion connection) {
		// TODO Auto-generated method stub

	}
	
	public void nouveauLabelJeu(Label label){
		controle.evemenementModele(this, "ajout joueur", label);
	}

	/* (non-Javadoc)
	 * @see modele.Jeu#envoi(outils.connexion.Connection, java.lang.Object)
	 */
	
	public void envoi(Object info) {
		for(Connexion unJoueur : lesJoueurs.keySet()){
			super.envoi(unJoueur, info);
		}
	}

}
