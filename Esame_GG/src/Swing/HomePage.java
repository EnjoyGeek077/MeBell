package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Utility.myTableCellRenderer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class HomePage extends JFrame {

    private JPanel contentPane;
    private Controller controller;
    DefaultTableModel model= new DefaultTableModel();
    private JTextField textNomeLocale;
    private final ButtonGroup buttonGroup = new ButtonGroup();
   
    public HomePage(Controller ctrl) {
    	setMinimumSize(new Dimension(651, 413));
    	setTitle("HomePage");
	controller = ctrl;
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 651, 413);
	contentPane = new JPanel();
	contentPane.setMinimumSize(new Dimension(651, 413));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));
	
	JScrollPane scrollPane = new JScrollPane();
	
	JLabel lblFiltri = new JLabel("Filtri:");
	lblFiltri.setFont(new Font("Arial Black", Font.BOLD, 18));
	
	JComboBox comboBox_FiltroComune = new JComboBox();
	comboBox_FiltroComune.setModel(new DefaultComboBoxModel(new String[] {"Tutti"}));
	
	JComboBox comboBox_FiltroTipologia = new JComboBox();
	comboBox_FiltroTipologia.setModel(new DefaultComboBoxModel(new String[] {"Tutti", "Alloggio", "Attrazione", "Ristorante"}));
	
	textNomeLocale = new JTextField();
	textNomeLocale.setColumns(10);
	
	JLabel lblComune = new JLabel("Comune");
	
	JLabel lblTipologia = new JLabel("Tipologia");
	
	JLabel lblNomeLocale = new JLabel("Nome Locale");
	
	JButton btnCerca = new JButton("Cerca");
	btnCerca.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			controller.getFilterLocation(comboBox_FiltroTipologia.getModel().getElementAt(comboBox_FiltroTipologia.getSelectedIndex()).toString(), comboBox_FiltroComune.getModel().getElementAt(comboBox_FiltroComune.getSelectedIndex()).toString(),textNomeLocale.getText());

		    controller.aggiornaTable(model);
		}
	});
	
	JLabel lblMediaVoti = new JLabel("Media voti");
	
	JCheckBox chckbxCrescente = new JCheckBox("Crescente");
	buttonGroup.add(chckbxCrescente);
	
	JCheckBox chckbxDecrescente = new JCheckBox("Decrescente");
	buttonGroup.add(chckbxDecrescente);
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(10)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblComune)
									.addComponent(lblFiltri)
									.addComponent(lblTipologia)
									.addComponent(lblNomeLocale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblMediaVoti, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(19)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(comboBox_FiltroTipologia, 0, 149, Short.MAX_VALUE)
									.addComponent(comboBox_FiltroComune, Alignment.TRAILING, 0, 149, Short.MAX_VALUE)
									.addComponent(textNomeLocale, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
							.addComponent(chckbxCrescente)
							.addComponent(chckbxDecrescente)))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnCerca, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap())
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblFiltri)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(52)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTipologia)
									.addComponent(comboBox_FiltroTipologia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNomeLocale)
									.addComponent(textNomeLocale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(16)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblComune)
									.addComponent(comboBox_FiltroComune, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addComponent(lblMediaVoti)
						.addGap(8)
						.addComponent(chckbxCrescente)
						.addGap(1)
						.addComponent(chckbxDecrescente)
						.addGap(24)
						.addComponent(btnCerca)))
				.addContainerGap())
	);
	
	JTable table = new JTable();
	model.addColumn("Location");
	model.addColumn("ID");
	model.addColumn("Nome");
	model.addColumn("Comune");
	model.addColumn("Media Voti");
	
	table.setModel(model);
	table.setRowHeight(25);
	table.getColumn("Location").setCellRenderer(new myTableCellRenderer());
	scrollPane.setViewportView(table);
	
	
	JLabel lblHomepage = new JLabel("HomePage");
	lblHomepage.setForeground(new Color(255, 255, 255));
	lblHomepage.setFont(new Font("Arial", Font.BOLD, 18));
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblHomepage)
				.addContainerGap(318, Short.MAX_VALUE))
	);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
				.addComponent(lblHomepage)
				.addContainerGap(42, Short.MAX_VALUE))
	);
	panel.setLayout(gl_panel);
	contentPane.setLayout(gl_contentPane);
    }
}
