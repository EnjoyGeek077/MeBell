package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Utility.ModelloTabella;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class VediRecensioni extends JFrame {

    private JPanel contentPane;
    private Controller controller;
    ModelloTabella model= new ModelloTabella();
    private JTable table;
    private JTextArea textAreaRecensione;

    public VediRecensioni(Controller ctrl) {
	setTitle("Vedi Recensioni");
	setMinimumSize(new Dimension(522, 300));
	controller=ctrl;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 522, 330);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));

	JScrollPane scrollPaneTabellaRecensioni = new JScrollPane();

	JButton btnInserisciNuovaRecensione = new JButton("Inserisci nuova recensione");
	btnInserisciNuovaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnInserisciNuovaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.openInserisciDialog();
		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato ha già recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JButton btnModificaRecensione = new JButton("Modifica recensione");
	btnModificaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnModificaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(!controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.openModificaDialog();
		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato non ha recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JButton btnEliminaRecensione = new JButton("Elimina recensione");
	btnEliminaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnEliminaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(!controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.openEliminaDialog();
		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato non ha recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JLabel lblFiltri = new JLabel("Filtri:");
	lblFiltri.setFont(new Font("Arial", Font.BOLD, 15));

	JScrollPane scrollPaneTestoRecensione = new JScrollPane();
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(scrollPaneTabellaRecensioni, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(lblFiltri, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
			.addContainerGap())
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(scrollPaneTestoRecensione, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
				.addComponent(btnInserisciNuovaRecensione)
				.addComponent(btnModificaRecensione, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnEliminaRecensione, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
			.addContainerGap())
		);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
				.addComponent(lblFiltri)
				.addComponent(scrollPaneTabellaRecensioni, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
			.addGap(18)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnEliminaRecensione)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModificaRecensione)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInserisciNuovaRecensione))
				.addComponent(scrollPaneTestoRecensione, 0, 0, Short.MAX_VALUE)))
		);

	textAreaRecensione = new JTextArea();
	textAreaRecensione.setEditable(false);
	textAreaRecensione.setLineWrap(true);
	textAreaRecensione.setRows(5);
	textAreaRecensione.setText("Recensione...");
	textAreaRecensione.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollPaneTestoRecensione.setViewportView(textAreaRecensione);

	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		controller.setCellNotEditable(table, model);
	    }
	});
	model.addColumn("Username");
	model.addColumn("Titolo");
	model.addColumn("Voto");

	table.setModel(model);
	table.setRowHeight(25);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scrollPaneTabellaRecensioni.setViewportView(table);

	JLabel lblRecensioni = new JLabel("Recensioni");
	lblRecensioni.setForeground(new Color(255, 255, 255));
	lblRecensioni.setFont(new Font("Arial", Font.BOLD, 18));
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addContainerGap()
			.addComponent(lblRecensioni)
			.addContainerGap(440, Short.MAX_VALUE))
		);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addComponent(lblRecensioni)
			.addContainerGap(37, Short.MAX_VALUE))
		);
	panel.setLayout(gl_panel);
	contentPane.setLayout(gl_contentPane);
    }

    public JTextArea getTextAreaRecensione() {
	return textAreaRecensione;
    }

    public void setTextAreaRecensione(String recensione) {
	this.textAreaRecensione.setText(recensione);
    }

    public ModelloTabella getModel() {
	return model;
    }

    public void setModel(ModelloTabella model) {
	this.model = model;
    }

}
