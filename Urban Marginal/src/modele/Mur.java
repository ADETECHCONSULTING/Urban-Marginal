package modele;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;

public class Mur extends Objet implements Global {
<<<<<<< HEAD
	
	public Mur(){
		posX = (int)Math.round(Math.random()*(L_ARENE-L_MUR));
		posY = (int)Math.round(Math.random()*(H_ARENE-H_MUR));
		
		label = new Label(-1, new JLabel());
		label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);
		label.getjLabel().setBounds(posX, posY, L_MUR, H_MUR);
		label.getjLabel().setIcon(new ImageIcon(MUR));
			
	}

=======

	
public Mur(){
	
	posY = (int)Math.round(Math.random() * (H_ARENE - H_MUR)) ;
	posX = (int) Math.round(Math.random() * (L_ARENE - L_MUR)) ;
	
	label = new Label(-1,new JLabel());
	label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
	label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);
	label.getjLabel().setBounds(posX, posY, L_MUR, H_MUR);
	label.getjLabel().setIcon(new ImageIcon(MUR));
	
}
>>>>>>> branch 'master' of https://github.com/gmanzola/TP-URBAN-MARGINAL.git
}
