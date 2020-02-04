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

    private JPanel contentPanel = new JPanel();
    private Controller controller;
    private JLabel lblAvvertenza;

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
	    btnVaBene.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		controller.eliminaRecensione();
	    		setVisible(false);
	    		controller.update();
	    		controller.openVediRecensioni();
	    	}
	    });
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
	
	JPanel panelTitle = new JPanel();
	panelTitle.setBackground(new Color(255, 0, 0));
	panelTitle.setBounds(0, 0, 450, 46);
	panel.add(panelTitle);
	panelTitle.setLayout(null);
	
		JLabel lblEliminareLaRecensione = new JLabel("Eliminare la recensione?");
		lblEliminareLaRecensione.setBounds(116, 21, 217, 14);
		panelTitle.add(lblEliminareLaRecensione);
		lblEliminareLaRecensione.setForeground(new Color(255, 255, 255));
		lblEliminareLaRecensione.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		
		lblAvvertenza = new JLabel("");
		lblAvvertenza.setForeground(Color.WHITE);
		lblAvvertenza.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblAvvertenza.setBounds(10, 57, 430, 161);
		panel.add(lblAvvertenza);
    }
	

    public JLabel getLblAvvertenza() {
		return lblAvvertenza;
	}
	public void setLblAvvertenza(String text) {
		this.lblAvvertenza.setText(text);
	}
}
