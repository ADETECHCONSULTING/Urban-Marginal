package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Global;
import outils.connexion.Connexion;

public class Attaque extends Thread implements Global {
	private Joueur attaquant;
	private JeuServeur jeuServeur;
	private ArrayList<Mur> lesMurs;
	private Hashtable<Connexion, Joueur> lesJoueurs;
	
	public Attaque(Joueur attaquant, JeuServeur jeuServeur, ArrayList<Mur> lesMurs, Hashtable<Connexion, Joueur> lesJoueurs){
		this.attaquant = attaquant;
		this.jeuServeur = jeuServeur;
		this.lesMurs = lesMurs;
		this.lesJoueurs = lesJoueurs;
		super.start();
	}
	
	public void run(){
		Boule laboule = attaquant.getBoule();
		int orientation = attaquant.getOrientation();
		laboule.label.getjLabel().setVisible(true);
		Joueur victime = null;
		do{
			if(orientation == 0){
				laboule.setPosX(laboule.getPosX()-LEPAS);
			}else{
				laboule.setPosX(laboule.getPosX()+LEPAS);
			}
			laboule.label.getjLabel().setBounds(laboule.getPosX(), laboule.getPosY(), L_BOULE, H_BOULE);
			this.pause(10, 15);
			jeuServeur.envoi(laboule.label);
			victime = toucheJoueur();
		}while(laboule.getPosX() > 0 && laboule.getPosX() < L_ARENE && toucheMur() == false && victime == null );
		laboule.getLabel().getjLabel().setVisible(false);
		jeuServeur.envoi(laboule.label);
	}
	
	public void pause(long milli, int nano){
		try {
			Thread.sleep(milli, nano);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean toucheMur(){
		for(Mur unMur : lesMurs){
			if(attaquant.getBoule().toucheObjet(unMur)){
				return true;
			}
		}
		return false;
	}
	
	public Joueur toucheJoueur(){
		for(Joueur unJoueur : lesJoueurs.values()){
			if(attaquant.getBoule().toucheObjet(unJoueur)){
				return unJoueur;
			}
		}
		return null;
	}
}
