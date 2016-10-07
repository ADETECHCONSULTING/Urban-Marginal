package vue;

<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import controleur.Global;
import modele.Joueur;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class Arene extends JFrame implements Global {

	private JPanel contentPane;
	private JTextField txtSaisie;
	private JTextField txtChat;
	private JPanel jpnMurs;
	private JPanel jpnJeu;
	private Boolean client;
	private Controle controle;
	
	
	/**
	 * Create the frame.
	 */
	public Arene(String typeJeu, Controle controle) {
		this.controle = controle; 
		
		if(typeJeu == "client"){
			this.client = true;
		}
		else{
			this.client = false;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, L_ARENE+3*MARGE, H_ARENE+H_CHAT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jpnJeu = new JPanel();
		jpnJeu.setBounds(0, 0, L_ARENE, H_ARENE);
		jpnJeu.setOpaque(false);
		contentPane.add(jpnJeu);
		jpnJeu.setLayout(null);
		
		jpnMurs = new JPanel();
		jpnMurs.setBounds(0, 0, L_ARENE, H_ARENE);
		contentPane.add(jpnMurs);
		jpnMurs.setOpaque(false);
		jpnMurs.setLayout(null);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, L_ARENE, H_ARENE);
		lblFond.setIcon(new ImageIcon(FONDARENE));
		contentPane.add(lblFond);
		
		if (client) {
			txtSaisie = new JTextField();
			txtSaisie.setBounds(0, H_ARENE, L_ARENE, H_SAISIE);
			contentPane.add(txtSaisie);
			txtSaisie.setColumns(10);

			txtSaisie.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					txtSaisie_keyPressed(arg0);
				}
			});
		}

		JScrollPane jspChat = new JScrollPane();
		jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspChat.setBounds(0, H_ARENE + H_SAISIE, L_ARENE, H_CHAT - H_SAISIE - 7*MARGE);
		contentPane.add(jspChat);
		
		txtChat = new JTextField();
		jspChat.setViewportView(txtChat);
		txtChat.setColumns(10);
	}
	
	public void ajoutMur(JLabel objet){
		jpnMurs.add(objet);
		jpnMurs.repaint();
	}
	
	public void ajoutPanelMur(JPanel objet){
		jpnMurs.add(objet);
		jpnMurs.repaint();
		contentPane.requestFocus();
	}

	/**
	 * @return the jpnMurs
	 */
	public JPanel getJpnMurs() {
		return jpnMurs;
	}
	
	public void ajoutJoueur(JLabel unJoueur){
		jpnJeu.add(unJoueur);
		jpnJeu.repaint();
	}
	
	public void ajoutModifJoueur(int num, JLabel unLabel){
		try {
			System.out.println(this.jpnJeu);
			this.jpnJeu.remove(num);
		} catch (ArrayIndexOutOfBoundsException e) {}
			System.out.println(this.jpnJeu);
			this.jpnJeu.add(unLabel, num);
			this.jpnJeu.repaint();
	}
	
	private void txtSaisie_keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (txtSaisie.getText() != "") {
				controle.evenementVue(this, CHAT + SEPARE + txtSaisie.getText());
				txtSaisie.setText("");
			}
			contentPane.requestFocus();
		}
	}
	
	/**
	 * @return the txtChat
	 */
	public String getTxtChat() {
		return txtChat.getText();
	}
	
	public void remplaceChat(String rempChat){
		txtChat.setText(rempChat);
	}

	public void ajoutChat(String unePhrase){
		txtChat.setText(unePhrase+ "\r\n" + txtChat.getText());
	}
<<<<<<< master
=======
>>>>>>> f7892db Chat semi-fonctionnel
=======
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import controleur.Global;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Arene extends JFrame implements Global {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSaisie;
	private JTextArea txtChat;
	private JPanel jpnMurs;
	private JPanel jpnJeu;
	private boolean client;
	private Controle controle;

	/**
	 * Create the frame.
	 */
	public Arene(String typeJeu, Controle controle) {

		this.controle = controle;
		this.client = (typeJeu == "client");
		setTitle("Arena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, L_ARENE + 3 * MARGE, H_ARENE + H_CHAT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpnJeu = new JPanel();
		jpnJeu.setBounds(0, 0, L_ARENE, H_ARENE);
		jpnJeu.setOpaque(false);
		contentPane.add(jpnJeu);
		jpnJeu.setLayout(null);

		jpnMurs = new JPanel();
		jpnMurs.setBounds(0, 0, L_ARENE, H_ARENE);
		jpnMurs.setOpaque(false);
		contentPane.add(jpnMurs);
		jpnMurs.setLayout(null);

		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, L_ARENE, H_ARENE);
		lblFond.setIcon(new ImageIcon(FONDARENE));
		contentPane.add(lblFond);

		if (client) {
			txtSaisie = new JTextField();
			txtSaisie.setBounds(0, H_ARENE, L_ARENE, H_SAISIE);
			contentPane.add(txtSaisie);
			txtSaisie.setColumns(10);

			txtSaisie.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					txtSaisie_keyPressed(arg0);
				}
			});
		}

		JScrollPane jspChat = new JScrollPane();
		jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspChat.setBounds(0, H_ARENE + H_SAISIE, L_ARENE + H_CHAT, H_CHAT - H_SAISIE - 7 * MARGE);
		contentPane.add(jspChat);

		txtChat = new JTextArea();
		jspChat.setViewportView(txtChat);
	}

	public void ajoutMur(JLabel objet) {
		jpnMurs.add(objet);
		jpnMurs.repaint();

	}

	public void ajoutPanelMurs(JPanel objet) {
		jpnMurs.add(objet);
		jpnMurs.repaint();
		contentPane.requestFocus();

	}

	public JPanel getJpnMurs() {
		return jpnMurs;
	}

	public void ajoutJoueur(JLabel unJoueur) {
		jpnJeu.add(unJoueur);
		jpnJeu.repaint();

	}

	public void ajoutModifJoueur(int num, JLabel unLabel) {

		try {
			this.jpnJeu.remove(num);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		this.jpnJeu.add(unLabel, num);
		this.jpnJeu.repaint();
		// System.out.println(unLabel);
	}

	private void txtSaisie_keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (txtSaisie.getText() != "") {
				controle.evenementVue(this, CHAT + SEPARE + txtSaisie.getText());
				txtSaisie.setText("");
			}
			contentPane.requestFocus();
		}
	}
	
	public void ajoutChat(String unePhrase){
		txtChat.setText(unePhrase +"\r\n" + txtChat.getText());
	}

>>>>>>> branch 'master' of https://github.com/gmanzola/TP-URBAN-MARGINAL.git
=======
>>>>>>> 8d85b82 BUG
}
