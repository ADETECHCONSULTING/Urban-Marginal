package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import controleur.Global;
<<<<<<< HEAD
import outils.connexion.Connexion;

public class JeuServeur extends Jeu implements Global {
	private ArrayList<Mur> lesMurs = new ArrayList<>();
	private Hashtable<Connexion, Joueur> lesJoueurs = new Hashtable<>();

	@Override
	public void setConnexion(Connexion connexion) {
		lesJoueurs.put(connexion, new Joueur(this));
		
	}

	@Override
	public void reception(Connexion connexion, Object info) {
		String[] infos = ((String)info).split(SEPARE);
		switch(Integer.parseInt(infos[0])){
		case PSEUDO :
<<<<<<< master
			controle.evenementModele(this,"envoi panel murs", connexion);
			for(Joueur unJoueur : lesJoueursDansLordre){
				super.envoi(connexion, unJoueur.getLabel());
				super.envoi(connexion, unJoueur.getMessage());
			}
		    lesJoueurs.get(connexion).initPerso(infos[1], Integer.parseInt(infos[2]), lesJoueurs, lesMurs);
		    this.lesJoueursDansLordre.add(this.lesJoueurs.get(connexion));
		    break;
		case CHAT : 
			String laPhrase = lesJoueurs.get(connexion).getPseudo()+" > "+ infos[1];
			controle.evenementModele(this, "ajout phrase", laPhrase);
=======
			System.out.println("reception pseudo");
			lesJoueurs.get(connexion).initPerso(infos[1], Integer.parseInt(infos[2]), lesJoueurs, lesMurs);
>>>>>>> f7892db Chat semi-fonctionnel
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
	
	public void nouveauLabelJeu(Label label){
		controle.evenementModele(this, "ajout joueur", label.getjLabel());
	}

	/* (non-Javadoc)
	 * @see modele.Jeu#envoi(outils.connexion.Connexion, java.lang.Object)
	 */
	public void envoi(Object info) {
		
		for(Connexion uneConnexion : lesJoueurs.keySet()){
			super.envoi(uneConnexion, info);
		}
		
	}
	
	
	
=======
import outils.connexion.Connection;

public class JeuServeur extends Jeu implements Global {
	
	private ArrayList<Mur> lesMurs = new ArrayList<>();
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<>() ;
	private ArrayList<Joueur> lesJoueursDansLordre = new ArrayList<>();

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
	public void setConnection(Connection connection) {
		lesJoueurs.put(connection, new Joueur(this));
		// envoi des murs creer en meme temps que l'enregistrement du joueur

	}

	@Override
	public void reception(Connection connection, Object info) {
		System.out.println(info);
		String[] infos;
		infos = ((String)info).split(SEPARE);
		
		switch (Integer.parseInt(infos[0])){
		
		case PSEUDO :
			
			controle.evemenementModele(this,"envoi panel murs", connection);
			for(Joueur unJoueur : lesJoueursDansLordre){
				super.envoi(connection, unJoueur.getLabel());
				super.envoi(connection, unJoueur.getMessage());
			}
		    lesJoueurs.get(connection).initPerso(infos[1], Integer.parseInt(infos[2]), lesJoueurs, lesMurs);
		    this.lesJoueursDansLordre.add(this.lesJoueurs.get(connection));
		    break;    
		    
		case CHAT :
			
			String laPhrase = lesJoueurs.get(connection).getPseudo() + " > " + infos[1];
			controle.evemenementModele(this, "ajout phrase", laPhrase);
			
		}
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub

	}
	
	public void nouveauLabelJeu(Label label){
		controle.evemenementModele(this, "ajout joueur", label.getjLabel());
	}

	/* (non-Javadoc)
	 * @see modele.Jeu#envoi(outils.connexion.Connection, java.lang.Object)
	 */
	
	public void envoi(Object info) {
		for(Connection unJoueur : lesJoueurs.keySet()){
			super.envoi(unJoueur, info);
		}
	}

>>>>>>> branch 'master' of https://github.com/gmanzola/TP-URBAN-MARGINAL.git
}
