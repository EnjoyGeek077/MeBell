package SwingDialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class EliminaRecensione extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Controller controller;
    
    public EliminaRecensione(Controller ctrl) {
    	setUndecorated(true);
	controller=ctrl;
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
	{
		JButton btnVaBene = new JButton("V");
		btnVaBene.setBounds(10, 266, 89, 23);
		panel.add(btnVaBene);
	}
	
	JButton btnRifiuto = new JButton("X");
	btnRifiuto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    setVisible(false);
		    controller.openVediRecensioni();
		}
	});
	btnRifiuto.setBounds(351, 266, 89, 23);
	panel.add(btnRifiuto);
	
	JLabel lblEliminareLaRecensione = new JLabel("Eliminare la recensione?");
	lblEliminareLaRecensione.setForeground(new Color(255, 255, 255));
	lblEliminareLaRecensione.setFont(new Font("Arial", Font.BOLD, 18));
	lblEliminareLaRecensione.setBounds(10, 11, 430, 14);
	panel.add(lblEliminareLaRecensione);
    }
}
