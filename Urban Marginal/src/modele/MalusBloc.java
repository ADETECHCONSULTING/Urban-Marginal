package modele;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controleur.Global;

public class MalusBloc extends Bonus implements Global {
	private Joueur joueur;
	public MalusBloc(){
		super();
		label.getjLabel().setIcon(new ImageIcon(MALUSBLOC));
	}

	@Override
	public void activationBonus(Joueur joueur) {
		//
	}

	@Override
	public void affiche(ArrayList<Bonus> lesBonus) {
		label.getjLabel().setBounds(posX, posY, L_BONUS, H_BONUS);
		label.getjLabel().setIcon(new ImageIcon(MALUSBLOC));
		
	}
}
