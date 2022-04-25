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

import acampadosPresentacion.SingletonControllerAcampado;

public class VistaPerfilAcampado extends JFrame implements GestoriaObserver{
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField edad;
	private JTextField dni;
	private JTextField email;
	private JTextField telefono;
	private JTextField usuario;
	
	public VistaPerfilAcampado(JFrame frame) {
		setTitle("Perfil");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(445,394);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(318, 309, 97, 25);
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
				if (dni.getText().matches("[0-9]{7,8}[A-Za-z]")) {
					if (email.getText().matches("[-\\w\\.]+@\\w+\\.\\w+")) {
						if (edad.getText().matches("[0-9]*")) {
							if (telefono.getText().matches("[0-9]*") && telefono.getText().length() == 9) {
								SingletonControllerAcampado.getInstance().modificarAcampado(HACERRRRR);
							}
							else JOptionPane.showMessageDialog(atras, "Formato del telefono es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else JOptionPane.showMessageDialog(atras, "Formato de la edad es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else JOptionPane.showMessageDialog(atras, "Formato del email es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else JOptionPane.showMessageDialog(atras, "Formato del dni es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		boton_modificar.setBounds(274, 156, 97, 25);
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
		nombre.setBounds(93, 64, 116, 22);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(93, 102, 116, 22);
		getContentPane().add(apellidos);
		
		edad = new JTextField();
		edad.setColumns(10);
		edad.setBounds(93, 138, 116, 22);
		getContentPane().add(edad);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(93, 178, 116, 22);
		getContentPane().add(dni);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(93, 216, 116, 22);
		getContentPane().add(email);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(93, 254, 116, 22);
		getContentPane().add(telefono);
		
		usuario = new JTextField();
		usuario.setColumns(10);
		usuario.setBounds(93, 292, 116, 22);
		getContentPane().add(usuario);
		
		
		this.setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
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
