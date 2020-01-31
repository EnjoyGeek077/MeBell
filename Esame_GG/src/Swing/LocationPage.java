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
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;

public class LocationPage extends JFrame {

    private JPanel contentPane;
    private Controller controller;

    private JLabel lblNomeLoc;
    private JLabel lblCategoria;
    private JLabel lblIndirizzo;
    private JLabel lblPiva;
    private JTextArea txtrDescrizione;
    private JTextArea txtrInfoServizi;
    private JLabel stella1;
    private JLabel stella2;
    private JLabel stella3;
    private JLabel stella4;
    private JLabel stella5;

    /**
     * Create the frame.
     */
    public LocationPage(Controller ctrl) {
	setTitle("Location Page");
	setMinimumSize(new Dimension(820, 482));
	controller=ctrl;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 820, 482);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));

	JPanel panelIMG = new JPanel();
	panelIMG.setBackground(new Color(0, 0, 0));

	JButton btnBack = new JButton("");
	btnBack.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON1.png")));
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON1.png")));
	    }
	});
	btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON1.png")));
	btnBack.setBorder(null);
	btnBack.setContentAreaFilled(false);
	btnBack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);
		controller.openHomePage();
	    }
	});

	lblNomeLoc = new JLabel("Location Name");
	lblNomeLoc.setForeground(Color.RED);
	lblNomeLoc.setFont(new Font("Arial", Font.BOLD, 20));

	JButton btnVediRecensioni = new JButton("");
	btnVediRecensioni.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON1.png")));
	    }
	});
	btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON1.png")));
	btnVediRecensioni.setBorder(null);
	btnVediRecensioni.setContentAreaFilled(false);

	txtrDescrizione = new JTextArea();
	txtrDescrizione.setRows(2);
	txtrDescrizione.setBackground(Color.WHITE);
	txtrDescrizione.setEditable(false);
	txtrDescrizione.setLineWrap(true);
	txtrDescrizione.setFont(new Font("Arial", Font.PLAIN, 16));
	txtrDescrizione.setText("Descrizione...");

	lblIndirizzo = new JLabel("Via, Civico, CAP, Comune");
	lblIndirizzo.setFont(new Font("Arial", Font.PLAIN, 16));

	txtrInfoServizi = new JTextArea();
	txtrInfoServizi.setFont(new Font("Arial", Font.PLAIN, 16));
	txtrInfoServizi.setText("Informazioni e servizi...");

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

	lblCategoria = new JLabel("Categoria:");
	lblCategoria.setFont(new Font("Arial", Font.BOLD, 14));
	
	lblPiva = new JLabel("P.IVA");
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panelIMG, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblIndirizzo, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
						.addContainerGap())
					.addComponent(lblNomeLoc, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblPiva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(stella1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stella2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stella3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stella4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stella5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblCategoria)))
						.addGap(240))))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addComponent(txtrDescrizione, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtrInfoServizi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 528, Short.MAX_VALUE)
						.addComponent(btnVediRecensioni, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addGap(21)))
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
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(stella5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(stella4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(stella3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(stella2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(stella1))
							.addComponent(lblCategoria))
						.addGap(23)
						.addComponent(lblPiva)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtrDescrizione, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtrInfoServizi, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addComponent(btnVediRecensioni)
					.addComponent(btnBack))
				.addGap(13))
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
    
    public void setLocationPage(String nome,String categoria,String indirizzo,String piva,float voto,String descrizione,String informazioni,String servizi) {
	lblNomeLoc.setText(nome);
	lblCategoria.setText("Categoria: "+categoria);
	lblIndirizzo.setText(indirizzo);
	lblPiva.setText("P.IVA: "+piva);
	txtrDescrizione.setText(descrizione);
	txtrInfoServizi.setText(informazioni+"\n"+servizi);
	
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
