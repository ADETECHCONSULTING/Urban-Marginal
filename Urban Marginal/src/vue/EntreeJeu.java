package vue;


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
		
		this.controle = controle;
	}
}
