package modele;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;

public class Joueur extends Objet implements Global {
	private String pseudo;
	private int numPerso;
	private Label message;
	public Joueur(){
		
	}
	
	public void initPerso(String pseudo, int numPerso){
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
		
		
	}
	
	public Label getMessage(){
		return message;
	}
}
