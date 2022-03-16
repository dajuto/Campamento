package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Bienvenidos extends JFrame {
	

	private JPanel contentPane;

	
	
	/**
	 * Create the frame.
	 */
	public Bienvenidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JLabel lblBienvenidos = new JLabel("Bienvenidos");
		lblBienvenidos.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblBienvenidos.setBounds(124, 13, 187, 38);
		contentPane.add(lblBienvenidos);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 76, 56, 16);
		contentPane.add(label);
		
		JButton btnInicarSesion = new JButton("Acampados");
		btnInicarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				acampados aca = new acampados();
				aca.setVisible(true);
			}
		});
		btnInicarSesion.setBounds(35, 106, 107, 25);
		contentPane.add(btnInicarSesion);
		
		JButton btnRegistrarse = new JButton("Empleados");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				empleados emp = new empleados();
				emp.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(266, 106, 113, 25);
		contentPane.add(btnRegistrarse);
	}

}
