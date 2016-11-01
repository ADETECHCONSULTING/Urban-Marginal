package modele;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controleur.Controle;
import controleur.Global;

public class BonusVie extends Bonus implements Global{
	private JeuServeur jeuServeur;
	private Controle controle;
	public BonusVie(){
		super();
		label.getjLabel().setIcon(new ImageIcon(BONUSVIE));
	}
	
	@Override
	public void activationBonus(Joueur joueur) {
		joueur.setGainVie(3); //donne au joueur 3 points de vie supplémentaires 
	}

	@Override
	public void affiche(ArrayList<Bonus> lesBonus) { 
		label.getjLabel().setBounds(posX, posY, L_BONUS, H_BONUS);
		label.getjLabel().setIcon(new ImageIcon(BONUSVIE));
		controle.evemenementModele(this, "ajout bonus", lesBonus.get(0).getLabel());
	}
}
