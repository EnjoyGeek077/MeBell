package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggiungiInMagazzino extends JFrame {

	private JPanel contentPane;
	private JTextField nomeAdd;
	private JTextField codAdd;
	private JTextField prezzoAdd;
	private Driver controller;
	

	/**
	 * Create the frame.
	 */
	public AggiungiInMagazzino(Driver ctrl) {
		controller = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 29, 56, 16);
		contentPane.add(lblNome);
		
		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setBounds(12, 76, 56, 16);
		contentPane.add(lblCodice);
		
		JLabel lblQuantit = new JLabel("Prezzo");
		lblQuantit.setBounds(12, 131, 56, 16);
		contentPane.add(lblQuantit);
		
		nomeAdd = new JTextField();
		nomeAdd.setBounds(113, 26, 181, 22);
		contentPane.add(nomeAdd);
		nomeAdd.setColumns(10);
		
		codAdd = new JTextField();
		codAdd.setBounds(113, 73, 181, 22);
		contentPane.add(codAdd);
		codAdd.setColumns(10);
		
		prezzoAdd = new JTextField();
		prezzoAdd.setBounds(113, 128, 116, 22);
		contentPane.add(prezzoAdd);
		prezzoAdd.setColumns(10);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(controllaEsattezzaInserimento(nomeAdd.getText(),codAdd.getText(),prezzoAdd.getText())) {
					nomeAdd.setText("");
					codAdd.setText("");
					prezzoAdd.setText("");
				}
			}
		});
		btnAggiungi.setBounds(323, 192, 97, 25);
		contentPane.add(btnAggiungi);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				controller.TerminaInserimentoArticoli();
			}
		});
		btnEsci.setBounds(214, 192, 97, 25);
		contentPane.add(btnEsci);
	}
	public boolean controllaEsattezzaInserimento(String n, String c, String p) {
		try {
			Float d = new Float(p);
			controller.addOnMagazzino(n, c, d);
			JOptionPane.showMessageDialog(new JFrame(), "inserimento completato", "Inserimento",
			        JOptionPane.INFORMATION_MESSAGE);
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Inserire Valori Corretti", "Errore Inserimento",
			        JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
