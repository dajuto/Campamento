package gestoria.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.TEmpleadoGestoria;
import gestoria.Negocio.GestoriaObserver;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaMenuLimpiezaGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private String nombreUsuario;
	public VistaMenuLimpiezaGestor(JFrame frame) {
		setTitle("Menu de Limpieza");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Mostrar = new JButton("Mostrar Horarios");
		boton_Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().mostrarLimpieza(getFrame());
			}
		});
		boton_Mostrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Mostrar.setBounds(51, 53, 145, 38);
		getContentPane().add(boton_Mostrar);
		
		JButton boton_Modificar = new JButton("Modificar Horarios");
		boton_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().mostrarModificarLimpieza(getFrame());
			}
		});
		boton_Modificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Modificar.setBounds(281, 53, 145, 38);
		getContentPane().add(boton_Modificar);
		
		JButton boton_Eliminar = new JButton("Eliminar Horarios");
		boton_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().mostrarEliminarLimpieza(getFrame());
			}
		});
		boton_Eliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Eliminar.setBounds(281, 119, 145, 38);
		getContentPane().add(boton_Eliminar);
		
		JButton boton_Anadir = new JButton("A\u00F1adir Horarios");
		boton_Anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().mostrarCrearLimpieza(getFrame());
			}
		});
		boton_Anadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Anadir.setBounds(51, 119, 145, 38);
		getContentPane().add(boton_Anadir);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}
	
	
}
