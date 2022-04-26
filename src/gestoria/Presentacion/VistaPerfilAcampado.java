package gestoria.Presentacion;

import javax.swing.JFrame;

import empleados.Negocio.TEmpleadoLimpieza;
import gestoria.Negocio.GestoriaObserver;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
import gestoria.Negocio.TMantenimiento;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;
import javax.swing.JPasswordField;

public class VistaPerfilAcampado extends JFrame implements GestoriaObserver{
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario;
	private List<TAcampado> listaAcampados;
	private TAcampado acampado;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField edad;
	private JTextField dni;
	private JTextField email;
	private JTextField telefono;
	private JTextField usuario;
	private JPasswordField password;
	
	public VistaPerfilAcampado(JFrame frame) {
		nombreUsuario = SingletonControllerGestoria.getInstance().getNombreAcampado();
		listaAcampados = SingletonControllerGestoria.getInstance().getListaAcampados();
		
		for (TAcampado a: listaAcampados) {
			if (a.getUsuario().equals(nombreUsuario)){
				acampado = a;
			}
		}
		setTitle("Perfil de "+ nombreUsuario);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(521,376);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(394, 291, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel label = new JLabel("");
		label.setBounds(46, 50, 56, 16);
		getContentPane().add(label);
		
		JLabel labmodificar = new JLabel("Mi perfil:");
		labmodificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labmodificar.setBounds(12, 13, 341, 36);
		getContentPane().add(labmodificar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(12, 62, 69, 25);
		getContentPane().add(lblNombre);
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (password.getText().equals(acampado.getContrasena())) {
					if (dni.getText().matches("[0-9]{7,8}[A-Za-z]")) {
						if (email.getText().matches("[-\\w\\.]+@\\w+\\.\\w+")) {
							if (edad.getText().matches("[0-9]*")) {
								if (telefono.getText().matches("[0-9]*") && telefono.getText().length() == 9) {
									setVisible(false);
									SingletonControllerGestoria.getInstance().modificarAcampado(nombreUsuario, nombre.getText(), apellidos.getText(), edad.getText(), dni.getText(), email.getText(), telefono.getText(),usuario.getText());
								}
								else JOptionPane.showMessageDialog(atras, "Formato del telefono es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
							}
							else JOptionPane.showMessageDialog(atras, "Formato de la edad es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else JOptionPane.showMessageDialog(atras, "Formato del email es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else JOptionPane.showMessageDialog(atras, "Formato del dni es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}			
				else JOptionPane.showMessageDialog(atras, "La contraseña introducida es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		boton_modificar.setBounds(349, 176, 97, 25);
		getContentPane().add(boton_modificar);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidos.setBounds(12, 100, 90, 25);
		getContentPane().add(lblApellidos);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(12, 138, 69, 25);
		getContentPane().add(lblEdad);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(12, 290, 69, 25);
		getContentPane().add(lblUsuario);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(12, 214, 69, 25);
		getContentPane().add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(12, 252, 69, 25);
		getContentPane().add(lblTelefono);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(12, 176, 69, 25);
		getContentPane().add(lblDni);
		
		nombre = new JTextField();
		nombre.setBounds(109, 62, 116, 22);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		nombre.setText(acampado.getNombre());
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(109, 100, 116, 22);
		getContentPane().add(apellidos);
		apellidos.setText(acampado.getApellidos());
		
		edad = new JTextField();
		edad.setColumns(10);
		edad.setBounds(109, 136, 116, 22);
		getContentPane().add(edad);
		edad.setText(Integer.toString(acampado.getEdad()));
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(109, 176, 116, 22);
		getContentPane().add(dni);
		dni.setText(acampado.getDni());
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(109, 214, 116, 22);
		getContentPane().add(email);
		email.setText(acampado.getEmail());
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(109, 252, 116, 22);
		getContentPane().add(telefono);
		telefono.setText(Integer.toString(acampado.getTelefono()));
		
		usuario = new JTextField();
		usuario.setColumns(10);
		usuario.setBounds(109, 290, 116, 22);
		getContentPane().add(usuario);
		usuario.setText(acampado.getUsuario());
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(278, 138, 85, 25);
		getContentPane().add(lblContrasea);
		
		password = new JPasswordField();
		password.setBounds(375, 136, 116, 22);
		getContentPane().add(password);
		
		
		this.setVisible(true);
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		update(nombreUsuario);
		
	}

	@Override
	public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		update(nombreUsuario);		
	}

	@Override
	public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		update(nombreUsuario);		
	}

	@Override
	public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		update(nombreUsuario);		
	}
}
