package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Carrello extends JFrame {

	private JPanel contentPane;
	private Driver controller;
	private JTable table;
	private JTextField textField;
		

	public Carrello(Driver ctrl) {
		controller = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Articolo", "Quantit\u00E0", "Prezzo"
			}
		));
		table.setBounds(26, 28, 292, 160);
		contentPane.add(table);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(36, 13, 56, 16);
		contentPane.add(lblNome);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E0");
		lblQuantit.setBounds(133, 13, 56, 16);
		contentPane.add(lblQuantit);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(330, 166, 107, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTotale = new JLabel("Totale");
		lblTotale.setBounds(350, 146, 56, 16);
		contentPane.add(lblTotale);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.apriInserimentoInCarrello();
			}
		});
		btnAggiungi.setBounds(12, 217, 97, 25);
		contentPane.add(btnAggiungi);
		
		JButton btnRimuovi = new JButton("Rimuovi");
		btnRimuovi.setBounds(121, 217, 97, 25);
		contentPane.add(btnRimuovi);
		
		JButton btnRimuoviAll = new JButton("Rimuovi All");
		btnRimuoviAll.setBounds(230, 217, 97, 25);
		contentPane.add(btnRimuoviAll);
		
		JButton btnPaga = new JButton("Paga");
		btnPaga.setBounds(335, 217, 105, 25);
		contentPane.add(btnPaga);
		
	}
	
	public void aggiungiArticoloInCarrello(String nome, String quantità, float prezzo) {
		int i=0;
		
		while(i<9 && table.getValueAt(i, 0)!=null && (table.getValueAt(i, 0)!=nome)) {
			i++;
			}
		
		if(i==10) {
			System.out.println("errore");
		}
		else if(table.getValueAt(i, 0)==null) {
			table.setValueAt(nome, i, 0);
			table.setValueAt(quantità, i, 1);
			table.setValueAt(prezzo, i, 2);
		}
		else if(table.getValueAt(i, 0)==nome) {
			
		}
	}
}