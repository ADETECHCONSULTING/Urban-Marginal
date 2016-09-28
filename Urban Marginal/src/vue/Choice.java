package vue;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import controleur.Global;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Choice extends JFrame implements Global {

	private JPanel contentPane;
	private JTextField txtPseudo;
	private int numPerso;
	private JLabel lblPersonnage;
	private Controle controle;

	/**
	 * Create the frame.
	 */
	public Choice(Controle controle) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 416, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblPrecedent_clic();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale();
			}
		});
		lblPrecedent.setBounds(59, 143, 36, 44);
		contentPane.add(lblPrecedent);

		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale();
			}
		});
		lblSuivant.setBounds(298, 143, 36, 44);
		contentPane.add(lblSuivant);

		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale();
			}
		});
		lblGo.setBounds(308, 198, 70, 65);
		contentPane.add(lblGo);

		txtPseudo = new JTextField();
		txtPseudo.setBounds(143, 243, 119, 22);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
				lblPersonnage = new JLabel("");
				lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
				lblPersonnage.setBounds(143, 116, 119, 116);
				contentPane.add(lblPersonnage);

		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		lblFond.setIcon(new ImageIcon(FONDCHOIX));
		contentPane.add(lblFond);
		this.controle = controle;
		txtPseudo.requestFocus();
		numPerso = 1;
		affichePerso();
	}

	public void lblPrecedent_clic() {
		numPerso--;
		
		if(numPerso == 0){
			numPerso = NBPERSOS;
		}
		affichePerso();
	}

	public void lblSuivant_clic() {	
			if(numPerso == NBPERSOS){
				numPerso = 0;
			}
			numPerso++;
			affichePerso();
	}

	public void lblGo_clic() {
		if(txtPseudo.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Il faut entrer un pseudo");
			txtPseudo.requestFocus();
		}
		else{
			controle.evenementVue(this, PSEUDO+SEPARE+txtPseudo.getText()+SEPARE+numPerso);
		}

	}

	private void souris_normale() {
		Cursor cursor;
		contentPane.setCursor(cursor = new Cursor(Cursor.DEFAULT_CURSOR));
	}

	private void souris_doigt() {
		Cursor cursor;
		contentPane.setCursor(cursor = new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void affichePerso(){
		lblPersonnage.setIcon(new ImageIcon(PERSO + numPerso + MARCHE + 1 + "d" + DROITE + EXTIMAGE));
		
	}
	
}
