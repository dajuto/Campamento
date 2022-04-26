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

import empleados.Presentacion.SingletonControllerEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VistaInicioSesionAcampado extends JFrame {

private JTextField usuario;
private JPasswordField password;
	
	public VistaInicioSesionAcampado() {
		setTitle("Inicio Sesion");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerAcampado.getInstance().acampado();
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel lblIniciarSesin = new JLabel("Iniciar Sesi\u00F3n:");
		lblIniciarSesin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblIniciarSesin.setBounds(25, 24, 156, 36);
		getContentPane().add(lblIniciarSesin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(25, 85, 69, 25);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(25, 123, 97, 25);
		getContentPane().add(lblContrasea);
		
		usuario = new JTextField();
		usuario.setBounds(122, 87, 116, 22);
		getContentPane().add(usuario);
		usuario.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(122, 125, 116, 22);
		getContentPane().add(password);
		
		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerAcampado.getInstance().registraUsuario(usuario.getText());
				
				if(SingletonControllerAcampado.getInstance().existeAcampado(usuario.getText(), password.getText())) {
					setVisible(false);
					SingletonControllerAcampado.getInstance().menuAcampado(getFrame());
				}
				else JOptionPane.showMessageDialog(null, "Usuario Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_Aceptar.setBounds(84, 162, 97, 25);
		getContentPane().add(boton_Aceptar);
		
		setVisible(true);
	}
	private JFrame getFrame() {
		return this;
	}
	
	private String getUsuario() {
		return usuario.getText();
	}
}
