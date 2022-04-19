package acampadosPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class VistaRegistrarAcampado extends JFrame {

private JFrame atras;
private JTextField usuario;
private JPasswordField password;
private JPasswordField password2;
private JTextField nombre;
private JTextField apellidos;
private JTextField dni;
private JTextField email;
private JComboBox comboBox;
private JCheckBox checkBox;
private boolean cambio = false;
private JTextField edad;
private JTextField telefono;
private String salud = "Sano";
	
	public VistaRegistrarAcampado(JFrame frame) {
		setTitle("Registrar");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,550);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 465, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labelResgistrar = new JLabel("Registrar:");
		labelResgistrar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labelResgistrar.setBounds(25, 24, 156, 36);
		getContentPane().add(labelResgistrar);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(35, 69, 69, 25);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(35, 107, 97, 25);
		getContentPane().add(lblContrasea);
		
		usuario = new JTextField();
		usuario.setBounds(132, 71, 116, 22);
		getContentPane().add(usuario);
		usuario.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(132, 109, 116, 22);
		getContentPane().add(password);
		
		JLabel lblContrasea_1 = new JLabel("Contrase\u00F1a:");
		lblContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea_1.setBounds(35, 145, 97, 25);
		getContentPane().add(lblContrasea_1);
		
		password2 = new JPasswordField();
		password2.setBounds(132, 147, 116, 22);
		getContentPane().add(password2);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(35, 183, 69, 25);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(132, 185, 116, 22);
		getContentPane().add(nombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidos.setBounds(35, 221, 88, 25);
		getContentPane().add(lblApellidos);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDNI.setBounds(35, 259, 69, 25);
		getContentPane().add(lblDNI);
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(132, 223, 116, 22);
		getContentPane().add(apellidos);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(132, 261, 116, 22);
		getContentPane().add(dni);
		
		checkBox = new JCheckBox("Marca si estas enfermo");
		checkBox.setBounds(25, 415, 163, 25);
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambio) {
					cambio = true;
					comboBox.setEnabled(cambio);
				}
				else {
					cambio = false;
					comboBox.setEnabled(cambio);
				}
			}
		});
		getContentPane().add(checkBox);
		
		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBounds(207, 416, 123, 22);
		//TODO DAVID PONER LAS ENFERMEDADES QUE QUIERAS
		comboBox.addItem("Covid");
		comboBox.addItem("Gripe");
		getContentPane().add(comboBox);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(35, 297, 69, 25);
		getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(132, 299, 116, 22);
		getContentPane().add(email);
		
		JButton boton_Registrar = new JButton("Registrar");
		boton_Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					salud = comboBox.getSelectedItem().toString();
				}
				if (password.getText().length() < 7 ) {
					if (!password.equals(password2)) {
						if (dni.getText().matches("[0-9]{7,8}[A-Za-z]")) {
							if (email.getText().matches("[-\\w\\.]+@\\w+\\.\\w+")) {
								if (edad.getText().matches("[0-9]*")) {
									if (telefono.getText().matches("[0-9]*") && telefono.getText().length() == 9) {
										SingletonControllerAcampado.getInstance().crearAcampado(usuario.getText(), password.getText(), nombre.getText(), apellidos.getText(), dni.getText(), email.getText(), edad.getText(), telefono.getText(), salud, frame);
									}
									else JOptionPane.showMessageDialog(atras, "Formato del telefono es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else JOptionPane.showMessageDialog(atras, "Formato de la edad es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
							}
							else JOptionPane.showMessageDialog(atras, "Formato del email es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else JOptionPane.showMessageDialog(atras, "Formato del dni es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else JOptionPane.showMessageDialog(atras, "Tamaño de clave minimo es de 8 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else JOptionPane.showMessageDialog(atras, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		boton_Registrar.setBounds(341, 222, 97, 25);
		getContentPane().add(boton_Registrar);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(35, 335, 69, 25);
		getContentPane().add(lblEdad);
		
		edad = new JTextField();
		edad.setColumns(10);
		edad.setBounds(132, 337, 116, 22);
		getContentPane().add(edad);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(35, 373, 69, 25);
		getContentPane().add(lblTelefono);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(132, 375, 116, 22);
		getContentPane().add(telefono);
		
		setVisible(true);
	}
	private JFrame getFrame() {
		return this;
	}
}
