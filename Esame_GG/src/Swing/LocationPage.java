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

public class LocationPage extends JFrame {

    private JPanel contentPane;
    private Controller controller;
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
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    setVisible(false);
		    controller.openHomePage();
		}
	});
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panelIMG, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(431, Short.MAX_VALUE))
			.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
				.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
				.addContainerGap())
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panelIMG, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
				.addComponent(btnBack))
	);
	panelIMG.setLayout(null);
	
	JLabel labelImmagineLocation = new JLabel("");
	labelImmagineLocation.setBounds(10, 11, 176, 161);
	panelIMG.add(labelImmagineLocation);
	labelImmagineLocation.setIcon(new ImageIcon("C:\\Users\\Universit\u00E0 A.G\\Downloads\\test.png"));
	
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
 
}
