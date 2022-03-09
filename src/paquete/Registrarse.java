package paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JTextField nomb_usu;
	private JTextField dni_usu;
	private JTextField edad_usu;
	private JTextField email_usu;
	private JTextField tele_usu;
	private JPasswordField cont_usu1;
	private JPasswordField cont_usu2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrarse frame = new Registrarse();
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
	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRegistrarse.setBounds(105, 13, 196, 46);
		contentPane.add(lblRegistrarse);
		
		JLabel Nombre_Usuario = new JLabel("Nombre:");
		Nombre_Usuario.setBounds(12, 86, 56, 16);
		contentPane.add(Nombre_Usuario);
		
		JLabel DNI_Usuario = new JLabel("DNI:");
		DNI_Usuario.setBounds(12, 115, 56, 16);
		contentPane.add(DNI_Usuario);
		
		JLabel Edad_Usuario = new JLabel("Edad:");
		Edad_Usuario.setBounds(12, 145, 56, 16);
		contentPane.add(Edad_Usuario);
		
		JLabel Contraseña_Usuario = new JLabel("Contrase\u00F1a:");
		Contraseña_Usuario.setBounds(12, 174, 86, 16);
		contentPane.add(Contraseña_Usuario);
		
		JLabel lblRepitaContrasea = new JLabel("Repita Contrase\u00F1a:");
		lblRepitaContrasea.setBounds(12, 203, 110, 16);
		contentPane.add(lblRepitaContrasea);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 232, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(12, 261, 56, 16);
		contentPane.add(lblTelefono);
		
		nomb_usu = new JTextField();
		nomb_usu.setBounds(71, 83, 116, 22);
		contentPane.add(nomb_usu);
		nomb_usu.setColumns(10);
		
		dni_usu = new JTextField();
		dni_usu.setBounds(46, 112, 116, 22);
		contentPane.add(dni_usu);
		dni_usu.setColumns(10);
		
		edad_usu = new JTextField();
		edad_usu.setBounds(56, 142, 116, 22);
		contentPane.add(edad_usu);
		edad_usu.setColumns(10);
		
		email_usu = new JTextField();
		email_usu.setBounds(56, 229, 116, 22);
		contentPane.add(email_usu);
		email_usu.setColumns(10);
		
		tele_usu = new JTextField();
		tele_usu.setBounds(81, 258, 116, 22);
		contentPane.add(tele_usu);
		tele_usu.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nomb_usu.getText().matches("[a-zA-z]*")) {
					if (dni_usu.getText().length() == 9) {
						if (dni_usu.getText().matches("[0-9]{7,8}[A-Za-z]")){
							if (edad_usu.getText().matches("[0-9]*")) {
								if (cont_usu1.getText().length() >= 8) {
									if (cont_usu1.getText().equals(cont_usu2.getText())) {
										if (email_usu.getText().matches("[-\\w\\.]+@\\w+\\.\\w+")) {
											if (tele_usu.getText().length() == 9 && tele_usu.getText().matches("[0-9]*")) {
												registrado regi = new registrado();
												regi.setVisible(true);
											}
											else {
												JOptionPane.showMessageDialog(null, "El formato del telefono es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "El formato del email es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir", "ERROR", JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "La contraseña debe de tener 8 caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "El formato de la edad es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Formato del Dni invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Formato del Dni invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Formato del nombre invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
					
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrarse.setBounds(265, 280, 133, 36);
		contentPane.add(btnRegistrarse);
		
		cont_usu1 = new JPasswordField();
		cont_usu1.setBounds(92, 171, 105, 22);
		contentPane.add(cont_usu1);
		
		cont_usu2 = new JPasswordField();
		cont_usu2.setBounds(131, 200, 105, 22);
		contentPane.add(cont_usu2);
	}

}
