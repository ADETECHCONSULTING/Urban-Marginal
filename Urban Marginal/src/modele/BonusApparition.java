package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connexion;
import vue.Arene;

public class BonusApparition extends Thread implements Global{
	private Joueur attaquant;
	private JeuServeur jeuServeur;
	private ArrayList<Mur> lesMurs;
	private ArrayList<Bonus> lesBonus;
	private Hashtable<Connexion, Joueur> lesJoueurs;
	
	public void run(){
		int pause = 3000;
		try {
			Thread.sleep(pause);
		} catch (InterruptedException e) {
			System.out.println("timing erreur "+ e);
		}	
	}
	
	
}
