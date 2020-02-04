package SwingDialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InserisciRecensione extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Controller controller;
    
    public InserisciRecensione(Controller ctrl) {
	controller=ctrl;
	setUndecorated(true);
	setBounds(100, 100, 450, 300);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));
	panel.setBounds(0, 0, 450, 300);
	contentPanel.add(panel);
	panel.setLayout(null);
	
	JLabel lblInserisciRecensione = new JLabel("Inserisci Recensione");
	lblInserisciRecensione.setFont(new Font("Arial", Font.BOLD, 18));
	lblInserisciRecensione.setForeground(new Color(255, 255, 255));
	lblInserisciRecensione.setBounds(10, 11, 430, 14);
	panel.add(lblInserisciRecensione);
	
	JButton btnAnnulla = new JButton("Annulla");
	btnAnnulla.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    setVisible(false);
		    controller.openVediRecensioni();
		}
	});
	btnAnnulla.setBounds(351, 266, 89, 23);
	panel.add(btnAnnulla);
	
	JButton btnConferma = new JButton("Conferma");
	btnConferma.setBounds(252, 266, 89, 23);
	panel.add(btnConferma);
    }
}
