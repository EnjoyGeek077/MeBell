package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class LocationPage extends JFrame {

    private JPanel contentPane;
    private Controller controller;
    
    JLabel lblNomeLoc;
    JLabel lblIndirizzo;
    JTextArea txtrDescrizione;
    JTextArea txtrServizi;
    JLabel stella1;
    JLabel stella2;
    JLabel stella3;
    JLabel stella4;
    JLabel stella5;
    
    /**
     * Create the frame.
     */
    public LocationPage(Controller ctrl) {
    	setMinimumSize(new Dimension(659, 482));
	controller=ctrl;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 659, 482);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));
	
	JPanel panelIMG = new JPanel();
	panelIMG.setBackground(new Color(0, 0, 0));
	
	JButton btnBack = new JButton("Indietro");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    setVisible(false);
		    controller.openHomePage();
		}
	});
	
	lblNomeLoc = new JLabel("Location");
	lblNomeLoc.setFont(new Font("Arial", Font.BOLD, 20));
	
	JButton btnVediRecensioni = new JButton("Vedi recensioni");
	
	txtrDescrizione = new JTextArea();
	txtrDescrizione.setRows(2);
	txtrDescrizione.setBackground(Color.WHITE);
	txtrDescrizione.setEditable(false);
	txtrDescrizione.setLineWrap(true);
	txtrDescrizione.setFont(new Font("Arial", Font.PLAIN, 16));
	txtrDescrizione.setText("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
	
	lblIndirizzo = new JLabel("Via xxxxx n xx Citta xxxxx CAP xxxxx");
	lblIndirizzo.setFont(new Font("Arial", Font.PLAIN, 16));
	
	txtrServizi = new JTextArea();
	txtrServizi.setFont(new Font("Arial", Font.PLAIN, 16));
	txtrServizi.setText("Servizio1, servizio2, servizio3");
	
	stella1 = new JLabel("");
	stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	
	stella2 = new JLabel("");
	stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	
	stella3 = new JLabel("");
	stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	
	stella4 = new JLabel("");
	stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	
	stella5 = new JLabel("");
	stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panelIMG, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(lblNomeLoc, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(stella1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stella2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stella3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stella4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stella5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblIndirizzo, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
						.addContainerGap())))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
				.addComponent(btnVediRecensioni, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
			.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addComponent(txtrServizi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
					.addComponent(txtrDescrizione, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
				.addGap(26))
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(panelIMG, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblNomeLoc, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblIndirizzo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(stella5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(stella4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(stella3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(stella2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(stella1))))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtrDescrizione, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtrServizi, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnBack)
					.addComponent(btnVediRecensioni)))
	);
	panelIMG.setLayout(null);
	
	JLabel labelImmagineLocation = new JLabel("");
	labelImmagineLocation.setBounds(10, 11, 176, 161);
	panelIMG.add(labelImmagineLocation);
	
	JLabel lblLocationPage = new JLabel("Location Page");
	lblLocationPage.setForeground(new Color(255, 255, 255));
	lblLocationPage.setFont(new Font("Arial", Font.BOLD, 18));
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblLocationPage)
				.addContainerGap(493, Short.MAX_VALUE))
	);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
				.addComponent(lblLocationPage)
				.addContainerGap(39, Short.MAX_VALUE))
	);
	panel.setLayout(gl_panel);
	contentPane.setLayout(gl_contentPane);
    }
    public void setLocationPage(String nome,String indirizzo,int voto,String descrizione,String servizi) {
    	lblNomeLoc.setText(nome);
    	lblIndirizzo.setText(indirizzo);
    	txtrDescrizione.setText(descrizione);
        txtrServizi.setText(servizi);
        if(voto<1) {
        	stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        }else if(voto<2) {
        	stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        }else if(voto<3) {
        	stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        }else if(voto<4) {
        	stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        	stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        }else if(voto<5) {
        	stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
        }else if(voto==5) {
        	stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        	stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
        }
        	
        
    }
}
