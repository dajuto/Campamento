package gestoria.Presentacion;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import empleados.Presentacion.SingletonControllerEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaRegistrarEmpleado extends JFrame {

private JFrame atras;
private JTextField usuario;
private JPasswordField password;
private JPasswordField password2;
private JTextField nombre;
private JComboBox puesto;
	
	public VistaRegistrarEmpleado(JFrame frame) {
		setTitle("Registrar");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,400);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 315, 97, 25);
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
		
		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (password.getText().length() > 7) {
					if(password.getText().equals(password2.getText())) {
							//TODO HABRA QUE AÑADIR EL USUARIO Y TAL
							SingletonControllerEmpleado.getInstance().crearEmpleado(getFrame(), usuario.getText(), password.getText(), nombre.getText(), puesto.getSelectedItem().toString());
					}
					else JOptionPane.showMessageDialog(atras, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else JOptionPane.showMessageDialog(atras, "Tamaño de clave minimo es de 8 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		boton_Aceptar.setBounds(84, 277, 97, 25);
		getContentPane().add(boton_Aceptar);
		
		JLabel lblContrasea_1 = new JLabel("Contrase\u00F1a:");
		lblContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea_1.setBounds(35, 145, 97, 25);
		getContentPane().add(lblContrasea_1);
		
		password2 = new JPasswordField();
		password2.setBounds(132, 147, 116, 22);
		getContentPane().add(password2);
		
		JLabel lblUsuario_1 = new JLabel("Nombre:");
		lblUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario_1.setBounds(35, 183, 69, 25);
		getContentPane().add(lblUsuario_1);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(132, 185, 116, 22);
		getContentPane().add(nombre);
		
		JLabel lblUsuario_1_1 = new JLabel("Puesto:");
		lblUsuario_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario_1_1.setBounds(35, 221, 69, 25);
		getContentPane().add(lblUsuario_1_1);
		
		puesto = new JComboBox();
		puesto.setModel(new DefaultComboBoxModel(new String[] {"Gestor", "Medico", "Contable", "Coordinador Actividades", "Empleado Mantenimiento", "Empleado Limpieza"}));
		puesto.setBounds(132, 223, 116, 22);
		getContentPane().add(puesto);
		
		setVisible(true);
	}
	private JFrame getFrame() {
		return this;
	}
}
