package modele;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connexion;
import vue.Arene;

public class Joueur extends Objet implements Global {

	private String pseudo;
	private int numPerso;
	private Label message;
	private JeuServeur jeuServeur;
	private int vie;
	private int etape;
	private Arene frmArene;
	private int orientation;
	private Boule boule;
	private Bonus bonus;
	private Controle controle;
	private static final int MAXVIE = 10;
	private static final int GAIN = 1;
	private static final int PERTE = 2;

	public Joueur(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		vie = MAXVIE;
		etape = 1; // numéro d'étape dans l'animation
		orientation = DROITE;
		frmArene = new Arene("client", controle);
	}

	public void affiche(String etat, int etape) {
		label.getjLabel().setBounds(posX, posY, L_PERSO, H_PERSO);
		label.getjLabel().setIcon(new ImageIcon(PERSO + this.numPerso + etat + etape + "d" + orientation + EXTIMAGE));
		message.getjLabel().setBounds(posX - 10, posY + H_PERSO, L_PERSO + 0, H_MESSAGE);
		message.getjLabel().setText(PSEUDO + " : " + vie);
		this.jeuServeur.envoi(super.label);
		this.jeuServeur.envoi(message);

	}

	public void initPerso(String pseudo, int numPerso, Hashtable<Connexion, Joueur> lesJoueurs,ArrayList<Mur> lesMurs) {
		this.pseudo = pseudo;
		this.numPerso = numPerso;
		label = new Label(Label.getNbLabel(), new JLabel());
		Label.setNbLabel(Label.getNbLabel() + 1);
		jeuServeur.nouveauLabelJeu(label);
		label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);

		message = new Label(Label.getNbLabel(), new JLabel());
		Label.setNbLabel(Label.getNbLabel() + 1);
		message.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		message.getjLabel().setFont(new Font("Dialog", Font.PLAIN, 8));
		jeuServeur.nouveauLabelJeu(message);
		premierePosition(lesJoueurs, lesMurs);
		affiche(MARCHE, etape);
		boule = new Boule(jeuServeur);
		jeuServeur.envoi(boule.label);
		
	}

	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	private boolean toucheJoueur(Hashtable<Connexion, Joueur> lesJoueurs) {
		for (Joueur unJoueur : lesJoueurs.values()) {
			if (!unJoueur.equals(this)) {
				if (super.toucheObjet(unJoueur)) {
					return true;
				}
			}

		}
		return false;
	}

	private boolean toucheMur(ArrayList<Mur> lesMurs) {
		for (Mur unMur : lesMurs) {
			if (super.toucheObjet(unMur)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean toucheBonus(ArrayList<Bonus> lesBonus){
		for(Bonus unBonus : lesBonus){
			if(super.toucheObjet(unBonus)){
				return true;
			}
		}
		return false;
	}

	private void premierePosition(Hashtable<Connexion, Joueur> lesJoueurs, ArrayList<Mur> lesMurs) {
		label.getjLabel().setBounds(0, 0, L_PERSO, H_PERSO);
		do {
			super.posX = (int) Math.round(Math.random() * (L_ARENE - L_PERSO)); 
			
																				
			super.posY = (int) Math.round(Math.random() * (H_ARENE - H_PERSO - H_MESSAGE)); 
			
			
		} while (toucheJoueur(lesJoueurs) || toucheMur(lesMurs));
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	
	public int deplace(int action, int position, int orientation, int lepas, int max, Hashtable<Connexion, Joueur> lesJoueurs, ArrayList<Mur> lesMurs,  ArrayList<Bonus> lesBonus){
		this.orientation = orientation;
		int ancpos = position;
		position += lepas;
		if(position < 0){
			position = 0;
		}
		if(position > max){
			position = max;
		}
		if(action == 0 || action == 1){
			super.posX = position;
		}
		else{
			super.posY = position;
		}
		if(this.toucheMur(lesMurs) || this.toucheJoueur(lesJoueurs)){
			position = ancpos;
		}
		if(this.toucheBonus(lesBonus)){
			this.BonusActivation(lesBonus);
		}
		etape++;
		if(etape == NBETATSMARCHE){
			etape = 1;
		}
		return position;
	}
	
	public void BonusActivation(ArrayList<Bonus>lesBonus){
			lesBonus.get(0).activationBonus(this);
			lesBonus.remove(0);
			jeuServeur.afficheBonus();
		
	}
	public void action(int action, Hashtable<Connexion, Joueur> lesJoueurs, ArrayList<Mur> lesMurs, ArrayList<Bonus> lesBonus){
		switch(action){
		case GAUCHE :
			posX = deplace(action, super.posX, GAUCHE, -LEPAS, L_ARENE-(H_PERSO+H_MESSAGE),lesJoueurs, lesMurs, lesBonus);
			break;
		case DROITE:
			posX = deplace(action, super.posX, DROITE, LEPAS, L_ARENE-(H_PERSO+H_MESSAGE),lesJoueurs, lesMurs, lesBonus);
			break;
		case HAUT:
			posY = deplace(action, super.posY, orientation, -LEPAS, H_ARENE-(H_PERSO+H_MESSAGE),lesJoueurs, lesMurs, lesBonus);
			break;
		case BAS:
			posY = deplace(action, super.posY, orientation, LEPAS, H_ARENE-(H_PERSO+H_MESSAGE),lesJoueurs, lesMurs, lesBonus);
			break;
		case TIRE:
			if(!boule.getLabel().getjLabel().isVisible()){
			jeuServeur.envoi(FIGHT);
			boule.tireBoule(this, lesMurs, lesJoueurs);
			}
			break;
		}
		affiche(MARCHE,etape);
	}

	/**
	 * @return the boule
	 */
	public Boule getBoule() {
		return boule;
	}
	
	public Bonus getBonus(){
		return bonus;
	}

	/**
	 * @return the orientation
	 */
	public int getOrientation() {
		return orientation;
	}
	
	public void gainVie(){
		vie += GAIN;
	}
	
	public void ressucite(){
		vie = 10;
	}
	public void perteVie(){
		vie -= PERTE;
		if(vie < 0){
			vie = 0;
		}
	}
	
	public void setGainVie(int gain){
		vie += gain;
	}
	
	public boolean estMort(){
		if(vie == 0){
			return true;
		}
		return false;
	}
	
	

	public void departJoueur(){
		if(this.label != null){
		this.message.getjLabel().setVisible(false);
		super.label.getjLabel().setVisible(false);
		this.boule.getLabel().getjLabel().setVisible(false);
		jeuServeur.envoi(message);
		jeuServeur.envoi(label);
		jeuServeur.envoi(boule.getLabel());
		}
		}
	
}
