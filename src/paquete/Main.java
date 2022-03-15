package paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
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
