package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textFirstN;
	private JTextField textLastN;
	private JTextField textUserN;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldR;
	private Controller controller;
	
	public Register(Controller ctrl) {
	    	controller = ctrl;
	    	
		setMinimumSize(new Dimension(400, 430));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 430);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(530, 430));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblFirstName = new JLabel("First name");

		JLabel lblLastName = new JLabel("Last name");

		JLabel lblUsername = new JLabel("Username");

		JLabel lblPassword = new JLabel("Password");

		JLabel lblReinsertPassword = new JLabel("Reinsert password");

		textFirstN = new JTextField();
		textFirstN.setColumns(10);

		textLastN = new JTextField();
		textLastN.setColumns(10);

		textUserN = new JTextField();
		textUserN.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("");

		passwordFieldR = new JPasswordField();
		passwordFieldR.setToolTipText("");

		JButton btnIscriviti = new JButton("Iscriviti");
		btnIscriviti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    	    
					if(controller.isPassEqual(passwordField.getPassword(),passwordFieldR.getPassword())){
				    		String pass = new String(passwordField.getPassword());
						controller.aggiungiUtente(textFirstN.getText(),textLastN.getText(),textUserN.getText(),pass);
						setVisible(false);
						controller.openLogin();
					}else {
					    	JOptionPane.showMessageDialog(null, "Le password non corrispondono", "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});

		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				controller.openLogin();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFirstName)
								.addComponent(lblLastName)
								.addComponent(lblUsername)
								.addComponent(lblPassword)
								.addComponent(lblReinsertPassword))
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordFieldR, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(textLastN, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(textFirstN, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(textUserN, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAnnulla)
							.addPreferredGap(ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
							.addComponent(btnIscriviti)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(textFirstN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(textLastN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textUserN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReinsertPassword)
						.addComponent(passwordFieldR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIscriviti)
						.addComponent(btnAnnulla))
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
