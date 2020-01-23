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

public class HomePage extends JFrame {

    private JPanel contentPane;
    private Controller controller;
    DefaultTableModel model= new DefaultTableModel();
   
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
	
	JButton btnNewButton = new JButton("New button");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(10)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
				.addGap(94)
				.addComponent(btnNewButton)
				.addGap(73))
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
						.addContainerGap())
					.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addComponent(btnNewButton)
						.addGap(36))))
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
