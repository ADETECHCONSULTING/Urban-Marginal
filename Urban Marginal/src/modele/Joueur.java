package modele;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;
<<<<<<< HEAD
import outils.connexion.Connexion;

public class Joueur extends Objet implements Global {
	private String pseudo;
	private int numPerso;
	private Label message;
	private JeuServeur jeuServeur;
	private int vie;
	private int orientation; //tourné vers la gauche (0) ou vers la droite (1)
	private int etape;		//numéro d'étape dans l'animation
	
	public Joueur(JeuServeur jeuServeur){
		this.jeuServeur = jeuServeur;
		this.vie = 10;
		this.etape = 1;
		this.orientation = DROITE;
		
	}
	
	public void affiche(String etat, int etape){
		label.getjLabel().setBounds(posX, posY, L_PERSO, H_PERSO);
		label.getjLabel().setIcon(new ImageIcon(PERSO + this.numPerso + MARCHE + etape + "d" + orientation + EXTIMAGE));
		message.getjLabel().setBounds(posX-10, posY+H_PERSO, L_PERSO+20, H_MESSAGE);
		message.getjLabel().setText(PSEUDO +" : "+ vie);
		jeuServeur.envoi(super.label);
		jeuServeur.envoi(this.message);
	}
	
		
	public void initPerso(String pseudo, int numPerso, Hashtable<Connexion, Joueur> lesJoueurs, ArrayList<Mur> lesMurs){
		this.pseudo = pseudo;
		this.numPerso = numPerso;
		label = new Label(Label.getNbLabel(),new JLabel());
		Label.setNbLabel(Label.getNbLabel()+1);
		label.getjLabel().setHorizontalTextPosition(SwingConstants.CENTER);
		label.getjLabel().setVerticalTextPosition(SwingConstants.CENTER);
		jeuServeur.nouveauLabelJeu(label);
		
		message = new Label(Label.nbLabel+1, new JLabel());
		Label.setNbLabel(Label.getNbLabel()+1);
		message.getjLabel().setHorizontalTextPosition(SwingConstants.CENTER);
		jeuServeur.nouveauLabelJeu(message);
		message.getjLabel().setFont(new Font("Dialog", Font.PLAIN, 8));
		premierePosition(lesJoueurs, lesMurs);
		
		affiche(MARCHE,etape);
		
		
	}
	
	public Label getMessage(){
		return message;
	}
	
	private boolean toucheJoueur (Hashtable<Connexion, Joueur> lesJoueurs){
		for(Joueur unJoueur : lesJoueurs.values()){
			if(!unJoueur.equals(this)){
				if(super.toucheObjet(unJoueur)){
					return true;
				};
			}		
		}
		return false;
		
	}
	
	private boolean toucheMur (ArrayList<Mur> lesMurs){
		for(Mur unMur : lesMurs){
			if(super.toucheObjet(unMur)){
				return true;
			}
		}
		return false;
	}
	
	private void premierePosition(Hashtable<Connexion, Joueur> lesJoueurs, ArrayList<Mur> lesMurs){
		this.getLabel().getjLabel().setBounds(0, 0, L_PERSO, H_PERSO);
		do{
			super.posX = (int)Math.round(Math.random()*(L_ARENE-L_PERSO));
			super.posY = (int)Math.round(Math.random()*(H_ARENE-(H_PERSO+H_MESSAGE)));
		}while(this.toucheJoueur(lesJoueurs) || this.toucheMur(lesMurs));
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	

	
}
=======
import outils.connexion.Connection;

public class Joueur extends Objet implements Global {

	private String pseudo;
	private int numPerso;
	private Label message;
	private JeuServeur jeuServeur;
	private int vie;
	private int etape;
	private int orientation;

	public Joueur(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		vie = 10;
		etape = 1; // numéro d'étape dans l'animation
		orientation = DROITE;
	}

	public void affiche(String etat, int etape) {
		label.getjLabel().setBounds(posX, posY, L_PERSO, H_PERSO);
		label.getjLabel().setIcon(new ImageIcon(PERSO + this.numPerso + etat + etape + "d" + orientation + EXTIMAGE));
		message.getjLabel().setBounds(posX - 10, posY + H_PERSO, L_PERSO + 0, H_MESSAGE);
		message.getjLabel().setText(PSEUDO + " : " + vie);
		this.jeuServeur.envoi(super.label);
		this.jeuServeur.envoi(message);

	}

	public void initPerso(String pseudo, int numPerso, Hashtable<Connection, Joueur> lesJoueurs,
			ArrayList<Mur> lesMurs) {

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
	}

	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	private boolean toucheJoueur(Hashtable<Connection, Joueur> lesJoueurs) {
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

	private void premierePosition(Hashtable<Connection, Joueur> lesJoueurs, ArrayList<Mur> lesMurs) {
		label.getjLabel().setBounds(0, 0, L_PERSO, H_PERSO);
		do {
			super.posX = (int) Math.round(Math.random() * (L_ARENE - L_PERSO)); 
			// on enleve les dimensions du perso pour ne pas qu'il sorte de l'arene
																				
			super.posY = (int) Math.round(Math.random() * (H_ARENE - H_PERSO - H_MESSAGE)); 
			// on enleve la hauteur du message sous le perso
			
		} while (toucheJoueur(lesJoueurs) || toucheMur(lesMurs));
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
}
>>>>>>> branch 'master' of https://github.com/gmanzola/TP-URBAN-MARGINAL.git
