package modele;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;

public abstract class Bonus extends Objet implements Global {
	protected Label message;
	
	public Bonus(){	
		
		posY = (int)Math.round(Math.random() * (H_ARENE - H_BONUS)) ;
		posX = (int) Math.round(Math.random() * (L_ARENE - L_BONUS)) ;
		
		label = new Label(-1,new JLabel());
		label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);
		label.getjLabel().setBounds(posX, posY, L_BONUS, H_BONUS);
		
		BonusApparition bonusApp = new BonusApparition();
		bonusApp.start();
	}
	
	public abstract void activationBonus(Joueur joueur);
	
	public abstract void affiche(ArrayList<Bonus> lesBonus);
}
