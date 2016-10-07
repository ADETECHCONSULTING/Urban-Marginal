package vue;

<<<<<<< HEAD

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntreeJeu extends JFrame {

	private JPanel contentPane;
	private JTextField txtIp;
	private Controle controle;
	
	private void btnStart_clic(){
		controle.evenementVue(this, "serveur");
	}
	
	private void btnConnect_clic(){
		controle.evenementVue(this,txtIp.getText());
	}



	/**
	 * Création de la fenêtre
	 * Create the frame.
	 */
	public EntreeJeu(Controle controle) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStart = new JLabel("Start a server :");
		lblStart.setBounds(76, 69, 101, 14);
		contentPane.add(lblStart);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnStart_clic();
			}
		});
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStart.setBounds(240, 65, 89, 23);
		contentPane.add(btnStart);
		
		JLabel lblConnectToAn = new JLabel("Connect an existing server :");
		lblConnectToAn.setBounds(76, 132, 158, 14);
		contentPane.add(lblConnectToAn);
		
		JLabel lblIp = new JLabel("IP server :");
		lblIp.setBounds(76, 192, 81, 14);
		contentPane.add(lblIp);
		
		txtIp = new JTextField();
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(134, 189, 86, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnConnect_clic();
			}
		});
		btnConnect.setBounds(240, 188, 89, 23);
		contentPane.add(btnConnect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(240, 227, 89, 23);
		contentPane.add(btnExit);
		
=======
import controleur.Controle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class EntreeJeu extends JFrame {

	private JPanel contentPane;
	private Controle controle;
	private JTextField txtIp;

	/**
	 * Launch the application.
	 */

	private void btnStart_clic() {
		controle.evenementVue(this, "serveur");
	}

	private void btnExit_clic() {
		System.exit(0);

	}

	private void btnConnect_clic() {
		controle.evenementVue(this, txtIp.getText());

	}

	/**
	 * Create the frame.
	 * 
	 * @param controle
	 */
	public EntreeJeu(Controle controle) {
		setTitle("Urban Marginal TP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Start a server :");
		lblNewLabel.setBounds(22, 29, 178, 28);
		contentPane.add(lblNewLabel);

		JLabel lblConnectToAn = new JLabel("Connect to an existing server :");
		lblConnectToAn.setBounds(22, 68, 189, 34);
		contentPane.add(lblConnectToAn);

		JLabel lblNewLabel_1 = new JLabel("Ip Server :");
		lblNewLabel_1.setBounds(22, 93, 80, 34);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnStart_clic();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(205, 32, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Connect");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConnect_clic();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(205, 99, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExit_clic();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(205, 158, 89, 23);
		contentPane.add(btnNewButton_2);

		txtIp = new JTextField();
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(85, 100, 86, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);

>>>>>>> branch 'master' of https://github.com/gmanzola/TP-URBAN-MARGINAL.git
		this.controle = controle;
	}
}
