package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Utility.ModelloTabella;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class HomePage extends JFrame {

    private JPanel contentPane;
    private Controller controller;
    ModelloTabella model= new ModelloTabella();
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

	JComboBox<String> comboBox_FiltroComune = new JComboBox<String>();
	comboBox_FiltroComune.setModel(new DefaultComboBoxModel(new String[] {"Tutti", "Napoli"}));

	JComboBox<String> comboBox_FiltroTipologia = new JComboBox<String>();
	comboBox_FiltroTipologia.setModel(new DefaultComboBoxModel(new String[] {"Tutti", "Alloggio", "Attrazione", "Ristorante"}));

	textNomeLocale = new JTextField();
	textNomeLocale.setColumns(10);

	JLabel lblComune = new JLabel("Comune");

	JLabel lblTipologia = new JLabel("Tipologia");

	JLabel lblNomeLocale = new JLabel("Nome Locale");

	JButton btnCerca = new JButton("");
	btnCerca.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/CercaICON1.png")));
	btnCerca.setBorder(null);
	btnCerca.setContentAreaFilled(false);
	btnCerca.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		String filtro_tipologia=comboBox_FiltroTipologia.getSelectedItem().toString();
		String filtro_comune=comboBox_FiltroComune.getSelectedItem().toString();
		String filtro_nome=textNomeLocale.getText();

		int filtro_media_voto=5;

		controller.getFilterLocation(filtro_tipologia, filtro_comune, filtro_nome);
		controller.aggiornaTable(model,filtro_media_voto);
	    }
	});
	btnCerca.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			btnCerca.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/CercaICON3.png")));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCerca.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/CercaICON1.png")));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCerca.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/CercaICON1.png")));
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCerca.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/CercaICON2.png")));
		}
	});

	JLabel lblMediaVoti = new JLabel("Media voti");
	
	JButton btnNewButton = new JButton("New button");
	btnCerca.setBorder(null);
	btnCerca.setContentAreaFilled(false);
	
	
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(10)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
					.addComponent(lblComune)
					.addComponent(lblFiltri)
					.addComponent(lblTipologia)
					.addComponent(lblNomeLocale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblMediaVoti, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(19)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(comboBox_FiltroTipologia, 0, 133, Short.MAX_VALUE)
					.addComponent(comboBox_FiltroComune, Alignment.TRAILING, 0, 133, Short.MAX_VALUE)
					.addComponent(textNomeLocale, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
				.addContainerGap())
			.addGroup(gl_contentPane.createSequentialGroup()
				.addContainerGap(397, Short.MAX_VALUE)
				.addComponent(btnNewButton)
				.addGap(35)
				.addComponent(btnCerca)
				.addContainerGap())
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
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
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblMediaVoti)
						.addGap(90)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addComponent(btnCerca)
					.addComponent(btnNewButton))
				.addGap(5))
	);

	JTable table = new JTable();
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    controller.setCellNotEditable(table, model);
		}
	});
	model.addColumn("Location");
	model.addColumn("ID");
	model.addColumn("Nome");
	model.addColumn("Comune");
	model.addColumn("Media Voti");
	
	
	table.setModel(model);
	table.setRowHeight(25);
	
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
