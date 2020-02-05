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
import javax.swing.ImageIcon;

public class VediRecensioni extends JFrame {

    private JPanel contentPane;
    private Controller controller;
    ModelloTabella model= new ModelloTabella();
    private JTable table;
    private JTextArea textAreaRecensione;
    private int filtro_media_voto;

    public VediRecensioni(Controller ctrl) {
	setTitle("Vedi Recensioni");
	setMinimumSize(new Dimension(522, 300));
	controller=ctrl;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 522, 366);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));

	JScrollPane scrollPaneTabellaRecensioni = new JScrollPane();

	JButton btnInserisciNuovaRecensione = new JButton("");
	btnInserisciNuovaRecensione.setBorder(null);
	btnInserisciNuovaRecensione.setContentAreaFilled(false);
	btnInserisciNuovaRecensione.setSelectedIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/InserisciNuovaRecCON1.png")));
	btnInserisciNuovaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/InserisciNuovaRecCON1.png")));
	btnInserisciNuovaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnInserisciNuovaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(!controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.openInserisciDialog();
		    textAreaRecensione.setText("");
		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato ha già recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JButton btnModificaRecensione = new JButton("");
	btnModificaRecensione.setBorder(null);
	btnModificaRecensione.setContentAreaFilled(false);
	btnModificaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/ModificaRecensioneICON1.png")));
	btnModificaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnModificaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.visualizzaOldRecensioneInDialog();
		    controller.openModificaDialog();
		    textAreaRecensione.setText("");
		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato non ha recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JButton btnEliminaRecensione = new JButton("");
	btnEliminaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/EliminaRecensioneICON1.png")));
	btnEliminaRecensione.setBorder(null);
	btnEliminaRecensione.setContentAreaFilled(false);
	btnEliminaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnEliminaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.openEliminaDialog();
		    textAreaRecensione.setText("");
		    
		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato non ha recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JScrollPane scrollPaneTestoRecensione = new JScrollPane();
	
	JLabel lblFiltri = new JLabel("Filtri");
	
	JButton btnTornaAllaLocation = new JButton("");
	btnTornaAllaLocation.setBorder(null);
	btnTornaAllaLocation.setContentAreaFilled(false);
	btnTornaAllaLocation.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/TornaAllaLocICON1.png")));
	btnTornaAllaLocation.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			controller.openLocationPage();
			textAreaRecensione.setText("");
		}
	});
	
	JButton btnStella1 = new JButton("");
	JButton btnStella2 = new JButton("");
	JButton btnStella3 = new JButton("");
	JButton btnStella4 = new JButton("");
	JButton btnStella5 = new JButton("");
	
	btnStella1.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		setFiltro_media_voto(1);

	    }
	});

	btnStella2.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		setFiltro_media_voto(2);

	    }
	});

	btnStella3.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		setFiltro_media_voto(3);

	    }
	});


	btnStella4.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		setFiltro_media_voto(4);

	    }
	});

	btnStella5.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));

		setFiltro_media_voto(5);

	    }
	});
	
	btnStella1.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella1.png")));
	btnStella1.setContentAreaFilled(false);
	btnStella1.setBorder(null);

	btnStella2.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella1.png")));
	btnStella2.setContentAreaFilled(false);
	btnStella2.setBorder(null);
	
	btnStella3.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella1.png")));
	btnStella3.setContentAreaFilled(false);
	btnStella3.setBorder(null);
	
	btnStella4.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella1.png")));
	btnStella4.setContentAreaFilled(false);
	btnStella4.setBorder(null);
	
	btnStella5.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella1.png")));
	btnStella5.setContentAreaFilled(false);
	btnStella5.setBorder(null);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/ConfermaICON1.png")));
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(scrollPaneTabellaRecensioni, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(btnEliminaRecensione))
						.addComponent(btnModificaRecensione, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
					.addComponent(btnInserisciNuovaRecensione)
					.addComponent(btnTornaAllaLocation, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
				.addContainerGap())
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(scrollPaneTestoRecensione, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFiltri, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnStella1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnStella2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnStella3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnStella4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnStella5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(label)
						.addGap(10))))
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				.addGap(11)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					.addComponent(scrollPaneTabellaRecensioni, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(btnEliminaRecensione)
						.addGap(7)
						.addComponent(btnModificaRecensione)
						.addGap(7)
						.addComponent(btnInserisciNuovaRecensione)
						.addGap(10)
						.addComponent(btnTornaAllaLocation)))
				.addGap(19)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					.addComponent(scrollPaneTestoRecensione, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblFiltri)
						.addGap(12)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(btnStella1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnStella2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnStella3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnStella4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnStella5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
						.addComponent(label)))
				.addContainerGap())
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
		controller.getTestoRecensioneDaTable(table);
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
	table.setModel(model);
    }

	public int getFiltro_media_voto() {
		return filtro_media_voto;
	}

	public void setFiltro_media_voto(int filtro_media_voto) {
		this.filtro_media_voto = filtro_media_voto;
	}
}
