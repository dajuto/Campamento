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
import javax.swing.JPasswordField;

import acampados.Negocio.TAcampado;

public class VistaContrasenaAcampado extends JFrame implements GestoriaObserver{
	private static final long serialVersionUID = 1L;
	private String nombreUsuario = SingletonControllerGestoria.getInstance().getNombreAcampado();
	private List<TAcampado> listaAcampado = SingletonControllerGestoria.getInstance().getListaAcampados();
	private TAcampado acampado;
	private JPasswordField password2;
	private JPasswordField password1;
	private JPasswordField password;
	
	public VistaContrasenaAcampado() {
		setTitle("Menu de gestoria: " + nombreUsuario);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		for (TAcampado a: listaAcampado) {
			if (a.getUsuario().equals(nombreUsuario)){
				acampado = a;
			}
		}
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().menuAcampado(getFrame());
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel lblCambiarContrasea = new JLabel("Cambiar Contrase\u00F1a:");
		lblCambiarContrasea.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblCambiarContrasea.setBounds(22, 13, 341, 36);
		getContentPane().add(lblCambiarContrasea);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(22, 62, 85, 25);
		getContentPane().add(lblContrasea);
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (password.getText().equals(acampado.getContrasena())) {
					if (password1.getText().length() > 7) {
						if (password1.getText().equals(password2.getText())) {
							setVisible(false);
							SingletonControllerGestoria.getInstance().CambiarContrasena(password1.getText());
						}
						else JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else JOptionPane.showMessageDialog(null, "La contraseña tiene que tener 8 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else JOptionPane.showMessageDialog(null, "La contraseña introducida es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		boton_modificar.setBounds(100, 176, 97, 25);
		getContentPane().add(boton_modificar);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contrase\u00F1a:");
		lblRepitaLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRepitaLaContrasea.setBounds(22, 138, 155, 25);
		getContentPane().add(lblRepitaLaContrasea);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNuevaContrasea.setBounds(22, 100, 155, 25);
		getContentPane().add(lblNuevaContrasea);
		
		password2 = new JPasswordField();
		password2.setBounds(183, 140, 116, 22);
		getContentPane().add(password2);
		
		password1 = new JPasswordField();
		password1.setBounds(183, 102, 116, 22);
		getContentPane().add(password1);
		
		password = new JPasswordField();
		password.setBounds(183, 64, 116, 22);
		getContentPane().add(password);
		
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}
}
