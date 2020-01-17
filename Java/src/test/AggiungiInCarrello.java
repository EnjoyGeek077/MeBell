package test;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggiungiInCarrello extends JFrame {

	private JPanel contentPane;
	private Driver controller;
	private JComboBox<String> comboBoxNomi;
	JComboBox<Integer> comboBoxQuantità;
	/**
	 * Create the frame.
	 */
	public AggiungiInCarrello(Driver ctrl) {
		controller=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxNomi = new JComboBox<String>();
		comboBoxNomi.setBounds(66, 31, 189, 22);
		contentPane.add(comboBoxNomi);
		
		
		comboBoxQuantità = new JComboBox<Integer>();
		comboBoxQuantità.setBounds(66, 83, 189, 22);
		contentPane.add(comboBoxQuantità);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(79, 13, 56, 16);
		contentPane.add(lblNome);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E0");
		lblQuantit.setBounds(76, 66, 56, 16);
		contentPane.add(lblQuantit);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.aggiungiOInCarrello(comboBoxNomi.getSelectedItem(),comboBoxQuantità.getSelectedItem());
				setVisible(false);
			}
		});
		btnAggiungi.setBounds(203, 142, 97, 25);
		contentPane.add(btnAggiungi);
		
	}

	public void updateCombobox() {
		for(Prodotto a:controller.getMagazzino()) {
			comboBoxNomi.addItem(a.getNome());
		}
	
	}
	public void setComboboxNumeri(){
		for(int i=0; i<=15;i++) {
			comboBoxQuantità.addItem(i);
		}
	}
}
