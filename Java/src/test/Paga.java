package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Paga extends JFrame {

	private JPanel contentPane;
	private JTextField dovuto;
	private JTextField versato;
	private JTextField daVersare;
	double importoD,importoDaVersare,importoVersato=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paga frame = new Paga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Paga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JCheckBox rimuoviEuro = new JCheckBox("Rimuovi \u20AC");
		rimuoviEuro.setSelected(true);
		rimuoviEuro.setBounds(10, 59, 113, 23);
		contentPane.add(rimuoviEuro);
		
		JButton b5 = new JButton("5\u20AC");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressioneEuro(5,rimuoviEuro.isSelected());
			}
		});
		
		b5.setBounds(10, 157, 68, 23);
		contentPane.add(b5);
		
		JButton b10 = new JButton("10\u20AC");
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressioneEuro(10,rimuoviEuro.isSelected());
			}
		});
		b10.setBounds(10, 123, 68, 23);
		contentPane.add(b10);
		
		JButton b20 = new JButton("20\u20AC");
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressioneEuro(20, rimuoviEuro.isSelected());
			}
		});
		b20.setBounds(10, 89, 68, 23);
		contentPane.add(b20);
		
		JButton b2 = new JButton("2\u20AC");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressioneEuro(2, rimuoviEuro.isSelected());
			}
		});
		b2.setBounds(88, 89, 68, 23);
		contentPane.add(b2);
		
		JButton b1 = new JButton("1\u20AC");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressioneEuro(1, rimuoviEuro.isSelected());
			}
		});
		b1.setBounds(88, 123, 68, 23);
		contentPane.add(b1);
		
		JButton b50c = new JButton("0.50\u20AC");
		b50c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressioneEuro(0.50, rimuoviEuro.isSelected());
			}
		});
		b50c.setBounds(88, 157, 68, 23);
		contentPane.add(b50c);
		
		JButton b20c = new JButton("0.20\u20AC");
		b20c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressioneEuro(0.20, rimuoviEuro.isSelected());
			}
		});
		b20c.setBounds(166, 123, 68, 23);
		contentPane.add(b20c);
		
		JButton b10c = new JButton("0.10\u20AC");
		b10c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressioneEuro(0.10, rimuoviEuro.isSelected());
			}
		});
		b10c.setBounds(166, 157, 68, 23);
		contentPane.add(b10c);
		
		JButton paga = new JButton("Paga");
		paga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(importoVersato==importoD) {
					
				}
			}
		});
		paga.setBounds(330, 157, 89, 23);
		contentPane.add(paga);
		
		JLabel lblNewLabel = new JLabel("Importo dovuto");
		lblNewLabel.setBounds(190, 11, 113, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Importo versato");
		lblNewLabel_1.setBounds(190, 36, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Importo da versare");
		lblNewLabel_2.setBounds(190, 61, 113, 14);
		contentPane.add(lblNewLabel_2);
		
		dovuto = new JTextField();
		dovuto.setText("0");
		dovuto.setEditable(false);
		dovuto.setBounds(313, 8, 106, 20);
		contentPane.add(dovuto);
		dovuto.setColumns(10);
		
		versato = new JTextField();
		versato.setText("0");
		versato.setEditable(false);
		versato.setBounds(313, 33, 106, 20);
		contentPane.add(versato);
		versato.setColumns(10);
		
		daVersare = new JTextField();
		daVersare.setText("0");
		daVersare.setEditable(false);
		daVersare.setBounds(313, 58, 106, 20);
		contentPane.add(daVersare);
		daVersare.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pagamento(200);
			}
		});
		btnNewButton.setBounds(330, 123, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void pagamento(double importo) {
		importoDaVersare = importo;
		daVersare.setText(importo+" €");
		dovuto.setText(importo+" €");
		importoD=importo;
	}
	public void pressioneEuro(double d, boolean delE) {
		if(!delE) {
			importoVersato+=d;
			importoDaVersare-=d;
			
		}else if((importoVersato-d)>=0){
			importoVersato-=d;
			importoDaVersare+=d;
			
		}
		versato.setText(importoVersato+" €");
		daVersare.setText(importoDaVersare+" €");
	}
}