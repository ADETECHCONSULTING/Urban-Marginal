package modele;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;
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
		label.getjLabel().setBounds(new Rectangle(posX, posY, L_PERSO, H_PERSO));
		label.getjLabel().setIcon(new ImageIcon(PERSO + this.numPerso + MARCHE + etape + "d" + orientation + EXTIMAGE));
		message.getjLabel().setBounds(posX-10, posY+H_PERSO, L_PERSO+20, H_MESSAGE);
		message.getjLabel().setText(PSEUDO +" : "+ vie);
		
		jeuServeur.envoi(super.label);
		jeuServeur.envoi(this.message);
	}
	
		
	public void initPerso(String pseudo, int numPerso, Hashtable<Connexion, Joueur> lesJoueurs, ArrayList<Mur> lesMurs){
		System.out.println("testInitPerso");
		this.pseudo = pseudo;
		this.numPerso = numPerso;
		label = new Label(Label.nbLabel+1,new JLabel());
		//Label.setNbLabel(Label.getNbLabel()+1);
		label.getjLabel().setHorizontalTextPosition(SwingConstants.CENTER);
		label.getjLabel().setVerticalTextPosition(SwingConstants.CENTER);
		
		
		message = new Label(Label.nbLabel+1, new JLabel());
		//Label.setNbLabel(Label.getNbLabel()+1);
		message.getjLabel().setHorizontalTextPosition(SwingConstants.CENTER);
		message.getjLabel().setFont(new Font("Dialog", Font.PLAIN, 8));
		premierePosition(lesJoueurs, lesMurs);
		System.out.println("posX = "+ posX);
		affiche(MARCHE,etape);
		jeuServeur.nouveauLabelJeu(message);
		jeuServeur.nouveauLabelJeu(label);
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
	

	
}
