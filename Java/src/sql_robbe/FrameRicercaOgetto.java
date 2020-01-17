package sql_robbe;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameRicercaOgetto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private Driver controller;
	private JButton btnNewButton;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public FrameRicercaOgetto(Driver ctrl) {
		controller = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(261, 62, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton ricerca = new JButton("Cerca");
		ricerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String o =controller.ricercaVideogame(textField.getText()).toString();
				System.out.println(o);
			}
		});
		ricerca.setBounds(280, 197, 97, 25);
		contentPane.add(ricerca);
		
		btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String testo = "null";
				if(textField.getText()!="") {
					testo=textField_1.getText();
				}
				controller.AggiungiNuovo(textField.getText(),testo);
			}
		});
		btnNewButton.setBounds(66, 197, 97, 25);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(261, 117, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setBounds(142, 65, 56, 16);
		contentPane.add(lblCodice);
		
		JLabel lblCodice_1 = new JLabel("Codice");
		lblCodice_1.setBounds(142, 120, 56, 16);
		contentPane.add(lblCodice_1);
	}
}
