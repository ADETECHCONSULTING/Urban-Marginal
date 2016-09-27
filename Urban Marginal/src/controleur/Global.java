package controleur;

public interface Global {
	int PORT = 6666;
	String SEPARATOR = "//";
	String CHEMIN = "media" + SEPARATOR;
	String CHEMINFONDS = CHEMIN + "fonds" + SEPARATOR;
	String FONDCHOIX = CHEMINFONDS + "fondchoix.jpg";
	int GAUCHE = 0; //direction
	int DROITE = 1; //direction
	String CHEMINPERSO = CHEMIN + "personnages" + SEPARATOR;
	String PERSO = CHEMINPERSO + "perso";
	String EXTIMAGE = ".gif";
	String MARCHE = "marche"; //ETATS
	String BLESSE = "touche"; //ETATS
	String MORT = "mort";
	int NBPERSOS = 3; // nombre de personnages
	int H_PERSO = 44; //taille de l'image du personnage
	int L_PERSO = 39; 
	String SEPARE = "~";
	int PSEUDO = 0;
}
