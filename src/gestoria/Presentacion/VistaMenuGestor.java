package gestoria.Presentacion;

import javax.swing.JFrame;

import empleados.Negocio.TEmpleadoLimpieza;
import gestoria.Negocio.LimpiezaObserver;
import gestoria.Negocio.TLimpieza;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VistaMenuGestor extends JFrame implements LimpiezaObserver{
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario;
	
	public VistaMenuGestor(JFrame frame) {
		setTitle("Menu de gestoria");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(323, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Instalaciones = new JButton("Instalaciones");
		boton_Instalaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_Instalaciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Instalaciones.setBounds(138, 137, 145, 38);
		getContentPane().add(boton_Instalaciones);
		
		JButton boton_Mantenimineto = new JButton("Mantenimiento");
		boton_Mantenimineto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_Mantenimineto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Mantenimineto.setBounds(235, 63, 145, 38);
		getContentPane().add(boton_Mantenimineto);
		
		JButton boton_Limpieza = new JButton("Limpieza");
		boton_Limpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SingletonControllerGestoria.getInstance().menuLimpiezaGestor(getFrame());
			}
		});
		boton_Limpieza.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Limpieza.setBounds(41, 63, 145, 38);
		getContentPane().add(boton_Limpieza);
		
		
		this.setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@Override
	public void onRegister(List<TLimpieza> listaA, List<TEmpleadoLimpieza> listaR, String nombreUsuario) {
		this.update(nombreUsuario);
	}

	@Override
	public void onCreateLimpieza(List<TLimpieza> listaA, List<TEmpleadoLimpieza> listaR, String nombreUsuario) {
		this.update(nombreUsuario);
	}

	@Override
	public void onEliminarLimpieza(List<TLimpieza> listaA, List<TEmpleadoLimpieza> listaR, String nombreUsuario) {
		this.update(nombreUsuario);
	}

	@Override
	public void onModificarLimpieza(List<TLimpieza> listaA, List<TEmpleadoLimpieza> listaR, String nombreUsuario) {
		this.update(nombreUsuario);
	}

	@Override
	public void onActualizarListaEmpleadosLimpieza(List<TLimpieza> listaLimpieza,
			List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.update(nombreUsuario);
	}
}
