package modele;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;
import outils.connexion.Connexion;

public class Joueur extends Objet implements Global {
	private String pseudo;
	private int numPerso;
	private Label message;
	public Joueur(){
		
	}
	
	public void initPerso(String pseudo, int numPerso, Hashtable<Connexion, Joueur> lesJoueurs, ArrayList<Mur> lesMurs){
		this.pseudo = pseudo;
		this.numPerso = numPerso;
		Label label = new Label(Label.getNbLabel(),new JLabel());
		Label.setNbLabel(Label.getNbLabel()+1);
		label.getjLabel().setHorizontalTextPosition(SwingConstants.CENTER);
		label.getjLabel().setVerticalTextPosition(SwingConstants.CENTER);
		
		message = new Label(Label.getNbLabel(), new JLabel());
		Label.setNbLabel(Label.getNbLabel()+1);
		message.getjLabel().setHorizontalTextPosition(SwingConstants.CENTER);
		message.getjLabel().setFont(new Font("Dialog", Font.PLAIN, 8));
		
		premierePosition(lesJoueurs, lesMurs);
	}
	
	public Label getMessage(){
		return message;
	}
	
	private boolean toucheJoueur (Hashtable<Connexion, Joueur> lesJoueurs){
		for(Joueur unJoueur : lesJoueurs.values()){
			if(!unJoueur.equals(this)){
				super.toucheObjet(unJoueur);
			}else{
				return true;
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
			super.posX = (int)Math.round(Math.random()*(L_PERSO-L_ARENE));
			super.posY = (int)Math.round(Math.random()*(H_PERSO - H_MESSAGE));
		}while(this.toucheJoueur(lesJoueurs) || this.toucheMur(lesMurs));
	}
}
