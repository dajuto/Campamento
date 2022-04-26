package gestoria.Presentacion;

import javax.swing.JFrame;

import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
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

public class VistaMenuGestor extends JFrame implements GestoriaObserver{
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	
	public VistaMenuGestor() {
		setTitle("Menu de gestoria" );
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerEmpleado.getInstance().menuEmpleado();
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Instalaciones = new JButton("Instalaciones");
		boton_Instalaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().menuInstalacionesGestor(getFrame());
			}
		});
		boton_Instalaciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Instalaciones.setBounds(41, 135, 165, 38);
		getContentPane().add(boton_Instalaciones);
		
		JButton boton_Mantenimineto = new JButton("Mantenimiento");
		boton_Mantenimineto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().menuMantenimientoGestor(getFrame());
			}
		});
		boton_Mantenimineto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Mantenimineto.setBounds(268, 63, 165, 38);
		getContentPane().add(boton_Mantenimineto);
		
		JButton boton_Limpieza = new JButton("Limpieza");
		boton_Limpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().menuLimpiezaGestor(getFrame());
			}
		});
		boton_Limpieza.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Limpieza.setBounds(41, 63, 165, 38);
		getContentPane().add(boton_Limpieza);
		
		JButton boton_añadirEmpleado = new JButton("A\u00F1adir Empleado");
		boton_añadirEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().crearEmpleado(getFrame());
			}
		});
		boton_añadirEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_añadirEmpleado.setBounds(268, 135, 165, 38);
		getContentPane().add(boton_añadirEmpleado);
		
		
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
